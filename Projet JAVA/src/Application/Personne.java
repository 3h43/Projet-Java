package Application;

public abstract class Personne {
	private String prenom;
	private String nom;
	private String adresse;
	
	public void setPrenom (String prenom) {
		this.prenom = prenom;
	}
	
	public void setNom (String nom) {
		this.nom = nom;
	}
	
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	
	public String getPrenom() {
		return this.prenom;
	}
	
	public String getNom() {
		return this.nom;
	}
	
	public String getAdresse() {
		return this.adresse;
	}
	
}
