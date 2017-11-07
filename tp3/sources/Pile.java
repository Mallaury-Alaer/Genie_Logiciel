public interface Pile<E> {
    int MAX_ELEMENTS = 100 ;    // nombre maximal d elements
    boolean vide() ;            // teste si la pile est vide
    boolean pleine() ;          // teste si la pile est pleine
    boolean peutEmpiler(E x) ;  // teste si la pile peut empiler x
    E sommet() ;                // reference de l objet au sommet
    E depile() ;                // enleve et retourne l objet au sommet
    void empile(E x) ;          // place un objet au sommet
    void vider() ;              // vide la pile
    int nbElements() ;          // compte le nombre d elements empiles
    void deplacerUnElementVers(Pile<E> p) ;// deplace un element de la pile courante vers p
    String getNom();
    String toString() ;         // affichage de tous les elements depuis le sommet
}
