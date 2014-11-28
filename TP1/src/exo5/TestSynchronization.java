package exo5;

public class TestSynchronization {

	private static class ConcurrentThread extends Thread {
		private Compteur compteur = new Compteur();
		
		public ConcurrentThread(Compteur compteur) {
			this.compteur = compteur;
		}

		@Override
		public void run() {
			for (int i = 0; i < 1_000_000L; i++) {
				compteur.next();
			}
		}
	}
	
	public static void main(String[] args) {
		final Compteur compteur = new Compteur();
		final ConcurrentThread threads[] = new ConcurrentThread[10];
		
		for (ConcurrentThread thread : threads) {
			thread = new ConcurrentThread(compteur);
			thread.start();
			try {
				thread.join();
			} catch (InterruptedException ie) {
				ie.printStackTrace();
			}
		}
		
		System.out.println("Longueur = " + compteur.getL());
	}
}
