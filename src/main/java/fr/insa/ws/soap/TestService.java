package fr.insa.ws.soap;

import javax.xml.ws.Endpoint;

public class TestService {
    public static String host = "localhost";
    public static short port = 8089;

    public void startService(){
        String url = "http://"+host+":"+port+"/";
        Endpoint.publish(url, new Add());
    }

    public static void main(String[] args) {
        new TestService().startService();
        System.out.println("Le service a démarré");
    }
}
