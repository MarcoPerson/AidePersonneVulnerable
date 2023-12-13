package MarcoWalter.AideAuxVulnerableRest.service;

import MarcoWalter.AideAuxVulnerableRest.bdd.MissionTrueBDD;
import MarcoWalter.AideAuxVulnerableRest.model.Mission;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.util.Collection;

@Path("/mission")
public class MissionRestService {
	
    @POST
    @Path("/ajoutMission")
    @Consumes(MediaType.APPLICATION_JSON)
    public boolean ajoutMission(Mission mission) {
        MissionTrueBDD.ajouterMission(mission);
        return true;
    }

    @PUT
    @Path("/assignerMission/{benevoleId}/{missionId}")
    public boolean assignerMission(@PathParam("benevoleId") int benevoleId,
                                   @PathParam("missionId") int missionId) {
        Mission mission = MissionTrueBDD.getMission(missionId);
        mission.setBenevoleAssigneId(benevoleId);
        MissionTrueBDD.mettreAjourMission(mission);
        return true;
    }

    @PUT
    @Path("/validerMission/{missionId}")
    public boolean validerMission(@PathParam("missionId") int missionId) {
        Mission mission = MissionTrueBDD.getMission(missionId);
        mission.setValidated(true);
        MissionTrueBDD.mettreAjourMission(mission);
        return true;
    }

    @GET
    @Path("/toutesLesMissions")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Mission> toutesLesMissions() {
        return MissionTrueBDD.getAllMission();
    }
}
