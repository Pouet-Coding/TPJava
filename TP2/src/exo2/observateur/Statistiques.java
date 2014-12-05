package exo2.observateur;

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

	private double getMinTemperature() {
		return this.min;
	}

	private double getMaxTemperature() {
		return this.max;
	}

	private double getMoyenneTemperature() {
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
