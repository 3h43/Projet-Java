package Application;

import java.util.ArrayList;

public class ServiceEspaceVert extends Municipalité {
	
	private MessagerieSEV MessagerieSEV;
	private ArrayList<Arbres> ListeArbres = null;
	private ArrayList<Arbres> ListeNomination = null;
	private ArrayList<Messagerie> ListeMessagerie;

	
	public ServiceEspaceVert(MessagerieSEV MessagerieSEV, ArrayList<Messagerie> ListeMessagerie) {
		this.MessagerieSEV = MessagerieSEV;
		this.ListeMessagerie = ListeMessagerie; 
	}
	
	public void AjoutListeMessagerie(Messagerie messagerie) {
		this.ListeMessagerie.add(messagerie);
	}
	
	public void setListeNomination(ArrayList<Arbres> ListeNomination) {
		this.ListeNomination = ListeNomination;
	}
	
	public ArrayList<Arbres> getListeNomination() {
		return ListeNomination;
	}
	
	public void setListeArbres(ArrayList<Arbres> ListeArbres) {
		this.ListeArbres = ListeArbres;
	}
	
	public ArrayList<Arbres> getListeArbres() {
		return ListeArbres;
	}
	
	public boolean VerifExiste(ArrayList<Arbres> ListeArbres, Arbres arbre) {
		boolean p = false;
		for (int k=0; k<ListeArbres.size(); k++) {
			if (ListeArbres.get(k) == arbre) {
				  p = true;
				}
		}
		return p;
	}
	
	public void Abattage(Arbres arbre, ArrayList<Messagerie> ListeMessagerie) {
		if(VerifExiste(ListeArbres,arbre)) {
		for (int k=0; k<ListeArbres.size();k++) {
			if(ListeArbres.get(k) == arbre){
				ListeArbres.get(k).setAbattage();
				ListeArbres.remove(k);
			}
		}
		MessagerieSEV.envoiAbattage(ListeMessagerie);
		}
		else {
			System.err.println("Cet arbre n'existe pas");
		}
	}

	
	public void Plantation(Arbres arbre,ArrayList<Messagerie> ListeMessagerie) {
		if(VerifExiste(ListeArbres,arbre)==false) {
			ListeArbres.add(arbre);
			MessagerieSEV.envoiPlantation(ListeMessagerie);
		}
		else {
			System.err.println("Cet arbre existe déjà");
		}
	}
	
	public void remarquable(ArrayList<Arbres> liste, ArrayList<Messagerie> ListeMessagerie) {
		for (int k=0; k<liste.size(); k++) {
			liste.get(k).setRemarquable();
		}
		MessagerieSEV.classification(ListeMessagerie);
	}

	   
}