package exo8;

public class LongAction {
	public void traitementLong() {
		for (int i = 0; i < 100; i++) {
			try {
				Thread.sleep(200L);
				System.out.print(".");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
