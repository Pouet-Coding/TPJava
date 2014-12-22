package exo2.observateur;

/**
 * Cette interface définit la/les action(s) que doit effectuer chaque
 * observateur.
 * 
 * @author Guillaume Chanson
 * @author François Chalifour
 * @since 07/12/14
 * @version 1.0
 */
public interface Observateur {

	/**
	 * Modifie la donnée captée par le capteur.
	 * 
	 * @param donnee
	 *            la donnée captée
	 */
	void modifier(Donnee donnee);
}
