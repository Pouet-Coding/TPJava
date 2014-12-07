package exo2.observateur;

/**
 * Classe caract�risant un ensemble de donn�e m�t�orologique.
 * 
 * @author V579656
 * @since 10/11/2014
 * @version 1.0
 * 
 */
public class Donnee {

	private final double temperature;
	private final double precipitation;
	private final double pression;

	/**
	 * Constructeur de la classe Donnee.
	 * 
	 * @param temperature
	 *            la temperature (� C).
	 * @param precipitation
	 *            le niveau de pr�cipitations (mm).
	 * @param pression
	 *            la pression atmosph�rique (hPa).
	 */
	public Donnee(double temperature, double precipitation, double pression) {
		this.temperature = temperature;
		this.precipitation = precipitation;
		this.pression = pression;
	}

	/**
	 * R�cup�re la temp�rature (� C).
	 * @return la temp�rature (� C).
	 */
	public double getTemperature() {
		return temperature;
	}

	/**
	 * R�cup�re le niveau de pr�cipitations (mm).
	 * @return  le niveau de pr�cipitations (mm).
	 */
	public double getPrecipitation() {
		return precipitation;
	}

	/**
	 * R�cup�re la pression atmosph�rique (hPa).
	 * @return  la pression atmosph�rique (hPa).
	 */
	public double getPression() {
		return pression;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Donnee [temperature=" + temperature + ", precipitation="
				+ precipitation + ", pression=" + pression + "]";
	}

}
