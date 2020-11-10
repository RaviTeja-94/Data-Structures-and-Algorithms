package binarysearchvariations;

public class FristAndLastAndCountInSortedArray {
	public static void main(String[] args) {
		int[] arr = { 4,4,4,5,6,7};
		int count=0;

		int firstOccurance = getFirstOccurance(arr, 4);
		System.out.println(firstOccurance);

		int lastOccurance = getLastOccurance(arr, 4);
		System.out.println(lastOccurance);

		// finding the count of given element
		if(arr.length!=0) {
			count = lastOccurance - firstOccurance + 1;
		}
		
		System.out.println(count);
	}

	private static int getLastOccurance(int[] arr, int element) {
		int start = 0;
		int end = arr.length - 1;
		int lastOcc = -1;

		while (start <= end) {
			int mid = start + ((end - start) / 2);

			if (arr[mid] == element) {
				lastOcc = mid;
				start = mid + 1;
			} else if (element > arr[mid]) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}

		return lastOcc;
	}

	private static int getFirstOccurance(int[] arr, int element) {
		int start = 0;
		int end = arr.length - 1;
		int firstOcc = -1;

		while (start <= end) {
			int mid = start + (end - start) / 2;

			if (arr[mid] == element) {
				firstOcc = mid;
				end = mid - 1;
			} else if (element > arr[mid]) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}

		return firstOcc;
	}
}
