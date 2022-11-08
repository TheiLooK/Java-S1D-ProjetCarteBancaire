// Pour fonctionner, la classe CarteBlocable doit d'abord avoir un attribut booléen bloquée, qui indique si la carte est bloquée ou non.
// Elle doit aussi avoir une méthode bloquer() qui permet de bloquer la carte et donc met l'attribut bloqué à true.
// La méthode depenser() doit vérifier si la carte est bloquée ou non.
// Il faudrait également ajouter une méthode de qui renvoi si la carte est bloqué est non.

public class CarteBlocable {
    private float solde;
    private float découvert;
    private String codeCarte;
    private boolean bloquée = true;

    public CarteBlocable(String code) {
        this.solde = 0;
        this.découvert = 100;
        this.codeCarte = code;
    }

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

    public boolean etreCodeCorrect(String code) {
        return this.codeCarte.equals(code);
    }

    public void deposer(float montant) {
        if (montant > 0)
            this.solde += montant;
    }

    public boolean depenser(double prix, String code) {
        if (etreCodeCorrect(code) && !bloquée) {
            if ((this.solde-prix) >= -this.découvert) {
                this.solde -= prix;
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

    // Méthodes carte bloquée
    public String bloquer() {
        if (this.bloquée == true) {
            return "La carte est déjà bloquée";
        }
        else {
            this.bloquée = true;
            return "La carte est maintenant bloquée";
        }
    }

    public boolean estBLoquée() {
        return this.bloquée;
    }
}
