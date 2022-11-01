public class CarteB {
    private float solde;
    private float découvert;
    private String codeCarte;

    public CarteB(String code) {
        solde = 0;
        découvert = 100;
        codeCarte = code;
    }

    public CarteB(float montant, float decouv, String code) {
        if (montant < 0)
            solde = 0;
        else
            solde = montant;

        if (decouv < 0)
            découvert = 0;
        else
            découvert = decouv;

        codeCarte = code;
    }

    public boolean etreCodeCorrect(String code) {
        return codeCarte.equals(code);
    }

    public void deposer(float montant) {
        if (montant > 0)
            solde += montant;
    }

    public boolean depenser(double prix, String code) {
        if (etreCodeCorrect(code)) {
            if ((solde-prix) >= -découvert) {
                solde -= prix;
                return true;
            }
        }
        return false;
    }

    public String toString() {
        return "carteB: "+solde+" / -"+découvert;
    }

    public float getSolde() {
        return solde;
    }

    public float getDécouvert() {
        return découvert;
    }
}
