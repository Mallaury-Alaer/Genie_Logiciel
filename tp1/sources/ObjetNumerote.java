public class ObjetNumerote{
    public static int numero = 1;
    public final int INSTANCE;

    public ObjetNumerote(){
	INSTANCE = numero;
	numero ++;
    }

    public String toString(){
	return "Numero : "+ INSTANCE;
    }

    public static void main(String[] args){
	for(int i=0;i<10;i++){
	    System.out.println(new ObjetNumerote());
	}
	return;
    }
}
