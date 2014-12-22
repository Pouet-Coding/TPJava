package exo1.adaptateur;

/**
 * Interface caractérisant une file.
 * 
 * @author Guillaume Chanson
 * @author François Chalifour
 * @since 07/12/14
 * @version 1.0
 * 
 * @param <E>
 *            Type des éléments traités par File
 */
public interface File<E> {

	/**
	 * Retourne la tête de la File.
	 * 
	 * @return <E> l'élément en tête de la File
	 */
	E tete();

	/**
	 * Insère l'élément entré en queue dans la File.
	 * 
	 * @param element
	 *            l'élément à insérer
	 */
	void insererQueue(E element);

	/**
	 * Enlève l'élément en tête de la File.
	 */
	void retirerTete();

	/**
	 * Retourne la longueur de la File.
	 * 
	 * @return int la longueur de la File
	 */
	int longueur();

	/**
	 * Retourne un booléen indiquant si la File est vide.
	 * 
	 * @return <code>true</code> si la File est vide; <br>
	 *         <code>false</code> sinon
	 */
	boolean estVide();
}
