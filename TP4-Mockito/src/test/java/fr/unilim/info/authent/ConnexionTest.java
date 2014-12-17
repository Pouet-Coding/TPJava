package fr.unilim.info.authent;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import fr.unilim.info.authent.exception.CompteInactifException;
import fr.unilim.info.authent.exception.CompteInexistantException;
import fr.unilim.info.authent.exception.MotDePasseIncorrectException;

public class ConnexionTest {
	@Mock
	private IAnnuaire annuaire;
	private ServiceAuthentification authentification;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		authentification = new ServiceAuthentification(annuaire);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testConnecterThrowsIllegalArgumentExceptionWhenIdEmpty()
			throws CompteInexistantException, CompteInactifException,
			MotDePasseIncorrectException {

		// When
		authentification.connecter(null, "abcde");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testConnecterThrowsIllegalArgumentExceptionWhenMotDePasseEmpty()
			throws CompteInexistantException, CompteInactifException,
			MotDePasseIncorrectException {

		// When
		authentification.connecter("abcde", null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testConnecterThrowsIllegalArgumentExceptionWhenIdAndMotDePasseEmpty()
			throws CompteInexistantException, CompteInactifException,
			MotDePasseIncorrectException {

		// When
		authentification.connecter(null, null);
	}

	@Test(expected = CompteInexistantException.class)
	public void testConnecterThrowsCompteInexistantExceptionWhenCompteNotRegistered()
			throws CompteInexistantException, CompteInactifException,
			MotDePasseIncorrectException {
		// Given
		final String id = "abcde";
		final String passwd = "edcba";

		Mockito.doReturn(null).when(annuaire).recupererCompteParIdentifiant(id);

		// When
		authentification.connecter(id, passwd);
	}

	@Test(expected = CompteInactifException.class)
	public void testConnecterThrowsCompteInactifExceptionWhenCompteIsNotActif()
			throws CompteInexistantException, CompteInactifException,
			MotDePasseIncorrectException {
		// Given
		final String id = "abcde";
		final String passwd = "edcba";
		final Compte compte = new Compte(id);

		compte.setActif(false);

		Mockito.doReturn(compte).when(annuaire)
				.recupererCompteParIdentifiant(id);

		// When
		authentification.connecter(id, passwd);
	}

	@Test(expected = MotDePasseIncorrectException.class)
	public void testConnecterThrowsMotDePasseIncorrectExceptionWhenMotDePasseWrong()
			throws CompteInexistantException, CompteInactifException,
			MotDePasseIncorrectException {
		// Given
		final String id = "abcde";
		final String passwd = "edcba";
		final Compte compte = new Compte(id);

		// Bien que par défaut, compte est actif, on s'en assure.
		compte.setActif(true);

		Mockito.doReturn(compte).when(annuaire)
				.recupererCompteParIdentifiant(id);

		Mockito.doReturn(false).when(annuaire).verifierMotDePasse(id, passwd);

		// When
		authentification.connecter(id, passwd);
	}

	@Test
	public void testConnecterWhenNotConnected()
			throws CompteInexistantException, CompteInactifException,
			MotDePasseIncorrectException {
		// Given
		final String id = "abcde";
		final String passwd = "edcba";
		final Compte compte = new Compte(id);

		// Bien que par défaut, compte est actif, on s'en assure.
		compte.setActif(true);

		Mockito.doReturn(compte).when(annuaire)
				.recupererCompteParIdentifiant(id);

		Mockito.doReturn(true).when(annuaire).verifierMotDePasse(id, passwd);

		// When
		authentification.connecter(id, passwd);

		// Then
		assertTrue(authentification.estConnecte(id));
	}

	@Test
	public void testConnecterWhenConnected()
			throws CompteInexistantException, CompteInactifException,
			MotDePasseIncorrectException {
		// Given
		final String id = "abcde";
		final String passwd = "edcba";
		final Compte compte = new Compte(id);

		// Bien que par défaut, compte est actif, on s'en assure.
		compte.setActif(true);

		Mockito.doReturn(compte).when(annuaire)
				.recupererCompteParIdentifiant(id);

		Mockito.doReturn(true).when(annuaire).verifierMotDePasse(id, passwd);

		// When
		authentification.connecter(id, passwd);
		authentification.connecter(id, passwd);

		// Then
		assertTrue(authentification.estConnecte(id));
	}
}
