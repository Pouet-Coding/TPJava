package authentification;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import authentification.exception.CompteInactifException;
import authentification.exception.CompteInexistantException;
import authentification.exception.MotDePasseIncorrectException;
import authentification.fixture.ConnexionFixture;

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
	@Mock
	private List<String> sessionsEnCours;
	private ServiceAuthentification authentification;

	private void mockSession() {
		authentification = new ServiceAuthentification(annuaire) {
			@Override
			protected List<String> getSessionsEnCours() {
				return sessionsEnCours;
			};
		};
	}

	/**
	 * Avant chaque test : initialise le mock, ainsi que le service
	 * d'authentification.
	 */
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
		final boolean actual;

		Mockito.when(sessionsEnCours.contains(id)).thenReturn(true);
		mockSession();

		// When
		actual = authentification.estConnecte(id);

		// Then
		assertTrue(actual);
	}

	@Test
	public void testEstConnecteWhenCompteNotConnected() {
		// Given
		final String id = "abcde";
		final boolean actual;

		// When
		actual = authentification.estConnecte(id);

		// Then
		assertFalse(actual);
	}

	/*
	 * Test de la méthode connecter.
	 */

	@Test(expected = IllegalArgumentException.class)
	public void testConnecterThrowsIllegalArgumentExceptionWhenIdEmpty()
			throws CompteInexistantException, CompteInactifException, MotDePasseIncorrectException {

		// When
		authentification.connecter(null, "abcde");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testConnecterThrowsIllegalArgumentExceptionWhenMotDePasseEmpty()
			throws CompteInexistantException, CompteInactifException, MotDePasseIncorrectException {

		// When
		authentification.connecter("abcde", null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testConnecterThrowsIllegalArgumentExceptionWhenIdAndMotDePasseEmpty()
			throws CompteInexistantException, CompteInactifException, MotDePasseIncorrectException {

		// When
		authentification.connecter(null, null);
	}

	@Test(expected = CompteInexistantException.class)
	public void testConnecterThrowsCompteInexistantExceptionWhenCompteNotRegistered()
			throws CompteInexistantException, CompteInactifException, MotDePasseIncorrectException {
		// Given
		final String id = "abcde";
		final String passwd = "edcba";

		// When
		ConnexionFixture.connecter(authentification, annuaire, id, passwd, null, false);
	}

	@Test(expected = CompteInactifException.class)
	public void testConnecterThrowsCompteInactifExceptionWhenCompteIsNotActif()
			throws CompteInexistantException, CompteInactifException, MotDePasseIncorrectException {
		// Given
		final String id = "abcde";
		final String passwd = "edcba";
		final Compte compte = new Compte(id);

		compte.setActif(false);

		// When
		ConnexionFixture.connecter(authentification, annuaire, id, passwd, compte, false);
	}

	@Test(expected = MotDePasseIncorrectException.class)
	public void testConnecterThrowsMotDePasseIncorrectExceptionWhenMotDePasseWrong()
			throws CompteInexistantException, CompteInactifException, MotDePasseIncorrectException {
		// Given
		final String id = "abcde";
		final String passwd = "edcba";
		final Compte compte = new Compte(id);

		// When
		ConnexionFixture.connecter(authentification, annuaire, id, passwd, compte, false);
	}

	@Test
	public void testConnecterWhenNotConnected() throws CompteInexistantException,
			CompteInactifException, MotDePasseIncorrectException {
		// Given
		final String id = "abcde";
		final String passwd = "edcba";
		final Compte compte = new Compte(id);
		final boolean actual;

		// When
		ConnexionFixture.connecter(authentification, annuaire, id, passwd, compte, true);
		actual = authentification.estConnecte(id);

		// Then
		assertTrue(actual);
	}

	@Test
	public void testConnecterWhenConnected() throws CompteInexistantException,
			CompteInactifException, MotDePasseIncorrectException {
		// Given
		final String id = "abcde";
		final String passwd = "edcba";
		final Compte compte = new Compte(id);
		final boolean actual;

		Mockito.when(sessionsEnCours.contains(id)).thenReturn(true);
		mockSession();

		// When
		ConnexionFixture.connecter(authentification, annuaire, id, passwd, compte, true);
		actual = authentification.estConnecte(id);

		// Then
		assertTrue(actual);
	}

	/*
	 * Test de la méthode deconnecter.
	 */

	@Test
	public void testDeconnecterWhenConnected() throws CompteInexistantException,
			CompteInactifException, MotDePasseIncorrectException {
		// Given
		final String id = "abcde";
		final boolean actual;

		Mockito.when(sessionsEnCours.contains(id)).thenReturn(true);
		Mockito.when(sessionsEnCours.remove(id)).thenReturn(true);
		mockSession();

		// When
		authentification.deconnecter(id);
		
		Mockito.when(sessionsEnCours.contains(id)).thenReturn(false);
		actual = authentification.estConnecte(id);

		// Then
		assertFalse(actual);
	}

	@Test
	public void testDeconnecterWhenNotConnected() throws CompteInexistantException,
			CompteInactifException, MotDePasseIncorrectException {
		// Given
		final String id = "abcde";
		final boolean actual;

		// When
		authentification.deconnecter(id);
		actual = authentification.estConnecte(id);

		// Then
		assertFalse(actual);
	}
}
