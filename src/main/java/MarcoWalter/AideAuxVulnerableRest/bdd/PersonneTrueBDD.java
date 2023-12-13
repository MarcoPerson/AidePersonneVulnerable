package MarcoWalter.AideAuxVulnerableRest.bdd;

import MarcoWalter.AideAuxVulnerableRest.model.Personne;

import java.sql.*;
import java.util.ArrayList;

public class PersonneTrueBDD {

    private static Connection conn;
    
    static {
    	DBConnection connection = new DBConnection();
        connection.connect("jdbc:mysql://srv-bdens.insa-toulouse.fr:3306/projet_gei_055", "projet_gei_055", "Mahg7mac");
        setConn(connection.getConn());
    }

    public static void setConn(Connection _conn) {
        conn = _conn;
    }

    public static void ajouterPersonne(Personne personne) {
        try (PreparedStatement statement = conn.prepareStatement(
                "INSERT INTO Personne (nom, prenom, age, adresse, isBenevole) VALUES (?, ?, ?, ?, ?)",
                Statement.RETURN_GENERATED_KEYS)) {

            statement.setString(1, personne.getNom());
            statement.setString(2, personne.getPrenom());
            statement.setInt(3, personne.getAge());
            statement.setString(4, personne.getAdresse());
            statement.setBoolean(5, personne.getBenevole());

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

    public static void supprimerPersonne(Personne personne) {
        try (PreparedStatement statement = conn.prepareStatement(
                "DELETE FROM Personne WHERE id = ?")) {

            statement.setInt(1, personne.getId());
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
        personne.setBenevole(resultSet.getBoolean("isBenevole"));
        return personne;
    }
}
