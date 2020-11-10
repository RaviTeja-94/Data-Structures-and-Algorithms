package binarysearchvariations;

public class SortedArrayRotations {
	public static void main(String[] args) {
		int[] arr = { 12, 13, 15, 2, 4, 5, 6, 7, 11 };
		int len = arr.length;
		findNoOfRotations(arr, len);
		findElementInSortedArray(arr, len, 7);
	}

	private static void findNoOfRotations(int[] arr, int len) {
		int minElementIndex = getMinimumElementIndexOfRotatedArray(arr);

		/*
		 * calculate rotations based on min element index, if clockwise rotated
		 * rotations = (length of arr + index of min element)%length of arr if
		 * anti-clockwise rotated rotations = index of min element
		 */
		if (minElementIndex != -1) {
			int antiClockWiseRotationsDone = (len - minElementIndex) % len;
			int clockWiseRotationsDone = minElementIndex;

			System.out.println("antiClockWiseRotationsDone" + antiClockWiseRotationsDone);
			System.out.println("clockWiseRotationsDone" + clockWiseRotationsDone);

		}
	}
	
	private static void findElementInSortedArray(int[] arr, int len, int element) {
		int start=0;
		int end =arr.length-1;
		int minElementIndex = getMinimumElementIndexOfRotatedArray(arr);
		
		int indexFoundInLeftOfMin = search(arr, start, minElementIndex-1, element);
		int indexFoundInRightOfMin = search(arr, minElementIndex, end, element);
		
		if(indexFoundInLeftOfMin!=-1) {
			System.out.println(indexFoundInLeftOfMin);
			return;
		}
		else if(indexFoundInRightOfMin!=-1) {
			System.out.println(indexFoundInRightOfMin);
			return;
		}
		else {
			System.out.println("not found");
			return;
		}
	}

	private static int search(int[] arr, int start, int end, int element) {
		int index = -1;

		while (start <= end) {
			int mid = start + (end - start) / 2;

			if (arr[mid] == element) {
				index = mid;
				break;
			} else if (element > arr[mid]) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}

		return index;
	}

	private static int getMinimumElementIndexOfRotatedArray(int[] arr) {
		int start = 0;
		int n = arr.length;
		int end = n - 1;
		int minElementIndex = -1;

		while (start <= end) {
			if (arr[start] <= arr[end]) {
				minElementIndex = start;
				break;
			}
			int mid = start + (end - start) / 2;
			int prev = (mid + n - 1) % n;
			int next = (mid + 1) % n;

			if (arr[mid] <= prev && arr[mid] <= next) {
				minElementIndex = mid;
				break;
			} else if (arr[mid] >= arr[start]) {
				start = mid + 1;
			}

			else if (arr[mid] <= arr[end]) {
				end = mid - 1;
			}
		}

		return minElementIndex;
	}
}
