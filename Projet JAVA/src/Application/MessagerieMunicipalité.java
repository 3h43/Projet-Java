package Application;

public class MessagerieMunicipalit√© extends Messagerie{
	
	public MessagerieMunicipalit√©(String nom) {
		super(" Bienvenue sur la messagerie de la Municipalit√© !", nom);
	}

	public void envoiSubvention(String mess, MessagerieAssociation messagerie) {
		envoiMessage(mess, messagerie);
	}
	

}
