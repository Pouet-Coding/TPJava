package exo9;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TestExecutorService {

	private final ExecutorService executorService;
	private final Future<Integer> future;

	/**
	 * Construct a new TestExecutorService
	 */
	public TestExecutorService() {
		this.executorService = Executors.newFixedThreadPool(2);

		// Version 1
		/*
		 * this.executorService.submit(new Thread(new Task("task 1")));
		 * this.executorService.submit(new Thread(new Task("task 2")));
		 * this.executorService.submit(new Thread(new Task("task 3")));
		 */

		/*
		 * Seuls les 2 premiers Threads se lancent Conformément à la taille du
		 * pool de Threads (2) qui est fixe ici (newFixedThreadPool)
		 */

		// Version 2
		future = executorService.submit(new CallableTask("task 1"));

		/*
		 * On instancie une CallableTask grâce à la méthode submit. Cela renvoie
		 * un interface Future qui nous permettra par la suite de récupérer le
		 * résultat.
		 */
	}

	/**
	 * Return the ExecutorService of the class
	 * 
	 * @return the current instance of ExecutorService
	 */
	public ExecutorService getExecutorService() {
		return this.executorService;
	}

	/**
	 * Return the Future<Integer> instance of the class
	 * 
	 * @return the current instance of Future<Integer>
	 */
	public Future<Integer> getFutureInteger() {
		return this.future;
	}

	/**
	 * Main
	 * 
	 * @param args
	 *            arguments
	 */
	public static void main(String[] args) {
		final TestExecutorService service = new TestExecutorService();

		try {
			Thread.sleep(4_100L);
			service.getExecutorService().shutdownNow();
			System.out
					.println("Compteur = " + service.getFutureInteger().get());
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}

		/*
		 * Limites : on ne peut pas retourner de résultats Contrairement à une
		 * interface Callable call retourne une instance du type T : Callable<T>
		 */

	}
}
