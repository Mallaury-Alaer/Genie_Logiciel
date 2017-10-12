/** L'interface Pile definit le comportement de toute pile. */
public interface Pile<E> {

    /** Nombre maximal d'elements pouvant etre places dans les instances 
     * des classes implementant Pile (constante de classe) */
     int MAX_ELEMENTS = 12 ;

    /** Teste si la pile est vide */
    boolean vide() ;
    /** Teste si la pile est pleine */
    boolean pleine () ;
    /** Teste si on peut empiler <code>x</code> sur la pile */
    boolean peutEmpiler (E x) ;
    /** Renvoie la valeur de l'objet sur le sommet de la pile */
    E sommet() ;
    /** Renvoie la valeur de l'objet sur le sommet de la pile, et
     * l'enleve de la pile*/
    E depile() ;
    /** Ajoute un objet sur le sommet de la pile */
    void empile(E x) ;
    /** Vide la pile */
    void vider() ;
    /** Compte le nombre d'elements presents dans la pile */
    int nbElements() ;
    /** Deplace un element de la pile courante vers la pile specifiee */
    void deplacerUnElementVers(Pile<E> p) ;
    /** Chaine contenant tous les elements <b>depuis le sommet</b> */
    String toString() ;
}
