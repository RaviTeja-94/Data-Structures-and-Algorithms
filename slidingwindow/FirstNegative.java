package slidingwindow;

import java.util.ArrayDeque;

public class FirstNegative {

	public static void main(String[] args) {
		int[] arr = {12 ,-1, -7, 8 ,-15 ,30, 16, 28};
		int windowSize = 3;
		printFirstNegativeOfAWindowSize(arr, windowSize);

	}

	private static void printFirstNegativeOfAWindowSize(int[] arr, int windowSize) {

		int i = 0;
		int j = 0;
		int len = arr.length;
		ArrayDeque<Integer> deque = new ArrayDeque<Integer>();
		
		while (j < len) {
			//this if is our core logic to get the answer later
			if(arr[j]<0) {
				deque.addLast(arr[j]);
			}
			
			if(j-i+1<windowSize) {
				j++;
			}
			
			else if(j-i+1==windowSize) {
				//reached window size get the answer from above computation
				if(deque.size()>0) {
					System.out.println(deque.getFirst());
				}
				else {
					System.out.println(0);
				}
				
				//slide the window but remove previously done computation for ith element
				if(deque.size()>0 && arr[i]==deque.getFirst()) {
					deque.removeFirst();
				}
				i++;
				j++;
			}
		}
	}
}
