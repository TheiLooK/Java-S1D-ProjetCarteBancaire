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

    public boolean donnerCarte(Personne p) {
        if ((this.carte != null) && (p.carte == null) && (p != null)) {
            p.prendreCarte(this.carte);
            this.carte = null;
            return true;
        }
        return false;
    }

    public String payer(float prix, String code) {

    }



    public String getNom() {
        return this.nom;
    }

    public CarteB getCarte() {
        return this.carte;
    }
}
