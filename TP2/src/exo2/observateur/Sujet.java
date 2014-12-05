package exo2.observateur;

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
	 * Notifier les observateurs.
	 */
	void notifierObservateur();
}
