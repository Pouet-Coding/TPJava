package exo3.composite;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Classe qui définit un répertoire, sorte de composant système.
 * 
 * @author Guillaume Chanson - François Chalifour
 * @since 07/12/14
 * @version 1.0
 */
public class Repertoire extends ComposantSysteme {

	private final String nom;
	private final List<ComposantSysteme> composantSystemes;

	/**
	 * Crée un nouveau répertoire de nom donné.
	 * 
	 * @param nom
	 *            le nom du nouveau répertoire
	 */
	public Repertoire(String nom) {
		this.nom = nom;
		this.composantSystemes = new ArrayList<>();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see exo3.composite.ComposantSysteme#getNom()
	 */
	public String getNom() {
		return this.nom;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see exo3.composite.ComposantSysteme#getTaille()
	 */
	public int getTaille() {
		int taille = 0;

		for (ComposantSysteme composant : composantSystemes)
			taille += composant.getTaille();

		return taille;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see exo3.composite.ComposantSysteme#addComposantSysteme(exo3.composite.
	 * ComposantSysteme)
	 */
	@Override
	public void addComposantSysteme(ComposantSysteme composant) {
		if (composant == null)
			throw new NullPointerException("Le composant est null");

		composantSystemes.add(composant);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * exo3.composite.ComposantSysteme#removeComposantSysteme(exo3.composite
	 * .ComposantSysteme)
	 */
	@Override
	public void removeComposantSysteme(ComposantSysteme composant) {
		if (!composantSystemes.remove(composant))
			throw new NoSuchElementException("Le composant " + composant
					+ " n'existe pas");

		/* else : composant retiré */
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see exo3.composite.ComposantSysteme#getComposantSysteme(int)
	 */
	@Override
	public ComposantSysteme getComposantSysteme(int index) {
		return composantSystemes.get(index);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Repertoire [nom=" + nom + ", composantSystemes="
				+ composantSystemes + "]";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * exo3.composite.ComposantSysteme#acceptVisisteur(exo3.composite.Visiteur)
	 */
	@Override
	public void acceptVisisteur(Visiteur visiteur) {
		
		visiteur.beforeVisit(this);
		visiteur.visit(this);

		for (ComposantSysteme composant : composantSystemes)
			composant.acceptVisisteur(visiteur);
		
		visiteur.afterVisit(this);
	}
}
