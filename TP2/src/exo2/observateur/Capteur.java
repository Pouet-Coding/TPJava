package exo2.observateur;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Capteur implements Runnable, Sujet {
	
	private Donnee donnee;
	private final List<Observateur> observateurs;

	/**
	 * Créé une instance de la classe Capteur.
	 */
	public Capteur() {
		this.observateurs = new ArrayList<>();
	}

	/**
	 * Ajoute un observateur au capteur.
	 * 
	 * @param observateur
	 *            l'observateur à ajouter
	 */
	@Override
	public void ajouterObservateur(Observateur observateur) {
		this.observateurs.add(observateur);
	}

	/**
	 * Retire un observateur au capteur.
	 * 
	 * @param observateur
	 *            l'observateur à retirer
	 */
	@Override
	public void retirerObservateur(Observateur observateur) {
		if (observateurs.isEmpty())
			throw new IllegalStateException("La liste d'observateurs est vide.");

		this.observateurs.remove(observateur);
	}

	/**
	 * Notifie tous les observateurs.
	 */
	@Override
	public void notifierObservateur() {
		for (Observateur observateur : observateurs) {
			observateur.modifier(donnee);
		}
	}

	@Override
	public void run() {
		try {
			while (!Thread.currentThread().isInterrupted()) {
				Thread.sleep(200L);
				donnee = new Donnee(ThreadLocalRandom.current().nextDouble(-30,
						40), ThreadLocalRandom.current().nextDouble(0, 100),
						ThreadLocalRandom.current().nextDouble(800, 1200));
				this.notifierObservateur();
			}
		} catch (InterruptedException ie) {
			System.out.println("Capteur " + Thread.currentThread() + " arrêté");
		}
	}
}
