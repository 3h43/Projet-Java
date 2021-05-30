package Application;

public abstract class Messagerie {
	
	private String notif;
	private String nom;
	
	
	public Messagerie(String notif, String nom) {
		this.notif = notif;
		this.nom = nom;
	}
	
	
	public void envoiMessage(String mess, Messagerie messagerie) {
		messagerie.changenotif(mess);
	}
	
	
	public void changenotif(String mess) {
		this.notif = mess;
		messagerieON();
	}
	
	public void receptionMessage() {
		System.out.println("[" + getNom() + "] a reçu :" + this.notif );
	}
	
	public void messagerieON() {
		do{
			try {
			receptionMessage();
			break;
			}
		    catch (Exception e) {
		        System.out.println(e);
		      }
		      System.out.println("erreur");
		  } 
		while(true);
		}
	
	public String getNom() {
		return this.nom;
	}
}
