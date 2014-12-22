package exo2.observateur;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Classe qui définit un capteur de données, météorologique par exemple.
 * 
 * @author Guillaume Chanson
 * @author François Chalifour
 * @since 07/12/14
 * @version 1.0
 */
public class Capteur implements Runnable, Sujet {

	private Donnee donnee;
	private final List<Observateur> observateurs;

	/**
	 * Créé une instance de la classe Capteur.
	 */
	public Capteur() {
		this.observateurs = new ArrayList<>();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * exo2.observateur.Sujet#ajouterObservateur(exo2.observateur.Observateur)
	 */
	@Override
	public void ajouterObservateur(Observateur observateur) {
		this.observateurs.add(observateur);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * exo2.observateur.Sujet#retirerObservateur(exo2.observateur.Observateur)
	 */
	@Override
	public void retirerObservateur(Observateur observateur) {
		if (observateurs.isEmpty())
			throw new IllegalStateException("La liste d'observateurs est vide.");

		this.observateurs.remove(observateur);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see exo2.observateur.Sujet#notifierObservateur()
	 */
	@Override
	public void notifierObservateur() {
		for (Observateur observateur : observateurs) {
			observateur.modifier(donnee);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 */
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
