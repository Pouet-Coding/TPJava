package exo6;

public class Impair implements Runnable {

	private final Compteur compteur;

	public Impair(Compteur compteur) {
		this.compteur = compteur;
	}

	@Override
	public void run() {
		while (true) {
			synchronized (compteur) {
				while (compteur.getL() % 2 == 0) {
					try {
						compteur.wait();
					} catch (InterruptedException ie) {
						ie.printStackTrace();
					}
				}
				
				try {
					Thread.sleep(500L);
				} catch (InterruptedException ie) {
					ie.printStackTrace();
				}

				System.out.println(compteur.getL());
				compteur.next();
				compteur.notifyAll();
			}

		}

	}
}
