package Application;

import java.util.Date;
import javafx.util.Pair;

public class Arbres {
	private String genre;
	private String espece;
	private String nom;
	private float circonf;
	private float hauteur;
	private String stade;
	private String adresse;
	private Pair<Float, Float> coord;
	private String classif;
	private Date date;
	private String etat;
	
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	public void setEspece(String espece) {
		this.espece = espece;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public void setCirconf(Float circonf) {
		this.circonf = circonf;
	}
	
	public void setHauteur(Float hauteur) {
		this.hauteur = hauteur;
	}
	
	public void setStade(String stade) {
		this.stade = stade;
	}
	
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	
	public void setCood(Pair<Float, Float> coord) {
		this.coord = coord;
	}
	
	public void setClassif(String classif) {
		this.classif = classif;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	public void setEtat(String etat) {
		this.etat = etat;
	}
	
	public String getGenre() {
		return this.genre;
	}
	
	public String getEspece() {
		return this.espece;
	}
	
	public String getNom() {
		return this.nom;
	}
	
	public Float getCirconf() {
		return this.circonf;
	}
	
	public Float getHauteur() {
		return this.hauteur;
	}
	
	public String getStade() {
		return this.stade;
	}
	
	public String getAdresse() {
		return this.adresse;
	}
	
	public Pair<Float, Float> getCoord() {
		return this.coord;
	}
	
	public String getClassif() {
		return this.classif;
	}
	
	public Date getDate() {
		return this.date;
	}
	
	public String getEtat() {
		return this.etat;
	}
	
	public String getInfo() {
		if (etat == "abattu") {
			return "Arbre abattu";
		}
		else {
			return "Voici les informations :"
					+ "Genre :" + getGenre() + " / "
					+ "Espece : " + getEspece() + " / "
					+ "Nom : " + getNom() + " / "
					+ "Circonférence : " + getCirconf() + " / "
					+ "Hauteur : " + getHauteur() + " / "
					+ " Stade : " + getStade() + " / "
					+ "Adresse : " + getAdresse() + " / "
					+ "Coordonnées : " + getCoord() + " / "
					+ "Classification : " + getClassif() + " / "
					+ "Date de classification : " + getDate() + " / ";
		}
	}
	
	
}
