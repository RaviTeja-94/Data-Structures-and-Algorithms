package unboundedknapsackrelated;

public class CoinChange2 {
	
	public static void main(String[] args) {
		int[] denominations = { 25, 10, 5};
		int value = 30;

		System.out.println(getMinNoOfCoinsTomakevalue(denominations, value));
	}
	
	private static int getMinNoOfCoinsTomakevalue(int[] denominations, int value) {
		int[][] dp = new int[denominations.length + 1][value + 1];

		//min no of coins needed to make given sum with no denominations
		for (int j = 0; j <=value; j++) {
			dp[0][j] = Integer.MAX_VALUE-1;
		}
		
		//min no of coins needed to make sum as 0 with given denominations(no denomination needed so 0)
		for (int i = 0; i <denominations.length; i++) {
			dp[i][0] = 0;
		}

		return getMinNoOfCoinsTomakevalueUtil(denominations, value, dp);

	}

	//unbounded knapsack logic
	private static int getMinNoOfCoinsTomakevalueUtil(int[] denominations, int value, int[][] dp) {

		for (int i = 1; i <= denominations.length; i++) {
			for (int j = 1; j <= value; j++) {
				if (denominations[i - 1] <= j) {
					//+1 indicates one coin has been used
					dp[i][j] = Math.min(1 + dp[i][j-denominations[i-1]], dp[i-1][j]);
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}

		return dp[denominations.length][value];
	}
}
