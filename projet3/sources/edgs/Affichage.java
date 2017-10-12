/** L'interface Affichage permet de dissocier la manipulation des disques 
 * dans les piles (algorithme de resolution, verification des contraintes)
 * de leur affichage (mode texte plus ou moins sophistique, mode graphique, ...)
 */
public interface Affichage 
{
    /** Methode construisant une chaine qui correspond a la facon dont
     * on veut afficher les n premiers elements du tableau de disques */
    String affichage_tableau(Disque [] d, int n) ;
}
