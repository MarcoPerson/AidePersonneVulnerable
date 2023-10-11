package model;

public class Mission {
    int id;
    int demandeurId;
    int benevoleAssigneId;

    String sujet;
    boolean isValidated;

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
}
