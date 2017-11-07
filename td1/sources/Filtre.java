import java.util.*;
public class Filtre{
    ArrayList<Integer> filtres = new ArrayList<Integer>();

    public Filtre(int x){
	filtres.add(x);
    }

    public void filtrer(int x){
	boolean bool = true;
	int i = 0;
	while(i<filtres.size() && bool){
	    if(x % filtres.get(i) == 0)
		bool = false;
	    i++;
	}
	if(bool) filtres.add(x);
    }

    public String toString(){
	String res = "";
	for(int i = 0; i < filtres.size(); i++){
	    res += filtres.get(i) + " ";
	}
	return res;
    }
}
