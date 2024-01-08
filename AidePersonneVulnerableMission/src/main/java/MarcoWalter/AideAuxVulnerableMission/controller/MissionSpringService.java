package MarcoWalter.AideAuxVulnerableMission.controller;

import MarcoWalter.AideAuxVulnerableMission.bdd.MissionTrueBDD;
import MarcoWalter.AideAuxVulnerableMission.model.Mission;

import java.util.Collection;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class MissionSpringService {
	
    @PostMapping("/ajoutMission")
    public boolean ajoutMission(@RequestBody Mission mission) {
    	mission.setMotif("");
    	mission.setRealised(false);
    	mission.setValidated(false);
    	mission.setReferred(false);
    	mission.setWaiting(true);
        MissionTrueBDD.ajouterMission(mission);
        return true;
    }

    @PutMapping(value = "/assignerMission/{missionId}/{benevoleId}")
    public boolean assignerMission(@PathVariable int missionId,
    							   @PathVariable int benevoleId) {
        Mission mission = MissionTrueBDD.getMission(missionId);
        mission.setBenevoleAssigneId(benevoleId);
        MissionTrueBDD.mettreAjourMission(mission);
        return true;
    }
    
    @PutMapping(value = "/referrerMission/{missionId}")
    public boolean assignerMission(@PathVariable int missionId) {
        Mission mission = MissionTrueBDD.getMission(missionId);
        mission.setReferred(true);
        if(mission.getIsReferentNeeded() && mission.isValidated()) {
        	mission.setWaiting(false);
        }
        MissionTrueBDD.mettreAjourMission(mission);
        return true;
    }

    @PutMapping(value = "/validerMission/{missionId}")
    public boolean validerMission(@PathVariable int missionId) {
        Mission mission = MissionTrueBDD.getMission(missionId);
        mission.setValidated(true);
        if(mission.getIsReferentNeeded() && mission.isReferred()) {
        	mission.setWaiting(false);
        }
        if(!mission.getIsReferentNeeded()) {
        	mission.setWaiting(false);
        }
        MissionTrueBDD.mettreAjourMission(mission);
        return true;
    }
    
    @PostMapping(value = "/refuserMission/{missionId}")
    public boolean refuserMission(@PathVariable int missionId, @RequestBody Mission missionTemp) {
        Mission mission = MissionTrueBDD.getMission(missionId);
        mission.setMotif(missionTemp.getMotif());
        mission.setWaiting(false);
        MissionTrueBDD.mettreAjourMission(mission);
        return true;
    }
    
    @PutMapping(value = "/completeMission/{missionId}")
    public boolean completeMission(@PathVariable int missionId) {
        Mission mission = MissionTrueBDD.getMission(missionId);
        mission.setRealised(true);
        MissionTrueBDD.mettreAjourMission(mission);
        return true;
    }
    
    @PostMapping(value = "/ajoutAvisMission/{missionId}")
    public boolean ajoutAvisMission(@PathVariable int missionId, @RequestBody Mission missionTemp) {
        Mission mission = MissionTrueBDD.getMission(missionId);
        mission.setAvis(missionTemp.getAvis());
        MissionTrueBDD.mettreAjourMission(mission);
        return true;
    }
    
    @GetMapping(value = "/getMission/{missionId}")
    public Mission getMission(@PathVariable int missionId) {
    	Mission mission = MissionTrueBDD.getMission(missionId);
        return mission;
    }

    @GetMapping(value = "/getMissionsDemandeur/{demandeurId}")
    public Collection<Mission> getMissionsDemandeur(@PathVariable int demandeurId) {
    	Collection<Mission> missions = MissionTrueBDD.getMissionsDemandeur(demandeurId);
        return missions;
    }

    @GetMapping(value = "/getMissionsBenevole/{benevoleId}")
    public Collection<Mission> getMissionsBenevole(@PathVariable int benevoleId) {
    	Collection<Mission> missions = MissionTrueBDD.getMissionsBenevole(benevoleId);
        return missions;
    }
    
    @GetMapping("/toutesLesMissionsSansBenevole")
    public Collection<Mission> toutesLesMissionsSansBenevole() {
        return MissionTrueBDD.getNonBenevoleMissions();
    }
    
    @GetMapping("/toutesLesMissionsNonValidees")
    public Collection<Mission> toutesLesMissionsNonValidees() {
        return MissionTrueBDD.getNonValidatedMissions();
    }
    
    @GetMapping("/toutesLesMissionsNonReferrees")
    public Collection<Mission> toutesLesMissionsNonReferrees() {
        return MissionTrueBDD.getNonReferredMissions();
    }

    @GetMapping("/toutesLesMissions")
    public Collection<Mission> toutesLesMissions() {
        return MissionTrueBDD.getAllMission();
    }
}
