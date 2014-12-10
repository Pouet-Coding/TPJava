package exo.fixture;

import exo.Animal;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Outils pour des tests concernant la classe Animal.
 * 
 * @author Guillaume Chanson - François Chalifour
 * @since 10/12/14
 * @version 1.0
 */
public class AnimalFixture {

	/**
	 * Retourne une liste d'animaux générés COMPLETEMENT aléatoirement (c'est le
	 * joyeux bordel).
	 * 
	 * @return une liste d'animaux générés aléatoirement
	 */
	public static List<Animal> creerListeAnimaux() {
		final List<Animal> animaux = new ArrayList<>();
		final int taille = 6;

		for (int i = 0; i < taille; i++) {
			Animal animal = new Animal(
					new BigInteger(130, new SecureRandom()).toString(32),
					new Random().nextBoolean(),
					new Random().nextFloat() % 5000 + 1);
			animaux.add(animal);
		}

		return animaux;
	}

	/**
	 * Créé une instance d'un animal végétarien.
	 * 
	 * @return un nouvel animal végétarien
	 */
	public static Animal creerAnimalVegetarien() {
		return new Animal(new BigInteger(130, new SecureRandom()).toString(32),
				false, new Random().nextFloat() % 5000 + 1);
	}

	/**
	 * Créé une instance d'un animal carnivore.
	 * 
	 * @return un nouvel animal carnivore
	 */
	public static Animal creerAnimalCarnivore() {
		return new Animal(new BigInteger(130, new SecureRandom()).toString(32),
				true, new Random().nextFloat() % 5000 + 1);
	}
}
