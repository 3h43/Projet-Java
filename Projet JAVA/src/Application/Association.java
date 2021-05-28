package Application;

import java.util.ArrayList;
import java.util.Collections;

public class Association {
	
	private ArrayList<Membre> ListeMembres;
	
	public Association(ArrayList<Membre> ListeMembres) {
		this.ListeMembres = ListeMembres;
	}
	
	public ArrayList<Arbres> ListeFinale(ArrayList<Membre> ListeMembres){
		ArrayList<Arbres> NominationFinale = new ArrayList<Arbres>();
		for (int k=0; k<ListeMembres.size() ;k++) {
			for (int i=0; i<5 ; i++) {
			NominationFinale.add(ListeMembres.get(k).getNomination().get(i));
			Collections.frequency(NominationFinale, ListeMembres.get(k).getNomination().get(i).getID());
			}
		}
		return NominationFinale;
	}
	
}
