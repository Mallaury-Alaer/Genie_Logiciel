/**
 * Classe Date
 * @author Mallaury Alaer
 */
public class Date
{
    // les attributs des instances
    private int jour, mois, annee ;
    // les attributs de la classe
    /** Tableau contenant le nom des mois */
    /*
    public static final String [] NOM_DES_MOIS =
    { "Janvier", "Fevrier", "Mars", "Avril", "Mai", "Juin", "Juillet",
      "Aout", "Septembre", "Octobre", "Novembre", "Decembre" } ;
    */
    public String [] nom_mois =
    { "Janvier", "Fevrier", "Mars", "Avril", "Mai", "Juin", "Juillet",
      "Aout", "Septembre", "Octobre", "Novembre", "Decembre" } ;
    
    public static final String[] anglais = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November","December"};
    /** Constructeur */
    public Date(int jour, int mois, int annee, boolean french)
    {
	nom_mois = french ? nom_mois : anglais;
        this.jour = jour ;
        this.mois = mois ;
        this.annee = annee ;
    }
    /** Affiche la date sous forme de texte */
    public String toString()
    {
        return jour + " " + nom_mois[mois-1] + " " + annee ;
    }

    public static void main(String[] args){
	boolean french = true;
	int jour, mois, annee;
	if(args.length == 0){
	    System.out.println("Parametre manquant");
	    return;
	}
	if(args[0].equals("-anglais"))
	    french = false;
	else if(args[0].equals("-francais"))
	    french = true;
	System.out.println("Jour: ");
	jour = Clavier.readInt();
	System.out.println("Mois: ");
	mois = Clavier.readInt();
	System.out.println("Annee: ");
	annee = Clavier.readInt();
	System.out.println("Date = " + new Date(jour, mois, annee, french));
	return;
    }
}
