package exo3.composite;

/**
 * Classe abstraite qui définit le comportement de base d'un composant système.
 * 
 * @author Guillaume Chanson - François Chalifour
 * @since 07/12/14
 * @version 1.0
 */
public abstract class ComposantSysteme {

	/**
	 * Renvoie le nom du composant système.
	 * 
	 * @return String - le nom du composant système
	 */
	public String getNom() {
		throw new UnsupportedOperationException("getNom");
	}

	/**
	 * Renvoie la taille du composant système.
	 * 
	 * @return int - la taille du composant système
	 */
	public int getTaille() {
		throw new UnsupportedOperationException("getTaille");
	}

	/**
	 * Ajoute un composant système à la liste de composants systèmes.
	 * 
	 * @param composant
	 *            composant système à être ajouté
	 */
	public void addComposantSysteme(ComposantSysteme composant) {
		throw new UnsupportedOperationException("addComposantSysteme");
	}

	/**
	 * Retire un composant système de la liste de composants systèmes.
	 * 
	 * @param composant
	 *            composant système à être retiré
	 */
	public void removeComposantSysteme(ComposantSysteme composant) {
		throw new UnsupportedOperationException("removeComposantSysteme");
	}

	/**
	 * Retourne le composant système contenu dans le composant courant à l'index
	 * entré.
	 * 
	 * @param index
	 *            index du composant système dans la liste du composant courant
	 * @return ComposantSystem le composant système
	 */
	public ComposantSysteme getComposantSysteme(int index) {
		throw new UnsupportedOperationException("removeComposantSysteme");
	}

	/**
	 * Visite du composant système courant.
	 * 
	 * @param visiteur
	 *            le visiteur
	 */
	public void acceptVisisteur(Visiteur visiteur) {
		throw new UnsupportedOperationException("removeComposantSysteme");
	}
}
