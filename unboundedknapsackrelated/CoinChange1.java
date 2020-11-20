package unboundedknapsackrelated;

public class CoinChange1 {
	public static void main(String[] args) {
		int[] denominations = { 1, 2, 3};
		int value = 4;

		System.out.println(findNoOfWaysToMakeValue(denominations, value));
	}

	private static int findNoOfWaysToMakeValue(int[] denominations, int value) {
		int[][] dp = new int[denominations.length + 1][value + 1];

		//no of ways to with no denominations with given sum(0 ways)
		for (int j = 0; j < dp[0].length; j++) {
			dp[0][j] = 0;
		}
		
		//no of ways to make value 0 with any number of coins(no coins were needed so 1 way)
		for (int i = 0; i < dp.length; i++) {
			dp[i][0] = 1;
		}

		return findNoOfWaysToMakeValueUtil(denominations, value, dp);

	}

	//unbounded knapsack logic
	private static int findNoOfWaysToMakeValueUtil(int[] denominations, int value, int[][] dp) {

		for (int i = 1; i <= denominations.length; i++) {
			for (int j = 1; j <= value; j++) {
				if (denominations[i - 1] <= j) {
					dp[i][j] = dp[i][j - denominations[i - 1]] + dp[i - 1][j];
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}

		return dp[denominations.length][value];
	}
}
