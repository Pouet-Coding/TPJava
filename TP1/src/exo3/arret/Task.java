package exo3.arret;

public class Task implements Runnable {
	
	private boolean stopped;
	
	public Task() {
		this.stopped = false;
	}

	@Override
	public void run() {
		try {
			while (!isStopped()) {
				Thread.sleep(100L);
				System.out.print(".");
			}
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}
	}

	
	public synchronized void setStopped(boolean stopped) {
		this.stopped = stopped;
	}
	
	public synchronized boolean isStopped() {
		return this.stopped;
	}
}
