package be.technifutur.servlets.beans;

public class Voiture {
	
	// Ce fichier est un bean, classe utilisable dans un servlet
	
	private String modele;
	private int cylindree;
	
	public String getModele() {
		return modele;
	}
	
	public void setModele(String modele) {
		this.modele = modele;
	}
	
	public int getCylindree() {
		return cylindree;
	}
	
	public void setCylindree(int cylindree) {
		this.cylindree = cylindree;
	}

	@Override
	public String toString() {
		return "Voiture [modele=" + modele + ", cylindree=" + cylindree + "]";
	}
	
	
}
