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
	 * @return String le nom du composant
	 */
	public String getNom() {
		throw new UnsupportedOperationException("getNom");
	}

	/**
	 * Renvoie la taille du composant système.
	 * 
	 * @return int la taille du composant
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

}
