/**
 *@author Mallaury Alaer
 */
package image;

import dictionnaire.correction.*;
import java.util.Iterator;
public class ImageDict implements ImageGrise{
    int largeur;
    int hauteur;
    TabDict dico = new TabDict(); //<Point, NiveauGris>
    
    public ImageDict(){}
    
    public ImageDict(int largeur, int hauteur){
        this.largeur = largeur;
        this.hauteur = hauteur;
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
        Point p = new Point(x, y);
        if(dico.contientClef(p)){
	       return (NiveauGris) dico.valeurPour(p);
        }
        return NiveauGris.BLANC;    
    }
    
    /** Fixe le niveau de gris du point de coordonnées (x,y) à la valeur spécifiée 
    *@params x y les coordonnées du point
    *@param gris niveau de grispar lequel remplacer le niveau de gris actuel du point
    */
    public void definirPoint(int x, int y, NiveauGris gris){
        Point point = new Point(x,y);
        dico.ajouter(point,gris);
    }
    
    /** Met en noir le point de coordonnées (x,y) 
    *@params x y les coordonnees du point a allumer
    */
    public void allumer(int x, int y){
        Point point = new Point(x,y);
        if(dico.contientClef(point))
            dico.enleverPour(point);
        dico.ajouter(point, NiveauGris.NOIR);
    }
    
    /** Met en blanc le point de coordonnées (x,y) 
    *@params x y les coordonees du point a eteindre
    */
    public void eteindre(int x, int y){
        Point point = new Point(x,y);
        if(dico.contientClef(point))
            dico.enleverPour(point);
        dico.ajouter(point, NiveauGris.BLANC);
    }
    
    /** Donne une valeur aléatoire (noir ou blanc) à chaque point de l'image */
    public void randomize(){
        for(int i=0;i<largeur;i++){
            for(int j=0; j<hauteur; j++){
                NiveauGris ng= NiveauGris.randomizeNB();
                dico.ajouter(new Point(i,j),ng);
            }
        }
    }
    
    /** Compte le nombre de points de l'image dont le niveau de gris est égal au niveau spécifié */
    public int compterPoints(NiveauGris gris){
        int cpt=0;
        Iterator it = dico.iterator();
        while(it.hasNext()){
            if(dico.valeurPour(it.next()).equals(gris))
                cpt++;
        }
        
        return cpt;
    }
    
    /** Retourne une image qui est le négatif de l'image courante */
    public ImageGrise inverser(){
        ImageGrise img = new ImageDict(largeur, hauteur);
        for(int i=0;i<largeur;i++){
            for(int j=0 ; j<hauteur ; j++){
                if(dico.contientClef(new Point(i,j)))
                    img.definirPoint(i,j,((NiveauGris) dico.valeurPour(new Point(i, j))).inverser());
                else
                    img.definirPoint(i, j, NiveauGris.BLANC.inverser());
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
                if(!((NiveauGris) dico.valeurPour(new Point(i, j))).estBlanc())
                    img.definirPoint(i,j,((NiveauGris) dico.valeurPour(new Point(i, j))).eclaircir());
                else
                    img.definirPoint(i,j,((NiveauGris) dico.valeurPour(new Point(i, j))));
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
                if(!((NiveauGris) dico.valeurPour(new Point(i, j))).estNoir())
                    img.definirPoint(i,j,((NiveauGris) dico.valeurPour(new Point(i, j))).assombrir());
                else
                    img.definirPoint(i,j,((NiveauGris) dico.valeurPour(new Point(i, j))));
            }
        }
        return img;
    }
    
    /** Retourne une <B>copie</B> de l'image courante */
    public ImageGrise dupliquer(){
        ImageGrise img = new ImageTab(largeur, hauteur);
        for(int i=0;i<largeur;i++){
            for(int j=0 ; j<hauteur ; j++){
                img.definirPoint(i,j,((NiveauGris) dico.valeurPour(new Point(i, j))));
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
                    newImg.definirPoint(i,j,((NiveauGris) dico.valeurPour(new Point(i, j))).ajouter(img.pointEn(i,j)));
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
                    newImg.definirPoint(i,j,((NiveauGris) dico.valeurPour(new Point(i, j))).soustraire(img.pointEn(i,j)));
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
                    newImg.definirPoint(i,j,((NiveauGris) dico.valeurPour(new Point(i, j))).XOR(img.pointEn(i,j)));
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
                    if(((NiveauGris) dico.valeurPour(new Point(i, j))).equals(img.pointEn(i,j)))
                        newImg.definirPoint(i,j,((NiveauGris) dico.valeurPour(new Point(i, j))));
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
                moyenne+=((NiveauGris) dico.valeurPour(new Point(i, j))).ordinal();
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
                if (((NiveauGris) dico.valeurPour(new Point(i, j))).compareTo(moyen) < 0)
                    ((NiveauGris) dico.valeurPour(new Point(i, j))).eclaircir();
                else
                    ((NiveauGris) dico.valeurPour(new Point(i, j))).assombrir();
            }
        }
        return newImg;
    }
}
