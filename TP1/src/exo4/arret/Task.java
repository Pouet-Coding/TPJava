package exo4.arret;

public class Task implements Runnable {

	@Override
	public void run() {
		try {
			while(!Thread.interrupted()) {
				Thread.sleep(100L);
				System.out.print(".");
			}
		} catch (InterruptedException ie) {
			System.out.println("\n" + Thread.currentThread() + " est arreté");
		}
	}
}
