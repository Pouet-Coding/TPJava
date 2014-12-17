package exo;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * Classe qui lance les tests des classes Animal et Zoo
 * 
 * @author Guillaume Chanson - François Chalifour
 * @since 10/12/14
 * @version 1.0
 */

@RunWith(Suite.class)
@SuiteClasses({ AnimalTest.class, ZooTest.class })
public class ZooTestSuite {
}
