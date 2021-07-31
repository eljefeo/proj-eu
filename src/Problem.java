
public interface Problem {
	
	public default String runProblem() {
		long startT = System.nanoTime();
		String answer = problem();
		long endT = System.nanoTime();
		double time = (double) (endT - startT) / 1000000000;
		System.out.printf("Took %f seconds\n", time);
		System.out.printf("Answer : %s", answer);
		return answer;
	}
	
	public String problem();

}
