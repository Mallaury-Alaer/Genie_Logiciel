public class PileTableauComp<Comparable> implements Pile<Comparable>{
    private Comparable [] elements;
    private int nbElem = 0;
    private String nom;

    public PileTableau(String nom){
	this.nom = nom;
	elements = (Comparable[]) new Object[MAX_ELEMENTS];
    }

    public boolean vide(){
	return nbElem == 0;
    }
    
    public boolean pleine() {
	return nbElem == MAX_ELEMENTS;
    }
    
   public  boolean peutEmpiler(E x){
	return pleine();
    }
    
    public Comparable sommet() {
	return elements[nbElem-1];
    }
    
    public Comparable depile() {
	Comparable sommet = elements[nbElem-1];
	elements[nbElem-1] = null;
	return sommet;
    }
    
    public void empile(Comparable x) {
	elements[nbElem] = x;
	nbElem++;
    }
    
    public void vider() {
	for(int i =0; i<nbElem; i++) elements[i] = null;
    }
    
    public int nbElements() {
	return nbElem;
    }

    public void trier(){
	bool trie = false;
	while(!trie){
	    trie = true;
	    for(int i = 0; i<nbElem; i++){
		if(elements[i].compareTo(elements[i+1])<0){
		    Comparable save = elements[i+1];
		    elements[i+1] = elements[i];
		    elements[i] = save;
		    trie = false;
		}
	    }
	}
    }
}
