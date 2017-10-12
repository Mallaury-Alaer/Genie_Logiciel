/** Programme permettant de manipuler et d'experimenter le probleme
 *  des tours de Hanoi */
public class Hanoi 
{
    // Les trois piles representant les tours de Hanoi
    private static PileHanoi a, b, c ;

    // Initialisation des tours pour n disques, places au debut en A
    private static void init(int n) 
    {
	a = new PileHanoi("A", new AffichageJoli("o"));
	b = new PileHanoi("B", new AffichageJoli("o"));
	c = new PileHanoi("C", new AffichageJoli("o"));
	for (int i=n; i>0; i--)
	    a.empile(new DisqueHanoi(i)) ;
    }

    // Affichage des trois tours
    private static void affiche() 
    {
	System.out.println(a) ;
	System.out.println(b) ;
	System.out.println(c) ;
    }

    // Pour le mode interactif, le choix de la pile est donne par le joueur
    // en toutes lettres ("A", "B", "C"). -> retourne la pile correspondante
    private static PileHanoi analyse(String r) 
    {
	if (r.equalsIgnoreCase("A"))
	    return a ;
	if (r.equalsIgnoreCase("B"))
	    return b ;
	return c ;
    }

    // Methode principale du programme.
    public static void main (String [] arg) 
    {
	// le nombre de disques (on peut aussi le demander au joueur)
	int nbDisques = 3 ;
	
	// initialisation des piles
	init(nbDisques) ;

	if(arg.length > 0 && arg[0].equals("--auto")){
	    resoudreAuto(a, b, c);
	    affiche();
	} else {
	    boolean fini = false ;
	    String rep ;
	    PileHanoi depart, arrivee ;
	    do {
		// on commence par afficher les tours	    
		affiche() ;
		// on demande au joueur la tour de depart (A, B, C)
		System.out.print("Deplacer de : ") ;
		rep = Clavier.readString() ;
		if (rep.equalsIgnoreCase("STOP"))
		    fini = true ;
		// on en deduit l'objet correspondant
		depart = analyse(rep) ;
		if (!fini) 
		    {
			// meme chose pour la tour d'arrivee
			System.out.print("Vers : ") ;
			rep = Clavier.readString() ;
			if (rep.equalsIgnoreCase("STOP"))
			    fini = true ;
			arrivee = analyse(rep) ;
			// on effectue le deplacement si c'est possible
			if(depart.sommet() != null){
			    if (arrivee.peutEmpiler(depart.sommet()))
				depart.deplacerUnElementVers(arrivee) ;
			} else
			    System.out.println("Impossible !") ;
		    }
		// et on continue tant que le joueur n'a pas dit STOP
	    } while (!fini) ;
	    System.out.println("OK, c'est fini !") ;
	    affiche();
	}
    }




    /**
       Resoud automatiquement le probleme des tours
     */
    static void resoudreAuto(PileHanoi a, PileHanoi b, PileHanoi c){
	a.deplacerDesDisques(a.getNbElem(), c, b);
    }
}
