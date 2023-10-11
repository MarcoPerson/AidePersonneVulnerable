package bdd;

import model.Mission;
import model.Personne;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class MissionBDD {
    static int lastId = 0;
    static HashMap<Integer, Mission> missionBDD = new HashMap<>();

    public MissionBDD() {
    }

    public static void initBdd(){
    }
    public static void ajouterMission(Mission mission){
        mission.setId(lastId);
        missionBDD.put(lastId, mission);
        lastId++;
    }

    public static Mission getMission(int missionId){
        return MissionBDD.getMission(missionId);
    }

    public static Collection<Mission> getAllMission(){
        return missionBDD.values();
    }

    public static void mettreAjourMission(Mission mission){
        missionBDD.remove(mission.getId());
        missionBDD.put(mission.getId(), mission);
    }
    public static void supprimerMission(Mission mission){
        missionBDD.remove(mission.getId());
    }
}
