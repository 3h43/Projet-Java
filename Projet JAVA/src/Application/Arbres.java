package Application;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Arbres {
	
    private Integer idBase;
    private String adresse;
    private String libelleFrancais;
    private String genre;
    private String espece;
    private Integer circonferenceEnCm;
    private Integer hauteurEnM;
    private String stadeDeveloppement;
    private Boolean remarquable;
    private Float[] geographicalPoint2D = new Float[2];
	private String classif;
	private Date date;
	private String etat;
	private ArrayList<CompteRendu> ListeCompteRendu;
	private ArrayList<String> ListeVisites = null;
	
	ArrayList<CompteRendu> vide = new ArrayList<CompteRendu>();
	

	public Arbres(Integer idBase, String adresse, String libelleFrancais, String genre, String espece, Integer circonferenceEnCm, Integer hauteurEnM, 
			String stadeDeveloppement, Boolean remarquable, Float[] geographicalPoint2D) {
		this.idBase = idBase;
		this.adresse = adresse;
		this.libelleFrancais = libelleFrancais;
		this.genre = genre;
		this.espece = espece;
		this.circonferenceEnCm = circonferenceEnCm;
		this.hauteurEnM = hauteurEnM;
		this.stadeDeveloppement = stadeDeveloppement;
		this.remarquable = remarquable;
		this.geographicalPoint2D = geographicalPoint2D;
		this.ListeCompteRendu = vide;
	}

	public ArrayList<String> getListeVisites(){
		return this.ListeVisites;
	}
	
	public void ajoutListeVisites(String date){
		ListeVisites.add(date);
	}
	
	public void setAbattage() {
		this.idBase = 00000;
		this.adresse = null;
		this.libelleFrancais = "Arbre abattu";
		this.genre = null;
		this.espece = null;
		this.circonferenceEnCm = null;
		this.hauteurEnM = null;
		this.stadeDeveloppement = null;
		this.remarquable = null;
		this.geographicalPoint2D = null;
	}
	
	public void ajoutCompteRendu(String message, Calendar datecompterendu, Membre membre) {
		CompteRendu compterendu = new CompteRendu(message, datecompterendu, membre);
		ListeCompteRendu.add(compterendu);
	}
	
	public void getCompteRendu(Calendar date) {
		for (int k=0; k<ListeCompteRendu.size(); k++) {
			if (ListeCompteRendu.get(k).getDate() == date) {
				System.out.println(ListeCompteRendu.get(k).getCompteRendu());
			}
			else {
				System.out.println("Pas de Compte rendu à cette date");
				}
		}
	}
	
	public void setRemarquable() {
		this.remarquable = true;
	}
	
	public boolean isremarquable() {
		return remarquable;
	}
	
	public void setID(int idBase) {
		this.idBase = idBase;
	}
	
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	public void setEspece(String espece) {
		this.espece = espece;
	}
	
	public void setNom(String libelleFrancais) {
		this.libelleFrancais = libelleFrancais;
	}
	
	public void setCirconf(Integer circonferenceEnCm) {
		this.circonferenceEnCm = circonferenceEnCm;
	}
	
	public void setHauteur(Integer hauteurEnM) {
		this.hauteurEnM = hauteurEnM;
	}
	
	public void setStade(String stadeDeveloppement) {
		this.stadeDeveloppement = stadeDeveloppement;
	}
	
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	
	public void setCood(Float[] geographicalPoint2D) {
		this.geographicalPoint2D = geographicalPoint2D;
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
	
	public int getID() {
		return this.idBase;
	}
	
	public String getGenre() {
		return this.genre;
	}
	
	public String getEspece() {
		return this.espece;
	}
	
	public String getNom() {
		return this.libelleFrancais;
	}
	
	public Integer getCirconf() {
		return this.circonferenceEnCm;
	}
	
	public Integer getHauteur() {
		return this.hauteurEnM;
	}
	
	public String getStade() {
		return this.stadeDeveloppement;
	}
	
	public String getAdresse() {
		return this.adresse;
	}
	
	public Float[] getCoord() {
		return this.geographicalPoint2D;
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
			return "Voici les informations =>"
					+ " idBase : " + getID() + " / "
					+ "Genre : " + getGenre() + " / "
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
