import java.util.*;
public class Anagrammes{
    public static HashMap<Character, Integer> toHashMap(String phrase){
	HashMap<Character, Integer> map = new HashMap<>();

	int index=0;
	while(index < phrase.length()){
	    char c = phrase.charAt(index);
	    if(map.containsKey(c)){
		Integer val = map.get(c) +1;
		map.put(c, val);
	    } else {
		map.put(c, 1);
	    }	    
	    index++;
	}
	return map;
    }

    public static boolean areAnagrammes(String mot1, String mot2){
	HashMap<Character, Integer> map1 = toHashMap(mot1.toLowerCase());
	HashMap<Character, Integer> map2 = toHashMap(mot2.toLowerCase());
	//boolean res = true;

	if(map1.size()==map2.size()){
	    for(char key : map1.keySet()){
		if(!(map2.containsKey(key) && map1.get(key)==map2.get(key)))
		    return false;
	    }
	}else
	    return false;
	return true;
    }
    
    public static void main (String[] args){
        if(areAnagrammes(args[0],args[1]))
	    System.out.println("Ce sont des anagrammes");
	else
	    System.out.println("Ce ne sont pas des anagrammes");
    }
}
