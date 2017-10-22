/**
 *Classe permettant un affichage simple
 *@author Mallaury Alaer
 */
public class AffichageSimple implements Affichage{
    /**Méthode d'affichage du tableau
     *@param d : un ableau de disques
     *@param n : le nombre de disques
     *@return l'affichage du tableau
     */
    public String affichage_tableau(Disque [] d, int n){
	String s =" ";
	for (int i = 0; i< n; i++){
	    s += d[i].diametre() + " " ;
	}
	return s ;
    }
}
