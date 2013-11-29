package recursiveVsLoops;

public abstract class PartRecursive implements CircularPrinting {

	public static String[][] generateSquare(int n) {

		String[][] array = new String[n][];

		for (int i = 0; i < n; i++) {

			array[i] = new String[n];
			for (int j = 0; j < n; j++) {
				array[i][j] = String.format("(%d,%d)", j, i);
			}

		}

		return array;
	}

	public static void main(String[] args) {
		new PartRecursive() {

			@Override
			protected <T> void print(T elem) {
				System.out.print(elem);
			}
		}.circularPrinting(generateSquare(41));
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

	private <T> void printBottomToTop(T[][] array, int index) {
		for (int i = array.length - index - 1; i > index; i--) {
			print(array[i][index]);
		}
	}

	private <T> void printCircle(T[][] array, int index) {

		if (index < array.length / 2) {

			printLeftToRight(array, index);
			printTopToBottom(array, index);
			printRightToLeft(array, index);
			printBottomToTop(array, index);
			printCircle(array, index + 1);

		}

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
