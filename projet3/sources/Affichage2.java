public class Affichage2 implements Affichage{    
    public String affichage_tableau(Disque [] d, int n){
	String s =" ";
	for (int i = 0; i< n; i++){
	    s += d[i].diametre() + " " ;
	}
	return s ;
    }
    
}
