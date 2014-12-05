package exo2.observateur;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestObservateur implements Observateur {

	private int compteur;
	private final ExecutorService executorService;
	private final Capteur capteur;
	
	public TestObservateur() {
		compteur = 0;
		
		executorService = Executors.newFixedThreadPool(2);
		
		capteur = new Capteur();
		capteur.ajouterObservateur(new Grapheur());
		capteur.ajouterObservateur(this);
		
		executorService.submit(new Thread(capteur));

		try {
			Thread.sleep(1_000L);
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}
		capteur.ajouterObservateur(new Statistiques());
	}

	@Override
	public void modifier(Donnee donnee) {
		compteur++;
		
		if (compteur == 30) {
			executorService.shutdownNow();
			System.out.println("Capteur " + capteur + " arrêté");
		}
	}
	
	public static void main(String[] args) {
		new TestObservateur();
	}


}
