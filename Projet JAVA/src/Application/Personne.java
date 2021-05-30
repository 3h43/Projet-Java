package Application;
import java.util.Calendar;
import java.util.Date;

public class Personne extends Donateur {
	private String prenom;
	private String nom;
	private String adresse;
	private Calendar DateDeNaissance;
	private MessageriePersonne MessageriePersonne;
	
	public Personne(String prenom, String nom, String adresse,Calendar DateDeNaissance) {
		this.prenom = prenom;
		this.nom = nom;
		this.adresse = adresse;
		this.DateDeNaissance = DateDeNaissance;
	}
	
	public MessageriePersonne getMessagerie() {
		return this.MessageriePersonne;
	}

	public void setPrenom (String prenom) {
		this.prenom = prenom;
	}

	public Membre Inscription(Association association, Calendar date) {
		Membre membre = new Membre(this.prenom, this.nom, this.adresse, this.DateDeNaissance, date, association);
		return membre;
	}
	
	
	public void setNom (String nom) {
		this.nom = nom;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public void setDateDeNaissance(String date){
		this.DateDeNaissance= date;
	}

	public String getDateDeNaissance(){
		return this.DateDeNaissance;
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
