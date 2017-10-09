import java.util.StringTokenizer;
import java.util.Scanner;

public class Majmin{
    public static void main(String [] args){
	System.out.print("Entrez une phrase : ");
	Scanner scan = new Scanner(System.in);
	String phrase = scan.nextLine(), res="";
	StringTokenizer st = new StringTokenizer(phrase);
	int cpt = 0;
	while(st.hasMoreTokens()){
	    res+= cpt%2==0 ? st.nextToken().toUpperCase()+' ' : st.nextToken().toLowerCase()+' ';
	    cpt++;
	}
	System.out.println(res);
    }
}
