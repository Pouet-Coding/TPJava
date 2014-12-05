package exo9;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Callable;

public class CallableTask implements Callable<Integer> {

	private final String nom;

	/**
	 * Construct a new CallableTask with the given name.
	 * 
	 * @param nom
	 *            official name
	 */
	public CallableTask(String nom) {
		this.nom = nom;
	}

	@Override
	public Integer call() throws Exception {
		Integer compteur = new Integer(0);

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

		return compteur;
	}

}
