package Application;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Association extends Donateur {
	
	private ArrayList<Membre> ListeMembres;
	private ArrayList<Arbres> ListeArbres;
	protected ArrayList<Donateur> DonateurList;
	private Cagnotte cagnotte;
	private MessagerieAssociation MessagerieAssociation;
	private float pointBudgetaire;
	private float recetteTotale;
	private float depenseTotale;
	private String demandeSubvention = "L'association a besoin de : ";
	private float montantSubvention;
	private ArrayList<String> activiteList;

	
	public Association(ArrayList<Membre> ListeMembres,ArrayList<Arbres> ListeArbres,ArrayList<Donateur> DonateurList, Cagnotte cagnotte) {
		this.ListeMembres = ListeMembres;
		this.ListeArbres = ListeArbres;
		this.DonateurList = DonateurList;
		this.cagnotte = cagnotte;
	}
	
	public Cagnotte getCagnotte() {
		return this.cagnotte;
	}
	
	public void TrouverVisite() {
		ArrayList<Arbres> ListeRemarquables = new ArrayList<Arbres>();
		for (int k=0; k<ListeArbres.size();k++) {
			if (ListeArbres.get(k).isremarquable() == true) {
				ListeRemarquables.add(ListeArbres.get(k));
			}
		}

	}
	
	public ArrayList<Membre> getListeMembre(){
		return this.ListeMembres;
	}
	
	public void PayerFacture(float facture) {
		if(facture < cagnotte.getMontant()) {
			cagnotte.EnleveMontant(facture);
		}
		else {
			System.out.println("Pas assez d'argent, il faut demander des dons");
		}
	}
	
	public void setPointBudgetaire(float budget){
		this.pointBudgetaire = budget;
	}

	public void setRecetteTotale(float recette){
		this.recetteTotale+=recette;
		pointBudgetaire+=recette;
	}

	public void setDepenseTotale(float depense){
		this.depenseTotale+=depense;
		pointBudgetaire-=depense;
	}

	public float getPointBudgetaire(){
		return this.pointBudgetaire;
	}

	public float getRecetteTotale() {
		return this.recetteTotale;
	}

	public float getDepenseTotale(){
		return this.depenseTotale;
	}
	
	public void setMontantSubvention(float montant){
		this.montantSubvention = montant;
	}
	
	public float getMontantSubvention(){
		return montantSubvention;
	}
	
	public void setDemandeSubvention(float montant) {
		this.demandeSubvention += montant + "�\n";
	}
	
	public String getDemandeSubvention() {
		return this.demandeSubvention + "Nos recettes sont : " + recetteTotale +"\n"
				+ "Nos depenses sont : " + depenseTotale
				+ "\n" + "Notre point Budgetaire est : " + pointBudgetaire + "\n"
				+ "Nos dernieres activitees sont " + "INSERER getActitviteList";
	}
	
	public void getActiviteList(){
		for(int a=0;a<activiteList.size();a++){
			System.out.println("\n");
			System.out.println(activiteList.get(a));
		}
	}
	
	public void setActiviteList(String activite){
		this.activiteList.add(activite);
	}
	
	public boolean estDansAssociation(Personne personne){
		for (int k=0; k<ListeMembres.size(); k++) {
			if(ListeMembres.get(k) == personne){
				return true;
			}
		}
		return false;
	}
	
	public void AjoutMembre(Personne personne, Association association, Calendar date){
		if(estDansAssociation(personne)) {
			System.err.println("Ce membre est d�j� dans l'association");
		}
		else {
			ListeMembres.add(personne.Inscription(association, date));
			}
	}
	
	public void ExclureMembre(Membre membre){
		if(estDansAssociation(membre)){
			quitterAssociation(membre);
		}
		else {System.err.println("Ce membre n'est pas dans l'association");}
	}
	
	public void quitterAssociation(Membre membre){
		if (estDansAssociation(membre)){
			membre.setNom("<< Membre ayant quitté l'Association>> ");
			membre.setPrenom("");
			membre.setAdresse("");
			membre.setDateDeNaissance("0,0,0");
			membre.setDateDerniereInscription("0,0,0");
			ListeMembres.remove(membre);
		}
		else {
			System.err.println("Le membre n'est pas dans l'association");
		}
	}
	
	public Membre ListetoMembre(int k) {
		return ListeMembres.get(k);
	}
	
	public void checkMemberCotise(ArrayList<Membre> liste){          
		for(int j=0; j<liste.size();j++){                           
			if (liste.get(j).getCotise() == false){
				quitterAssociation(liste.get(j));
			}
		}
	}
	
	public boolean estDonateur(Entities entite){
		for (int k=0; k<DonateurList.size(); k++) {
			if(DonateurList.get(k) == entite){
				return true;
			}
		}
		return false;
	}
	
//a finir
	public void supprimerDonateur(Donateur donateur){
		for (int k=0; k<DonateurList.size(); k++) {
			if(DonateurList.get(k).getNom() == donateur.getNom()){
				DonateurList.remove(k);
			}
		}
	}
//
	
	public void AjoutDonateur(Entities entite){
		if(estDonateur(entite)) {
			System.err.println("Cette entite donne deja");
		}
		else {
			}
			if (entite.getClass() == Entreprises.class) {
				Entreprises Entreprise = new Entreprises();
				DonateurList.add(Entreprise);
			}
			if (entite.getClass() == Municipalité.class) {
				Municipalité municipalité = new Municipalité();
				DonateurList.add(municipalité);
			}
			if (entite.getClass() == Personne.class) {
				Personne donateur = new Personne("A REMPLIR", "A REMPLIR", 	"A REMPLIR", null);
				DonateurList.add(donateur);
			}
		}

	
	public void remarquable(Arbres arbre){
		arbre.setClassif("remarquable");

	}
	
	public void nonRemarquable(Arbres arbre){
		arbre.setClassif("");
	}

	
	public Arbres idToArbre(Integer id) {
		Integer idx = 0;
		for (int k=0; k<ListeArbres.size(); k++) {
			if (ListeArbres.get(k).getID() == id) {
				idx = k;
			}
		}
		return ListeArbres.get(idx);
	}


	public ArrayList<Arbres> ListeFinale(ArrayList<Membre> ListeMembres){
		ArrayList<Arbres> NominationFinale = new ArrayList<Arbres>();
		ArrayList<String> listefinale = new ArrayList<String>();
		
		try {
		for (int k=0; k<ListeMembres.size() ;k++) {
			for (int i=0; i<5 ; i++) {
				NominationFinale.add(ListeMembres.get(k).getNomination().get(i));
				}
			}

		}
			catch(Exception e) {
			   System.err.println("");
			   System.err.println("Exception: ");
			   System.out.println("Un membre a tenté de nominer deux fois un arbre, son vote n'a pas été compté.");
			   System.err.println("");

			}

			ArrayList<Integer> ListeID = new ArrayList<Integer>();
			for(int p = 0 ; p < NominationFinale.size() ; p++) {
				ListeID.add(NominationFinale.get(p).getID());
			}

			Map<Integer,Integer> map = new HashMap<>();
			for(int j = 0 ; j < NominationFinale.size(); j++){
				if(map.containsKey(ListeID.get(j))) {
					map.replace(ListeID.get(j), map.get(ListeID.get(j))+1);
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
		       
		        if(tri.size()>=6) {
		        	
		        	if(tri.values().toArray()[4] != tri.values().toArray()[5]) {
					    NominationFinale.removeAll(NominationFinale);
		        		for (Map.Entry<Integer, Integer> entry : tri.entrySet()) {
		        			listefinale.add("idBase : " + entry.getKey() + " - Nombre de votes : " + entry.getValue());
						    NominationFinale.add(idToArbre(entry.getKey()));

		        			}
					    for (int m=0;m<(listefinale.size()-5); m++) {
					    	listefinale.remove(listefinale.size() - 1);
					    } 	
		        	}
		        	
		        	else {
					
					ArrayList<Integer> ListeIDfinal = new ArrayList<Integer>();
					for (Integer key : tri.keySet() ) {
					    ListeIDfinal.add(key);
					}

					ArrayList<Integer> ListeVotes = new ArrayList<Integer>();
					for (Integer value : tri.values() ) {
					    ListeVotes.add(value);
					}
//					9,8,7,6//5,5//,5,5
					
					Arbres arbre1 = idToArbre(ListeIDfinal.get(4));
					Arbres arbre2 = idToArbre(ListeIDfinal.get(5));

		
					if (arbre1.getCirconf() > arbre2.getCirconf()) {
					    NominationFinale.removeAll(NominationFinale);

						tri.remove(ListeIDfinal.get(5));
						for (Map.Entry<Integer, Integer> entry : tri.entrySet()) {
						    listefinale.add("idBase : " + entry.getKey() + " - Nombre de votes : " + entry.getValue());
						    NominationFinale.add(idToArbre(entry.getKey()));

						}

					}

					if (arbre1.getCirconf() < arbre2.getCirconf()) {		
					    NominationFinale.removeAll(NominationFinale);

						tri.put(ListeIDfinal.get(5), tri.remove(ListeIDfinal.get(4)));
						
						for (Map.Entry<Integer, Integer> entry : tri.entrySet()) {
						    listefinale.add("idBase : " + entry.getKey() + " - Nombre de votes : " + entry.getValue());
						    NominationFinale.add(idToArbre(entry.getKey()));

						}

					}					
						else {					
							if (arbre1.getHauteur() > arbre2.getHauteur()) {
							    NominationFinale.removeAll(NominationFinale);

								tri.remove(ListeIDfinal.get(5));
								for (Map.Entry<Integer, Integer> entry : tri.entrySet()) {
									listefinale.add("idBase : " + entry.getKey() + " - Nombre de votes : " + entry.getValue());
								    NominationFinale.add(idToArbre(entry.getKey()));

								}
							}
					
					
							if (arbre1.getHauteur() < arbre2.getHauteur()) {
							    NominationFinale.removeAll(NominationFinale);

								tri.put(ListeIDfinal.get(5), tri.remove(ListeIDfinal.get(4)));
							for (Map.Entry<Integer, Integer> entry : tri.entrySet()) {
								listefinale.add("idBase : " + entry.getKey() + " - Nombre de votes : " + entry.getValue());
							    NominationFinale.add(idToArbre(entry.getKey()));

								}
							}
						}
		        	}
//
		        }
		        else {
				    NominationFinale.removeAll(NominationFinale);

		        	for (Map.Entry<Integer, Integer> entry : tri.entrySet()) {
		        			listefinale.add("idBase : " + entry.getKey() + " - Nombre de votes : " + entry.getValue());
						    NominationFinale.add(idToArbre(entry.getKey()));
		        			}
		        	}
		        	
		        
			    for (int m=0;m<(NominationFinale.size()-5); m++) {
			    	NominationFinale.remove(NominationFinale.size() - 1);
			    	
			    }
				return NominationFinale;
		}		
	    	   
	    
}


