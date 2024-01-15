

import java.util.Random;

public class Rand extends Random {

	private static final long serialVersionUID = -6517862755940452386L;
	private double nextDouble = 0.0;
	private double increment = 0.01;
	
	public Rand() {
	}

	public Rand(long seed) {
		super(seed);	
	}

	public Rand(double nextStart, double increment) {
		this.nextDouble = nextStart;
		this.increment = increment;
	}
	
	@Override
	public double nextDouble() {
		nextDouble += increment;
		if(nextDouble == 1.0) {
			nextDouble = 0.0;
		}
		return nextDouble;
	}
	

	public static void main(String[] args) {
	    Random rng = new Random(3);

	    for (int i = 0; i < 10; i++) {
	        double randomNum = rng.nextDouble();
	        System.out.println(randomNum);
	    }
	}
}
