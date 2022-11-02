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
        if (this.carte == null)
            return "* pas de carte";
        else if (this.carte.depenser(prix, code))
            return "* montant accepte";
        else if (this.carte.etreCodeCorrect(code))
            return "* montant refuse";
        else
            return "* code incorrect";
    }

    public String toString() {
        if (this.carte == null)
            return this.nom+"(pas de carte)";
        else
            return this.nom+"( "+this.carte.toString()+")";
    }

    public String getNom() {
        return this.nom;
    }

    public CarteB getCarte() {
        return this.carte;
    }
}
