/**
 *@author Mallaury Alaer
 */
package image;
import java.util.Random;

public class ImageTab implements ImageGrise{
    int largeur=0, hauteur=0;
    NiveauGris[][] nivGris = new NiveauGris[largeur][hauteur];
    
    public ImageTab(){
        initialization();
    }
    
    public ImageTab(int largeur, int hauteur){
        this.largeur = largeur;
        this.hauteur = hauteur;
        nivGris = new NiveauGris[largeur][hauteur];
        initialization();
    }
    
    private void initialization(){
        for(int i=0;i<largeur;i++){
            for(int j =0; i<hauteur; i++){
                nivGris[i][j] = NiveauGris.BLANC;  
            }
        }
    }
    
    /** Retourne la largeur de l'image 
    *@return largeur
    */
    public int largeur(){
        return largeur;
    }
    
    /** Retourne la hauteur de l'image 
    *@return hauteur
    */
    public int hauteur(){
        return hauteur;
    }
    
    /** Retourne le niveau de gris du point de coordonnées (x,y) 
    *@param x coordonnée x d'un point
    *@param y coordonée y d'un point
    *@return niveau de gris du point dont les coordonnees sont passees en parametres
    */
    public NiveauGris pointEn(int x, int y){
        return nivGris[x][y];    
    }
    
    /** Fixe le niveau de gris du point de coordonnées (x,y) à la valeur spécifiée 
    *@params x y les coordonnées du point
    *@param gris niveau de grispar lequel remplacer le niveau de gris actuel du point
    */
    public void definirPoint(int x, int y, NiveauGris gris){
        nivGris[x][y] = gris;
    }
    
    /** Met en noir le point de coordonnées (x,y) 
    *@params x y les coordonnees du point a allumer
    */
    public void allumer(int x, int y){
        nivGris[x][y] = NiveauGris.NOIR;    
    }
    
    /** Met en blanc le point de coordonnées (x,y) 
    *@params x y les coordonees du point a eteindre
    */
    public void eteindre(int x, int y){
        nivGris[x][y] = NiveauGris.BLANC;
    }
    
    /** Donne une valeur aléatoire (noir ou blanc) à chaque point de l'image */
    public void randomize(){
        Random r = new Random();
        int indice;
        for(int i=0;i<largeur;i++){
            for(int j=0; j<hauteur; j++){
                indice = r.nextInt(2);
                nivGris[i][j] = indice==1 ? NiveauGris.BLANC : NiveauGris.NOIR;
            }
        }
    }
    
    /** Compte le nombre de points de l'image dont le niveau de gris est égal au niveau spécifié */
    public int compterPoints(NiveauGris gris){
        int cpt=0;
        for(int i=0;i<largeur;i++){
            for(int j=0; j<hauteur; j++){
                if(nivGris[i][j].equals(gris))
                    cpt++;
            }
        }
        return cpt;
    }
    
    /** Retourne une image qui est le négatif de l'image courante */
    public ImageGrise inverser(){
        ImageGrise img = new ImageTab(largeur, hauteur);
        for(int i=0;i<largeur;i++){
            for(int j=0 ; j<hauteur ; j++){
                img.definirPoint(i,j,nivGris[i][j].inverser());
            }
        }
        return img;
    }
    
    /** Retourne une image dont tous les points (sauf blancs) sont un niveau
     * plus clair que dans l'image courante */
    public ImageGrise eclaircir(){
        ImageGrise img = new ImageTab(largeur, hauteur);
        for(int i=0;i<largeur;i++){
            for(int j=0 ; j<hauteur ; j++){
                if(!nivGris[i][j].estBlanc())
                    img.definirPoint(i,j,nivGris[i][j].eclaircir());
                else
                    img.definirPoint(i,j,nivGris[i][j]);
            }
        }
        return img;
    }
    
    /** Retourne une image dont tous les points (sauf noirs) sont un niveau
     * plus foncé que dans l'image courante */
    public ImageGrise assombrir(){
        ImageGrise img = new ImageTab(largeur, hauteur);
        for(int i=0;i<largeur;i++){
            for(int j=0 ; j<hauteur ; j++){
                if(!nivGris[i][j].estNoir())
                    img.definirPoint(i,j,nivGris[i][j].assombrir());
                else
                    img.definirPoint(i,j,nivGris[i][j]);
            }
        }
        return img;
    }
    
    /** Retourne une <B>copie</B> de l'image courante */
    public ImageGrise dupliquer(){
        ImageGrise img = new ImageTab(largeur, hauteur);
        for(int i=0;i<largeur;i++){
            for(int j=0 ; j<hauteur ; j++){
                img.definirPoint(i,j,nivGris[i][j]);
            }
        }
        return img;
    }
    
    /** Retourne une image en additionnant point par point les niveaux de gris de l'image 
     * courante et de l'image en paramètre (les deux images doivent être de même taille) */
    public ImageGrise ajouter(ImageGrise img){
        if(this.largeur == img.largeur() && this.hauteur==img.hauteur()){
            ImageGrise newImg = new ImageTab(largeur, hauteur);
            for(int i=0;i<largeur;i++){
                for(int j=0 ; j<hauteur ; j++){
                    newImg.definirPoint(i,j,nivGris[i][j].ajouter(img.pointEn(i,j)));
                }
            }
        return newImg;
        }
        return null;
    }
    
    /** Retourne une image en retranchant point par point les niveaux de gris de l'image 
     * courante et de l'image en paramètre (les deux images doivent être de même taille) */
    public ImageGrise soustraire(ImageGrise img){
        if(this.largeur == img.largeur() && this.hauteur==img.hauteur()){
            ImageGrise newImg = new ImageTab(largeur, hauteur);
            for(int i=0;i<largeur;i++){
                for(int j=0 ; j<hauteur ; j++){
                    newImg.definirPoint(i,j,nivGris[i][j].soustraire(img.pointEn(i,j)));
                }
            }
            return newImg;
        }
        return null;
    }
    
    /** Retourne une image en faisant un OU Exclusif (XOR) point par
     * point les niveaux de gris de l'image courante et de l'image en
     * paramètre (les deux images doivent être de même taille) */
    public ImageGrise XOR(ImageGrise img){
        if(this.largeur == img.largeur() && this.hauteur==img.hauteur()){
            ImageGrise newImg = new ImageTab(largeur, hauteur);
            for(int i=0;i<largeur;i++){
                for(int j=0 ; j<hauteur ; j++){
                    newImg.definirPoint(i,j,nivGris[i][j].XOR(img.pointEn(i,j)));
                }
            }
            return newImg;
        }
        return null;
    }
    
    /** Retourne une image qui représente "l'intersection" de l'image courante et de l'image 
     * en paramètre : seuls les points qui ont le même niveau de gris dans les deux images sont
     * conservés (les deux images doivent être de même taille) */
    public ImageGrise intersection(ImageGrise img){
        if(this.largeur == img.largeur() && this.hauteur==img.hauteur()){
            ImageGrise newImg = new ImageTab(largeur, hauteur);
            for(int i=0;i<largeur;i++){
                for(int j=0 ; j<hauteur ; j++){
                    if(nivGris[i][j].equals(img.pointEn(i,j)))
                        newImg.definirPoint(i,j,nivGris[i][j]);
                }
            }
            return newImg;
        } 
        return null;
    }
    
    /** Retourne le niveau de gris moyen de l'image. Pour le calculer, il faut faire la 
     * moyenne des niveaux de chaque point de l'image (ce qui revient à compter combien il y
     * a de points de chaque niveau de gris possible) */
    public NiveauGris niveauMoyen(){
        int moyenne =0;
        for(int i=0;i<largeur;i++){
            for(int j=0 ; j<hauteur ; j++){
                moyenne+=nivGris[i][j].ordinal();
            }
        }
        moyenne = moyenne / (largeur*hauteur);
        return NiveauGris.deNiveau(moyenne);
    }
    
    /** Retourne une image obtenue en augmentant le contraste de l'image courante. Pour 
     * augmenter le contraste, il faut rendre les points sombres plus sombres qu'ils ne sont, 
     * et les points clairs plus clairs. Un bon moyen de procéder consiste à calculer le 
     * niveau de gris moyen de l'image, et assombrir (respectivement eclaircir) les points 
     * plus sombres (resp. plus clairs) que ce niveau moyen */
    public ImageGrise augmenterContraste(){
        ImageGrise newImg = new ImageTab(largeur, hauteur);
        NiveauGris moyen = this.niveauMoyen();
	
        for(int i=0; i < largeur ; i++){
            for(int j=0; j < hauteur ; j++){
                if (nivGris[i][j].compareTo(moyen) < 0)
                    nivGris[i][j].eclaircir();
                else
                    nivGris[i][j].assombrir();
            }
        }
        return newImg;
    }
}
