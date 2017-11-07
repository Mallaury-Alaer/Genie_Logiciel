//import java.lang.Comparable;
public class Rationnel implements Comparable<Rationnel>{
    int num, den;

    public Rationnel(int num,int  den){
	this.num = num;
	this.den = (den >0) ? den : 1;
	if(den<0) System.out.println("Erreur le denominateur ne peut etre negatif, il a ete mis a 1");
    }

    public double calcul(){
	return (double)num/(double)den;
    }

    public int compareTo(Rationnel r){
	if(this.calcul() == r.calcul())
	    return 0;
	else if(this.calcul() > r.calcul())
	    return 1;
	return -1;
    }
}
