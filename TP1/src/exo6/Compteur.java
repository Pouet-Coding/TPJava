package exo6;

public class Compteur {

	private long l;
	
	public Compteur() {
		this.l = 0;
	}
	
	public synchronized void next() {
		this.l++;
	}
	
	public synchronized long getL() {
		return this.l;
	}
}
