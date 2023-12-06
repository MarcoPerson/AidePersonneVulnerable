package service;

import bdd.MissionBDD;
import model.Mission;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Collection;

@Path("/mission")
public class MissionRestService {

    @POST
    @Path("/ajoutMission")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public boolean ajoutMission(@FormParam("demandeurId") int demandeurId,
                                @FormParam("missionSujet") String missionSujet) {
        Mission mission = new Mission(demandeurId, missionSujet);
        MissionBDD.ajouterMission(mission);
        return true;
    }

    @PUT
    @Path("/assignerMission/{benevoleId}/{missionId}")
    public boolean assignerMission(@PathParam("benevoleId") int benevoleId,
                                   @PathParam("missionId") int missionId) {
        Mission mission = MissionBDD.getMission(missionId);
        mission.setBenevoleAssigneId(benevoleId);
        MissionBDD.mettreAjourMission(mission);
        return true;
    }

    @PUT
    @Path("/validerMission/{missionId}")
    public boolean validerMission(@PathParam("missionId") int missionId) {
        Mission mission = MissionBDD.getMission(missionId);
        mission.setValidated(true);
        MissionBDD.mettreAjourMission(mission);
        return true;
    }

    @GET
    @Path("/toutesLesMissions")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Mission> toutesLesMissions() {
        return MissionBDD.getAllMission();
    }
}
