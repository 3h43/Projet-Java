package Application;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Association {
	
	private ArrayList<Membre> ListeMembres;
	
	public Association(ArrayList<Membre> ListeMembres) {
		this.ListeMembres = ListeMembres;
	}

	public ArrayList<String> ListeFinale(ArrayList<Membre> ListeMembres){
		ArrayList<Arbres> NominationFinale = new ArrayList<Arbres>();
		ArrayList<String> listefinale = new ArrayList<String>();
		for (int k=0; k<ListeMembres.size() ;k++) {
			for (int i=0; i<5 ; i++) {
			NominationFinale.add(ListeMembres.get(k).getNomination().get(i));
			}
			
			ArrayList<Integer> ListeID = new ArrayList<Integer>();
			for(int p = 0 ; p < NominationFinale.size() ; p++) {
				ListeID.add(NominationFinale.get(p).getID());
			}
			
			Map<Integer,Integer> map = new HashMap<>();
			
			for(int j = 0 ; j < NominationFinale.size(); j++){
				if(map.containsKey(NominationFinale.get(j))) {
					map.replace(NominationFinale.get(j).getID(),map.get(NominationFinale.get(j))+1);
					}
			 else {
			  map.put(NominationFinale.get(j).getID(),1);
			  }
			}
		
			 Map<Integer, Integer> tri = new LinkedHashMap<>();
		        map.entrySet().stream()
		                .sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed())
		                .forEachOrdered(x -> tri.put(x.getKey(), x.getValue()));
			
			System.out.println(tri);
				if(tri.values().toArray()[4]!=tri.values().toArray()[5]) {
					for (Map.Entry<Integer, Integer> entry : tri.entrySet()) {
					    listefinale.add("idBase : " + entry.getKey() + " - Nombre de votes : " + entry.getValue());
					    for (int m=0;m<(listefinale.size()-5); m++) {
					    	listefinale.remove(listefinale.size() - 1);
					    }
					}	
				}
			}
		return listefinale;
		}
	
	
}
