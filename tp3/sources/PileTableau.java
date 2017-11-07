public class PileTableau<E> implements Pile<E>{
    private E [] elements;
    private int nbElem = 0;
    private String nom;

    public PileTableau(String nom){
	this.nom = nom;
	elements = (E[]) new Object[MAX_ELEMENTS];
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
    
    public E sommet() {
	return elements[nbElem-1];
    }
    
    public E depile() {
	E sommet = elements[nbElem-1];
	elements[nbElem-1] = null;
	return sommet;
    }
    
    public void empile(E x) {
	elements[nbElem] = x;
	nbElem++;
    }
    
    public void vider() {
	for(int i =0; i<nbElem; i++) elements[i] = null;
    }
    
    public int nbElements() {
	return nbElem;
    }
    
    public void deplacerUnElementVers(Pile<E> p){
	E element = sommet();
	p.empile(element);
	System.out.println("Pile source: " + this.getNom() + ", pile dest: " + p.getNom());
    }

    public String toString(){
	String res = "";
	for(int i=0; i<nbElem; i++){
	    res += (i == nbElem -1) ? elements[i] : elements[i] + ", ";
	}
	return res;
    }

    public String getNom(){
	return this.nom;
    }

    public static void main(String[] args){
	PileTableau<Integer> niktou = new PileTableau<Integer>("Niktou");
	PileTableau<String> pt = new PileTableau<String>("Respect");
	niktou.empile(4);
	niktou.empile(10);
	niktou.empile(96);

	pt.empile("Je");
	pt.empile("respecte");
	pt.empile("R");

	System.out.println(niktou.toString());
	System.out.println(pt.toString());

	PileTableau<Integer> niklesstup = new PileTableau<Integer>("Niklesstups");
	niktou.deplacerUnElementVers(niklesstup);
    }
 
}
