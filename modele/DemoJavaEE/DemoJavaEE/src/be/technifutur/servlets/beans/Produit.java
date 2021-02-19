package be.technifutur.servlets.beans;

public class Produit {
	
	private String nom;
	private int prix;
	private int quantite;
	private TypeProd type;
	
	public Produit(String nom, int prix, int quantite, TypeProd type) {
		this.nom = nom;
		this.prix = prix;
		this.quantite = quantite;
		this.type = type;
	}

	public enum TypeProd {
		ALIMENT, MEUBLE, OUTIL
	}
	
	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public int getPrix() {
		return prix;
	}
	
	public void setPrix(int prix) {
		this.prix = prix;
	}
	
	public int getQuantite() {
		return quantite;
	}
	
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public TypeProd getType() {
		return type;
	}

	public void setType(TypeProd type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Produit " + nom + " - prix : " + prix + ", quantité : " + quantite + ", type : " + type;
	}
	
	

}
