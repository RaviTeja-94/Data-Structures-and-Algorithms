package longestcommonsubsequencevariations;

import java.util.Arrays;

public class LongestCommonSubsequence {

	public static void main(String[] args) {
		String str1 = "abcdef";
		String str2 = "aabrdfk";

		// using recursive
		System.out.println(findTheLengthOfLongestCommonSubsequenceUsingRecursion(str1, str2, str1.length(), str2.length()));

		// using top down or memoization
		System.out.println(findTheLengthOfLongestCommonSubsequenceUsingMemo(str1, str2, str1.length(), str2.length()));

		// using bottom up or iterativeDP
		System.out.println(findTheLengthOfLongestCommonSubsequenceUsingTabulation(str1, str2, str1.length(), str2.length()));

	}

	// recursive 2^length of longest string
	private static int findTheLengthOfLongestCommonSubsequenceUsingRecursion(String str1, String str2, int str1Len,
			int str2Len) {

		if (str1Len == 0 || str2Len == 0) {
			return 0;
		}

		if (str1.charAt(str1Len - 1) == str2.charAt(str2Len - 1)) {
			return 1 + findTheLengthOfLongestCommonSubsequenceUsingRecursion(str1, str2, str1Len - 1, str2Len - 1);
		}

		else {
			return Math.max(findTheLengthOfLongestCommonSubsequenceUsingRecursion(str1, str2, str1Len - 1, str2Len),
					findTheLengthOfLongestCommonSubsequenceUsingRecursion(str1, str2, str1Len, str2Len - 1));
		}
	}

	// Using memoization : O(str1Len)(str2Len) time and space: O(str1Len)(str2Len) +
	// call stack space
	private static int findTheLengthOfLongestCommonSubsequenceUsingMemo(String str1, String str2, int length,
			int length2) {

		int[][] dp = new int[str1.length() + 1][str2.length() + 1];

		for (int[] row : dp) {
			Arrays.fill(row, -1);
		}

		return findTheLengthOfLongestCommonSubsequenceUsingMemoUtil(str1, str2, str1.length(), str2.length(), dp);

	}

	private static int findTheLengthOfLongestCommonSubsequenceUsingMemoUtil(String str1, String str2, int str1Len,
			int str2Len, int[][] dp) {

		if (str1Len == 0 || str2Len == 0) {
			return 0;
		}

		if (dp[str1Len][str2Len] != -1) {
			return dp[str1Len][str2Len];
		}

		if (str1.charAt(str1Len - 1) == str2.charAt(str2Len - 1)) {
			dp[str1Len][str2Len] = 1
					+ findTheLengthOfLongestCommonSubsequenceUsingRecursion(str1, str2, str1Len - 1, str2Len - 1);
		}

		else {
			dp[str1Len][str2Len] = Math.max(
					findTheLengthOfLongestCommonSubsequenceUsingRecursion(str1, str2, str1Len - 1, str2Len),
					findTheLengthOfLongestCommonSubsequenceUsingRecursion(str1, str2, str1Len, str2Len - 1));
		}

		return dp[str1Len][str2Len];
	}

	// using iterative dp: O(str1len*str2len) time and space
	private static int findTheLengthOfLongestCommonSubsequenceUsingTabulation(String str1, String str2, int length,
			int length2) {

		int[][] dp = new int[str1.length() + 1][str2.length() + 1];

		return findTheLengthOfLongestCommonSubsequenceUsingTabulationUtil(str1, str2, str1.length(), str2.length(), dp);

	}

	private static int findTheLengthOfLongestCommonSubsequenceUsingTabulationUtil(String str1, String str2, int str1Len,
			int str2Len, int[][] dp) {

		for (int i = 0; i <= str1Len; i++) {
			for (int j = 0; j <= str2Len; j++) {
				if (i == 0 || j == 0) {
					dp[i][j] = 0;
				}

				else if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
					dp[i][j] = 1 + dp[i - 1][j - 1];
				} else {
					dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
				}
			}
		}

		return dp[str1Len][str2Len];
	}

}
