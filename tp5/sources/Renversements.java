import java.util.*;

public class Renversements{
    static String reversePhrase(String phrase){
	String res = "";
	Stack stack = new Stack();
	StringTokenizer st = new StringTokenizer(phrase.toUpperCase());
	while(st.hasMoreTokens()){
	    String tok = st.nextToken();
	    for(int i = 0; i<tok.length(); i++)
		stack.push(tok.charAt(i));
	}
        while(!stack.empty())
	    res+=stack.pop();

	return res;
    }

    static String enleveEspaces(String phrase){
	StringTokenizer st = new StringTokenizer(phrase.toUpperCase());
	List<String> list = new ArrayList<>();
	String res="";
	while(st.hasMoreTokens()){
	    String tok = st.nextToken();
	    for(int i = 0; i<tok.length(); i++)
		list.add(""+tok.charAt(i));
	}
	for(String letter : list)
	    res+=letter;
	return res;
    }

    static boolean isPalindrome(String phrase){
	return enleveEspaces(phrase).equals(reversePhrase(phrase));
    }

    static String verlen(String phrase){
	String res = "";
	StringTokenizer st = new StringTokenizer(phrase);
	Stack stack = new Stack();
	while(st.hasMoreTokens())
	    stack.push(st.nextToken());
	while(!stack.empty())
	    res+=stack.pop() + " ";
	return res;
    }

    static String motsAlenvers(String phrase){
	String res = "";
	StringTokenizer st = new StringTokenizer(phrase);
	while (st.hasMoreTokens()){
	    String tok = st.nextToken();
	    Stack stack = new Stack();
	    for(int i = 0; i<tok.length() ; i++)
		stack.push(tok.charAt(i));
	    while(!stack.empty())
		res+=stack.pop();
	    res+=" ";
	}
	return res;
    }
    
    public static void main(String[] args){
	System.out.print("Entrez une phrase: ");
	Scanner scan = new Scanner(System.in);
	String phrase = scan.nextLine();
	System.out.println(motsAlenvers(phrase));
    }
}
