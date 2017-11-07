package comptes;
public class LivretA extends CompteEpargne{
    private final double TAUX = 2;
    public LivretA(int numCompte){
	super(numCompte, TAUX);
    }

    public void retirer(double somme){
	if(somme<=montant)
	    super.montant -= somme;
    }

    public void operationsMensuelles() throws DepassementDecouvertExc, VersementsInsuffisantsExc{
	calculerInteret();
    }
}
