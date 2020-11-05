
public class MissingAndDuplicate1ToN {
	public static void main(String[] args) {
		int[] input = { 1,3,4,4,5,6,7};

		findMissingAndDuplicateNumberFrom1toN(input);
	}

	/*
	 * This can be solved in three ways 
	 * 1.Use hashMap with extra space complexity of O(n) 
	 * 2.Use Math to do it in O(n) time and O(1) space, but difficult to find more than one missing numbers 
	 * and duplicates
	 *  3.Use swap sort(only when you are allowed to modify input array),time:O(n), sapce:O(1) 
	 *  swap sort algo:
	 * -->modify the array in such a way that the elements are at their index+1 positions
	 *  -->find missing and duplicate numbers on above modified array in one pass
	 */
	private static void findMissingAndDuplicateNumberFrom1toN(int[] input) {
		int len = input.length;
		int i = 0;

		while (i < len) {
			//if its already in correct place
			if (input[i] == i + 1) {
				i++;
				continue;
			} else if (input[i] == input[input[i] - 1]) { //if the elment to be swapped with are same
				i++;
				continue;
			} else {
				int temp = input[i];
				input[i] = input[input[i] - 1];
				input[temp - 1] = temp;
			}
		}

		for (i = 0; i < len; i++) {
			if (input[i] != i + 1) {
				System.out.println("Missing number : " + (i + 1));
				System.out.println("Duplicate number : " + input[i]);
			}
		}

	}
}
