package model;

public class Personne {
    int id;
    String nom;
    String prenom;
    int age;
    String adresse;
    Boolean isBenevole;

    public Personne(){};

    public Personne(String nom, String prenom, int age, String adresse) {
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.adresse = adresse;
    }

    public Personne(int id, String nom, String prenom, int age, String adresse, Boolean isBenevole) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.adresse = adresse;
        this.isBenevole = isBenevole;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public Boolean getBenevole() {
        return isBenevole;
    }

    public void setBenevole(Boolean benevole) {
        isBenevole = benevole;
    }
}
