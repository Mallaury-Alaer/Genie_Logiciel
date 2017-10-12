/**
   Classe implementant "Pile", qui permet de simuler des Tours de facon Hanoi. 
   @author mezierev
 */
public class PileHanoi implements Pile<DisqueHanoi>{

    private DisqueHanoi [] elements ;  // les elements contenus dans la pile
    private int nbElem = 0 ; // le nombre d'elements dans la pile
    public String nom;
    private Affichage algoAffichage = new AffichageSimple() ; // affichage par defaut

    /**
       Constructeur vide
     */
    public PileHanoi(){
	elements = new DisqueHanoi[MAX_ELEMENTS];
    }

    /**
       Constructeur donnant un nom a la pile
       @param n nom
    */
    public PileHanoi(String n){
	nom = n;
	elements = new DisqueHanoi[MAX_ELEMENTS];
    }

    /**
       Constructeur donnant un nom a la pile et stipulant l'affichage
       @param nom
       @param a affichage
    */
    public PileHanoi(String nom, Affichage a) { 
        this.nom = nom ;
        algoAffichage = a ;
        elements = new DisqueHanoi[MAX_ELEMENTS];
    }

    /** teste si la pile est vide */
    public boolean vide() {
	return (nbElem == 0) ;
    }
    
    /** teste si la pile est pleine */
    public boolean pleine () {
	return (nbElem == MAX_ELEMENTS) ;
    }
    
    /** teste si la pile peut empiler x */
    public boolean peutEmpiler (DisqueHanoi x) {
	if(!pleine() && !vide()){
	    return x.diametre() < sommet().diametre();
	} else if(!pleine()){
	    return true;
	}
    
	return false;
    }
    
    /** renvoie la valeur de l'objet sur le sommet de la pile */
    public DisqueHanoi sommet() {
	if (vide())
	    return null ;
	else return elements[nbElem-1] ;
    }
    
    /** renvoie la valeur de l'objet sur le sommet de la pile
     * et l'enleve */
    public DisqueHanoi depile() {
	if (vide())
	    return null ;
	nbElem-- ;
	return elements[nbElem] ;
    }
    
    /** ajoute un objet sur le sommet de la pile */
    public void empile(DisqueHanoi o) {
	if (peutEmpiler(o)) {
	    elements[nbElem] = o ;
	    nbElem++ ;
	}
    }
    
    /** vide la pile */
    public void vider() {
	nbElem = 0 ;
    }
    
    /** compte le nombre d'elements presents dans la pile */
    public int nbElements() {
	return nbElem ;
    }

    public void deplacerUnElementVers(Pile<DisqueHanoi> p) {
	if (!vide() && p.peutEmpiler(sommet())) {
	    p.empile(this.depile()) ;
	    if(p instanceof PileHanoi)
		System.out.println("Deplacement de " + nom + " vers " + ((PileHanoi) p).nom);
	}
    }
    
    /** affichage */
    public String toString() {
	Disque[] lesDisques = elements;
	return nom + " : " + algoAffichage.affichage_tableau(lesDisques, nbElem); 
    }

    /** Deplacement de disques*/
    public void deplacerDesDisques(int n, Pile dest, Pile interm){	  
	if(n <= nbElem && n > 0){
	    deplacerDesDisques(n-1, interm, dest);
	    deplacerUnElementVers(dest);
	    ((PileHanoi) interm).deplacerDesDisques(n-1, dest, this);
	}
    }

    /**retourne nombre elements*/
    public int getNbElem(){
	return nbElem;
    }
    
}
