package exo1.adaptateur;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


/**
 * Test la file implémentée dans src/main/java/exo1/adaptateur.
 * 
 * @author Guillaume Chanson
 * @author François Chalifour
 * @since 07/12/14
 * @version 1.0
 */
public class FileTest {

	/**
	 * Teste si l'élément en tête est égal au seul élément inséré.
	 */
	@Test
	public void testTeteEgalSeulElementInsere() {
		// Given
		final FileImpl<Integer> fileImpl = new FileImpl<>();
		final Integer expected = 10;

		// When
		fileImpl.insererQueue(expected);

		// Assert
		assertEquals(expected, fileImpl.tete());
		assertEquals(1, fileImpl.longueur());
	}

	/**
	 * Teste si, après avoir ajouté 2 éléments, puis retiré celui en tête,
	 * l'élément en tête est l'élément restant (le deuxième inséré).
	 */
	@Test
	public void testTeteEgalDernierElementRestant() {
		// Given
		final FileImpl<Integer> fileImpl = new FileImpl<>();
		final Integer nombre1 = 10;
		final Integer nombre2 = 20;

		// When
		fileImpl.insererQueue(nombre1);
		fileImpl.insererQueue(nombre2);

		fileImpl.retirerTete();

		// Assert
		assertEquals(nombre2, fileImpl.tete());
		assertEquals(1, fileImpl.longueur());
	}
}
