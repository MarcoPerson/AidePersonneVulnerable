package MarcoWalter.AideAuxVulnerableMission.model;

public class Mission {
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

	public Mission(){}

    public Mission(int demandeurId, String sujet) {
        this.demandeurId = demandeurId;
        this.sujet = sujet;
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

    public void setValidated(boolean validated) {
        isValidated = validated;
    }
    
    public boolean isReferred() {
		return isReferred;
	}

	public void setReferred(boolean isReferred) {
		this.isReferred = isReferred;
	}

	public boolean getIsReferentNeeded() {
		return isReferentNeeded;
	}

	public void setIsReferentNeeded(boolean isReferentNeeded) {
		this.isReferentNeeded = isReferentNeeded;
	}

	public String getMotif() {
		return motif;
	}

	public void setMotif(String motif) {
		this.motif = motif;
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

	public String getAvis() {
		return avis;
	}

	public void setAvis(String avis) {
		this.avis = avis;
	}
}
