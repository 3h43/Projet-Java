package Application;

import java.util.ArrayList;

public class Membre extends Personne{
	
	private Boolean cotise;
	private ArrayList<Arbres> nomination;
	
	public Membre( Boolean cotise, ArrayList<Arbres> nomination) {
		this.cotise = cotise;
		this.nomination = nomination;
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
			nomination.remove(-1);
		}
	}	
	
	public ArrayList<Arbres> getNomination() {
		ArrayList<Arbres> NominationMembre = new ArrayList<Arbres>();
		for (int k=0; k<nomination.size() ;k++) {
			NominationMembre.add(nomination.get(k));
		}
		return NominationMembre;
	}	
	
	
	public String toStringgetNomination() {
		StringBuilder str = new StringBuilder();
		for (int k=0; k<nomination.size() ;k++) {
			str.append("Arbre n°"+ k + " : " + nomination.get(k).getInfo() + "\n");
		}
		return "Les arbres nominés sont : " + str + "\n";
	}
	
}
