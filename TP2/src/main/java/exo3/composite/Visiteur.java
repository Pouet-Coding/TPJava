package exo3.composite;

/**
 * Interface qui définit les actions que doivent réaliser les Visiteur d'un
 * ComposantSysteme.
 * 
 * @author Guillaume Chanson
 * @author François Chalifour
 * @since 07/12/14
 * @version 1.0
 */
public interface Visiteur {

	/**
	 * Visite un fichier.
	 * 
	 * @param fichier
	 *            le fichier à visiter
	 */
	public void visit(Fichier fichier);

	/**
	 * Visite un répertoire.
	 * 
	 * @param repertoire
	 *            le répertoire à visiter
	 */
	public void visit(Repertoire repertoire);

	/**
	 * Avant chaque visite.
	 * 
	 * @param composant
	 *            composant qui va être visité
	 */
	public void beforeVisit(ComposantSysteme composant);

	/**
	 * Après chaque visite.
	 * 
	 * @param composant
	 *            composant qui a été visité
	 */
	public void afterVisit(ComposantSysteme composant);

}
