/**
 * Classe CarteB
 */
public class CarteB {
    /**
     * Attribut solde de type float correspondant au solde de la carte
     */
    private float solde;

    /**
     * Attribut découvert de type float correspondant au découvert autorisé
     */
    private float découvert;

    /**
     * Attribut codeCarte de type String correspondant au code de la carte
     */
    private String codeCarte;

    /**
     * Constructeur qui construit une carte avec un solde par défaut de 0 et un découvert par défaut de 100 avec un code rentré en paramètre
     * @param code correspondant au code de la carte
     */
    public CarteB(String code) {
        this.solde = 0;
        this.découvert = 100;
        this.codeCarte = code;
    }

    /**
     * Constructeur qui construit une carte avec un solde, un découvert et un code rentrés en paramètre
     * @param montant correspondant au solde de la carte
     * @param decouv correspondant au découvert autorisé
     * @param code correspondant au code de la carte
     */
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

    /**
     * Méthode etreCodeCorrect, qui renvoi true si le code rentré en paramètre est le même que celui de la carte et false dans le cas contraire
     * @param code correspondant au code rentré
     * @return true si le code est le même que celui de la carte, false sinon
     */
    public boolean etreCodeCorrect(String code) {
        return this.codeCarte.equals(code);
    }

    /**
     * Méthode deposer, qui ajoute le montant en paramètre au solde de la carte
     * @param montant correspondant au montant à ajouter au solde
     */
    public void deposer(float montant) {
        if (montant > 0)
            this.solde += montant;
    }

    /**
     * Méthode depenser, qui retire le prix en paramètre du solde de la carte si le code rentré en paramètre est le même que celui de la carte et si le solde est suffisant prenant en compte le découvert autorisé
     * @param prix correspondant au montant à retirer au solde
     * @param code correspondant au code rentré
     * @return true si le code est correct et si le solde est suffisant, false sinon
     */
    public boolean depenser(double prix, String code) {
        if (etreCodeCorrect(code)) {
            if ((this.solde-prix) >= -this.découvert) {
                this.solde -= prix;
                return true;
            }
        }
        return false;
    }

    /**
     * Méthode toString, qui renvoi une chaîne de caractères correspondant au solde et au découvert autorisé de la carte
     * @return une chaîne de caractères sous la forme "carteB: solde / -découvert"
     */
    public String toString() {
        return "carteB: "+this.solde+" / -"+this.découvert;
    }

    /**
     * Méthode getSolde qui renvoi le solde de la carte
     * @return le solde de la carte
     */
    public float getSolde() {
        return this.solde;
    }

    /**
     * Méthode getDécouvert qui renvoi le découvert autorisé de la carte
     * @return le découvert autorisé de la carte
     */
    public float getDécouvert() {
        return this.découvert;
    }
}