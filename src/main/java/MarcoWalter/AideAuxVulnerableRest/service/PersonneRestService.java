package MarcoWalter.AideAuxVulnerableRest.service;

import MarcoWalter.AideAuxVulnerableRest.bdd.PersonneTrueBDD;
import MarcoWalter.AideAuxVulnerableRest.model.Personne;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.util.ArrayList;

@Path("/personne")
public class PersonneRestService {

    @POST
    @Path("/ajoutDemandeur")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public boolean ajoutDemandeur(@FormParam("demandeurNom") String demandeurNom,
                                  @FormParam("demandeurPrenom") String demandeurPrenom,
                                  @FormParam("demandeurAge") int demandeurAge,
                                  @FormParam("demandeurAdresse") String demandeurAdresse) {
        Personne personne = new Personne(demandeurNom, demandeurPrenom, demandeurAge, demandeurAdresse);
        personne.setBenevole(false);
        PersonneTrueBDD.ajouterPersonne(personne);
        return true;
    }

    @POST
    @Path("/ajoutBenevole")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public boolean ajoutBenevole(@FormParam("benevoleNom") String benevoleNom,
                                 @FormParam("benevolePrenom") String benevolePrenom,
                                 @FormParam("benevoleAge") int benevoleAge,
                                 @FormParam("benevoleAdresse") String benevoleAdresse) {
        Personne personne = new Personne(benevoleNom, benevolePrenom, benevoleAge, benevoleAdresse);
        personne.setBenevole(true);
        PersonneTrueBDD.ajouterPersonne(personne);
        return true;
    }

    @GET
    @Path("/toutesLesPersonnes")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Personne> toutesLesPersonnes() {
        return PersonneTrueBDD.getAllPersonne();
    }
}
