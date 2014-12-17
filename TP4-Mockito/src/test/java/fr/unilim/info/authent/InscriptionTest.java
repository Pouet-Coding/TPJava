package fr.unilim.info.authent;

import static org.junit.Assert.assertEquals;

import java.util.Random;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import fr.unilim.info.authent.exception.CompteDejaInscritException;
import fr.unilim.info.authent.exception.CompteInexistantException;

public class InscriptionTest {

	@Mock
	private IAnnuaire annuaire;
	private ServiceAuthentification authentification;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		authentification = new ServiceAuthentification(annuaire);
	}

	/*
	 * Test sur inscrire
	 */

	@Test(expected = IllegalArgumentException.class)
	public void testInscrireThrowsIllegalArgumentExceptionWhenIdEmpty()
			throws CompteDejaInscritException {

		// When
		authentification.inscrire(null, "abcde");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testInscrireThrowsIllegalArgumentExceptionWhenMotDePasseEmpty()
			throws CompteDejaInscritException {

		// When
		authentification.inscrire("abcde", null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testInscrireThrowsIllegalArgumentExceptionWhenIdAndMotDePasseEmpty()
			throws CompteDejaInscritException {

		// When
		authentification.inscrire(null, null);
	}

	@Test(expected = CompteDejaInscritException.class)
	public void testInscrireThrowsCompteDejaInscritExceptionWhenCompteRegistered()
			throws CompteDejaInscritException {
		// Given
		final String id = "abcde";
		final String passwd = "edcba";
		final Compte compte = new Compte(id);

		Mockito.when(annuaire.recupererCompteParIdentifiant(id)).thenReturn(
				compte);

		// When
		authentification.inscrire(id, passwd);
	}

	@Test
	public void testInscrireWhenCompteNotRegistered()
			throws CompteDejaInscritException {
		// Given
		final String id = "abcde";
		final String passwd = "edcba";
		final boolean expected = new Random().nextBoolean();

		Mockito.when(annuaire.recupererCompteParIdentifiant(id)).thenReturn(
				null);

		Mockito.doReturn(expected).when(annuaire).creerCompte(id, passwd);

		// When
		final boolean actual = authentification.inscrire(id, passwd);
		
		// Then
		assertEquals(expected, actual);
	}

	/*
	 * Test sur desinscrire
	 */

	@Test(expected = IllegalArgumentException.class)
	public void testDesinscrireThrowsIllegalArgumentExceptionWhenIdNull()
			throws CompteInexistantException {
		// When
		authentification.desinscrire(null);
	}

	@Test(expected = CompteInexistantException.class)
	public void testDesinscrireThrowsCompteInexistantExceptionWhenCompteInexistant()
			throws CompteInexistantException {
		// Given
		final String id = "abcde";

		Mockito.doReturn(null).when(annuaire).recupererCompteParIdentifiant(id);

		// When
		authentification.desinscrire(id);
	}

	@Test
	public void testDesinscrireWhenCompteRegistered()
			throws CompteDejaInscritException, CompteInexistantException {
		// Given
		final String id = "abcde";
		final Compte compte = new Compte(id);
		final boolean expected = new Random().nextBoolean();

		Mockito.when(annuaire.recupererCompteParIdentifiant(id)).thenReturn(
				compte);
		Mockito.doReturn(expected).when(annuaire).supprimerCompte(id);
		
		// When
		final boolean actual = authentification.desinscrire(id);

		// Then
		assertEquals(expected, actual);

	}
}
