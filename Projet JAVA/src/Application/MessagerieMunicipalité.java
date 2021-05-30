package Application;

public class MessagerieMunicipalité extends Messagerie{
	
	public MessagerieMunicipalité(String nom) {
		super(" Bienvenue sur la messagerie de la Municipalité !", nom);
	}

	public void envoiSubvention(String mess, MessagerieAssociation messagerie) {
		envoiMessage(mess, messagerie);
	}
	

}
