/** ICI les commentaires sur le fonctionnement de la classe */
public class TabDict<K,V> // implements  Dictionnaire<K,V> //, Iterable<K>
{
    private static final int INIT_SIZE = 100 ;       // taille initiale du tableau
    private Couple<K,V> [] associations ;            // tableau contenant les associations
    private int nbAssoc ;	// nombre d'elements effectivement presents dans le dictionnaire

    /** Crée une instance de dictionnaire vide */
    public TabDict() {
        nbAssoc = 0 ;
        associations = (Couple<K,V>[]) new Couple[INIT_SIZE] ;
    }
    
    // redimensionnement automatique du tableau en une taille double
    private void resize() {
        // ... à compléter
    }

    // ajoute une association à la première position libre (après avoir 
    // redimensionné le tableau si nécessaire)
    private void add(Couple<K,V> assoc) {
        // ... à compléter
    }

    // enlève l'association à l'indice spécifié
    void remove(int index) {
        // ... à compléter
    }

    // indice de l'association assoc ; -1 si elle est absente 
    private int indexOf(Couple<K,V> assoc) {
        // ... à compléter
    }
    
    // indice de l'association de clef c ; -1 si elle est absente
    private int indexOfClef(K c) {
        // ... à compléter
    }

    // méthode nécessaire pour l'itérateur :
    // retourne la clef située à l'indice i, null si i incorrect
    K clefPourIndex(int i) {
        // ... à compléter
    }
    
    // IMPLÉMENTATION DE L'INTERFACE Dictionnaire
    

    // IMPLÉMENTATION DE L'INTERFACE Iterable (2e partie du TP)
    // /** Itérateur permettant de parcourir les clefs (et d'en supprimer) */
    // public Iterator<K> iterator() {
    //     return new DictIterator<K>(this) ;
    // }    
}
