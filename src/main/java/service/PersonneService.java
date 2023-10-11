package service;

import bdd.PersonneBDD;
import model.Personne;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.ArrayList;

@WebService(serviceName = "personne")
public class PersonneService {
    @WebMethod(operationName = "ajoutDemandeur")
    public boolean ajoutDemandeur(@WebParam(name = "demandeurNom") String demandeurNom,
                                  @WebParam(name = "demandeurPrenom") String demandeurPrenom,
                                  @WebParam(name = "demandeurAge") int demandeurAge,
                                  @WebParam(name = "demandeurAdresse") String demandeurAdresse){
        Personne personne = new Personne(demandeurNom, demandeurPrenom, demandeurAge, demandeurAdresse);
        personne.setBenevole(false);
        PersonneBDD.ajouterPersonne(personne);
        return true;
    }

    @WebMethod(operationName = "ajoutBenevole")
    public boolean ajoutBenevole(@WebParam(name = "benevoleNom") String benevoleNom,
                                  @WebParam(name = "benevolePrenom") String benevolePrenom,
                                  @WebParam(name = "benevoleAge") int benevoleAge,
                                  @WebParam(name = "benevoleAdresse") String benevoleAdresse){
        Personne personne = new Personne(benevoleNom, benevolePrenom, benevoleAge, benevoleAdresse);
        personne.setBenevole(true);
        PersonneBDD.ajouterPersonne(personne);
        return true;
    }

    @WebMethod(operationName = "toutesLesPersonnes")
    public ArrayList<Personne> toutesLesPersonnes(){
        return PersonneBDD.getAllPersonne();
    }
}
