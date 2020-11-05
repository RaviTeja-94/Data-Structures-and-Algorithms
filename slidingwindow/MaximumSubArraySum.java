package slidingwindow;

public class MaximumSubArraySum {

	/*
	 * brute force: O(n^2)
	 * slidig window: O(n)
	 */
	public static int findMaximumSubArraySum(int[] arr, int windowSize) {
		int i=0; //denotes start of sliding window
		int j=0; //denotes end of sliding window
		int sum=0; //to maintain sum of the window
		int max= Integer.MIN_VALUE; // maintain the maximum
		int len= arr.length;
		while(j< len) {
			sum=sum+arr[j];
			
			if(j-i+1==windowSize) {
				max=Math.max(max,  sum);
				sum-=arr[i];
				i++;
				j++;
			}
			
			else {
				j++;
			}
		}
		
		return max;
	}
	
	public static void main(String[] args) {
		int[] arr = {1,2,3,3,4,100,1,2,3,200,-10101,-10000,3,4,5000,6,6};
		int windowSize=3;
		
		System.out.println(findMaximumSubArraySum(arr, windowSize));
		
	}
}
