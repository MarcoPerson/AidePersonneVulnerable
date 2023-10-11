package bdd;

import model.Personne;

import java.util.ArrayList;

public class PersonneBDD {
    static int lastId = 0;
    static ArrayList<Personne> personneBDD = new ArrayList<>();

    public PersonneBDD() {
    }

    public static void initBdd(){
        personneBDD.add(new Personne(lastId, "Telefo", "Walter", 21, "Rue des Demandeurs, Toulouse", false));
        lastId++;
        personneBDD.add(new Personne(lastId, "Person", "Marco", 23, "Rue des Benevoles, Toulouse", true));
        lastId++;
    }
    public static void ajouterPersonne(Personne personne){
        personne.setId(lastId);
        personneBDD.add(personne);
        lastId++;
    }

    public static ArrayList<Personne> getAllPersonne(){
        return personneBDD;
    }
    public static void supprimerPersonne(Personne personne){
        personneBDD.remove(personne);
    }
}
