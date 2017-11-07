import calculatrice.* ;

public class Test {
    public static void main(String [] args) {
        if (args.length < 3) 
            System.err.println("Au moins trois nombres sur la ligne de commande !") ;
        else {
            // deux nombres passés sur la ligne de commande
            double x = new Double(args[0]);
	    String oper = new String(args[1]);
	    double y = new Double(args[1]);
            // la liste des opérations disponibles
            for (Operation o: Operation.values()){
		if(o.toString().equals(oper))
		    System.out.println(x + " " + o + " " + y + " = " + o.eval(x,y)) ;
	    }
        }
    }
}
