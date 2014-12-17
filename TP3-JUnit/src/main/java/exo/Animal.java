package exo;

/**
 * Classe Animal qui caractérise un animal.
 * 
 * @author Guillaume Chanson - François Chalifour
 * @since 10/12/14
 * @version 1.0
 */
public class Animal {

	private final Espece espece;
	private final boolean carnivore;
	private float poids;

	/**
	 * Crée un nouvel animal à partir des informations données.
	 * 
	 * @param espece
	 *            l'espèce de l'animal
	 * @param carnivore
	 *            le régime alimentaire de l'animal : carnivore (true) ou non
	 *            (false)
	 * @param poids
	 *            le poids de la bête (kg)
	 */
	public Animal(Espece espece, boolean carnivore, float poids) {
		this.espece = espece;
		this.carnivore = carnivore;
		this.poids = poids;
	}

	/**
	 * Retourne la quantité de viande hebdomadaire nécessaire.
	 * 
	 * @return la quantité de viande (kg) nécessaire (0 si non carnivore)
	 */
	public float calculerViandeHebdo() {
		if (carnivore)
			return poids / 4F;

		return 0;
	}

	/**
	 * Retourne l'espèce de l'animal.
	 * 
	 * @return l'espèce
	 */
	public Espece getEspece() {
		return espece;
	}

	/**
	 * Indique si l'animal est carnivore.
	 * 
	 * @return <code>true</code> si l'animal est carnivore; <br>
	 *         <code>false</code> sinon
	 */
	public boolean isCarnivore() {
		return carnivore;
	}
	
	/**
	 * Retourne le poids de l'animal.
	 * 
	 * @return le poids (kg)
	 */
	public float getPoids() {
		return poids;
	}

	/**
	 * Modifie le poids de l'animal.
	 * 
	 * @param poids
	 *            le nouveau poids de l'animal (kg)
	 */
	public void setPoids(float poids) {
		this.poids = poids;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		// On rajoute "\n" à la fin, pour que la liste affiche un animal par
		// ligne
		return "Animal [espece=" + espece + ", carnivore=" + carnivore
				+ ", poids=" + poids + "]\n";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (carnivore ? 1231 : 1237);
		result = prime * result + ((espece == null) ? 0 : espece.hashCode());
		result = prime * result + Float.floatToIntBits(poids);
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;

		if (obj instanceof Animal) {
			final Animal animal = (Animal) obj;
			if (animal.getEspece() == espece && animal.getPoids() == poids
					&& animal.isCarnivore() == carnivore)
				return true;
		}

		return false;
	}

}
