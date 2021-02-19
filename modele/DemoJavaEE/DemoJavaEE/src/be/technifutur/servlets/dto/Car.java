package be.technifutur.servlets.dto;

import java.util.Objects;

public class Car {
	
	private int id;
    private String model;
    private Double price;
    private Moteur moteur;

    public Car() {
    	
    }
    
    public Car(int id, String model, Double price, Moteur moteur) {
        this.id = id;
        this.model = model;
        this.price = price;
        this.moteur = moteur;
    }

    public Car(String model, Double price, Moteur moteur) {
        this.model = model;
        this.price = price;
        this.moteur = moteur;
    }

	public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Moteur getMoteur() {
        return moteur;
    }

    public void setMoteur(Moteur moteur) {
        this.moteur = moteur;
    }

    @Override
    public String toString() {
        return "Voiture " +
                "ID = " + id +
                ", Modèle = " + model +
                ", Prix = " + price +
                ", Moteur = " + moteur;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car voiture = (Car) o;
        return id == voiture.id &&
                model.equals(voiture.model) &&
                price.equals(voiture.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, model, price, moteur);
    }

}
