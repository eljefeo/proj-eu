
public interface Problem {
	
	public default void runProblem() {
		long startT = System.nanoTime();
		problem();
		long endT = System.nanoTime();
		double time = (double) (endT - startT) / 1000000000;
		System.out.printf("\nTook %f seconds\n", time);
	}
	
	public void problem();

}
