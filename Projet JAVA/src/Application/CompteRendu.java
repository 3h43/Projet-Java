package Application;

import java.util.ArrayList;
import java.util.Calendar;

public class CompteRendu {
	private String compterendu;
	private Calendar date;
	private Membre auteur;
	
	public CompteRendu(String compterendu, Calendar date, Membre auteur) {
		this.compterendu = compterendu;
		this.date = date;
		this.auteur = auteur;
	}

	public Calendar getDate() {
		return this.date;
	}
	
	public String getCompteRendu() {
		return this.compterendu;
	}
	
	public String getAuteur() {
		return this.auteur.getNom();
	}
}