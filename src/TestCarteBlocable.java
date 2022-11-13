import static libtest.Lanceur.lancer;
import static libtest.OutilTest.assertEquals;
import libtest.*;


/**
 * classe de test qui permet de verifier que la classe Arc
 * fonctionne correctement
 */
public class TestCarteBlocable {

    /**
     * methode de lancement des tests
     *
     * @param args
     */
    public static void main(String[] args) {
        lancer(new TestCarteBlocable(), args);
    }

    /**
     * verification des méthodes
     */
    public void test_00_depenser(){
        CarteBlocable carte = new CarteBlocable("code");
        carte.deposer(100);
        boolean test1 = carte.depenser(50,"code");
        assertEquals("Peut dépenser",true,test1);

        CarteBlocable carte2 = new CarteBlocable("code");
        carte2.deposer(100);
        carte2.depenser(50,"mauvais code");
        carte2.depenser(50,"mauvais code");
        carte2.depenser(50,"mauvais code");
        boolean test2 = carte2.depenser(50,"code");
        assertEquals("Ne peut pas dépenser car la carte est bloquée",false,test2);

        CarteBlocable carte3 = new CarteBlocable("code");
        carte3.deposer(100);
        carte3.depenser(50,"mauvais code");
        carte3.depenser(50,"mauvais code");
        boolean test3 = carte3.depenser(50,"code");
        assertEquals("Peut dépenser car la carte ne doit pas être bloquée",true,test3);
        carte3.depenser(50,"mauvais code");
        carte3.depenser(50,"mauvais code");
        boolean test4 = carte3.depenser(50,"code");
        assertEquals("Peut dépenser car la carte ne doit toujours pas être bloquée",true,test3);

    }
}