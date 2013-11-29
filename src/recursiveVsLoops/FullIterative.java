package recursiveVsLoops;

public abstract class FullIterative implements CircularPrinting {

	public static void main(String[] args) {

		new FullIterative() {

			@Override
			protected <T> void print(T elem) {
				System.out.print(elem);
			}

		}.circularPrinting(PartRecursive.generateSquare(41));

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
		for (int i = 0; i < array.length / 2; i++) {
			printCircle(array, i);
		}

		if (array.length % 2 != 0) {
			print(array[array.length / 2][array.length / 2]);
		}
	}

	protected abstract <T> void print(T elem);

	private <T> void printBottomToTop(T[][] array, int index) {
		for (int i = array.length - index - 1; i > index; i--) {
			print(array[i][index]);
		}
	}

	private <T> void printCircle(T[][] array, int index) {

		printLeftToRight(array, index);
		printTopToBottom(array, index);
		printRightToLeft(array, index);
		printBottomToTop(array, index);

	}

	private <T> void printLeftToRight(T[][] array, int index) {
		for (int i = index; i < array.length - index - 1; i++) {
			print(array[index][i]);
		}
	}

	private <T> void printRightToLeft(T[][] array, int index) {
		for (int i = array.length - index - 1; i > index; i--) {
			print(array[array.length - index - 1][i]);
		}
	}

	private <T> void printTopToBottom(T[][] array, int index) {
		for (int i = index; i < array.length - 1 - index; i++) {
			print(array[i][array.length - index - 1]);
		}
	}

}
