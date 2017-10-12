/**
   Classe permettant d'afficher de facon visuelle un tableau de disques
   @author mezierev
 */
public class AffichageJoli implements Affichage{
    String symbole="*";

    /**
       Constructeur vide
     */
    public AffichageJoli(){ }

    /**
       Constructeur prenant en compte un symbole
       @param s symbole
     */
    public AffichageJoli(String s){
	symbole = s;
    }

    /**
       Affiche les disques de facon visuelle
       @param d tableau de disques
       @param n nombre de disques
       @return affichage
     */
    public String affichage_tableau(Disque [] d, int n){
	String s ="\n";
	String nbS = symbole;

	if(n == 0){
	    return " ";
	}

	/**Faire la premiere partie de l'affichage*/
	for(int i=0; i < d[0].diametre()*2-1 ; i++){
	    if(i%2==0 && i >= 2 && i < n*2-1){
		nbS+=symbole;
	    }
	    s+=nbS+"\n";
	}

	 s+=nbS+"\n";

	 /**Faire la deuxieme partie de l'affichage*/
	 for(int i=d[0].diametre()*2-1; i > 0 ; i--){
	     if(i%2==0 && i < n*2-1){
		 nbS=nbS.substring(1, nbS.length());
	     }
	     s+=nbS+"\n";
	 }
	return s ;
    }
    
}
