package exo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import exo.fixture.AnimalFixture;

/**
 * Classe de test de la classe Zoo.
 *
 * @author Guillaume Chanson
 * @author François Chalifour
 * @since 10/12/14
 * @version 1.0
 */
public class ZooShould {

	private static List<Animal> animaux;
	private Zoo zoo;

	@BeforeClass
	public static void setUpClass() {
		animaux = AnimalFixture.creerListeAnimaux();
	}

	@Before
	public void setUp() {
		zoo = new Zoo();
	}

	@Test
	public void be_empty_when_created() {
		// Then
		assertTrue(zoo.estVide());
	}

	@Test(expected = IllegalArgumentException.class)
	public void throw_NullThrowException_when_ajouter_animal_null() {
		// When
		zoo.ajouterAnimal(null);
	}

	@Test
	public void return_not_empty_when_ajouter_animal_non_null() {
		// When
		zoo.ajouterAnimal(animaux.get(3));

		// Then
		assertFalse(zoo.estVide());
	}

	@Test(expected = IllegalArgumentException.class)
	public void throw_NullThrowException_when_retirer_animal_null() {
		// When
		zoo.retirerAnimal(null);
	}

	@Test(expected = IllegalStateException.class)
	public void throw_IllegalStateException_when_retirer_animal_and_zoo_vide() {
		// When
		zoo.retirerAnimal(animaux.get(3));
	}

	@Test(expected = NoSuchElementException.class)
	public void throw_NoSuchElementException_when_retirer_animal_non_existant() {
		// When
		zoo.ajouterAnimal(animaux.get(3));
		zoo.retirerAnimal(animaux.get(4));
	}

	@Test
	public void be_empty_when_retirer_tous_les_animaux() {
		// Given
		zoo.ajouterAnimal(animaux.get(3));

		// When
		zoo.retirerAnimal(animaux.get(3));

		// Then
		assertTrue(zoo.estVide());
	}

	@Test
	public void return_0_viande_hebdomadaire_when_zoo_non_carnivore() {
		// Given
		Animal vegetarien = AnimalFixture.creerAnimalVegetarien();

		// When
		zoo.ajouterAnimal(vegetarien);

		// Then
		assertEquals(vegetarien.calculerViandeHebdo(),
				zoo.calculerViandeHebdo(), 0);
	}

	@Test
	public void return_viande_hebdomadaire_equals_to_somme_animaux_carnivore() {
		// Given
		Animal carnivore1 = AnimalFixture.creerAnimalCarnivore();
		Animal carnivore2 = AnimalFixture.creerAnimalCarnivore();

		// When
		final double expected = carnivore1.calculerViandeHebdo()
				+ carnivore2.calculerViandeHebdo();

		zoo.ajouterAnimal(carnivore1);
		zoo.ajouterAnimal(carnivore2);

		// Then
		assertEquals(expected, zoo.calculerViandeHebdo(), 0.1);
	}

	/**
	 * On cherche à soigner les dents.<br>
	 * Teste si recupererAnimauxASoigner() retourne bien une file vide lorsque
	 * le zoo est vide.
	 */
	@Test
	public void return_0_animaux_a_soigner_des_dents_when_zoo_empty() {

		// Then
		assertTrue(zoo.recupererAnimauxASoigner(SoinEnum.DENTS).isEmpty());
	}

	/**
	 * On cherche à soigner les dents.<br>
	 * Teste si recupererAnimauxASoigner() retourne une liste vide lorsque le
	 * zoo ne contient que des végétariens.
	 */
	@Test
	public void return_0_animaux_a_soigner_des_dents_when_zoo_has_only_vegerien() {
		// Given
		Animal vegetarien1 = AnimalFixture.creerAnimalVegetarien();
		Animal vegetarien2 = AnimalFixture.creerAnimalVegetarien();

		// When
		zoo.ajouterAnimal(vegetarien1);
		zoo.ajouterAnimal(vegetarien2);

		// Then
		assertTrue(zoo.recupererAnimauxASoigner(SoinEnum.DENTS).isEmpty());
	}

	/**
	 * On cherche à soigner les dents.<br>
	 * Teste si recupererAnimauxASoigner() retourne ce qu'il faut lorsque le zoo
	 * contient des carnivores (il est censé retourner une liste de ces
	 * carnivores).
	 */
	@Test
	public void return_number_of_carnivores_animaux_a_soigner_des_dents_when_zoo_has_carnivores() {
		// Given
		Animal carnivore1 = AnimalFixture.creerAnimalCarnivore();
		Animal carnivore2 = AnimalFixture.creerAnimalCarnivore();

		// When
		zoo.ajouterAnimal(carnivore1);
		zoo.ajouterAnimal(carnivore2);

		// Then
		assertEquals(2, zoo.recupererAnimauxASoigner(SoinEnum.DENTS).size());
	}

	/**
	 * On cherche à soigner les pieds.<br>
	 * Teste si recupererAnimauxASoigner() retourne bien une file vide lorsque
	 * le zoo est vide.
	 */
	@Test
	public void return_0_animaux_a_soigner_des_pieds_when_zoo_empty() {
		// Then
		assertTrue(zoo.recupererAnimauxASoigner(SoinEnum.PIEDS).isEmpty());
	}

	/**
	 * On cherche à soigner les pieds.<br>
	 * Teste si recupererAnimauxASoigner() retourne une liste vide lorsque le
	 * zoo ne contient que des animaux trop légers.
	 */
	@Test
	public void return_0_animaux_a_soigner_des_pieds_when_zoo_has_only_little_animals() {
		// Given
		Animal leger1 = AnimalFixture.creerAnimalLeger();
		Animal leger2 = AnimalFixture.creerAnimalLeger();

		// When
		zoo.ajouterAnimal(leger1);
		zoo.ajouterAnimal(leger2);

		// Then
		assertTrue(zoo.recupererAnimauxASoigner(SoinEnum.PIEDS).isEmpty());
	}

	/**
	 * On cherche à soigner les pieds.<br>
	 * Teste si recupererAnimauxASoigner() retourne ce qu'il faut lorsque le zoo
	 * contient des animaux assez lourds pour être soignés (il est censé
	 * retourner une liste de ces animaux).
	 */
	@Test
	public void return_number_of_big_animals_animaux_a_soigner_des_dents_when_zoo_has_big_animals() {
		// Given
		Animal lourd1 = AnimalFixture.creerAnimalLourd();
		Animal lourd2 = AnimalFixture.creerAnimalLourd();

		// When
		zoo.ajouterAnimal(lourd1);
		zoo.ajouterAnimal(lourd2);

		// Then
		assertEquals(2, zoo.recupererAnimauxASoigner(SoinEnum.PIEDS).size());
	}

	/**
	 * Teste la méthode toString(), teste l'affichage en liste.
	 */
	@Test
	public void have_toString_representing_the_state_of_the_zoo() {
		// Given
		zoo.ajouterAnimal(animaux.get(3));
		zoo.ajouterAnimal(animaux.get(4));

		final String expected = "Liste des animaux du zoo :\n["
				+ animaux.get(3) + ", " + animaux.get(4) + "]";

		// Then
		assertEquals(expected, zoo.toString());
	}
}
