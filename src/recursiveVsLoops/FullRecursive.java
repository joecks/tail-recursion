package recursiveVsLoops;

public abstract class FullRecursive implements CircularPrinting {

	public static void main(String[] args) {
		new FullRecursive() {

			@Override
			protected <T> void print(T elem) {
				System.out.print(elem);
			}
		}.circularPrinting(PartRecursive.generateSquare(101));
	}

	/**
	 * Prints contents of an array in a circular fashion towards the center. The
	 * array must be of dimension A[n][n]
	 * 
	 * @param array
	 */
	@Override
	public <T> void circularPrinting(T[][] array) {
		assert (array != null);
		printCircle(array, 0);
	}

	protected abstract <T> void print(T elem);

	private <T> void printCircle(T[][] array, int index) {

		if (index < array.length / 2) {
			int lowerBound = index;
			int upperBound = array.length - lowerBound - 1;

			printHorizontal(array, lowerBound, lowerBound, upperBound, true);
			printVertical(array, upperBound, lowerBound, upperBound, true);
			printHorizontal(array, upperBound, upperBound, lowerBound, false);
			printVertical(array, lowerBound, upperBound, lowerBound, false);
			printCircle(array, index + 1);

		} else if (array.length % 2 != 0 && index == (array.length / 2)) {
			print(array[index][index]);
		}

	}

	private <T> void printHorizontal(T[][] array, int fixed, int start,
			int end, boolean accending) {
		if ((accending && start >= end) || (!accending && start <= end)) {
			return;
		}
		print(array[fixed][start]);
		printHorizontal(array, fixed, accending ? start + 1 : start - 1, end,
				accending);
	}

	private <T> void printVertical(T[][] array, int fixed, int start, int end,
			boolean accending) {
		if ((accending && start >= end) || (!accending && start <= end)) {
			return;
		}
		print(array[start][fixed]);
		printVertical(array, fixed, accending ? start + 1 : start - 1, end,
				accending);
	}
}
