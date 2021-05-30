package Application;

public class RapportActivite {
	private float recettes;
	private float depenses;
	
	public float pointbudg(float recettes, float depenses) {
		return recettes - depenses;
	}
	
	public void envoiRapport(float recettes, float depenses) {
		System.out.println("Voici le rapport d'activité de cette année" + pointbudg(recettes, depenses));
	}
}
