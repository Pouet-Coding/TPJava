package exo1.adaptateur;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe implémentant une liiste d'éléments.
 * 
 * @author Guillaume Chanson - François Chalifour
 * @since 07/12/14
 * @version 1.0
 * 
 * @param <E>
 *            Type des éléments à être traités par FileImpl
 */
public class FileImpl<E> implements File<E> {

	private final List<E> list;

	/**
	 * Créé une instance de FileImpl.
	 */
	public FileImpl() {
		this.list = new ArrayList<>();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see exo1.adaptateur.File#tete()
	 */
	@Override
	public E tete() {
		if (estVide())
			throw new IllegalStateException("La liste est vide");

		return list.get(0);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see exo1.adaptateur.File#insererQueue(java.lang.Object)
	 */
	@Override
	public void insererQueue(E element) {
		list.add(element);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see exo1.adaptateur.File#retirerTete()
	 */
	@Override
	public void retirerTete() {
		if (estVide())
			throw new IllegalStateException("La liste est vide");

		list.remove(0);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see exo1.adaptateur.File#longueur()
	 */
	@Override
	public int longueur() {
		return list.size();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see exo1.adaptateur.File#estVide()
	 */
	@Override
	public boolean estVide() {
		return list.isEmpty();
	}

	/**
	 * Retourne une chaîne caractéristique de l'objet FileImpl.
	 * 
	 * @return String la chaîne caractéristique
	 */
	@Override
	public String toString() {
		return "FileImpl [list=" + list + "]";
	}
}
