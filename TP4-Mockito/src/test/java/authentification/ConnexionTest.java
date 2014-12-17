package authentification;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import authentification.exception.CompteInactifException;
import authentification.exception.CompteInexistantException;
import authentification.exception.MotDePasseIncorrectException;

/**
 * Classe de test de la classe Connexion.
 * 
 * @author Guillaume Chanson - François Chalifour
 * @since 17/12/14
 * @version 1.0
 */
public class ConnexionTest {

	@Mock
	private IAnnuaire annuaire;
	private ServiceAuthentification authentification;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		authentification = new ServiceAuthentification(annuaire);
	}

	/*
	 * Test de la méthode estConnecte.
	 */

	@Test
	public void testEstConnecteWhenCompteConnected() {
		// Given
		final String id = "abcde";

		// When
		authentification.getSessionsEnCours().add(id);

		final boolean actual = authentification.estConnecte(id);

		// Then
		assertTrue(actual);
	}

	@Test
	public void testEstConnecteWhenCompteNotConnected() {
		// Given
		final String id = "abcde";

		// When
		final boolean actual = authentification.estConnecte(id);

		// Then
		assertFalse(actual);
	}

	/*
	 * Test de la méthode connecter.
	 */

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
	public void testConnecterWhenConnected() throws CompteInexistantException,
			CompteInactifException, MotDePasseIncorrectException {
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
		authentification.getSessionsEnCours().add(id);
		authentification.connecter(id, passwd);

		// Then
		assertTrue(authentification.estConnecte(id));
	}

	/*
	 * Test de la méthode deconnecter.
	 */

	@Test
	public void testDeconnecterWhenConnected()
			throws CompteInexistantException, CompteInactifException,
			MotDePasseIncorrectException {
		// Given
		final String id = "abcde";
		final String passwd = "edcba";
		final Compte compte = new Compte(id);

		Mockito.doReturn(compte).when(annuaire)
				.recupererCompteParIdentifiant(id);

		Mockito.doReturn(true).when(annuaire).verifierMotDePasse(id, passwd);

		// When
		authentification.connecter(id, passwd);
		authentification.deconnecter(id);

		// Then
		assertFalse(authentification.estConnecte(id));
	}

	@Test
	public void testDeconnecterWhenNotConnected()
			throws CompteInexistantException, CompteInactifException,
			MotDePasseIncorrectException {
		// Given
		final String id = "abcde";

		// When
		authentification.deconnecter(id);

		// Then
		assertFalse(authentification.estConnecte(id));
	}
}
