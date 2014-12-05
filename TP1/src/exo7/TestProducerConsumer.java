package exo7;

import java.util.ArrayList;
import java.util.List;

public class TestProducerConsumer {

	public static void main(String[] args) {
		final List<Products> products = new ArrayList<>();
		final int size = 10;
		
		final Producer producer = new Producer(products, size);
		final Consumer consumer = new Consumer(products);
		
		new Thread(producer).start();
		new Thread(consumer).start();
	}
}
