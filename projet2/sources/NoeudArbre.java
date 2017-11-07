import java.util.Scanner;
/**
 *Classe permettant le parcous d'un arbre binaire
 *@author Mallaury Alaer
 **/
public class NoeudArbre {
    String question;
    NoeudArbre droite;//oui
    NoeudArbre gauche;//non

    /**
     *Constructeur
     **/
    public NoeudArbre(String question){
	this.question = question;
    }
    /**
     *Constructeur
     **/
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

    /**
     *Methode permettant d'afficher le contenu du noeud
     *@return contenu du noeud
     **/
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
	String rep=this.question;
	String tmp;

	if(this.gauche != null){
	    tmp = " --> non --> " + this.gauche.definir(animal);
	    if(tmp.contains(animal))
		rep += tmp;
	}
	if(this.droite != null){
	    tmp = " --> oui --> " + this.droite.definir(animal);
	    if(tmp.contains(animal))
		rep+=tmp;
	}
	return rep;
    }

    public static void main(String[] args){
	NoeudArbre test;
	if(args.length==2 &&  args[0].equals("--definir")){
	    test = new NoeudArbre("Est-ce un mammifere?",new NoeudArbre("Est-ce qu'il aboie?", new NoeudArbre("un chien"), new NoeudArbre("un cheval")),new NoeudArbre("un crocodile"));
	    System.out.println(test.definir(args[1]));
	}else{
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
}
