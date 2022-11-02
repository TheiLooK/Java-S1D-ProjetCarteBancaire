import static libtest.Lanceur.lancer;
import static libtest.OutilTest.assertEquals;
import libtest.*;


/**
 * classe de test qui permet de verifier que la classe CarteB
 * fonctionne correctement
 */
public class TestCarteB {

    /**
     * methode de lancement des tests
     *
     * @param args
     */
    public static void main(String[] args) {
        lancer(new TestCarteB(), args);
    }

    /**
     * verification des méthodes
     */
    public void test_00_Methodes() {
        CarteB carte = new CarteB("code");
        System.out.println(carte.getSolde());
        assertEquals("solde",0.0,carte.getSolde());

        CarteB carte2 = new CarteB(100,1000,"code");
        assertEquals("solde",100.0,carte2.getSolde());

        boolean res = carte2.etreCodeCorrect("test");
        assertEquals("etreCodeCorrect",false,res);

        carte2.deposer(300);
        assertEquals("solde", 400.0, carte2.getSolde());

        res = carte2.depenser(100, "code");
        assertEquals("solde", 300.0, carte2.getSolde());
    }

    public void test_01_Methode_etreCodeCorrect() {
        CarteB carte = new CarteB("code");
        assertEquals("le code devrait être correct", true, carte.etreCodeCorrect("code"));
        assertEquals("le code devrait être incorrect", false, carte.etreCodeCorrect("incorrect"));
    }

    public void test_02_Methode_deposer() {
        CarteB carte = new CarteB("code");
        carte.deposer(100);
        assertEquals("deposer(100) aurait du ajouter 100", 100.0, carte.getSolde());
        carte.deposer(-100);
        assertEquals("deposer(-100) aurait du ne rien faire", 100.0, carte.getSolde());
    }

    public void test_03_Methode_depenser() {
        CarteB carte = new CarteB("code");
        carte.deposer(100);
        assertEquals("depenser(100) aurait du retourner true", true, carte.depenser(200,"code"));
        assertEquals("depenser(100) aurait du retirer 200", -100.0, carte.getSolde());
        assertEquals("depenser(100) aurait du retourner false", false, carte.depenser(100,"code"));
        assertEquals("depenser(100) aurait du ne rien retirer", 0.0, carte.getSolde());
        assertEquals("depenser(100) aurait du retourner false", false, carte.depenser(100,"incorrect"));
        assertEquals("depenser(100) aurait du ne rien retirer", 0.0, carte.getSolde());
    }

    public void test_04_Methode_toString() {
        CarteB carte = new CarteB("code");
        assertEquals("toString() aurait du retourner \"carteB: 0.0 / -100.0\"", "carteB: 0.0 / -100.0", carte.toString());
        carte.deposer(100);
        assertEquals("toString() aurait du retourner \"carteB: 100.0 / -100.0\"", "carteB: 100.0 / -100.0", carte.toString());
    }

    public void test_05_Methode_getSolde() {
        CarteB carte = new CarteB("code");
        assertEquals("getSolde() aurait du retourner 0.0", 0.0, carte.getSolde());
        carte.deposer(100);
        assertEquals("getSolde() aurait du retourner 100.0", 100.0, carte.getSolde());
    }

    public void test_06_Constructeur() {
        CarteB carte = new CarteB(-100, -1, "code");
        assertEquals("le solde devrait être 0", 0.0, carte.getSolde());
        assertEquals("le découvert devrait être 0", 0.0, carte.getDécouvert());
    }
}
