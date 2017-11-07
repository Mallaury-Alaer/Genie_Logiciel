public class PileTableau<E> implements Pile{
    private E [] elements;
    private int nbElem = 0;
    private String nom;

    int MAX_ELEMENTS = 100;
    boolean vide(){
	return nbElem == 0;
    }
    
    boolean pleine() {
	return nbElem == MAX_ELEMENTS;
    }
    
    boolean peutEmpiler(E x){
	return pleine();
    }
    
    E sommet() {
	return elements[nbElem-1];
    }
    
    E depile() {
	E sommet = elements[nbElem-1];
	elements[nbElem-1] = null;
	return sommet;
    }
    
    void empile(E x) {
	elements[nbElem] = x;
	nbElem++;
    }
    
    void vider() {
	for(int i =0; i<nbElem; i++) elements[i] = null;
    }
    
    int nbElements() {
	return nbElem;
    }
    
    void deplacerUnElementVers(Pile<E> p){
	E element = sommet();
	p.empile(element);
    }
}
