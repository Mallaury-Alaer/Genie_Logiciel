import java.util.*;

public class Exercice2{
    public static void main(String [] args){
	System.out.print("Entrez une phrase: ");
	Scanner scan = new Scanner(System.in);
	String res = "", phrase = scan.nextLine();
	List<String> list = new ArrayList<>();
	StringTokenizer st = new StringTokenizer(phrase);
	while(st.hasMoreTokens()){
	    list.add(st.nextToken());
	}
        Collections.sort(list);
        for(String element : list)
	    res+=element + " ";
	System.out.println(res);
    }
}
