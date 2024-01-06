package MarcoWalter.AideAuxVulnerablePersonne.controller;

import MarcoWalter.AideAuxVulnerablePersonne.bdd.PersonneTrueBDD;
import MarcoWalter.AideAuxVulnerablePersonne.model.Personne;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonneSpringService {

    @PostMapping("/ajoutPersonne")
    public boolean ajoutBenevole(@RequestBody Personne personne) {
    	if(personne.getIsReferentNeeded() == null) {
    		personne.setIsReferentNeeded(false);
    	}
        PersonneTrueBDD.ajouterPersonne(personne);
        return true;
    }
    
    @GetMapping("/getPersonne/{personneId}")
    public Personne getPersonne(@PathVariable int personneId) {
        return PersonneTrueBDD.getPersonne(personneId);
    }
    
    @GetMapping("/supprimerPersonne/{personneId}")
    public boolean supprimerPersonne(@PathVariable int personneId) {
        PersonneTrueBDD.supprimerPersonne(personneId);
        return true;
    }

    @GetMapping("/toutesLesPersonnes")
    public ArrayList<Personne> toutesLesPersonnes() {
        return PersonneTrueBDD.getAllPersonne();
    }
    
    @GetMapping("/tousLesDemandeurs")
    public ArrayList<Personne> tousLesDemandeurs() {
        return PersonneTrueBDD.getAllDemandeurs();
    }
    
    @GetMapping("/tousLesValidateurs")
    public ArrayList<Personne> tousLesValidateurs() {
        return PersonneTrueBDD.getAllValidateurs();
    }
    
    @GetMapping("/tousLesBenevoles")
    public ArrayList<Personne> tousLesBenevoles() {
        return PersonneTrueBDD.getAllBenevoles();
    }
    
    @GetMapping("/tousLesReferents")
    public ArrayList<Personne> tousLesReferents() {
        return PersonneTrueBDD.getAllReferents();
    }
}
