package MarcoWalter.AideAuxVulnerablePersonne.model;

public class Personne {
	public enum TypeRole {
		Benevole("Benevole"), Demandeur("Demandeur"), Validateur("Validateur"), Referent("Referent");
		
		private final String value;

		TypeRole(String value) {
	        this.value = value;
	    }

	    public String getValue() {
	        return value;
	    }
	    
	    public static TypeRole fromValue(String value) {
	        for (TypeRole role : TypeRole.values()) {
	            if (role.getValue().equals(value)) {
	                return role;
	            }
	        }
	        throw new IllegalArgumentException("Invalid TypeRole value: " + value);
	    }
	    
	    @Override
	    public String toString() {
	    	return value;
	    }
	}
	
	TypeRole role; 
	
    public TypeRole getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = TypeRole.fromValue(role);
	}

	int id;
    String nom;
    String prenom;
    int age;
    String adresse;
    Boolean isReferentNeeded;

	public Personne(){};

    public Personne(String nom, String prenom, int age, String adresse) {
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.adresse = adresse;
    }

    public Personne(int id, String nom, String prenom, int age, String adresse, Boolean isReferentNeeded) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.adresse = adresse;
        this.isReferentNeeded = isReferentNeeded;
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
}
