package exo.fixture;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import exo.Animal;
import exo.Espece;

/**
 * Outils pour des tests concernant la classe Animal.
 * 
 * @author Guillaume Chanson - François Chalifour
 * @since 10/12/14
 * @version 1.0
 */
public class AnimalFixture {

	private static final Espece[] especes = Espece.values();

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
					especes[new Random().nextInt(especes.length)],
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
		return new Animal(especes[new Random().nextInt(especes.length)], false,
				new Random().nextFloat() % 5000 + 1);
	}

	/**
	 * Créé une instance d'un animal carnivore.
	 * 
	 * @return un nouvel animal carnivore
	 */
	public static Animal creerAnimalCarnivore() {
		return new Animal(especes[new Random().nextInt(especes.length)], true,
				new Random().nextFloat() % 5000 + 1);
	}

	/**
	 * Créé une instance d'un animal trop léger pour être soigné par les pieds.
	 * 
	 * @return un nouvel animal léger
	 */
	public static Animal creerAnimalLeger() {
		return new Animal(especes[new Random().nextInt(especes.length)],
				new Random().nextBoolean(), new Random().nextFloat() % 100 + 1);
	}

	/**
	 * Créé une instance d'un animal assez lourd pour être soigné par les pieds.
	 * 
	 * @return un nouvel animal lourd
	 */
	public static Animal creerAnimalLourd() {
		return new Animal(especes[new Random().nextInt(especes.length)],
				new Random().nextBoolean(),
				new Random().nextFloat() % 5000 + 500);
	}
}
