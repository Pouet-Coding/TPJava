package exo7;

import java.util.List;

public class Producer implements Runnable {

	/**
	 * Maximum size of products that can be stored at one time.
	 */
	private int SIZE;
	private final List<Products> products;

	/**
	 * Construct a new Producer to produce food.
	 * 
	 * @param products
	 *            List<Products> of the products
	 */
	public Producer(List<Products> products, int SIZE) {
		this.products = products;
		this.SIZE = SIZE;
	}

	/**
	 * Run method of Producer class.
	 */
	@Override
	public void run() {

		while (true) {
			synchronized (products) {
				while (products.size() >= SIZE) {
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
				produce();
				products.notifyAll();
			}
		}
	}

	private void produce() {
		int random = (int) (Math.random() * Products.getNumberOfProducts());
		Products product;

		switch (random) {
		case 0:
			product = Products.Carotte;
			break;

		case 1:
			product = Products.Courgette;
			break;

		case 2:
			product = Products.Patate;
			break;

		case 3:
			product = Products.Potiron;
			break;

		default:
			product = null;
		}

		System.out.println("Je viens de produire une " + product);
		products.add(product);
	}
}
