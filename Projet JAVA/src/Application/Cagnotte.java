package Application;

public class Cagnotte {
    private float montant;

    public Cagnotte(float montant){
        this.montant=montant;
    }

    public float getMontant(){
        return this.montant;
    }

    public void AjoutMontant(float montant){
        this.montant+=montant;
    }

    public void EnleveMontant(float montant){
        this.montant-=montant;
    }
}
