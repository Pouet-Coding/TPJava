package exo9;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Task implements Runnable {

	private final String nom;

	/**
	 * Construct a new Task with the given name.
	 * 
	 * @param nom
	 *            official name
	 */
	public Task(String nom) {
		this.nom = nom;
	}

	@Override
	public void run() {
		int compteur = 0;

		try {
			while (!Thread.interrupted() && compteur < 10) {
				Thread.sleep(1_000L);
				System.out.println("Thread "
						+ this.nom
						+ " - heure : "
						+ new SimpleDateFormat("hh:mm:ss").format(new Date()
								.getTime()));
				compteur++;
			}
		} catch (InterruptedException ie) {
			System.out.println("Thread " + this.nom + " arrêté");
		}

		// Pas besoin de synchronized :
		// il n'y a pas de partage de ressource :
		// chaque compteur est propose à chaque run
		// le nom est interne à chaque instance
	}
}
