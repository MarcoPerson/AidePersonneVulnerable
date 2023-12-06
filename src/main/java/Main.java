import bdd.DBConnection;
import bdd.MissionTrueBDD;
import bdd.PersonneTrueBDD;
import service.PersonneService;
import service.MissionService;

import javax.xml.ws.Endpoint;

public class Main {
    public static String host = "localhost";
    public static short port1 = 8089;
    public static short port2 = 8090;

    public void startService(){
        DBConnection connection = new DBConnection();
        connection.connect("jdbc:mysql://srv-bdens.insa-toulouse.fr:3306/projet_gei_055", "projet_gei_055", "Mahg7mac");
        PersonneTrueBDD.setConn(connection.getConn());
        MissionTrueBDD.setConn(connection.getConn());
        String url1 = "http://"+host+":"+port1+"/";
        Endpoint.publish(url1, new PersonneService());
        String url2 = "http://"+host+":"+port2+"/";
        Endpoint.publish(url2, new MissionService());
    }

    public static void main(String[] args) {
        new Main().startService();
        System.out.println("Le service a démarré");
    }
}
