import calculatrice2.* ;

public class Test {
    public static void main(String [] args) {
        if (args.length < 3) 
            System.err.println("Au moins trois nombres sur la ligne de commande !") ;
        else {
            // deux nombres passés sur la ligne de commande
            Double [] operandes = {new Double(args[0]),new Double(args[2])} ;
	    String oper = new String(args[1]);
            // la liste des opérations disponibles
            for (Operation o: Operation.values()){
		if(o.toString().equals(oper))
		    System.out.println(operandes[0] + " " + o + " " + operandes[1] + " = " + o.eval(operandes)) ;
	    }
        }
    }
}
