/**
 *@author Mallaury Ala
 */

package comptes;

public class CompteGenerique extends Compte{
    private int numCompte;
    private double montant=0;
    private int nbMois=0;

    public CompteGenerique(int numCompte){
	this.numCompte = numCompte;
    }

    public CompteGenerique(int numCompte, double montant){
	this.numCompte = numCont;
	this.montant = montant;
    }

    public CompteGenerique(int numCompte, double montant, int nbMois){
	this.numCompte = numCompte;
	this.montant = montant;
	this.nbMois = nbMois;
    }

    /** Retourne le numéro identifiant le compte 
     *@return identifiant du compte
     */
    int getNumero(){
	return numCompte;
    }
    
    /** Retourne le nombre de mois écoulés depuis l’ouverture 
     *@return nombre de mois
     */
    int getAnciennete(){
	return nbMois;
    }
    
    /** Retourne le numéro du compte et le montant 
     *@return le numero du compte et son montant
     */
    String toString(){
	return "Id Compte : " + numCompte + ' | Solde : ';
    }
    
    /** Effectue un ajout de la somme spécifiée sur le compte 
     *@param somme : la somme a ajouter au montant du compte
     */
    void ajouter(double somme){
	montant+=somme;
    }
    
    /** Tente d’effectuer un retrait de la somme spécifiée sur le compte 
     *@param somme : la somme a débiter du compte
     */
    void retirer(double somme){
	montant -= somme;
    }
    
    /** Effectue les opérations mensuelles de maintenance du compte. Cette méthode est
     * susceptible de déclencher des exceptions si des anomalies sont détectées. */
    void operationsMensuelles() throws DepassementDecouvertExc, VersementsInsuffisantsExc ;
}
