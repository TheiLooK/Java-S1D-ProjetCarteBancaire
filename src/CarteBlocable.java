// Pour fonctionner, la classe CarteBlocable doit d'abord avoir un attribut booléen bloquée, qui indique si la carte est bloquée ou non.
// Ensuite, il lui faut un attribut nbEssais qui indique le nombre d'essais restants pour entrer le bon code.
// Elle doit aussi avoir une méthode bloquer() qui permet de bloquer la carte et donc met l'attribut bloqué à true.
// La méthode depenser() doit vérifier si la carte est bloquée ou non et compter le nombre de fois qu'on se trompe.
// Il faudrait également ajouter une méthode de qui renvoi si la carte est bloqué est non.

public class CarteBlocable {
    private float solde;
    private float découvert;
    private String codeCarte;
    private boolean bloquée = false;
    int nbEssais = 3;

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
