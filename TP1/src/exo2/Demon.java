package exo2;

public class Demon extends Thread {

	/**
	 * Construct a new Demon with the given name.
	 * 
	 * @param nom
	 *            official name
	 */
	public Demon(String nom) {
		super(nom);
	}

	/**
	 * Run method of the Demon.
	 */
	@Override
	public void run() {
		try {
			for (int i = 0; i < 10; i++) {
				try {
					sleep(500L);
				} catch (InterruptedException ie) {
					ie.printStackTrace();
				}
				System.out.println(this);
			}
		} finally {
			System.out.println("Not a daemon");
		}
	}

	/**
	 * Return a String representation of the Demon.
	 * 
	 * @return a String
	 */
	@Override
	public String toString() {
		return "Thread : " + getName();
	}
}
