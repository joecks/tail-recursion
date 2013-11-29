package recursiveVsLoops;

import com.google.caliper.BeforeExperiment;
import com.google.caliper.Benchmark;
import com.google.caliper.Param;

public class TimeTest {

	private static void runOnTime(String name,
			CircularPrinting circularPrinting, String[][] array) {

		long justNow = System.currentTimeMillis();
		circularPrinting.circularPrinting(array);
		System.out.println(String.format("%s: %dmsec", name,
				System.currentTimeMillis() - justNow));

	}

	private String[][] A;

	private FullIterative fullIterative;

	private FullRecursive fullRecursive;

	@Param({ "2000" })
	private int N;

	private PartRecursive partRecursive;

	@Benchmark
	public void runIterative() {
		runOnTime("iterative", fullIterative, A);
	}

	@Benchmark
	public void runPartRecursive() {
		runOnTime("partRecursive", partRecursive, A);
	}

	@Benchmark
	public void runRecursive() {
		runOnTime("recursive", fullRecursive, A);
	}

	@BeforeExperiment
	protected void setUp() {
		fullIterative = new FullIterative() {

			@Override
			protected <T> void print(T elem) {
			}
		};
		fullRecursive = new FullRecursive() {

			@Override
			protected <T> void print(T elem) {
			}
		};

		partRecursive = new PartRecursive() {

			@Override
			protected <T> void print(T elem) {
			}
		};

		A = PartRecursive.generateSquare(N);
	}

}
