package exo2.observateur;

/**
 * Cette interface définit les actions que doit effectuer chaque capteur.
 * 
 * @author Guillaume Chanson
 * @author François Chalifour
 * @since 07/12/14
 * @version 1.0
 */
public interface Sujet {

	/**
	 * Ajoute un observateur à la liste.
	 * 
	 * @param observateur
	 *            l'observateur à ajouter
	 */
	void ajouterObservateur(Observateur observateur);

	/**
	 * Enleve un observateur de la liste d'observateur.
	 * 
	 * @param observateur
	 *            l'observateur à enlever
	 */
	void retirerObservateur(Observateur observateur);

	/**
	 * Notifie les observateurs.
	 */
	void notifierObservateur();
}
