package MarcoWalter.AideAuxVulnerableRest.bdd;

import MarcoWalter.AideAuxVulnerableRest.model.Mission;

import java.sql.*;
import java.util.Collection;
import java.util.ArrayList;

public class MissionTrueBDD {

    private static Connection conn;
    
    static {
    	DBConnection connection = new DBConnection();
        connection.connect("jdbc:mysql://srv-bdens.insa-toulouse.fr:3306/projet_gei_055", "projet_gei_055", "Mahg7mac");
        setConn(connection.getConn());
    }

    public static void setConn(Connection _conn) {
        conn = _conn;
    }

    public static void ajouterMission(Mission mission) {
        try (PreparedStatement statement = conn.prepareStatement(
                "INSERT INTO Mission (demandeurId, benevoleId, sujet, isValidated) VALUES (?, ?, ?, ?)",
                Statement.RETURN_GENERATED_KEYS)) {

            statement.setInt(1, mission.getDemandeurId());
            statement.setInt(2, mission.getBenevoleAssigneId());
            statement.setString(3, mission.getSujet());
            statement.setBoolean(4, mission.isValidated());

            int affectedRows = statement.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Creating mission failed, no rows affected.");
            }

            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    mission.setId(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("Creating mission failed, no ID obtained.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception according to your needs
        }
    }

    public static Mission getMission(int missionId) {
        Mission mission = null;

        try (PreparedStatement statement = conn.prepareStatement(
                "SELECT * FROM Mission WHERE id = ?")) {

            statement.setInt(1, missionId);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    mission = mapResultSetToMission(resultSet);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception according to your needs
        }

        return mission;
    }

    public static Collection<Mission> getAllMission() {
        Collection<Mission> missions = new ArrayList<>();

        try (Statement statement = conn.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM Mission")) {

            while (resultSet.next()) {
                Mission mission = mapResultSetToMission(resultSet);
                missions.add(mission);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception according to your needs
        }

        return missions;
    }

    public static void mettreAjourMission(Mission mission) {
        try (PreparedStatement statement = conn.prepareStatement(
                "UPDATE Mission SET demandeurId=?, benevoleId=?, sujet=?, isValidated=? WHERE id=?")) {

            statement.setInt(1, mission.getDemandeurId());
            statement.setInt(2, mission.getBenevoleAssigneId());
            statement.setString(3, mission.getSujet());
            statement.setBoolean(4, mission.isValidated());
            statement.setInt(5, mission.getId());

            int affectedRows = statement.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Updating mission failed, no rows affected.");
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception according to your needs
        }
    }


    public static void supprimerMission(Mission mission) {
        try (PreparedStatement statement = conn.prepareStatement(
                "DELETE FROM Mission WHERE id = ?")) {

            statement.setInt(1, mission.getId());
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception according to your needs
        }
    }

    private static Mission mapResultSetToMission(ResultSet resultSet) throws SQLException {
        Mission mission = new Mission();
        mission.setId(resultSet.getInt("id"));
        mission.setDemandeurId(resultSet.getInt("demandeurId"));
        mission.setBenevoleAssigneId(resultSet.getInt("benevoleId"));
        mission.setSujet(resultSet.getString("sujet"));
        mission.setValidated(resultSet.getBoolean("isValidated"));
        return mission;
    }
}
