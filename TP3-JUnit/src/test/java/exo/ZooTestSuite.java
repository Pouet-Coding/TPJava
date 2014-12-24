package exo;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * Classe qui lance les classes de test AnimalShould et ZooTest.
 *
 * @author Guillaume Chanson
 * @author François Chalifour
 * @since 10/12/14
 * @version 1.0
 */

@RunWith(Suite.class)
@SuiteClasses({ AnimalShould.class, ZooTest.class })
public class ZooTestSuite {
}
