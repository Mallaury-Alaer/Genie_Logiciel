/**
   Classe permettant d'afficher de facon simple un tableau de disques, c'est-a-dire en affichant son diametre.
   @author mezierev
 */
public class AffichageSimple implements Affichage{

    /**
       Affichage simple
       @param d tableau de disque
       @param n nombre de disque
       @return affichage
     */
    public String affichage_tableau(Disque [] d, int n){
	String s =" ";
	for (int i = 0; i< n; i++)
	    s += d[i].diametre() + " " ;
	return s ;
    }
    
}
