package exo1.adaptateur;

/**
 * Classe de test.
 * 
 * @author Guillaume Chanson
 * @author François Chalifour
 * @since 07/12/14
 * @version 1.0
 */
public class TestFile {

	/**
	 * Crée la classe de test.
	 */
	public TestFile() {
		/* Version basique */
		test(new Integer(10), new Integer(20));
		test("La première chaine.", "La deuxième chaine.");
		test(null, "La seule chaine.");

		/* Version JUnit 4 : voir src/test/java */
	}

	/**
	 * Teste avec les objets entrés.
	 * 
	 * @param element1
	 *            premier élément de la liste
	 * @param element2
	 *            deuxième élément de la liste
	 */
	public <E> void test(E element1, E element2) {
		final File<E> file = new FileImpl<>();

		file.insererQueue(element1);
		file.insererQueue(element2);

		file.retirerTete();

		System.out.println("File " + file);
	}

	public static void main(String[] args) {
		new TestFile();
	}
}
