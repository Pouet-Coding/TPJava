package exo2.observateur;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Classe de test du package exo2.observateur : instancie et lance les
 * observateurs implémentés, nourris des informations d'un / de plusieurs
 * capteur(s).
 * 
 * @author Guillaume Chanson - François Chalifour
 * @since 07/12/14
 * @version 1.0
 */
/**
 * @author guillaume
 * 
 */
public class TestObservateur implements Observateur {

	private int compteur;
	private final int compteurFin;
	private final ExecutorService executorService;
	private final Capteur capteur;

	/**
	 * Crée et lance la classe de test avec comme compteur de fin l'entier
	 * entré.
	 * 
	 * @param compteurFin
	 *            nombre de données captées avant l'arrêt du test
	 */
	public TestObservateur(int compteurFin) {
		this.compteur = 0;
		this.compteurFin = compteurFin;

		executorService = Executors.newFixedThreadPool(1);

		capteur = new Capteur();
		capteur.ajouterObservateur(new Grapheur());

		/*
		 * En s'ajoutant en observateur, on reçoit ainsi une notification pour
		 * chaque donnée captée. Ainsi, cela permet dans ce cas de s'arrêter une
		 * fois le seuil de données atteint.
		 */
		capteur.ajouterObservateur(this);

		executorService.submit(new Thread(capteur));

		/*
		 * Permet de tester l'ajout dynamique d'un observateur : On attend 1
		 * second avant d'ajouter un observateur. On remarquera le lancement de
		 * la console une seconde après le grapheur.
		 */
		try {
			Thread.sleep(1_000L);
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}
		capteur.ajouterObservateur(new Statistiques());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see exo2.observateur.Observateur#modifier(exo2.observateur.Donnee)
	 */
	@Override
	public void modifier(Donnee donnee) {
		compteur++;

		if (compteur == compteurFin) {
			executorService.shutdownNow();
			System.out.println("Capteur " + capteur + " arrêté");
		}
	}

	public static void main(String[] args) {
		new TestObservateur(10);
	}

}
