import java.util.Scanner;

public class NoeudArbre {
    String question;
    NoeudArbre droite;//oui
    NoeudArbre gauche;//non

    public NoeudArbre(String question){
	this.question = question;
    }

    public NoeudArbre(String question, NoeudArbre droite, NoeudArbre gauche){
	this.question = question;
	this.droite = droite;
	this.gauche = gauche;
    }

    public String toString(){
	String rep = question + " ";
	if(droite != null)
	    rep+= droite.toString();
	if(gauche != null)
	    rep+= gauche.toString();
	return rep;
    }

    public String contenu(){
	return this.question;
    }

    public void rechercherAnimal(){
	Scanner scan = new Scanner(System.in);
	String reponse;

	System.out.println(question);
	reponse = scan.nextLine();
	
	if (reponse.equals("oui")){
	    if(droite != null)
		droite.rechercherAnimal();
	    else
		System.out.println("Trouve !");
	}else if(reponse.equals("non")){
	    if(gauche != null)
		gauche.rechercherAnimal();
	    else{
		System.out.println("Qu'est ce que c'est?");
		String animal = scan.nextLine();
		System.out.println(animal + "! Je ne connais pas cet animal. Donnez moi une question qui permette de differencier "+ animal+ " d\'"+ question);
		String question = scan.nextLine();
		System.out.println("Quelle doit etre la reponse pour "+ animal + "?");
		String rep = scan.nextLine();

		apprendre(this, question, rep, animal);
	    }
	}else{
	    System.out.println("Reponse inconnue");
	}
    }

    public void apprendre(NoeudArbre courant, String question, String reponse, String animal){
	if( reponse.equals("oui")){
	    courant.droite = new NoeudArbre(animal);
	    courant.gauche = new NoeudArbre(question);
	}else{
	    courant.droite = new NoeudArbre(question);
	    courant.gauche = new NoeudArbre(animal);
	}
	courant.question = question;
    }

    public String definir(String animal){
	return "";
    }

    public static void main(String[] args){
	NoeudArbre test;
	NoeudArbre animal1 = (args.length ==0 ) ?  new NoeudArbre("un chien") : new NoeudArbre(args[2]);
	NoeudArbre animal2 = (args.length == 0 ) ? new NoeudArbre("un crocodile") : new NoeudArbre(args[1]);
	String questionDepart = (args.length == 0) ? "Est-ce un mammifere?" : args[0];
	    
	String rejoue = "oui";
	while(rejoue.equals("oui")){
	    test = new NoeudArbre(questionDepart,animal1, animal2);
	    test.rechercherAnimal();
	    System.out.println("Voulez vous rejouer?");
	    rejoue = (new Scanner(System.in)).nextLine();
	}
	
    }
}
