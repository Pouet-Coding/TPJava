package exo1.adaptateur;

/**
 * Classe de test.
 * 
 * @author Guillaume Chanson - François Chalifour
 * @since 07/12/14
 * @version 1.0
 */
public class TestFile {

	/**
	 * Créé et Lance la classe de test.
	 */
	public TestFile() {
		test(new Integer(10), new Integer(20));
		test("La première chaine.", "La deuxième chaine.");
		test(null, "La première chaine.");
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
		final FileImpl<E> fileImpl = new FileImpl<>();

		fileImpl.insererQueue(element1);
		fileImpl.insererQueue(element2);

		fileImpl.retirerTete();

		System.out.println("File " + fileImpl);
	}

	/**
	 * Main.
	 * 
	 * @param args
	 *            arguments
	 */
	public static void main(String[] args) {
		new TestFile();
	}
}
