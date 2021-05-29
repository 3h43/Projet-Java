package Application;

import java.util.ArrayList;

public class Membre extends Personne{
	
	private Boolean cotise;
	private ArrayList<Arbres> nomination = new ArrayList<Arbres>();
	
	public Membre(String prenom, String nom, String adresse, boolean cotise) {
		super(prenom, nom, adresse);
		this.cotise = cotise;
	}
	
	public void setCotise(Boolean costise) {
		this.cotise = cotise;
	}
	
	public Boolean getCotise() {
		return this.cotise;
	}
	
	public void Nominer(Arbres arbre) {
		if (nomination.size() < 5) {
			nomination.add(0,arbre);
		}
		else {
			nomination.add(0,arbre);
			nomination.remove(nomination.size() -1);
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
