package Application;

import java.util.ArrayList;

public class Association {
	
	private ArrayList<Membre> ListeMembres;
	
			
	public ArrayList<Arbres> ListeFinale(ArrayList<Membre> ListeMembres){
		ArrayList<Arbres> NominationFinale = new ArrayList<Arbres>();
		for (int k=0; k<ListeMembres.size() ;k++) {
			ListeMembres.get(k).getNomination();
			
		}
		return NominationFinale;
	}
	
}
