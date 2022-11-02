public class CarteB {
    private float solde;
    private float découvert;
    private String codeCarte;

    public CarteB(String code) {
        this.solde = 0;
        this.découvert = 100;
        this.codeCarte = code;
    }

    public CarteB(float montant, float decouv, String code) {
        if (montant < 0)
            this.solde = 0;
        else
            this.solde = montant;

        if (decouv < 0)
            this.découvert = 0;
        else
            this.découvert = decouv;

        this.codeCarte = code;
    }

    public boolean etreCodeCorrect(String code) {
        return this.codeCarte.equals(code);
    }

    public void deposer(float montant) {
        if (montant > 0)
            this.solde += montant;
    }

    public boolean depenser(double prix, String code) {
        if (etreCodeCorrect(code)) {
            if ((this.solde-prix) >= -this.découvert) {
                float nouveauSolde = (float) (this.solde - prix);
                this.solde = nouveauSolde;
                return true;
            }
        }
        return false;
    }

    public String toString() {
        return "carteB: "+this.solde+" / -"+this.découvert;
    }

    public float getSolde() {
        return this.solde;
    }

    public float getDécouvert() {
        return this.découvert;
    }
}
