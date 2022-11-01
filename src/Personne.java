public class Personne {
    private String nom;
    private CarteB carte;

    public Personne(String pNom) {
        this.nom = pNom;
        this.carte = null;
    }

    public void prendreCarte(CarteB pCarte) {
        this.carte = pCarte;
    }

    public String getNom() {
        return this.nom;
    }

    public CarteB getCarte() {
        return this.carte;
    }
}
