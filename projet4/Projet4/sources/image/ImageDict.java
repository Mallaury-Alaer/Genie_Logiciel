package image;

import dictionnaire.correction.*;
import java.util.Iterator ;

/**
 * @author mezierev
 * Cette methode construit une image selon un dictionnaire, afin de ne stocker que les points qui ne sont pas blancs. 
 *
 *
 * Elle gagne en memoire sur les images car elle ne stocke pas les points blancs. Toutefois, pour les images qui ont beaucoup de points noirs, on peut supposer qu'elle sera plus longue car elle devra comparer tous les points et savoir s'ils sont noirs ou blancs. On peut penser que cela prendra plus de temps qu'une classe qui parcourt toutes les coordonnees sans distinction. Il serait intéressant de stocker l'image dans ImageDict ou ImageTab suivant sa composition en points blancs ; s'ils sont nombreux, ImageDict est plus adapte, sinon ImageTab le sera. 
 *
 */

public class ImageDict implements ImageGrise{
    private int largeur =0;
    private int hauteur =0;
    private TabDict dict = new TabDict(); //Couple<Point, NiveauGris>

    /** Constructeur vide */
    public ImageDict(){ }
  
    /**
       Constructeur avec hauteur et largeur
       @param h hauteur
       @param l largeur
    */
    public ImageDict(int h, int l){
	largeur = l;
	hauteur = h;
    }

    /** Retourne la largeur de l'image 
	@return largeur
    */
    public int largeur() {
	return largeur;
    }
    
    /** Retourne la hauteur de l'image 
	@return hauteur
    */
    public int hauteur() {
	return hauteur;
    }
    
    /** Retourne le niveau de gris du point de coordonnées (x,y) 
	@param x
	@param y
	@return niveau de gris
    */
    public NiveauGris pointEn(int x, int y) {
	Point p = new Point(x, y);
	if(dict.contientClef(p)){
	    return (NiveauGris) dict.valeurPour(p);
	}
	return NiveauGris.BLANC;
    }
    
    /** Fixe le niveau de gris du point de coordonnées (x,y) à la valeur spécifiée 
	@param x
	@param y
	@param gris
    */
    public void definirPoint(int x, int y, NiveauGris gris) {
	if(!gris.equals(NiveauGris.BLANC)){
	    dict.ajouter(new Point(x, y), gris);
	}
    }
    
    /** Met en noir le point de coordonnées (x,y) 
	@param x
	@param y
    */
    public void allumer(int x, int y) {
	dict.ajouter(new Point(x, y), NiveauGris.NOIR);
	
    }
    
    /** Met en blanc le point de coordonnées (x,y) 
	@param x
	@param y
    */
    public void eteindre(int x, int y) {
	dict.enleverPour(new Point(x, y));	
    }
    
    /** Donne une valeur aléatoire (noir ou blanc) à chaque point de l'image */
    public void randomize() {
	for(int i=0; i < largeur ; i++){
	    for(int j=0; j < hauteur ; j++){
		NiveauGris nivGris = NiveauGris.randomizeNB();
		if(nivGris.equals(NiveauGris.NOIR)){
		    dict.ajouter(new Point(i, j), nivGris);	
		}
	    }
	}
    }

    /** Compte le nombre de points de l'image dont le niveau de gris est égal au niveau spécifié 
	@param gris
	@return int
    */
    public int compterPoints(NiveauGris gris) {
	int cpt=0;
	Iterator it = dict.iterator() ;
	while (it.hasNext()) {
	    Object o = it.next();
	    if (dict.valeurPour(o).equals(gris)) {
		cpt++;
	    }
	}

	if(gris.equals(NiveauGris.BLANC)){
	    return (largeur*hauteur) - cpt;
	} else {	
	    return cpt;
	}
    }
    
    /** Retourne une image qui est le négatif de l'image courante 
	@return imagegrise
    */
    public ImageGrise inverser() {
	ImageGrise newImg = new ImageTab(largeur, hauteur);

	for(int i=0; i < largeur ; i++){
	    for(int j=0; j < hauteur ; j++){
		if(dict.contientClef(new Point(i, j))){
		    newImg.definirPoint(i, j, ((NiveauGris) dict.valeurPour(new Point(i, j))).inverser());
		} else {  
		    newImg.definirPoint(i, j, NiveauGris.BLANC.inverser());
		}
	    }
	}
	return newImg;
    }
    
    /** Retourne une image dont tous les points (sauf blancs) sont un niveau
     * plus clair que dans l'image courante 
     @return imagegrise
    */
    public ImageGrise eclaircir() {
	ImageGrise newImg = new ImageDict(largeur, hauteur);
	
	Iterator it = dict.iterator() ;
	while (it.hasNext()) {
	    Object o = it.next();
	    NiveauGris nvG = ((NiveauGris) dict.valeurPour(o)).eclaircir();
	    if(!nvG.equals(NiveauGris.BLANC))
		newImg.definirPoint(((Point)o).getX(), ((Point)o).getY(), nvG);	   
	}
	return newImg;
    }
    
    /** Retourne une image dont tous les points (sauf noirs) sont un niveau
     * plus foncé que dans l'image courante 
     @return imagegrise
    */
    public ImageGrise assombrir() {
	ImageGrise newImg = new ImageTab(largeur, hauteur);
	
	for(int i=0; i < largeur ; i++){
	    for(int j=0; j < hauteur ; j++){
		if(dict.contientClef(new Point(i, j))){
		    //SI NON NOIR
		    if(! ((NiveauGris) dict.valeurPour(new Point(i, j))).equals(NiveauGris.NOIR) ){
			newImg.definirPoint(i, j, ((NiveauGris) dict.valeurPour(new Point(i, j))).assombrir());
		    }
		    //SI BLANC
		} else {  
		    newImg.definirPoint(i, j, NiveauGris.BLANC.assombrir());
		}
	    }
	}
	return newImg;
    }
    
    /** Retourne une <B>copie</B> de l'image courante 
	@return imagegrise
    */
    public ImageGrise dupliquer(){
	ImageGrise newImg = new ImageDict(largeur, hauteur);

	Iterator it = dict.iterator() ;
	while (it.hasNext()) {
	    Object o = it.next();
	    newImg.definirPoint(((Point)o).getX(), ((Point)o).getY(), (NiveauGris) dict.valeurPour(o));	   
	}
	
	return newImg;
    }
    
    /** Retourne une image en additionnant point par point les niveaux de gris de l'image 
     * courante et de l'image en paramètre (les deux images doivent être de même taille) 
     @param img
     @return imagegrise
    */
    public ImageGrise ajouter(ImageGrise img){
	if(img.largeur() == this.largeur && img.hauteur() == this.hauteur){
	    ImageGrise newImg = new ImageTab(largeur, hauteur);

	    for(int i=0; i < largeur ; i++){
		for(int j=0; j < hauteur ; j++){
		    //SI NON BLANC
		    if(dict.contientClef(new Point(i, j))){
			newImg.definirPoint(i, j, ((NiveauGris) dict.valeurPour(new Point(i, j))).ajouter(img.pointEn(i, j)));
			//SI BLANC
		    } else {  
			newImg.definirPoint(i, j, NiveauGris.BLANC.ajouter(img.pointEn(i, j)));
		    }

		    //SI NOUVEAU POINT BLANC, LE RETIRER
		    if(newImg.pointEn(i, j).equals(NiveauGris.BLANC)){
			newImg.eteindre(i, j);
		    }
		}
	    }
	    return newImg;
	} else {	    
	    return null;
	}
    }

    
    /** Retourne une image en retranchant point par point les niveaux de gris de l'image 
     * courante et de l'image en paramètre (les deux images doivent être de même taille) 
     @param img
     @return imagegrise
    */
    public ImageGrise soustraire(ImageGrise img) {
	if(img.largeur() == this.largeur && img.hauteur() == this.hauteur){
	    ImageGrise newImg = new ImageTab(largeur, hauteur);

	    for(int i=0; i < largeur ; i++){
		for(int j=0; j < hauteur ; j++){
		    //SI NON BLANC
		    if(dict.contientClef(new Point(i, j))){
			newImg.definirPoint(i, j, ((NiveauGris) dict.valeurPour(new Point(i, j))).soustraire(img.pointEn(i, j)));
			//SI BLANC
		    } else {  
			newImg.definirPoint(i, j, NiveauGris.BLANC.soustraire(img.pointEn(i, j)));
		    }
		    
		    //SI NOUVEAU POINT BLANC, LE RETIRER
		    if(newImg.pointEn(i, j).equals(NiveauGris.BLANC)){
			newImg.eteindre(i, j);
		    }
		}
	    }
	    return newImg;
	} else {	    
	    return null;
	}
    }
    
    /** Retourne une image en faisant un OU Exclusif (XOR) point par
     * point les niveaux de gris de l'image courante et de l'image en
     * paramètre (les deux images doivent être de même taille) 
     @param img
     @return imagegrise
    */
    public ImageGrise XOR(ImageGrise img) {
	if(img.largeur() == this.largeur && img.hauteur() == this.hauteur){
	    ImageGrise newImg = new ImageTab(largeur, hauteur);

	    for(int i=0; i < largeur ; i++){
		for(int j=0; j < hauteur ; j++){
		    //SI NON BLANC
		    if(dict.contientClef(new Point(i, j))){
			newImg.definirPoint(i, j, ((NiveauGris) dict.valeurPour(new Point(i, j))).XOR(img.pointEn(i, j)));
			//SI BLANC
		    } else {  
			newImg.definirPoint(i, j, NiveauGris.BLANC.XOR(img.pointEn(i, j)));
		    }
		    
		    //SI NOUVEAU POINT BLANC, LE RETIRER
		    if(newImg.pointEn(i, j).equals(NiveauGris.BLANC)){
			newImg.eteindre(i, j);
		    }
		}
	    }
	    return newImg;
	} else {	    
	    return null;
	}
    }
    
    /** Retourne une image qui représente "l'intersection" de l'image courante et de l'image 
     * en paramètre : seuls les points qui ont le même niveau de gris dans les deux images sont
     * conservés (les deux images doivent être de même taille) 
     @param img
     @return imagegrise
    */
    public ImageGrise intersection(ImageGrise img) {
	if(img.largeur() == this.largeur && img.hauteur() == this.hauteur){
	    ImageGrise newImg = new ImageTab(largeur, hauteur);

	    for(int i=0; i < largeur ; i++){
		for(int j=0; j < hauteur ; j++){	    
		    //SI NON BLANC
		    if(dict.contientClef(new Point(i, j))){
			NiveauGris nivG = (NiveauGris) dict.valeurPour(new Point(i, j));
			if(nivG.equals(img.pointEn(i, j))){
			    newImg.definirPoint(i, j, nivG);
			}
		    }
		}
	    }
	    return newImg;
	} else {	    
	    return null;
	}
    }
    
    /** Retourne le niveau de gris moyen de l'image. Pour le calculer, il faut faire la 
     * moyenne des niveaux de chaque point de l'image (ce qui revient à compter combien il y
     * a de points de chaque niveau de gris possible) 
     @return NiveauGris
    */
    public NiveauGris niveauMoyen() {
	int moyenne=0;
	Iterator it = dict.iterator() ;
	while (it.hasNext()) {
	    Object o = it.next();
	    moyenne += ((NiveauGris)dict.valeurPour(o)).ordinal();
	}
	
	moyenne = moyenne / (largeur*hauteur);
	return NiveauGris.deNiveau(moyenne);
    }
    
    /** Retourne une image obtenue en augmentant le contraste de l'image courante. Pour 
     * augmenter le contraste, il faut rendre les points sombres plus sombres qu'ils ne sont, 
     * et les points clairs plus clairs. Un bon moyen de procéder consiste à calculer le 
     * niveau de gris moyen de l'image, et assombrir (respectivement eclaircir) les points 
     * plus sombres (resp. plus clairs) que ce niveau moyen 
     @return ImageGrise
    */
    public ImageGrise augmenterContraste() {
	ImageGrise newImg = new ImageTab(largeur, hauteur);
	NiveauGris grisMoyen = this.niveauMoyen();
	
	Iterator it = dict.iterator() ;
	while (it.hasNext()) {
	    Object o = it.next();
	    NiveauGris nivG = (NiveauGris) dict.valeurPour(o);
	
	    if (nivG.compareTo(grisMoyen) <= 0){
		newImg.definirPoint(((Point) o).getX(), ((Point) o).getY(), nivG.eclaircir());
	    } else {
		newImg.definirPoint(((Point) o).getX(), ((Point) o).getY(), nivG.assombrir());
	    }
	}
    
	return newImg;
    }

       /** Convertit l'image celle la mieux adaptee
     */
    public ImageGrise optimiser(){
	int nbBlanc = this.compterPoints(NiveauGris.BLANC);
	if(nbBlanc < hauteur*largeur/2){
	    ImageGrise newImg = new ImageTab(hauteur, largeur);

	    for(int i=0; i < largeur ; i++){
		for(int j=0; j < hauteur ; j++){

		    //SI NON BLANC
		    if(dict.contientClef(new Point(i, j))){
			NiveauGris nivG = (NiveauGris) dict.valeurPour(new Point(i, j));
			newImg.definirPoint(i, j, nivG);
			
		    } else {
			newImg.definirPoint(i, j, NiveauGris.BLANC);
		    }
		}
	    }
	    return newImg;	    
	} else {	    
	    return this;
	}
    }
}
