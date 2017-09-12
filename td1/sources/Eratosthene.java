public class Eratosthene{
    public static int[] res;
    
    public Eratosthene(int n){
	res = new int[n-1];
	for(int i = 2; i<=n; i++){
	    res[i-2] = i;
	}
    }

    public int[] doTheThing(){
	int nbTours = 0;
	int[] tab = res;
	
	while(nbTours<res.length){
	    if(res[nbTours] != 0){
		for(int i=nbTours ; i<res.length-1 ; i++){
		    if(res[i+1]!=0 && res[i+1] % res[nbTours]== 0)
			tab[i+1]=0;
		}
	    }
  	    nbTours++;
	}
	return tab;
    }

    public String toString(){
	String yo="";
	for(int i = 0; i<res.length; i++){
	    yo+= res[i] + " ";
	}
	return yo + "\n";
    }

    public static void main(String[] args){
	Eratosthene e = new Eratosthene(25);
	e.doTheThing();
	System.out.println(e.toString());
	return;
    }
}
