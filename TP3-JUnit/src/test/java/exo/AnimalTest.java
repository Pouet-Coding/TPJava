package exo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Classe de test de la classe Animal
 *
 * @author Guillaume Chanson
 * @author François Chalifour
 * @since 10/12/14
 * @version 1.0
 */
public class AnimalTest {

	/**
	 * Teste la méthode toString().
	 */
	@Test
	public void Should_ReturnARepresentativeStringOfAnimal_On_ToStringCall() {
		// Given
		final Espece espece = Espece.Lion;
		final boolean carnivore = true;
		final float poids = 217.5F;

		final Animal animal = new Animal(espece, carnivore, poids);

		// Then
		final String expected = "Animal [espece=" + espece + ", carnivore=" + carnivore
				+ ", poids=" + poids + "]\n";

		assertEquals(expected, animal.toString());
	}

	/**
	 * Teste equals() entre le même objet.
	 */
	@Test
	public void Should_SucceedEquals_When_AnimalsAreTheSameInstance() {
		// Given
		final Animal animal = new Animal(Espece.Lion, true, 217.5F);

		// Then
		assertTrue(animal.equals(animal));
	}

	/**
	 * Teste equals() entre deux instances aux mêmes attributs.
	 */
	@Test
	public void Should_SucceedEquals_When_AnimalsAreIdentical() {
		// Given
		final Espece espece = Espece.Lion;
		final boolean carnivore = true;
		final float poids = 217.5F;

		final Animal animal1 = new Animal(espece, carnivore, poids);
		final Animal animal2 = new Animal(espece, carnivore, poids);

		// Then
		assertTrue(animal1.equals(animal2));
	}

	/**
	 * Teste equals() entre deux instances avec des attributs complètement
	 * différents.
	 */
	@Test
	public void Should_FailEquals_When_AnimalsAreTotallyDifferent() {
		// Given
		final Animal animal1 = new Animal(Espece.Lion, true, 217.5F);
		final Animal animal2 = new Animal(Espece.Girafe, false, 12.3F);

		// Then
		assertFalse(animal1.equals(animal2));
	}

	/**
	 * Teste equals() entre deux instances avec des régimes alimentaires
	 * différents.
	 */
	@Test
	public void Should_FailEquals_When_AnimalsHaveDifferentRegime() {
		// Given
		final Animal animal1 = new Animal(Espece.Lion, true, 217.5F);
		final Animal animal2 = new Animal(Espece.Lion, false, 217.5F);

		// Then
		assertFalse(animal1.equals(animal2));
	}

	/**
	 * Teste equals() entre deux instances avec des poids différents.
	 */
	@Test
	public void Should_FailEquals_When_AnimalsHaveDifferentWeight() {
		// Given
		final Animal animal1 = new Animal(Espece.Lion, true, 217.5F);
		final Animal animal2 = new Animal(Espece.Lion, true, 203.2F);

		// Then
		assertFalse(animal1.equals(animal2));
	}

	/**
	 * Teste equals() entre deux instances avec des espèces différentes.
	 */
	@Test
	public void Should_FailEquals_When_AnimalsHaveDifferentSpecies() {
		// Given
		final Animal animal1 = new Animal(Espece.Lion, true, 217.5F);
		final Animal animal2 = new Animal(Espece.Elephant, true, 217.5F);

		// Then
		assertFalse(animal1.equals(animal2));
	}

	/**
	 * Teste equals() entre une instance d'Animal et une instance d'Objet.
	 */
	@Test
	public void Should_FailEquals_When_AnimalAndNonAnimalTested() {
		// Given
		final Animal animal = new Animal(Espece.Girafe, false, 2.5F);
		final Object obj = new Object();

		// Then
		assertFalse(animal.equals(obj));
	}

	/**
	 * Teste equals() entre une instace d'Animal et null.
	 */
	@Test
	public void Should_FailEquals_When_AnimalAndNullTested() {
		// Given
		final Animal animal = new Animal(Espece.Antilope, false, 2.5F);

		// Then
		assertFalse(animal.equals(null));
	}

}
