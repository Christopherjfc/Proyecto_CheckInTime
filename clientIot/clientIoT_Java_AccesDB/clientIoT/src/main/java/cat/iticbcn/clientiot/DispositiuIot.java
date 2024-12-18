/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.iticbcn.clientiot;

import org.json.JSONObject;

/**
 *
 * @author david
 */
import com.amazonaws.services.iot.client.AWSIotException;
import com.amazonaws.services.iot.client.AWSIotMessage;
import com.amazonaws.services.iot.client.AWSIotMqttClient;
import com.amazonaws.services.iot.client.AWSIotQos;
import com.amazonaws.services.iot.client.sample.sampleUtil.SampleUtil;
import com.amazonaws.services.iot.client.sample.sampleUtil.SampleUtil.KeyStorePasswordPair;

public class DispositiuIot{

    //private static final String FICH_CLAU_PUBLICA = "./client1certs/";
    private static final String FICH_CLAU_PRIVADA = "/home/isard/Documents/clientIot/clientIoT_Java_AccesDB/clientIoT/client1certs/private2.pem";
    private static final String FICH_CERT_DISP_IOT = "/home/isard/Documents/clientIot/clientIoT_Java_AccesDB/clientIoT/client1certs/certificate2.pem";
    private static final String ENDPOINT = "a2i1qfl9blnkos-ats.iot.us-east-1.amazonaws.com";
    //public static final String TOPIC = "iticbcn/espnode01/pub";
    public static final String TOPIC = "ESP32/RFID";
    public static final String CLIENT_ID = "ESP32_RFID";
    public static final AWSIotQos TOPIC_QOS = AWSIotQos.QOS0;
    private static AWSIotMqttClient awsIotClient;

    public static void setClient(AWSIotMqttClient cli) {
        awsIotClient = cli;
    }

    public static void initClient() {
        String cliEP = ENDPOINT;
        String cliId = CLIENT_ID;

        String certFile = FICH_CERT_DISP_IOT;
        String pKFile = FICH_CLAU_PRIVADA;

        if (awsIotClient == null && certFile != null && pKFile != null) {
            String algorithm = null;
            KeyStorePasswordPair pair = SampleUtil.getKeyStorePasswordPair(certFile, pKFile, algorithm);
            awsIotClient = new AWSIotMqttClient(cliEP, cliId, pair.keyStore, pair.keyPassword);
        }

        if (awsIotClient == null) {
            throw new IllegalArgumentException("Error als construir client amb el certificat o les credencials.");
        }
    }

    public void conecta() throws AWSIotException{
        initClient();
        awsIotClient.connect();
        System.out.println("Cliente Conetado!!!");
    }

    public void subscriu() throws AWSIotException{
        TopicIoT topic= new TopicIoT(TOPIC, TOPIC_QOS);
        awsIotClient.subscribe(topic, true);
        System.out.println("Cliente suscrito!!!");
    }

    public void enviarMensajeToAws(String message) {
        try {
            JSONObject jsonMessage = new JSONObject();
            jsonMessage.put("message", message);

            String jsonString = jsonMessage.toString();

            AWSIotMessage iotMessage = new AWSIotMessage(DispositiuIot.TOPIC, DispositiuIot.TOPIC_QOS, jsonString);

            awsIotClient.publish(iotMessage);

            System.out.println("Mensaje enviado a AWS IoT: " + jsonString);
        } catch (Exception e) {
            System.out.println("Error al enviar mensaje a AWS IoT: " + e.getMessage());
        }
    }
}