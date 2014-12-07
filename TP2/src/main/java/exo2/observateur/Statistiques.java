package exo2.observateur;

/**
 * Classe qui gère les statistiques des données qu'elle reçoit.
 * 
 * @author Guillaume Chanson - François Chalifour
 * @since 07/12/14
 * @version 1.0
 */
public class Statistiques implements Observateur {

	private double min;
	private double max;
	private double cumul;
	private int nombreValeurs;

	/**
	 * Créé un observateur qui gère les Statistiques.
	 */
	public Statistiques() {
		this.min = 0.0;
		this.max = 0.0;
		this.cumul = 0.0;
		this.nombreValeurs = 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see exo2.observateur.Observateur#modifier(exo2.observateur.Donnee)
	 */
	@Override
	public void modifier(Donnee donnee) {
		double temperature = donnee.getTemperature();

		if (min > temperature)
			min = temperature;

		if (max < temperature)
			max = temperature;

		cumul += donnee.getTemperature();
		nombreValeurs++;

		System.out.println(this);
	}

	/**
	 * Retourne la température minimum reçue.
	 * 
	 * @return double la température minimum reçue
	 */
	public double getMinTemperature() {
		return this.min;
	}

	/**
	 * Retourne la température maximum reçue.
	 * 
	 * @return double la température maximum reçue
	 */
	public double getMaxTemperature() {
		return this.max;
	}

	/**
	 * Retourne la température moyenne reçue.
	 * 
	 * @return double la température moyenne reçue
	 */
	public double getMoyenneTemperature() {
		return this.cumul / this.nombreValeurs;
	}

	/**
	 * Retourne une chaine caractéristique de l'object statistique courant.
	 * 
	 * @return String la chaine caractéristique
	 */
	@Override
	public String toString() {
		return "Statistiques [getMinTemperature()=" + getMinTemperature()
				+ ", getMaxTemperature()=" + getMaxTemperature()
				+ ", getMoyenneTemperature()=" + getMoyenneTemperature() + "]";
	}

}
