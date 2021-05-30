package Application;

import java.util.ArrayList;

public class MessagerieSEV extends Messagerie {
	
	public MessagerieSEV(String nom) {
		super(" Bienvenue sur la messagerie du Service des Espaces Verts !", nom);
	}
	
	public void envoiAbattage(ArrayList<Messagerie> ListeMessagerie) {
		for (int k=0; k<ListeMessagerie.size(); k++) {
		envoiMessage("[Service des Espaces Verts à " + ListeMessagerie.get(k).getNom() + "] Nous avons abattu l'arbre", ListeMessagerie.get(k));
		System.out.println("[Service des Espaces Verts] Message à [" + ListeMessagerie.get(k).getNom() + "] bien envoyé !");
	}
	}
	public void envoiPlantation(ArrayList<Messagerie> ListeMessagerie) {
		for (int k=0; k<ListeMessagerie.size(); k++) {
		envoiMessage("[Service des Espaces Verts à " + ListeMessagerie.get(k).getNom() + "] Nous avons planté l'arbre", ListeMessagerie.get(k));
		System.out.println("[Service des Espaces Verts] Message à [" + ListeMessagerie.get(k).getNom() + "] bien envoyé !");
	}
	}
	public void classification(ArrayList<Messagerie> ListeMessagerie) {
		for (int k=0; k<ListeMessagerie.size(); k++) {
		envoiMessage("[Service des Espaces Verts à " + ListeMessagerie.get(k).getNom() + "] Nous avons classé remarquables les arbres nominés", ListeMessagerie.get(k));
		System.out.println("[Service des Espaces Verts] Message à [" + ListeMessagerie.get(k).getNom() + "] bien envoyé !");
		}
	}	
	
}