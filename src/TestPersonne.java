import static libtest.Lanceur.lancer;
import static libtest.OutilTest.assertEquals;


/**
 * classe de test qui permet de verifier que la classe Personne
 * fonctionne correctement
 */
public class TestPersonne {

	/**
	 * methode de lancement des tests
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		lancer(new TestPersonne(), args);
	}

	/**
	 * verifie constructeur
	 */
	public void test_00_Constructeur(){
		Personne p = new Personne("Albert");
		CarteB carte = p.getCarte();
		assertEquals("carte doit être null", null, carte);
	}
	/**
	 * verifie methodes correctes
	 */
	public void test_01_Methode_prendreCarte_donnerCarte_payer() {
		Personne p = new Personne("Albert");
		CarteB cb=new CarteB("Moncode");
		p.prendreCarte(cb);
		assertEquals("Moncode code doit être correct", true, p.getCarte().etreCodeCorrect("Moncode"));
		assertEquals("incorrect code doit être incorrect", false, p.getCarte().etreCodeCorrect("incorrect"));

		Personne p2 = new Personne("B");
		boolean res = p.donnerCarte(p2);
		assertEquals("donnerCarte doit retourner true", true, res);
		assertEquals("p1 ne doit plus avoir de carte", null, p.getCarte());
		assertEquals("p2 doit avoir la carte de p1", true, p2.getCarte().etreCodeCorrect("Moncode"));

		String resString = p.payer((float) 200., "Moncode");
		assertEquals("p1 n'est pas censé avoir de carte", "* pas de carte", resString);
		String resString2 = p2.payer(2000, "Moncode");
		assertEquals("p2 n'a pas sassez d'argent et donc ne peut pas payer", "* montant refuse", resString2);
		p2.getCarte().deposer(1000);
		String resString3 = p2.payer(200, "Moncode");
		assertEquals("p2 a assez d'argent et peut donc payer", "* montant accepte", resString3);
		String resString4 = p2.payer(200, "MoncodeIncorrect");
		assertEquals("p2 n'a pas pu payer il a mit le mauvais code", "* code incorrect", resString4);

	}
}
