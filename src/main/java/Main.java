import bdd.MissionBDD;
import bdd.PersonneBDD;
import service.PersonneService;
import service.MissionService;

import javax.xml.ws.Endpoint;

public class Main {
    public static String host = "localhost";
    public static short port1 = 8089;
    public static short port2 = 8090;

    public void startService(){
        PersonneBDD.initBdd();
        MissionBDD.initBdd();
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
