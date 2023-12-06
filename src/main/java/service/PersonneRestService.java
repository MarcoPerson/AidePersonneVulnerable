package service;

import bdd.PersonneBDD;
import model.Personne;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
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
        PersonneBDD.ajouterPersonne(personne);
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
        PersonneBDD.ajouterPersonne(personne);
        return true;
    }

    @GET
    @Path("/toutesLesPersonnes")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Personne> toutesLesPersonnes() {
        return PersonneBDD.getAllPersonne();
    }
}
