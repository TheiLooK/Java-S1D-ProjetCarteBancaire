public class ProgCarte {
    /**
     * Main programme Carte
     * @param args
     */
    public static void main(String[] args) {
        // Main à écrire
        CarteB carte = new CarteB(100, 1000, "MonCode"); // 1.
        Personne albert = new Personne("Albert"); // 2.
        albert.prendreCarte(carte); // 3.
        String albertPaye = albert.payer(50, "MonCode"); // 4.
        System.out.println(albertPaye); // 5.

        Personne bertrand = new Personne("Bertrand"); // 6.
        albert.donnerCarte(bertrand); // 7.
        String bertrandPaye = bertrand.payer(500, "MonCode"); // 8.
        System.out.println(bertrandPaye); // 9.

        String albertPaye2 = albert.payer(100, "MonCode"); // 10.
        System.out.println(albertPaye2); // 11.

        String bertrandPaye2 = bertrand.payer(100, "MauvaisCode"); // 12.
        System.out.println(bertrandPaye2); // 13.

    }
}
