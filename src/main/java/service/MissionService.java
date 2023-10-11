package service;

import bdd.MissionBDD;
import bdd.PersonneBDD;
import model.Mission;
import model.Personne;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.ArrayList;
import java.util.Collection;

@WebService(serviceName = "mission")
public class MissionService {
    @WebMethod(operationName = "ajoutMission")
    public boolean ajoutMission(@WebParam(name = "demandeurId") int demandeurId,
                                  @WebParam(name = "missionSujet") String missionSujet){
        Mission mission = new Mission(demandeurId, missionSujet);
        MissionBDD.ajouterMission(mission);
        return true;
    }
    public boolean assignerMission(@WebParam(name = "benevoleId") int benevoleId,
                                @WebParam(name = "missionId") int missionId){
        Mission mission = MissionBDD.getMission(missionId);
        mission.setBenevoleAssigneId(benevoleId);
        MissionBDD.mettreAjourMission(mission);
        return true;
    }
    public boolean validerMission(@WebParam(name = "missionId") int missionId){
        Mission mission = MissionBDD.getMission(missionId);
        mission.setValidated(true);
        MissionBDD.mettreAjourMission(mission);
        return true;
    }

    @WebMethod(operationName = "toutesLesMissions")
    public Collection<Mission> toutesLesMissions(){
        return MissionBDD.getAllMission();
    }
}
