package recursion;

public class BinaryNumberPrint {

	public static void main(String[] args) {
		int n = 5;
		int ones = 0;
		int zeroes = 0;
		StringBuilder output = new StringBuilder("");

		printNDigitBinaryNumbersWithMoreOrEqualOnesInPrefix(n, ones, zeroes, output);

	}

	private static void printNDigitBinaryNumbersWithMoreOrEqualOnesInPrefix(int n, int ones, int zeroes,
			StringBuilder output) {
		if (n == 0) {
			System.out.println(output.toString());
			return;
		}

		StringBuilder output1 = new StringBuilder(output);

		output1.append('1');

		printNDigitBinaryNumbersWithMoreOrEqualOnesInPrefix(n - 1, ones + 1, zeroes, output1);

		if (ones > zeroes) {

			StringBuilder output2 = new StringBuilder(output);

			output2.append('0');

			printNDigitBinaryNumbersWithMoreOrEqualOnesInPrefix(n - 1, ones, zeroes + 1, output2);

		}

		return;

	}
}
