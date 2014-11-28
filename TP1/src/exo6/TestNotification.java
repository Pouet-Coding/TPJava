package exo6;

public class TestNotification {

	public static void main(String[] args) {
		final Compteur compteur = new Compteur();

		new Thread(new Pair(compteur)).start();
		new Thread(new Impair(compteur)).start();
	}
}
