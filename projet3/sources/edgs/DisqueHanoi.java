/** Un DisqueHanoi est un objet implementant simultanement les
 * interfaces suivantes : <UL><LI><code>Disque</code> : les disques
 * ont un diametre specifique</LI>
 * <LI><code>Comparable&lt;Disque&gt;</code> : les disques peuvent
 * etre compares les uns aux autres</LI></UL>
 */
public class DisqueHanoi implements Disque, Comparable<Disque> {
    // le diametre du disque
    private int diametre = 1 ;

    /** On construit une instance de DisqueHanoi en specifiant son diametre
     * @param d entier positif donnant le diametre du disque */
    public DisqueHanoi(int d) { 
	diametre = d ;
    }

    /** Affichage elementaire d'un disque
     *  @return une chaine donnant la valeur du diametre */
    public String toString() { 
	return "" + diametre ; 
    }

    ////////////////////////////////////////////////////////////////
    //
    // ICI COMMENCE L'IMPLEMENTATION DE L'INTERFACE Disque
    //

    /** Retourne le diametre du disque */
    public int diametre() { 
	return diametre ; 
    }

    ////////////////////////////////////////////////////////////////
    //
    // ICI COMMENCE L'IMPLEMENTATION DE L'INTERFACE Comparable
    //

    /** Compare l'instance courante a un autre Disque.
     * @param o un objet qui doit implementer l'interface <code>Disque</code>
     * @return un nombre negatif si <code>o</code> est plus grand que l'instance
     * courante, positif s'il est plus petit, 0 en cas d'egalite. 
     * @see java.lang.Comparable
     */
    public int compareTo(Disque o) {
	return (diametre - o.diametre()) ;       
    }
}
