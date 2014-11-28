package exo1;

public class WhoIsThread extends Thread {

	@Override
	public void run() {
		for (int i = 0; i < 20; i++) {
			try {
				sleep(500l);
				System.out.println(this);
			} catch (InterruptedException ie) {
				ie.printStackTrace();
			}
		}
	}

	@Override
	public String toString() {
		return this.getName();
	}
}
