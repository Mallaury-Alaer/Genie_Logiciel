import java.util.*;
public class InstanceMemo{
    public static int numero = 1;
    public static List<Integer> instances = new ArrayList<Integer>();

    public InstanceMemo(){
	instances.add(numero);
	numero ++;
    }

    public static int nombreInstances(){
	return instances.size();
    }

    public static void afficherInstances(){
	String yo = "";
	int nb = instances.size()<=10 ? 0 : instances.size()-10;
	for(int i=nb; i<instances.size(); i++){
	    yo+= "Je suis l'instance numero " + instances.get(i) + "\n";
	}
	System.out.print(yo);
    }
}
