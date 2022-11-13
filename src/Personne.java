/**
 * Classe Personne
 */
public class Personne {
    /**
     * Attribut nom de type String correspondant au nom de la personne
     */
    private String nom;

    /**
     * Attribut carte de type CarteB correspondant à la carte de la personne
     */
    private CarteB carte;

    /**
     * Constructeur qui construit une personne avec un nom rentré en paramètre
     * @param pNom le nom de la personne
     */
    public Personne(String pNom) {
        this.nom = pNom;
        this.carte = null;
    }

    /**
     * Méthode prendreCarte qui prend en paramètre une carte et qui la donne à la personne
     * @param pCarte la carte que la personne prend
     */
    public void prendreCarte(CarteB pCarte) {
        this.carte = pCarte;
    }

    /**
     * Méthode donnerCarte qui donne la carte de la personne à une autre personne
     * @param p la personne qui reçoit la carte
     * @return true si la carte a bien été donnée, false sinon
     */
    public boolean donnerCarte(Personne p) {
        if ((this.carte != null) && (p.carte == null) && (p != null)) {
            p.prendreCarte(this.carte);
            this.carte = null;
            return true;
        }
        return false;
    }

    /**
     * Méthode payer qui permet à la personne de payer une somme donnée, somme qui sera retiré du solde de sa carte
     * @param prix le prix à payer
     * @param code le code de sa carte
     * @return une chaîne de caractère indiquant si le paiement a été effectué ou non, donnant la raison du refus ou du succès de l'opération : pas de carte, montant accepte, montant refuse ou code incorrect
     */
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

    /**
     * Méthode toString qui renvoi une chaîne de caractère contenant le nom de la personne et le solde de sa carte
     * @return une chaîne de caractère contenant le nom de la personne et le solde de sa carte sous la forme "nom: solde"
     */
    public String toString() {
        if (this.carte == null)
            return this.nom+"(pas de carte)";
        else
            return this.nom+"( "+this.carte.toString()+")";
    }

    /**
     * Méthode getNom qui renvoi le nom de la personne
     * @return le nom de la personne
     */
    public String getNom() {
        return this.nom;
    }

    /**
     * Méthode getCarte qui renvoi la carte de la personne
     * @return la carte de la personne
     */
    public CarteB getCarte() {
        return this.carte;
    }
}
