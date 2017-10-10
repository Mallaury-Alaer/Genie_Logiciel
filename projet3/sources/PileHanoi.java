public class PileHanoi implements Pile<DisqueHanoi>{
    DisqueHanoi[] contenu;//ou utiliser stack
    int nbElem=0;
    public PileHanoi(){
	contenu = new DisqueHanoi[MAX_ELEMENTS];
    }

    /** Teste si la pile est vide */
    boolean vide(){
	return nbElem == 0;
    }
    
    /** Teste si la pile est pleine */
    boolean pleine (){
	return nbElem == MAX_ELEMENTS;
    }
    
    /** Teste si on peut empiler <code>x</code> sur la pile */
    boolean peutEmpiler (E x){
	return !pleine() && x.diametre() < sommet().diametre();
    }
    
    /** Renvoie la valeur de l'objet sur le sommet de la pile */
    E sommet(){
	return contenu[MAX_ELEMENTS-1];
    }
    
    /** Renvoie la valeur de l'objet sur le sommet de la pile, et
     * l'enlève de la pile*/
    E depile(){
	if(vide())
	    return null;
	DisqueHanoir tmp = sommet();
	contenu[MAX_ELEMENTS] = null;
	nbElem--;
	return tmp;
    }
    
    /** Ajoute un objet sur le sommet de la pile */
    void empile(E x){
	if(peutEmpiler(x)){
	    nbElem++;
	    contenu[nbElem]=x;
	}
    }
    
    /** Vide la pile */
    void vider(){
	contenu = new DisqueHanoi[MAX_ELEMENTS];
    }
    
    /** Compte le nombre d'éléments présents dans la pile */
    int nbElements() ;
    /** Déplace un élément de la pile courante vers la pile spécifiée */
    void deplacerUnElementVers(Pile<E> p) ;
    /** Chaîne contenant tous les éléments <b>depuis le sommet</b> */
    String toString() ;
}
