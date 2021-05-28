package Application;

import java.util.ArrayList;

public class Membre extends Personne{
	
	private Boolean cotise;
	private ArrayList<Arbres> nomination;
	
	public void setCotise(Boolean costise) {
		this.cotise = cotise;
	}
	
	public Boolean getCotise() {
		return this.cotise;
	}
	
	public void Nominer(Arbres arbre) {
		int k = 0;
		if (nomination.size() < 5) {
			nomination.add(0,arbre);
		}
		else {
			nomination.add(0,arbre);
			nomination.remove(-1);
		}
	}
	
	public String getNomination(ArrayList<Arbres> nomination) {
		StringBuilder str = new StringBuilder();
		for (int k=0; k<nomination.size() ;k++) {
			str.append("Arbre n°"+ k + " : " + nomination.get(k).getInfo() + "\n");
		}
		return "Les arbres nominés sont :" + str;
	}
	
}
