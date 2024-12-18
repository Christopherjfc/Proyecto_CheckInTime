/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package cat.iticbcn.clientiot;

import java.sql.Connection;
import java.sql.SQLException;


import com.amazonaws.services.iot.client.AWSIotMessage;
import com.amazonaws.services.iot.client.AWSIotQos;
import com.amazonaws.services.iot.client.AWSIotTopic;

public class TopicIoT  extends AWSIotTopic {
    static final String url = "jdbc:postgresql://192.168.38.2:5432/sprint3"; 
    static final String usuario = "postgres"; 
    static final String contrasena = "sprint3"; 

    public TopicIoT(String topic, AWSIotQos qos) {
        super(topic, qos);
    }

    @Override
    public void onMessage(AWSIotMessage message) {

        // Si el payload es "insert ok", se asigna null a lastMessage
        if (!"insert ok".equals(message.getStringPayload())) { // Comparación correcta de cadenas
          System.out.println("\n");
          creaRegistro(message);
          System.out.println("\n");
        } 
    }
    
    public void creaRegistro(AWSIotMessage mensajeIoT){
          System.out.println("\n");
          System.out.println("Esperando mensajes de AWS IoT...");
        if (mensajeIoT != null) {
            System.out.println("Mensaje recibido en el main: " + mensajeIoT.getStringPayload());
            System.out.println("\n");

            // Procesar el mensaje
            try (Connection con = ConnectDB.getConnection(url, usuario, contrasena)) {
                System.out.println("Se conecta a la base de datos");
                AccesMethodsToDB access = new AccesMethodsToDB();
                access.insertRegistry(con, mensajeIoT); // Pasar el mensaje al método
            } catch (SQLException e) {
                System.out.println("Error de conexión: " + e.getMessage());
            }catch(Exception e){
                System.err.println("Error IOT: "+e.getLocalizedMessage());
                System.exit(-1);
            }
        }
    }
}