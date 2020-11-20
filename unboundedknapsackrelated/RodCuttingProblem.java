package unboundedknapsackrelated;

import java.util.Arrays;

public class RodCuttingProblem {

	private static int getMaxValueByCuttingRod(int[] profits, int[] lengths, int maxLen, int[][] dp, int noOfItems) {

		if (maxLen == 0 || noOfItems == 0) {
			return 0;
		}

		if (dp[noOfItems][maxLen] != -1) {
			return dp[noOfItems][maxLen];
		}

		else if (lengths[noOfItems - 1] <= maxLen) {
			dp[noOfItems][maxLen] = Math.max(
					profits[noOfItems - 1]
							+ getMaxValueByCuttingRod(profits, lengths, maxLen - lengths[noOfItems - 1], dp, noOfItems),
					getMaxValueByCuttingRod(profits, lengths, maxLen, dp, noOfItems - 1));
			// return dp[noOfItems][maxLen];
		} else {
			dp[noOfItems][maxLen] = getMaxValueByCuttingRod(profits, lengths, maxLen, dp, noOfItems - 1);
			// return dp[noOfItems][maxLen];
		}
		return dp[noOfItems][maxLen];
	}

	public static void main(String[] args) {
		int[] profits = { 1,7,10,1,5,19 };
		int maxLength = 6;

		int[] lengths = new int[maxLength];
		for (int i = 0; i < maxLength; i++) {
			lengths[i] = i + 1;
		}

		int[][] dp = new int[lengths.length + 1][maxLength + 1];

		for (int[] row : dp) {
			Arrays.fill(row, -1);
		}
		
		for(int j=0;j<dp[0].length;j++) {
			dp[0][j] = 0;
		}
		
		for(int i=0;i<dp.length;i++) {
			dp[i][0] = 0;
		}
		System.out.println("lengths:" + Arrays.toString(lengths));
		System.out.println("profits:" + Arrays.toString(profits));
		for (int[] row : dp) {
			System.out.println("dp:" + Arrays.toString(row));
		}

		System.out.println(getMaxValueByCuttingRod(profits, lengths, maxLength, dp, maxLength));
		
		for (int[] row : dp) {
			System.out.println("dp:" + Arrays.toString(row));
		}
	}
}
