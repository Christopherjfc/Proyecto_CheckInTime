package cat.iticbcn.clientiot;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HexFormat;

import org.json.JSONObject;

import com.amazonaws.services.iot.client.AWSIotMessage;

public class AccesMethodsToDB {

    public String creaHashPsswd(String password) throws Exception{
        MessageDigest md = MessageDigest.getInstance("SHA-512");
        byte[] bytes = md.digest(password.getBytes(StandardCharsets.UTF_8));
        HexFormat hex = HexFormat.of();
        String hash = hex.formatHex(bytes); 
        return hash; 
    }

    public String getNUIDHex(AWSIotMessage message) {
        try {
            // Obtener el payload como cadena
            String payload = message.getStringPayload();
            
            // Convertir el payload en un objeto JSON
            JSONObject jsonObject = new JSONObject(payload);
            // Extraer el valor de la clave "NUID_Hex"
            if (jsonObject.has("NUID_Hex")) {
                String uidTarget = jsonObject.getString("NUID_Hex");
                System.out.println("\n");
                System.out.println(uidTarget);
                System.out.println("\n");
                return uidTarget.strip();
            } else {
                return "Error: Clave 'uid_target' no encontrada en el mensaje.";
            }
        } catch (Exception e) {
            return "Error al procesar el mensaje: " + e.getMessage();
        }
    }

    public void selectAlumnes (Connection con) {
        String sql = "SELECT * FROM alumne"; // Consulta SQL
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
        
            while (rs.next()) {
                int id = rs.getInt("IdAlumne");
                String nombre = rs.getString("NomAlumne");
                System.out.println("ID: " + id + ", Nom: " + nombre);
            }
        } catch (SQLException e) {
            System.out.println("Error al ejecutar la consulta: " + e.getMessage());
        }
    }

    public void insertRegistry(Connection con, AWSIotMessage message) throws Exception{

        if (message == null) {
            System.out.println("El mensaje es nulo, no se puede procesar.");
            return; 
        }else {
            System.out.println("entra en el insert");
        }
    
        String uid_target = getNUIDHex(message);
        if (uid_target.startsWith("Error")) {
            System.out.println("Error procesando el UID del mensaje: " + uid_target);
            return; 
        }
        String sqlAlum = "INSERT INTO usuario (nombre, correo, contrasenya, rol) VALUES ('Christopher Joshua', '2023_christopher.flores@iticbcn.cat', ?, 'alumno');";
        String sql = "INSERT INTO marcaje (id_marcaje, id_usuario, fecha_hora_salida) VALUES (?, (SELECT id_usuario FROM usuario WHERE correo = '2023_christopher.flores@iticbcn.cat'), '2024-12-05 19:30:00');";

        try (PreparedStatement pstmt = con.prepareStatement(sqlAlum)) {
            pstmt.setString(1, creaHashPsswd("12345"));
            pstmt.executeUpdate();
            System.out.println("Registro insertado correctamente.");

            try (PreparedStatement pstmt2 = con.prepareStatement(sql)) {
                pstmt2.setString(1, uid_target);
                pstmt2.executeUpdate();
                
                // Después de insertar el registro, enviar mensaje a AWS IoT
                DispositiuIot dispositiu = new DispositiuIot();
                dispositiu.enviarMensajeToAws("insert ok");  // Mensaje a AWS IoT
            } catch (SQLException e) {
                System.out.println("Error al insertar el registro: " + e.getMessage());
            }
        } catch (SQLException e) {
            System.out.println("Error al insertar el usuario: " + e.getMessage());
        }
    }
}
