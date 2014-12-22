package authentification;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * Classe qui automatise le lancement des classes de test.
 *
 * @author Guillaume Chanson
 * @author François Chalifour
 * @since 17/12/14
 * @version 1.0
 */
@RunWith(Suite.class)
@SuiteClasses({ ConnexionTest.class, InscriptionTest.class })
public class AuthentificationTestSuite {
}
