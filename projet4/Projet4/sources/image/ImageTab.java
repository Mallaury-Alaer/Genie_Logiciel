package image;

/**
 * @author mezierev
 *
 * Cette classe permet de stocker les points d'une image et leur niveau de gris au travers d'un tableau.
 */
public class ImageTab implements ImageGrise{
    int largeur =0;
    int hauteur =0;
    NiveauGris[][] gris;


    /** Constructeur vide */
    public ImageTab(){ init(); }
  
    /**
       Constructeur avec hauteur et largeur
       @param h hauteur
       @param l largeur
    */
    public ImageTab(int h, int l){
	largeur = l;
	hauteur = h;
	gris = new NiveauGris[hauteur][largeur];
	init();
    }
    
    /** Initialise une image blanche */
    private void init(){
	for(int i=0; i < largeur ; i++){
	    for(int j=0; j < hauteur ; j++){
		gris[i][j] = NiveauGris.BLANC;
	    }
	}
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
	@return NiveauGris
    */
    public NiveauGris pointEn(int x, int y) {
	return gris[x][y];
    }
    
    /** Fixe le niveau de gris du point de coordonnées (x,y) à la valeur spécifiée 
	@param x
	@param y
	@param gris
    */
    public void definirPoint(int x, int y, NiveauGris gris) {
	this.gris[x][y] = gris;
    }
    
    /** Met en noir le point de coordonnées (x,y)
	@param x
	@param y
    */
    public void allumer(int x, int y) {
	gris[x][y] = NiveauGris.NOIR;
	
    }
    
    /** Met en blanc le point de coordonnées (x,y) 
	@param x
	@param y
    */
    public void eteindre(int x, int y) {
	gris[x][y] = NiveauGris.BLANC;
    }
    
    /** Donne une valeur aléatoire (noir ou blanc) à chaque point de l'image */
    public void randomize() {
	for(int i=0; i < largeur ; i++){
	    for(int j=0; j < hauteur ; j++){
		gris[i][j] = NiveauGris.randomizeNB();
	    }
	}
    }
    
    /** Compte le nombre de points de l'image dont le niveau de gris est égal au niveau spécifié 
	@return sum
    */
    public int compterPoints(NiveauGris gris) {
	int sum = 0;
	for(int i=0; i < largeur ; i++){
	    for(int j=0; j < hauteur ; j++){
		if(this.gris[i][j] == gris)
		    sum++;
	    }
	}
	return sum;
    }
    /** Retourne une image qui est le négatif de l'image courante 
	@return ImageGrise
    */
    public ImageGrise inverser() {
	ImageGrise newImg = new ImageTab(largeur, hauteur);

	for(int i=0; i < largeur ; i++){
	    for(int j=0; j < hauteur ; j++){
		newImg.definirPoint(i, j, gris[i][j].inverser());
	    }
	}
	return newImg;
    }
    
    /** Retourne une image dont tous les points (sauf blancs) sont un niveau
     * plus clair que dans l'image courante 
     @return ImageGrise
    */
    public ImageGrise eclaircir() {
	ImageGrise newImg = new ImageTab(largeur, hauteur);

	for(int i=0; i < largeur ; i++){
	    for(int j=0; j < hauteur ; j++){
		newImg.definirPoint(i, j, gris[i][j].eclaircir());
	    }
	}
	return newImg;
    }
    
    /** Retourne une image dont tous les points (sauf noirs) sont un niveau
     * plus foncé que dans l'image courante 
     @return ImageGrise
    */
    public ImageGrise assombrir() {
	ImageGrise newImg = new ImageTab(largeur, hauteur);
	
	for(int i=0; i < largeur ; i++){
	    for(int j=0; j < hauteur ; j++){
		newImg.definirPoint(i, j, gris[i][j].assombrir());
	    }
	}
	return newImg;
    }
    
    /** Retourne une <B>copie</B> de l'image courante 
	@return ImageGrise
    */
    public ImageGrise dupliquer(){
	ImageGrise newImg = new ImageTab(largeur, hauteur);
	
	for(int i=0; i < largeur ; i++){
	    for(int j=0; j < hauteur ; j++){
		newImg.definirPoint(i, j, gris[i][j]);
	    }
	}
	return newImg;
    }
    
    /** Retourne une image en additionnant point par point les niveaux de gris de l'image 
     * courante et de l'image en paramètre (les deux images doivent être de même taille) 
     @param img
     @return ImageGrise
    */
    public ImageGrise ajouter(ImageGrise img){
	if(img.largeur() == this.largeur && img.hauteur() == this.hauteur){
	    ImageGrise newImg = new ImageTab(largeur, hauteur);
	
	    for(int i=0; i < largeur ; i++){
		for(int j=0; j < hauteur ; j++){
		    newImg.definirPoint(i, j, gris[i][j].ajouter(img.pointEn(i, j)));
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
     @return ImageGrise
    */
    public ImageGrise soustraire(ImageGrise img) {
	if(img.largeur() == this.largeur && img.hauteur() == this.hauteur){
	    ImageGrise newImg = new ImageTab(largeur, hauteur);
	
	    for(int i=0; i < largeur ; i++){
		for(int j=0; j < hauteur ; j++){
		    newImg.definirPoint(i, j, gris[i][j].soustraire(img.pointEn(i, j)));
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
     @return ImageGrise
    */
    public ImageGrise XOR(ImageGrise img) {
	if(img.largeur() == this.largeur && img.hauteur() == this.hauteur){
	    ImageGrise newImg = new ImageTab(largeur, hauteur);
	
	    for(int i=0; i < largeur ; i++){
		for(int j=0; j < hauteur ; j++){
		    newImg.definirPoint(i, j, gris[i][j].XOR(img.pointEn(i, j)));
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
     @return ImageGrise
    */
    public ImageGrise intersection(ImageGrise img) {
	if(img.largeur() == this.largeur && img.hauteur() == this.hauteur){
	    ImageGrise newImg = new ImageTab(largeur, hauteur);
	
	    for(int i=0; i < largeur ; i++){
		for(int j=0; j < hauteur ; j++){
		    if(gris[i][j].equals(img.pointEn(i, j))){
			newImg.definirPoint(i, j, gris[i][j]);
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
     @return gris
    */
    public NiveauGris niveauMoyen() {
	int moyenne=0;
	for(int i=0; i < largeur ; i++){
	    for(int j=0; j < hauteur ; j++){	
		moyenne += gris[i][j].ordinal();	
	    }
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

	
	for(int i=0; i < largeur ; i++){
	    for(int j=0; j < hauteur ; j++){
		if (gris[i][j].compareTo(grisMoyen) <= 0){
		    newImg.definirPoint(i, j, gris[i][j].eclaircir());
		} else {
		    newImg.definirPoint(i, j, gris[i][j].assombrir());
		}
	    }
	}
	return newImg;
    }



    /** Convertit l'image celle la mieux adaptee
     */
    public ImageGrise optimiser(){
	int nbBlanc = this.compterPoints(NiveauGris.BLANC);
	if(nbBlanc < hauteur*largeur/2){
	    ImageGrise newImg = new ImageDict(hauteur, largeur);

	    for(int i=0; i < largeur ; i++){
		for(int j=0; j < hauteur ; j++){
		    if (!gris[i][j].equals(NiveauGris.BLANC)){
			newImg.definirPoint(i, j, gris[i][j]);
		    }
		}
	    }
	    return newImg;	    
	} else {	    
	    return this;
	}
    }
}
