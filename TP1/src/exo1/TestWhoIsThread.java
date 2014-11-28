package exo1;

public class TestWhoIsThread {

	public static void main(String[] args) {

		final WhoIsThread thread1 = new WhoIsThread();
		final WhoIsThread thread2 = new WhoIsThread();

		thread1.start();
		thread2.start();

		final Thread thread3 = new Thread(new WhoIsThreadRunnable());
		final Thread thread4 = new Thread(new WhoIsThreadRunnable());

		thread3.start();
		thread4.start();
	}
}
