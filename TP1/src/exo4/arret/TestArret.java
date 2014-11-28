package exo4.arret;

public class TestArret {

	public static void main(String[] args) {		
		final Thread task = new Thread(new Task());
		
		task.start();
		
		try {
			Thread.sleep(2000L);
			task.interrupt();
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}
		
		System.out.println(Thread.currentThread() + " est arreté");
	}
}
