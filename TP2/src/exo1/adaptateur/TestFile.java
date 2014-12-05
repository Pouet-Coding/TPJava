package exo1.adaptateur;


public class TestFile {
	
	public TestFile() {
		test1();
		test2();
	}
	
	public void test1() {
		final FileImpl<Integer> fileImpl = new FileImpl<>();
		
		fileImpl.insererQueue(new Integer(10));
		fileImpl.insererQueue(new Integer(20));
		
		fileImpl.retirerTete();
		
		System.out.println("File " + fileImpl);
	}
	
	public void test2() {
		final FileImpl<String> fileImpl = new FileImpl<>();
		
		fileImpl.insererQueue("La première chaine.");
		fileImpl.insererQueue("La deuxième chaine.");
		
		fileImpl.retirerTete();
		
		System.out.println("File " + fileImpl);		
	}

	public static void main(String[] args) {
		new TestFile();
	}
}
