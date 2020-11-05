package recursion;

public class BalancedParanthesis {
	static int count=0;
	public static void main(String[] args) {
		int n = 2;
		int open = n;
		int close = n;

		generateAllBalancedParenthesis(n, open, close);
	}

	private static void generateAllBalancedParenthesis(int n, int open, int close) {
		if (n == 1) {
			System.out.println("()");
			return;
		}
		String output ="(";
		generateAllBalancedParenthesisUtil(open - 1, close, output);
		System.out.println("count: " + count);
	}

	private static void generateAllBalancedParenthesisUtil(int open, int close, String output) {

		if (open == 0 && close == 0) {
			count++;
			System.out.println(output);
			return;
		}
		if (open != 0) {
			generateAllBalancedParenthesisUtil(open - 1, close, output+'(');
		}

		if (open < close) {
			generateAllBalancedParenthesisUtil(open, close - 1, output+')');
		}

		return;

	}
}
