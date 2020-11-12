package binarysearchvariations;

import java.util.Arrays;

public class RowAndColumnWiseSorted {
	public static void main(String[] args) {
		int[][] arr = new int[][] {

				{ 10, 20, 30, 30 }, { 15, 25, 35, 45 }, { 24, 27, 38, 49 } };

		int[] res = findElementInRowAndColumnWiseSortedArray(arr, 27);

		System.out.println(res[0] + " " +res[1]);
	}

	private static int[] findElementInRowAndColumnWiseSortedArray(int[][] arr, int element) {
		int[] res = new int[2];
		Arrays.fill(res, -1);

		int rows = arr.length;
		int columns = arr[0].length;
		int i = 0;
		int j = columns - 1;

		while (i >= 0 && i < rows && j >= 0 && j < columns) {

			if (arr[i][j] == element) {
				res[0] = i;
				res[1] = j;
				break;
			}

			else if (arr[i][j] > element) {
				j--;
			} else {
				i++;
			}
		}

		return res;
	}
}
