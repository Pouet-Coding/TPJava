package exo2.observateur;

public interface Observateur {

	/**
	 * Modifie la donnee captée par le capteur.
	 * 
	 * @param donnee
	 *            la donnée captée
	 */
	void modifier(Donnee donnee);
}
