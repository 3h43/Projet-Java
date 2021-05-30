package Application;

public class MessagerieEntreprises extends Messagerie {

		
		public MessagerieEntreprises(String nom) {
			super(" Bienvenue sur la messagerie de l'entreprise !", nom);
		}

		public void envoiDon(String mess, Messagerie messagerie) {
			messagerie.envoiMessage(mess, messagerie);
		}
		
		
	}

