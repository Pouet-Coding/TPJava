package authentification.fixture;

import org.mockito.Mockito;

import authentification.Compte;
import authentification.IAnnuaire;
import authentification.ServiceAuthentification;
import authentification.exception.CompteInactifException;
import authentification.exception.CompteInexistantException;
import authentification.exception.MotDePasseIncorrectException;

/**
 * Classe qui propose des méthodes visant à faciliter le test de
 * ServiceAuthentification.
 *
 * @author Guillaume Chanson
 * @author François Chalifour
 * @since 17/12/14
 * @version 1.0
 */
public class ConnexionFixture {

	/**
	 * Connecte le compte d'identifiant et mot de passe donnés, à l'annuaire
	 * donné via le service d'authentification spécifié. <br>
	 * Les modalités de la connexion sont précisées ensuite.
	 *
	 * @param authentification
	 *            le service d'authentification
	 * @param annuaire
	 *            l'annuaire
	 * @param id
	 *            l'identifiant du compte
	 * @param motDePasse
	 *            le mot de passe du compte
	 * @param recupererCompteValue
	 *            ce que doit retourner la méthode
	 *            <code>recupererCompteParIdentifiant</code> de l'annuaire
	 * @param verifierPasswdValue
	 *            ce que doit retourner la méthode
	 *            <code>verifierMotDePasse</code> de l'annuaire
	 * @throws CompteInexistantException
	 *             si le compte est inexistant
	 * @throws CompteInactifException
	 *             si le comtpe est inactif
	 * @throws MotDePasseIncorrectException
	 *             si le mot de passe est incorrect
	 */
	public static void connecter(ServiceAuthentification authentification, IAnnuaire annuaire,
			String id, String motDePasse, Compte recupererCompteValue, boolean verifierPasswdValue)
			throws CompteInexistantException, CompteInactifException, MotDePasseIncorrectException {

		Mockito.doReturn(recupererCompteValue).when(annuaire).recupererCompteParIdentifiant(id);
		Mockito.doReturn(verifierPasswdValue).when(annuaire).verifierMotDePasse(id, motDePasse);

		authentification.connecter(id, motDePasse);
	}
}
