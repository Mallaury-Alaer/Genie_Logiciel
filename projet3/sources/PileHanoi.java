public class PileHanoi implements Pile<DisqueHanoi>{
    DisqueHanoi[] contenu;//ou utiliser stack
    int nbElem=0;
    String name="";
    Affichage aff = new Affichage2();
    
    
    public PileHanoi(){
	contenu = new DisqueHanoi[MAX_ELEMENTS];
    }

    public PileHanoi(String name){
	this.name = name;
	contenu = new DisqueHanoi[MAX_ELEMENTS];
    }

    public PileHanoi(String name, Affichage aff){
	this.name = name;
	this.aff = aff;
	contenu = new DisqueHanoi[MAX_ELEMENTS];
    }

    /** Teste si la pile est vide */
    public boolean vide(){
	return nbElem == 0;
    }
    
    /** Teste si la pile est pleine */
    public boolean pleine (){
	return nbElem == MAX_ELEMENTS;
    }
    
    /** Teste si on peut empiler <code>x</code> sur la pile */
    public boolean peutEmpiler (DisqueHanoi x){
        if(!pleine() && !vide()){
	    return x.diametre() < sommet().diametre();
	} else if(!pleine()){
	    return true;
	}
    
	return false;
    }
    
    /** Renvoie la valeur de l'objet sur le sommet de la pile */
    public DisqueHanoi sommet(){
	if(vide())
	    return null;
	return contenu[nbElem]; //MAX_ELEMENTS-1
    }
    
    /** Renvoie la valeur de l'objet sur le sommet de la pile, et
     * l'enlève de la pile*/
    public DisqueHanoi depile(){
	if(vide())
	    return null;
	DisqueHanoi tmp = sommet();
	contenu[nbElem] = null;
	nbElem--;
	return tmp;
    }
    
    /** Ajoute un objet sur le sommet de la pile */
    public void empile(DisqueHanoi x){
	if(peutEmpiler(x)){
	    nbElem++;
	    contenu[nbElem]=x;
	}
    }
    
    /** Vide la pile */
    public void vider(){
	contenu = new DisqueHanoi[MAX_ELEMENTS];
    }
    
    /** Compte le nombre d'éléments présents dans la pile */
    public int nbElements(){
	return nbElem;
    }
    
    /** Deplace un element de la pile courante vers la pile specifiee */
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
	System.out.println(nbElem);
	return this.name + " : " + aff.affichage_tableau(disc, nbElem);
    }
}
