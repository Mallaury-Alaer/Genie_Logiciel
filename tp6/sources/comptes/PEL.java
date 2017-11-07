/**
 *@author Mallaury Alaer
 */
package comptes;

public class PEL extends CompteEpargne{
    private final double TAUX = 5;
    private double ajoutMois = 0;

    public PEL(int idComtpe){
	super(idCompte, TAUX);
    }

    public void ajouter(double somme){
	ajoutMois += somme;
	super.montant+=somme;
    }

    public void retirer(double somme){
	if(super.getAnciennete()>=18 && somme)
	    super.montant -= somme;
    }

    public void operationsMensuelles() throws DepassementDecouvertExc, VersementInsuffisantExc{
	
    }
}
