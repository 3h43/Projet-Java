package Application;

public class Donateur implements Entities {
	
	private String nomdonateur;
    
	public void donner(float don, Association association) {
		association.getCagnotte().AjoutMontant(don);
	}
	
	public String getNom() {
		return this.nomdonateur;
	}
	
}

