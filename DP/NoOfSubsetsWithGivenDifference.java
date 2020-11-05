
public class NoOfSubsetsWithGivenDifference {
	
	/*
	 * sum an be calculated from given arr, after that we need to find S1's sum and S2's sum
	 * let S1's sum= S1, the S2's sum will be= sum-S1
	 * we need S1-S2=diff, then S1-(sum-S1) = diff
	 * S1= (diff+Sum)/2
	 * therefore, if we can find no of subsets with above sum S1, that will be our answer
	 */

	public static int countNoOfSubsetsWithGivenDiff(int[] arr, int diff) {
		int sum=0;
		int n=arr.length;
		for(int i=0;i<n;i++) {
			sum+=arr[i];
		}
		int s1= (diff+sum)/2;
		
		int[][] dp = new int[n+1][s1+1];
		
		//if sum is 0 then we can use an empty set to represent it, so 1
		for(int i=0;i<=n;i++) {
			dp[i][0]=1;
		}
		
		//if sum is not zero but the items are empty then we cant find any subset for given sum, hence 0
		for(int i=1;i<=s1;i++) {
			dp[0][i]=0;
		}
		
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=s1;j++) {
				
				if(arr[i-1]>j) {
					dp[i][j]= dp[i-1][j];
				}
				
				else if(arr[i-1]<=j) {
					dp[i][j] = dp[i-1][j] + dp[i-1][j-arr[i-1]];
				}
			}
		}
		
		return dp[n][s1];
	}
	
	public static void main(String[] args) {
		int[] arr= {3,1,2,3};
		int diff=3;
		
		System.out.println(countNoOfSubsetsWithGivenDiff(arr, diff));
	}
	
}
