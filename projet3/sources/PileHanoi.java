/**
 *Classe permettant de construire des Pile constituées de Disques Hanoi
 *@author Mallaury Alaer
 */

public class PileHanoi implements Pile<DisqueHanoi>{
    DisqueHanoi[] contenu;//ou utiliser stack
    int nbElem=0;
    String name="";
    Affichage aff = new AffichageSimple();
    
    /**Constructeur
     */
    public PileHanoi(){
	contenu = new DisqueHanoi[MAX_ELEMENTS];
    }

    /**Constructeur
     *@param name le nom de la pile
     */
    public PileHanoi(String name){
	this.name = name;
	contenu = new DisqueHanoi[MAX_ELEMENTS];
    }

    /**Constructeur
     *@param name le nom de la pile
     *@param aff l'affichage de la pile
     */
    public PileHanoi(String name, Affichage aff){
	this.name = name;
	this.aff = aff;
	contenu = new DisqueHanoi[MAX_ELEMENTS];
    }

    /** Teste si la pile est vide 
     *@return si la pile est vide ou non
     */
    public boolean vide(){
	return nbElem == 0;
    }
    
    /** Teste si la pile est pleine 
     *@return si la pile est pleine ou non
     */
    public boolean pleine (){
	return nbElem == MAX_ELEMENTS;
    }
    
    /** Teste si on peut empiler <code>x</code> sur la pile 
     *@param x : element a empiler
     *@return si le disque peut etre empiler ou non
     */
    public boolean peutEmpiler (DisqueHanoi x){
        if(!pleine() && !vide()){
	    return x.diametre() < sommet().diametre();
	} else if(!pleine()){
	    return true;
	}
    
	return false;
    }
    
    /** Renvoie la valeur de l'objet sur le sommet de la pile 
     *@return l'element se trouvant au sommet de la pile
     */
    public DisqueHanoi sommet(){
	if(vide())
	    return null;
	return contenu[nbElem-1]; //MAX_ELEMENTS-1
    }
    
    /** Renvoie la valeur de l'objet sur le sommet de la pile, et l'enlève de la pile
     *@return le disque dépilé
     */
    public DisqueHanoi depile(){
	if(vide())
	    return null;
	DisqueHanoi tmp = sommet();
	contenu[nbElem-1] = null;
	nbElem--;
	return tmp;
    }
    
    /** Ajoute un objet sur le sommet de la pile 
     *@param x : le disque a empiler
     */
    public void empile(DisqueHanoi x){
	if(peutEmpiler(x)){
	    contenu[nbElem]=x;
	    nbElem++;
	}
    }
    
    /** Vide la pile */
    public void vider(){
	contenu = new DisqueHanoi[MAX_ELEMENTS];
	nbElem=0;
    }
    
    /** Compte le nombre d'éléments présents dans la pile 
     *@return le nombre d'elements de la pile
     */
    public int nbElements(){
	return nbElem;
    }
    
    /** Deplace un element de la pile courante vers la pile specifiee 
     *@param p : pile destination
     */
    public void deplacerUnElementVers(Pile<DisqueHanoi> p){
	if(!vide() && p.peutEmpiler(sommet())){
	    p.empile(this.depile());
	    if(p instanceof PileHanoi)
		System.out.println("Deplacement : " + name + " --> " + ((PileHanoi)p).name );
	}
    }
    
    /** Chaine contenant tous les elements <b>depuis le sommet</b> */
    public String toString(){
	Disque[] disc = contenu;
	return this.name + " : " + aff.affichage_tableau(disc, nbElem);
    }

    /**
     *Déplacement automatique de disques
     *@param n : le nombre de disques a deplacer
     *@param dest : la pile destination
     *@param interm : pile intermediare
     */
    public void deplacerDesDisques(int n, Pile dest, Pile interm){
	if(n<=nbElem && n>0){
	    deplacerDesDisques(n-1, interm, dest);
	    deplacerUnElementVers(dest);
	    ((PileHanoi)interm).deplacerDesDisques(n-1, dest, this);
	}
    }
}
