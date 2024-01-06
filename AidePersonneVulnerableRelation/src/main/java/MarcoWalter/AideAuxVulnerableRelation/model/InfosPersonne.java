package MarcoWalter.AideAuxVulnerableRelation.model;

import java.util.Collection;

public class InfosPersonne {
    int id;
    String nom;
    String prenom;
    int age;
    String adresse;
    Boolean isReferentNeeded;
    Collection<Mission> missions = null;
    
	public InfosPersonne() {
		super();
	}
	public InfosPersonne(int id, String nom, String prenom, int age, String adresse, Boolean isReferentNeeded,
			Collection<Mission> missions) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
		this.adresse = adresse;
		this.isReferentNeeded = isReferentNeeded;
		this.missions = missions;
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
	public Boolean getIsReferentNeeded() {
		return isReferentNeeded;
	}
	public void setIsReferentNeeded(Boolean isReferentNeeded) {
		this.isReferentNeeded = isReferentNeeded;
	}
	public Collection<Mission> getMissions() {
		return missions;
	}
	public void setMissions(Collection<Mission> missions) {
		this.missions = missions;
	}
    
    
}
