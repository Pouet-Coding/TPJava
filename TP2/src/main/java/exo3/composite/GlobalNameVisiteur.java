package exo3.composite;

/**
 * Classe qui gère la visite d'un ComposantSysteme en n'affichant que les noms
 * des chemins physiques de ceux-ci.
 * 
 * @author Guillaume Chanson
 * @author François Chalifour
 * @since 07/12/14
 * @version 1.0
 */
public class GlobalNameVisiteur implements Visiteur {

	private String indent = "";

	/*
	 * (non-Javadoc)
	 * 
	 * @see exo3.composite.Visiteur#visit(exo3.composite.Fichier)
	 */
	@Override
	public void visit(Fichier fichier) {
		System.out.println(fichier.getNom());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see exo3.composite.Visiteur#visit(exo3.composite.Repertoire)
	 */
	@Override
	public void visit(Repertoire repertoire) {
		System.out.println(repertoire.getNom());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see exo3.composite.Visiteur#beforeVisit(exo3.composite.ComposantSysteme)
	 */
	@Override
	public void beforeVisit(ComposantSysteme composant) {
		System.out.print(indent);

		if (composant instanceof Repertoire)
			indent += composant.getNom() + "\\";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see exo3.composite.Visiteur#afterVisit(exo3.composite.ComposantSysteme)
	 */
	@Override
	public void afterVisit(ComposantSysteme composant) {
		if (composant instanceof Repertoire) {
			int fin = indent.length() - (composant.getNom().length() + 1);
			indent = indent.substring(0, fin);
		}

		/* composant.getNom().length() + 1 car on rajoute "\\" à chaque fois */
	}
}
