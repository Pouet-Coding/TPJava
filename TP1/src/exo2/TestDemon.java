package exo2;

public class TestDemon {

	/**
	 * Construct a new TestDemon with the given name.
	 * 
	 * @param nom
	 *            official name
	 */
	public TestDemon(Demon demon) {

		demon.setDaemon(true);
		demon.start();

		try {
			Thread.sleep(2_000L);
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}

		System.out.println("Arrêt + nom du thread courant.");
	}

	/**
	 * Main.
	 * 
	 * @param args
	 *            arguments
	 */
	public static void main(String[] args) {
		new TestDemon(new Demon("thread démon 1"));
	}

}
