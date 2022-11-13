// Pour fonctionner, la classe CarteBlocable doit d'abord avoir un attribut booléen bloquée, qui indique si la carte est bloquée ou non.
// Ensuite, il lui faut un attribut nbEssais qui indique le nombre d'essais restants pour entrer le bon code.
// Elle doit aussi avoir une méthode bloquer() qui permet de bloquer la carte et donc met l'attribut bloqué à true.
// La méthode depenser() doit vérifier si la carte est bloquée ou non et compter le nombre de fois qu'on se trompe.
// Il faudrait également ajouter une méthode de qui renvoi si la carte est bloqué est non.

/**
 * Classe CarteBlocable qui est une copie de la classe CarteB avec en plus la méthode depenser modifiée permettant de bloquer la carte après 3 essais infructueux
 */
public class CarteBlocable {
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
     * Attribut bloqué de type boolean qui indique si la carte est bloquée ou non
     */
    private boolean bloquée = false;

    /**
     * Attribut nbEssais de type int qui indique le nombre d'essais restants pour entrer le bon code
     */
    int nbEssais = 3;

    /**
     * Constructeur qui construit une carte avec un solde par défaut de 0 et un découvert par défaut de 100 avec un code rentré en paramètre
     * @param code correspondant au code de la carte
     */
    public CarteBlocable(String code) {
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
    public CarteBlocable(float montant, float decouv, String code) {
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
     * Méthode depenser qui permet de dépenser un montant en paramètre si le code rentré en paramètre est le même que celui de la carte
     * La carte est bloquée après 3 essais infructueux
     * @param prix correspondant au montant à retirer au solde
     * @param code correspondant au code rentré
     * @return true si le code est correct, si le solde est suffisant et si la carte n'est pas bloquée, false sinon
     */
    public boolean depenser(double prix, String code) {
        if (!bloquée) {
            if (etreCodeCorrect(code)) {
                nbEssais = 3;
                if ((this.solde - prix) >= -this.découvert) {
                    this.solde -= prix;
                    return true;
                }
            }
            else {
                nbEssais--;
                if (nbEssais == 0) {
                    this.bloquée = true;
                }
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
