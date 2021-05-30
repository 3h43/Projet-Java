package Application;

public class MessageriePersonne extends Messagerie {
	
	public MessageriePersonne(String nom) {
		super(" Bienvenue sur la messagerie de" + " !", nom);
	}
 
	public void envoieDon(String mess, Messagerie messagerie) {
		messagerie.envoiMessage(mess, messagerie);
	}
	
	
}