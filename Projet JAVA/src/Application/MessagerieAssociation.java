package Application;

public class MessagerieAssociation extends Messagerie {
	
	public MessagerieAssociation(String nom) {
		super(" Bienvenue sur la messagerie de l'Association !", nom);
	}
	
	public void MessageDon(Messagerie messagerie, Float don) {
		messagerie.envoiMessage(" [Association à " + messagerie.getNom() + "]" + " Nous avons besoin d'un don de " + don + "€.", messagerie);
		System.out.println("[MessagerieAssociation] : Message à [" + messagerie.getNom() + "] bien envoyé.");
	}
	
	
}