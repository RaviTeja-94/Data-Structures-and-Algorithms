package binarysearchvariations;

public class PeakElement {
	public static void main(String[] args) {
		int[] arr = { 1,3,8,9,10,11,12,4,2};
		System.out.println(findPeak(arr));
	}

	private static int findPeak(int[] arr) {
		int start = 0;
		int end = arr.length - 1;
		int peak = -1;
		if (arr.length == 1 || arr[0] > arr[1]) {
			return 0;
		}
		if (arr[end] > arr[end - 1]) {
			return end;
		} else {

			while (start <= end) {
				int mid = start + (end - start) / 2;
				
				if ((mid!=0 && arr[mid] > arr[mid - 1]) && (mid!=arr.length && arr[mid] > arr[mid + 1])) {
					peak=mid;
					break;
				}
				
				if (arr[mid] < arr[mid + 1]) {
					start = mid + 1;
				}

				else {
					end = mid - 1;
				}
			}
		}
		return peak;

	}
}
