package exo3.composite;

/**
 * Classe qui définit un fichier, sorte de composant système.
 * 
 * @author Guillaume Chanson
 * @author François Chalifour
 * @since 07/12/14
 * @version 1.0
 */
public class Fichier extends ComposantSysteme {

	private final String nom;
	private final int taille;

	/**
	 * Crée un nouveau fichier de nom et de taille donnés.
	 * 
	 * @param nom
	 *            le nom du nouveau fichier
	 * @param taille
	 *            la taille du nouveau fichier
	 */
	public Fichier(String nom, int taille) {
		this.nom = nom;
		this.taille = taille;
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
		return this.taille;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Fichier [nom=" + nom + ", taille=" + taille + "]";
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
		visiteur.afterVisit(this);
	}
}
