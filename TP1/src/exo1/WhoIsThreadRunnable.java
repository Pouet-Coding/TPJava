package exo1;

public class WhoIsThreadRunnable implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i < 20; i++) {
			try {
				Thread.sleep(500l);
				System.out.println(this);
			} catch (InterruptedException ie) {
				ie.printStackTrace();
			}
		}
	}

	@Override
	public String toString() {
		return Thread.currentThread().getName();
	}
}
