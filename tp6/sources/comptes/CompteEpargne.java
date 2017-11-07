/**
 *@author Mallaury Alaer
 */

package comptes;
public abstract class CompteEpargne extends CompteGenerique{
    private double taux;

    public CompteEpargne(int id){
	super(id);
    }

    public CompteEpargne(int id, double taux){
	super(id);
	this.taux = taux >0 && taux<100 ? taux : 0;
    }

    public abstract void retirer(double somme);

    public void calculInterets(){
	double interets = (super.montant * taux/100);
	System.out.println("Interets mensuel compte n°"+super.numCompte+" --> "+interets+"€");
	super.montant+=interets;
    }

    public abstract void operationsMensuelles();
}
