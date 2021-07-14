
public interface Problem {
	
	public default void runProblem() {
		long startT = System.nanoTime();
		 
		problem();
		
		long endT = System.nanoTime();

		double time = (double) (endT - startT) / 1000000000;
		
		
		//System.out.printf("dexp: %f\n", dexp);
		System.out.printf("Took %f seconds", time);
	}
	
	public void problem();

}
