package exo3.composite;

/**
 * Classe qui gère la visite d'un ComposantSysteme en ne traitant que les
 * fichiers.
 * 
 * @author Guillaume Chanson - François Chalifour
 * @since 07/12/14
 * @version 1.0
 */
public class FichierVisiteur implements Visiteur {

	/*
	 * (non-Javadoc)
	 * 
	 * @see exo3.composite.Visiteur#visit(exo3.composite.Fichier)
	 */
	@Override
	public void visit(Fichier fichier) {
		System.out.println(fichier.getNom() + "\t" + fichier.getTaille());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see exo3.composite.Visiteur#visit(exo3.composite.Repertoire)
	 */
	@Override
	public void visit(Repertoire repertoire) {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see exo3.composite.Visiteur#beforeVisit(exo3.composite.ComposantSysteme)
	 */
	@Override
	public void beforeVisit(ComposantSysteme composant) {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see exo3.composite.Visiteur#afterVisit(exo3.composite.ComposantSysteme)
	 */
	@Override
	public void afterVisit(ComposantSysteme composant) {
	}
}
