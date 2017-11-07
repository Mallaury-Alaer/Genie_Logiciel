/**
 * Generateur de nombres pour le crible d Eratosthene dans sa version objet.
 */
public class Generateur {
    // entier maximal jusqu auquel on effectue la recherche de nombres premiers
    private int limite ;
    // filtre initial (de valeur 2) auquel on envoie tous les nombres a tester
    private Filtre initial ;
    /**
     * cree un generateur de limite n
     */
    public Generateur (int n) {
        limite = n ;
        initial = new Filtre(2) ;
    }
    /**
     * affichage de la liste des nombres premiers trouves ; pour cela
     * on demande au filtre initial de s afficher (a charge pour lui
     * de demander aux autres filtres d afficher la suite)
     */
    public String toString() {
        return "Liste des nombres premiers compris entre 2 et "
            + limite + " : \n" + initial + "\n" ;
    }
    /**
     * genere les nombres a tester de 2 a limite, et les envoie au
     * filtre initial
     */
    public void travailler() {
        for (int i = 2; i<=limite; i++)
            initial.filtrer(i) ;
    }
}
