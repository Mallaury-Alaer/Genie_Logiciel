import java.util.*;

public class Recensements{
    public static String wBitSet(String phrase){
	BitSet bs = new BitSet();
	String res = "";

	for(int i=0; i<phrase.length(); i++){
	    if(!(""+phrase.charAt(i)).equals(" "))
		bs.set(phrase.charAt(i));
	}

	for (int i=0; i<bs.length(); i++){
	    if (bs.get(i)){
	        res+=(char) i + " ";
	    }
	}
	return res;
    }

    public static String wHashSet(String phrase){
	HashSet hs = new HashSet();
	for(int i=0; i<phrase.length(); i++){
	    if(!(""+phrase.charAt(i)).equals(" "))
		hs.add(phrase.charAt(i));
	}
	return hs.toString();
    }

    public static String wHashMap(String phrase){
	HashMap<Character, Integer> map = new HashMap<>();

	int index=0;
	while(index < phrase.length()){
	    Character c = phrase.charAt(index);
	    if(map.containsKey(c)){
		Integer val = map.get(c) +1;
		map.put(c, val);
	    } else {
		map.put(c, 1);
	    }	    
	    index++;
	}
	return map.toString();
    }

    public static void main(String[] args){
	System.out.print("Entrez une phrase : ");
	Scanner scan = new Scanner(System.in);
	String phrase = scan.nextLine();
	System.out.println(wHashMap(phrase));
    }
}
