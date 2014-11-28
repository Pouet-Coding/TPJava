package exo3.arret;

public class TestArret {

	public static void main(String[] args) {
		final Task task = new Task();
		
		new Thread(task).start();
		
		try {
			Thread.sleep(2000L);
			task.setStopped(true);
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}
		
		System.out.println("\n" + Thread.currentThread() + " est arreté");
	}
}
