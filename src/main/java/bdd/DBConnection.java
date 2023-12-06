package bdd;
import java.sql.*;

public class DBConnection {

    private Connection conn;

    public Connection getConn() {
        return conn;
    }
    public void connect(String url, String username, String password)
    {
        try
        {
            //étape 1: charger la classe de driver
            Class.forName("com.mysql.jdbc.Driver");

            //étape 2: créer l'objet de connexion
            conn = DriverManager.getConnection(
                    url, username, password);

            System.out.println(conn);
            //étape 3: créer l'objet statement
            Statement stmt = conn.createStatement();
                ResultSet res = stmt.executeQuery("SELECT * FROM Personne");

            //étape 4: exécuter la requête
            while(res.next())
                System.out.println(res.getInt(1)+"  "+res.getString(2)
                        +"  "+res.getString(3));

            //étape 5: fermez l'objet de connexion
            conn.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}

