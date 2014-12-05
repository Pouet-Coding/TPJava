package exo7;

import java.util.List;

public class Consumer implements Runnable {

	private final List<Products> products;

	/**
	 * Construct a new Producer to produce food.
	 * 
	 * @param products
	 *            List<Products> of the products
	 */
	public Consumer(List<Products> products) {
		this.products = products;
	}

	/**
	 * Run method of Consumer class.
	 */
	@Override
	public void run() {

		while (true) {
			synchronized (products) {
				while (products.size() <= 0) {
					try {
						products.wait();
					} catch (InterruptedException ie) {
						ie.printStackTrace();
					}
				}
			}

			try {
				Thread.sleep(1_000L);
			} catch (InterruptedException ie) {
				ie.printStackTrace();
			}

			synchronized (products) {
				consume();
				products.notifyAll();
			}
		}

	}

	private void consume() {
		int size = products.size() - 1;

		System.out.println("Je viens de manger une " + products.get(size));
		products.remove(size);
	}

}
