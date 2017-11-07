/** ICI les commentaires sur le fonctionnement de la classe */
public class TabDict<K,V> implements  Dictionnaire<K,V>, Iterable<K>
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
        Couple<K,V> [] tmp = (Couple<K,V>[]) new Couple[associations.length*2];
        for(int i = 0; i<associations.length; i++){
	    associations[i] = tmp[i];
	}
	associations = tmp;
    }

    // ajoute une association à la première position libre (après avoir 
    // redimensionné le tableau si nécessaire)
    private void add(Couple<K,V> assoc){
	if(nbAssoc == associations.length)
	    resize();
	int i = 0;
	while(associations[i] != null){
	    i++;
	}
	associations[i] = assoc;
	nbAssoc ++;
	
    }

    // enlève l'association à l'indice spécifié
    void remove(int index) {
	if(index < associations.length){
	    associations[index] = null;
	    nbAssoc --;
	}
    }

    // indice de l'association assoc ; -1 si elle est absente 
    private int indexOf(Couple<K,V> assoc) {
        for(int i=0; i<nbAssoc;i++){
	    if(associations[i] != null && associations[i].equals(assoc)){
		return i;
	    } 
	}
	return -1;
    }
    
    // indice de l'association de clef c ; -1 si elle est absente
    private int indexOfClef(K c) {
        for(int i=0; i<nbAssoc;i++){
	    if(associations[i] != null && associations[i].premier().equals(c)){
		return i;
	    }
	}
	return -1;
    }

    // méthode nécessaire pour l'itérateur :
    // retourne la clef située à l'indice i, null si i incorrect
    K clefPourIndex(int i) {
        return i < associations.length ? associations[i].premier() : null;
    }

    public String toString(){
	String rep = "";
	for(int i = 0; i<nbAssoc; i++){
	    rep+= associations[i].premier() + " -> " + associations[i].second() + "\n";
	}
	return rep;
    }

    public static void main(String[] args){
	TabDict tab = new TabDict();
	tab.add(new CoupleObj("test", "yo"));
	tab.add(new CoupleObj("test2", "yo2"));
	System.out.println(tab.toString());
	
    }
    
    // IMPLÉMENTATION DE L'INTERFACE Dictionnaire

    public boolean estVide(){
	return nbAssoc == 0 ? true : false;
    }
    
    public boolean contient(Couple <K,V> assoc){
	return indexOf((CoupleObj) assoc) != -1 ? true : false;
    }
    
    public boolean contientClef(K c){
	return indexOfClef(c) != -1 ? true : false;
    }
    
    public boolean contientValeur(V v) {
        for(int i=0; i<nbAssoc;i++){
	    if(associations[i] != null && associations[i].second().equals(v)){
		return true;
	    }
	}
	return false;
    }
    
    public int nbElements(){
	return nbAssoc;
    }
    
    public Couple<K,V> assocPour(K c) {
	int id = indexOfClef(c);
	return id != -1 ? associations[id] : null;
    }
    
    public V valeurPour(K c){
	return assocPour(c).second(); 
    }
    
    public void ajouter(Couple<K,V> assoc){
	if(indexOf(assoc) == -1){
	    add(assoc);
	} else {
	    associations[indexOf(assoc)] = assoc;
	}
    }
    
    public void ajouter(K c, V v){
	ajouter(new CoupleObj(c,v));
    }
    
    public void enlever(Couple<K,V> assoc){
	if(contient(assoc))
	    remove(indexOf(assoc));
    }

    public void enleverPour(K c){
	if(contientClef(c)){
	    remove(indexOfClef(c));
	}
    }
    

    // IMPLÉMENTATION DE L'INTERFACE Iterable (2e partie du TP)
     /** Itérateur permettant de parcourir les clefs (et d'en supprimer) */
     public Iterator<K> iterator() {
         return new DictIterator<K>(this) ;
    }    
}
