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
    @Consumes(MediaType.APPLICATION_JSON)
    public boolean ajoutDemandeur(Personne personne) {
        personne.setBenevole(false);
        PersonneTrueBDD.ajouterPersonne(personne);
        return true;
    }

    @POST
    @Path("/ajoutBenevole")
    @Consumes(MediaType.APPLICATION_JSON)
    public boolean ajoutBenevole(Personne personne) {
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
