package exo;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Classe Zoo qui gère une liste d'animaux.
 * 
 * @author Guillaume Chanson - François Chalifour
 * @since 10/12/14
 * @version 1.0
 */
public class Zoo {

	private final List<Animal> animaux;

	/**
	 * Créé une instance de Zoo.
	 */
	public Zoo() {
		animaux = new ArrayList<>();
	}

	/**
	 * Ajoute un animal au zoo.
	 * 
	 * @param animal
	 *            l'animal à ajouter
	 * @throws IllegalArgumentException
	 *             si l'animal entré est null
	 */
	public void ajouterAnimal(Animal animal) {
		if (animal == null)
			throw new IllegalArgumentException("L'animal est null");

		animaux.add(animal);
	}

	/**
	 * Retire un animal du zoo.
	 * 
	 * @param animal
	 *            l'animal à enlever.
	 * @throws IllegalArgumentException
	 *             si l'animal entré est null
	 * @throws IllegalStateException
	 *             si le zoo est vide
	 * @throws NoSuchElementException
	 *             si l'animal n'est pas dans le zoo
	 */
	public void retirerAnimal(Animal animal) {
		if (animal == null)
			throw new IllegalArgumentException("L'animal est null");

		if (estVide())
			throw new IllegalStateException("Le zoo est vide");

		if (!animaux.contains(animal))
			throw new NoSuchElementException(
					"L'animal n'existe pas dans ce zoo");

		animaux.remove(animal);
	}

	/**
	 * Indique si le zoo est vide ou non.
	 * 
	 * @return <code>true</code> si le zoo est vide; <br>
	 *         <code>false</code> sinon
	 */
	public boolean estVide() {
		return animaux.isEmpty();
	}

	/**
	 * Retourne la quantité de viande hebdomadaire au fonctionnement du zoo.
	 * 
	 * @return la quantité de viande (kg) hebdomadaire nécessaire
	 */
	public float calculerViandeHebdo() {
		float totalViande = 0F;

		for (Animal animal : animaux) {
			totalViande += animal.calculerViandeHebdo();
		}

		return totalViande;
	}

	/**
	 * Renvoie la liste des animaux éligibles au type de soin entré en
	 * paramètre.
	 * 
	 * @param soin
	 *            le type de soin
	 * @return une liste des animaux éligibles
	 */
	public List<Animal> recupererAnimauxASoigner(SoinEnum soin) {
		final List<Animal> resultat = new ArrayList<>();

		for (Animal animal : animaux) {
			if (soin == SoinEnum.DENTS) {
				if (animal.isCarnivore()) {
					resultat.add(animal);
				}
			} else {
				if (animal.getPoids() > 200F) {
					resultat.add(animal);
				}
			}
		}

		return resultat;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Liste des animaux du zoo :\n" + animaux;
	}

}
