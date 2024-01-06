package MarcoWalter.AideAuxVulnerableMission.bdd;

import MarcoWalter.AideAuxVulnerableMission.bdd.DBConnection;
import MarcoWalter.AideAuxVulnerableMission.model.Mission;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Collection;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

public class MissionTrueBDD {
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

    public static void ajouterMission(Mission mission) {
        try (PreparedStatement statement = conn.prepareStatement(
                "INSERT INTO Mission (demandeurId, benevoleId, sujet, isValidated, isReferred, isReferentNeeded, isWaiting, isRealised, motif, avis) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
                Statement.RETURN_GENERATED_KEYS)) {

            statement.setInt(1, mission.getDemandeurId());
            statement.setInt(2, mission.getBenevoleAssigneId());
            statement.setString(3, mission.getSujet());
            statement.setBoolean(4, mission.isValidated());
            statement.setBoolean(5, mission.isReferred());
            statement.setBoolean(6, mission.getIsReferentNeeded());
            statement.setBoolean(7, mission.isWaiting());
            statement.setBoolean(8, mission.isRealised());
            statement.setString(9, mission.getMotif());
            statement.setString(10, mission.getAvis());

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
    
    public static Collection<Mission> getNonBenevoleMissions() {
        Collection<Mission> missions = new ArrayList<>();

        try (Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM Mission WHERE benevoleId = 0")) {

            while (resultSet.next()) {
                Mission mission = mapResultSetToMission(resultSet);
                missions.add(mission);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception according to your needs
        }

        return missions;
    }

    public static Collection<Mission> getNonValidatedMissions() {
        Collection<Mission> missions = new ArrayList<>();

        try (Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM Mission WHERE isValidated = 0")) {

            while (resultSet.next()) {
                Mission mission = mapResultSetToMission(resultSet);
                missions.add(mission);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception according to your needs
        }

        return missions;
    }

    public static Collection<Mission> getNonReferredMissions() {
        Collection<Mission> missions = new ArrayList<>();

        try (Statement statement = conn.createStatement();
                ResultSet resultSet = statement
                        .executeQuery("SELECT * FROM Mission WHERE isReferred = 0 AND isReferentNeeded = 1")) {

            while (resultSet.next()) {
                Mission mission = mapResultSetToMission(resultSet);
                missions.add(mission);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception according to your needs
        }

        return missions;
    }

    public static Collection<Mission> getMissionsDemandeur(int demandeurId) {
        Collection<Mission> missions = new ArrayList<>();

        try (PreparedStatement statement = conn.prepareStatement("SELECT * FROM Mission WHERE demandeurId = ?")) {
            statement.setInt(1, demandeurId);
            try (ResultSet resultSet = statement.executeQuery()) {

                while (resultSet.next()) {
                    Mission mission = mapResultSetToMission(resultSet);
                    missions.add(mission);
                }
            }
        } catch (SQLException e) {
			e.printStackTrace();
		}
        return missions;
    }

    public static Collection<Mission> getMissionsBenevole(int benevoleId) {
    	Collection<Mission> missions = new ArrayList<>();

        try (PreparedStatement statement = conn.prepareStatement("SELECT * FROM Mission WHERE demandeurId = ?")) {
            statement.setInt(1, benevoleId);
            try (ResultSet resultSet = statement.executeQuery()) {

                while (resultSet.next()) {
                    Mission mission = mapResultSetToMission(resultSet);
                    missions.add(mission);
                }
            }
        } catch (SQLException e) {
			e.printStackTrace();
		}
        return missions;
    }

    public static void mettreAjourMission(Mission mission) {
        try (PreparedStatement statement = conn.prepareStatement(
                "UPDATE Mission SET demandeurId=?, benevoleId=?, sujet=?, isValidated=?, isReferred=?, isReferentNeeded=?, isWaiting=?, isRealised=?, motif=?, avis=? WHERE id=?")) {

            statement.setInt(1, mission.getDemandeurId());
            statement.setInt(2, mission.getBenevoleAssigneId());
            statement.setString(3, mission.getSujet());
            statement.setBoolean(4, mission.isValidated());
            statement.setBoolean(5, mission.isReferred());
            statement.setBoolean(6, mission.getIsReferentNeeded());
            statement.setBoolean(7, mission.isWaiting());
            statement.setBoolean(8, mission.isRealised());
            statement.setString(9, mission.getMotif());
            statement.setString(10, mission.getAvis());
            statement.setInt(11, mission.getId());

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
        mission.setIsReferentNeeded(resultSet.getBoolean("isReferentNeeded"));
        mission.setReferred(resultSet.getBoolean("isReferred"));
        mission.setWaiting(resultSet.getBoolean("isWaiting"));
        mission.setRealised(resultSet.getBoolean("isRealised"));
        mission.setMotif(resultSet.getString("motif"));
        mission.setAvis(resultSet.getString("avis"));
        return mission;
    }
}
