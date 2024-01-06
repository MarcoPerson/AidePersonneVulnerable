package MarcoWalter.AideAuxVulnerableRelation.model;

public class InfosMission {
    int id;
    int demandeurId;
    int benevoleAssigneId;
    String sujet;
    String motif;
	String avis;
    boolean isValidated;
    boolean isWaiting;
    boolean isRealised;
    boolean isReferred;
    boolean isReferentNeeded;
    String nomDemandeur;
    String prenomDemandeur;
    int ageDemandeur;
    String adresseDemandeur;
    String nomBenevole;
    String prenomBenevole;
    int ageBenevole;
    String adresseBenevole;
    
	public InfosMission() {
		super();
	}
	
	public InfosMission(int id, int demandeurId, int benevoleAssigneId, String sujet, String motif, String avis, boolean isValidated,
			boolean isWaiting, boolean isRealised, boolean isReferred, boolean isReferentNeeded, String nomDemandeur,
			String prenomDemandeur, int ageDemandeur, String adresseDemandeur, String nomBenevole,
			String prenomBenevole, int ageBenevole, String adresseBenevole) {
		super();
		this.id = id;
		this.demandeurId = demandeurId;
		this.benevoleAssigneId = benevoleAssigneId;
		this.sujet = sujet;
		this.motif = motif;
		this.avis = avis;
		this.isValidated = isValidated;
		this.isWaiting = isWaiting;
		this.isRealised = isRealised;
		this.isReferred = isReferred;
		this.isReferentNeeded = isReferentNeeded;
		this.nomDemandeur = nomDemandeur;
		this.prenomDemandeur = prenomDemandeur;
		this.ageDemandeur = ageDemandeur;
		this.adresseDemandeur = adresseDemandeur;
		this.nomBenevole = nomBenevole;
		this.prenomBenevole = prenomBenevole;
		this.ageBenevole = ageBenevole;
		this.adresseBenevole = adresseBenevole;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getDemandeurId() {
		return demandeurId;
	}
	public void setDemandeurId(int demandeurId) {
		this.demandeurId = demandeurId;
	}
	public int getBenevoleAssigneId() {
		return benevoleAssigneId;
	}
	public void setBenevoleAssigneId(int benevoleAssigneId) {
		this.benevoleAssigneId = benevoleAssigneId;
	}
	public String getSujet() {
		return sujet;
	}
	public void setSujet(String sujet) {
		this.sujet = sujet;
	}
	public boolean isValidated() {
		return isValidated;
	}
	public void setValidated(boolean isValidated) {
		this.isValidated = isValidated;
	}
	public boolean isReferred() {
		return isReferred;
	}
	public void setReferred(boolean isReferred) {
		this.isReferred = isReferred;
	}
	public boolean isReferentNeeded() {
		return isReferentNeeded;
	}
	public void setReferentNeeded(boolean isReferentNeeded) {
		this.isReferentNeeded = isReferentNeeded;
	}
	public String getNomDemandeur() {
		return nomDemandeur;
	}
	public void setNomDemandeur(String nomDemandeur) {
		this.nomDemandeur = nomDemandeur;
	}
	public String getPrenomDemandeur() {
		return prenomDemandeur;
	}
	public void setPrenomDemandeur(String prenomDemandeur) {
		this.prenomDemandeur = prenomDemandeur;
	}
	public int getAgeDemandeur() {
		return ageDemandeur;
	}
	public void setAgeDemandeur(int ageDemandeur) {
		this.ageDemandeur = ageDemandeur;
	}
	public String getAdresseDemandeur() {
		return adresseDemandeur;
	}
	public void setAdresseDemandeur(String adresseDemandeur) {
		this.adresseDemandeur = adresseDemandeur;
	}
	public String getNomBenevole() {
		return nomBenevole;
	}
	public void setNomBenevole(String nomBenevole) {
		this.nomBenevole = nomBenevole;
	}
	public String getPrenomBenevole() {
		return prenomBenevole;
	}
	public void setPrenomBenevole(String prenomBenevole) {
		this.prenomBenevole = prenomBenevole;
	}
	public int getAgeBenevole() {
		return ageBenevole;
	}
	public void setAgeBenevole(int ageBenevole) {
		this.ageBenevole = ageBenevole;
	}
	public String getAdresseBenevole() {
		return adresseBenevole;
	}
	public void setAdresseBenevole(String adresseBenevole) {
		this.adresseBenevole = adresseBenevole;
	}

	public String getMotif() {
		return motif;
	}

	public void setMotif(String motif) {
		this.motif = motif;
	}

	public String getAvis() {
		return avis;
	}

	public void setAvis(String avis) {
		this.avis = avis;
	}

	public boolean isWaiting() {
		return isWaiting;
	}

	public void setWaiting(boolean isWaiting) {
		this.isWaiting = isWaiting;
	}

	public boolean isRealised() {
		return isRealised;
	}

	public void setRealised(boolean isRealised) {
		this.isRealised = isRealised;
	}
	
}
