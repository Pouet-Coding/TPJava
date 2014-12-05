package exo1.adaptateur;

import java.util.ArrayList;
import java.util.List;

public class FileImpl<E> implements File<E> {

	private final List<E> list;

	/**
	 * Créé une instance de FileImpl.
	 */
	public FileImpl() {
		this.list = new ArrayList<>();
	}

	@Override
	public E tete() {
		if (estVide())
			throw new IllegalStateException("La liste est vide");

		return list.get(0);
	}

	@Override
	public void insererQueue(E element) {
		list.add(element);
	}

	@Override
	public void retirerTete() {
		if (estVide())
			throw new IllegalStateException("La liste est vide");

		list.remove(0);
	}

	@Override
	public int longueur() {
		return list.size();
	}

	@Override
	public boolean estVide() {
		return list.isEmpty();
	}

	@Override
	public String toString() {
		return "FileImpl [list=" + list + "]";
	}
}
