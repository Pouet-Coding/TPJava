package exo3.composite;

/**
 * Classe qui teste la gestion d'un système de fichier.
 * 
 * @author Guillaume Chanson - François Chalifour
 * @since 07/12/14
 * @version 1.0
 */
public class TestRepertoire {

	/**
	 * Crée et lance la classe de test.
	 */
	public TestRepertoire() {
		final Repertoire racine = new Repertoire("C:");
		final Repertoire windows = new Repertoire("Windows");
		final Repertoire temp = new Repertoire("temp");
		final Repertoire system32 = new Repertoire("System32");

		system32.addComposantSysteme(new Fichier("adsnt.dll", 12030));
		system32.addComposantSysteme(new Fichier("advnt.dll", 43220));

		windows.addComposantSysteme(system32);
		windows.addComposantSysteme(new Repertoire("win.ini"));

		temp.addComposantSysteme(new Fichier("test.data", 500));

		racine.addComposantSysteme(windows);
		racine.addComposantSysteme(temp);
		
		System.out.println("\n  ========  Hiérarchie ========  \n");
		racine.acceptVisisteur(new HierarchiqueVisiteur());
		
		System.out.println("\n  ========  Fichiers ========  \n");
		racine.acceptVisisteur(new FichierVisiteur());
		
		System.out.println("\n  ========  GlobalName ========  \n");
		racine.acceptVisisteur(new GlobalNameVisiteur());
	}

	/**
	 * Main.
	 * 
	 * @param args
	 *            arguments
	 */
	public static void main(String[] args) {
		new TestRepertoire();
	}
}
