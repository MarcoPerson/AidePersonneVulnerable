package MarcoWalter.AideAuxVulnerablePersonne.bdd;

import MarcoWalter.AideAuxVulnerablePersonne.bdd.DBConnection;
import MarcoWalter.AideAuxVulnerablePersonne.model.Personne;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;

public class PersonneTrueBDD {
private static Connection conn;
    
    static {
    	Properties properties = new Properties();
        try (InputStream input = DBConnection.class.getClassLoader().getResourceAsStream("application.properties")) {
            properties.load(input);
        } catch (IOException e) {
			e.printStackTrace();
		}

        String url = properties.getProperty("database.url");
        String username = properties.getProperty("database.username");
        String password = properties.getProperty("database.password");
        
    	DBConnection connection = new DBConnection();
        connection.connect(url, username, password);
        setConn(connection.getConn());
    }

    public static void setConn(Connection _conn) {
        conn = _conn;
    }

    public static void ajouterPersonne(Personne personne) {
        try (PreparedStatement statement = conn.prepareStatement(
                "INSERT INTO Personne (nom, prenom, age, adresse, isReferentNeeded, role) VALUES (?, ?, ?, ?, ?, ?)",
                Statement.RETURN_GENERATED_KEYS)) {

            statement.setString(1, personne.getNom());
            statement.setString(2, personne.getPrenom());
            statement.setInt(3, personne.getAge());
            statement.setString(4, personne.getAdresse());
            statement.setBoolean(5, personne.getIsReferentNeeded());
            statement.setString(6, personne.getRole().getValue());

            int affectedRows = statement.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Creating personne failed, no rows affected.");
            }

            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    personne.setId(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("Creating personne failed, no ID obtained.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception according to your needs
        }
    }

    public static ArrayList<Personne> getAllPersonne() {
        ArrayList<Personne> personnes = new ArrayList<>();

        try (Statement statement = conn.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM Personne")) {

            while (resultSet.next()) {
                Personne personne = mapResultSetToPersonne(resultSet);
                personnes.add(personne);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception according to your needs
        }

        return personnes;
    }
    
    public static Personne getPersonne(int personneId) {
    	Personne personne = null;

        try (PreparedStatement statement = conn.prepareStatement(
                "SELECT * FROM Personne WHERE id = ?")) {

            statement.setInt(1, personneId);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                	personne = mapResultSetToPersonne(resultSet);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception according to your needs
        }

        return personne;
    }
    
    public static ArrayList<Personne> getAllDemandeurs() {
    	ArrayList<Personne> personnes = new ArrayList<>();

        try (Statement statement = conn.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM Personne WHERE role = 'Demandeur'")) {

            while (resultSet.next()) {
                Personne personne = mapResultSetToPersonne(resultSet);
                personnes.add(personne);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception according to your needs
        }

        return personnes;
	}
    
    public static ArrayList<Personne> getAllValidateurs() {
    	ArrayList<Personne> personnes = new ArrayList<>();

        try (Statement statement = conn.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM Personne WHERE role = 'Validateur'")) {

            while (resultSet.next()) {
                Personne personne = mapResultSetToPersonne(resultSet);
                personnes.add(personne);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception according to your needs
        }

        return personnes;
	}
    
    public static ArrayList<Personne> getAllBenevoles() {
    	ArrayList<Personne> personnes = new ArrayList<>();

        try (Statement statement = conn.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM Personne WHERE role = 'Benevole'")) {

            while (resultSet.next()) {
                Personne personne = mapResultSetToPersonne(resultSet);
                personnes.add(personne);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception according to your needs
        }

        return personnes;
	}
    
    public static ArrayList<Personne> getAllReferents() {
    	ArrayList<Personne> personnes = new ArrayList<>();

        try (Statement statement = conn.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM Personne WHERE role = 'Referent'")) {

            while (resultSet.next()) {
                Personne personne = mapResultSetToPersonne(resultSet);
                personnes.add(personne);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception according to your needs
        }

        return personnes;
	}

    public static void supprimerPersonne(int personneId) {
        try (PreparedStatement statement = conn.prepareStatement(
                "DELETE FROM Personne WHERE id = ?")) {

            statement.setInt(1, personneId);
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception according to your needs
        }
    }

    private static Personne mapResultSetToPersonne(ResultSet resultSet) throws SQLException {
        Personne personne = new Personne();
        personne.setId(resultSet.getInt("id"));
        personne.setNom(resultSet.getString("nom"));
        personne.setPrenom(resultSet.getString("prenom"));
        personne.setAge(resultSet.getInt("age"));
        personne.setAdresse(resultSet.getString("adresse"));
        personne.setIsReferentNeeded(resultSet.getBoolean("isReferentNeeded"));
        personne.setRole(resultSet.getString("role"));
        return personne;
    }

}
