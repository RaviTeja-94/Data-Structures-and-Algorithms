package binarysearchvariations;

public class InfinitSortedArray {
	public static void main(String[] args) {
		int[] arr = new int[] { 3, 5, 7, 9, 10, 90, 100, 130, 140, 160, 170 };
		int position = findPosition(arr, 160);

		if (position != -1) {
			System.out.println("index: " + position);
		} else {
			System.out.println("no such element found");
		}
	}

	/*
	 * idea is to have low=0 and high=1(since arr is infinite and we dont have
	 * proper upper bound) , and if the element to search for is greater than
	 * current high we can make : low=high and high=high*2 then continue above
	 * process until we find proper bounds
	 */
	private static int findPosition(int[] arr, int element) {
		int low = 0;
		int high = 1;

		while (element > arr[high]) {
			low = high;
			if (high * 2 < arr.length) {
				high = high * 2;
			} else {
				high = arr.length - 1;
			}
		}

		return doBinarySearch(arr, low, high, element);
	}

	private static int doBinarySearch(int[] arr, int low, int high, int element) {

		while (low <= high) {
			int mid = low + (high - low) / 2;

			if (arr[mid] == element) {
				return mid;
			} else if (arr[mid] < element) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return -1;
	}
}
