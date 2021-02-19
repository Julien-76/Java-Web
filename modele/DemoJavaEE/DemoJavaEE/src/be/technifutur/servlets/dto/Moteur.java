package be.technifutur.servlets.dto;

import java.util.Objects;

public class Moteur {
	
	private int id;
    private int cylindree;
    private Carburant carburant;
    private int puissance;
    
    public Moteur() {
    	
    }

    public Moteur(int id, int cylindree, Carburant carburant, int puissance) {
        this.id = id;
        this.cylindree = cylindree;
        this.carburant = carburant;
        this.puissance = puissance;
    }

    public Moteur(int cylindree, Carburant carburant, int puissance) {
        this.cylindree = cylindree;
        this.carburant = carburant;
        this.puissance = puissance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCylindree() {
        return cylindree;
    }

    public void setCylindree(int cylindree) {
        this.cylindree = cylindree;
    }

    public Carburant getCarburant() {
        return carburant;
    }

    public void setCarburant(Carburant carburant) {
        this.carburant = carburant;
    }

    public int getPuissance() {
        return puissance;
    }

    public void setPuissance(int puissance) {
        this.puissance = puissance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Moteur moteur = (Moteur) o;
        return id == moteur.id &&
                cylindree == moteur.cylindree &&
                puissance == moteur.puissance &&
                carburant == moteur.carburant;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cylindree, carburant, puissance);
    }

    @Override
    public String toString() {
        return "(ID " + id +
                ", cylindrée : " + cylindree +
                " CC, carburant : " + carburant +
                ", puissance : " + puissance +
                " CV)";
    }

}
