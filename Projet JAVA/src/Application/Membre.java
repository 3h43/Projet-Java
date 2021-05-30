package Application;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Membre extends Personne{
	
	private Association association;
	private Boolean cotise;
	private Calendar DateDerniereInscription;
	private float cotisationPrice;
	private ArrayList<Float> cotiseList;
	private float cotisationTotale;
	private ArrayList<Arbres> nomination = new ArrayList<Arbres>();
	
	public Membre(String prenom, String nom, String adresse,Calendar DateDeNaissance, Calendar DateDerniereInscription, Association association) {
		super(prenom, nom, adresse, DateDeNaissance);
		this.DateDerniereInscription = DateDerniereInscription;
		this.association = association;
	}

	public void setDateDerniereInscription(String date) {
		
	}
	
	public void setCotise(Boolean cotise) {
		this.cotise = cotise;
	}
	
	public Boolean getCotise() {
		return this.cotise;
	}
	
	/*
	public void ajoutVisite(Calendar date, Arbres arbre) {
		if(arbre.isremarquable()) {
		for (int k=0; k < arbre.getListeVisites().size();k++) {
		if (arbre.getListeVisites().get(k) == date) {
			System.err.println("Une visite a déjà été programmée");
			}
		}
			arbre.ajoutListeVisites(date);
	}
	else {
		System.err.println("Cet arbre n'est pas remarquable");
		}
	}
	
	public void VisiteArbreRemarquable(Calendar date){
		for (int k =0;k<getListeRendezVous().size;k++) {
			if(getListeRendezVous().get(k) == date){
				System.out.println("Cette date est deja reservee");
			}
		}
		else{ 
			listeRendezVous.add(date); 
		}
	}
	
	*/
	
	public ArrayList<Float> getcotiseList() {                   
		return this.cotiseList;
	}
	
	public float getCotisationPrice() {                  
		return this.cotisationPrice;
	}
	
	public void setCotisationPrice(Float cotisationPrice) { 
		this.cotisationPrice = cotisationPrice;
		cotiseList.add(cotisationPrice);
		cotisationTotale+=cotisationPrice;
	}

	
	public boolean VerifNomin(Arbres arbre) {
		for (int k=0; k<nomination.size(); k++) {
			if (nomination.get(k) == arbre) {
				  return false;
				}
		}
		return true;
	}
	
	public float getCotisationTotale(){
		for (int k=0; k<cotiseList.size(); k++) {
			this.cotisationTotale = this.cotisationTotale + cotiseList.get(k);
		}
		return this.cotisationTotale;
	}
	
	public void Nominer(Arbres arbre) {
		if (VerifNomin(arbre)) {
		if (nomination.size() < 5) {
			nomination.add(0,arbre);
		}
		else {
			nomination.add(0,arbre);
			nomination.remove(nomination.size() -1);
			}
		}
		else {
			System.out.println("Arbre déjà nominé !");
		}
	}	
	
	public ArrayList<Arbres> getNomination() {
		ArrayList<Arbres> NominationMembre = new ArrayList<Arbres>();
		for (int k=0; k<nomination.size() ;k++) {
			NominationMembre.add(nomination.get(k));
		}
		return NominationMembre;
	}	
	
	
	public void toStringgetNomination() {
		StringBuilder str = new StringBuilder();
		for (int k=0; k<nomination.size() ;k++) {
			str.append("Arbre n°"+ k + " : " + nomination.get(k).getInfo() + "\n");
		}
		System.out.println("Les arbres nominés sont : \n" + str + "\n");
	}
	
}
