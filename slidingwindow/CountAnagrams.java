package slidingwindow;

import java.util.HashMap;

public class CountAnagrams {

	public static void main(String[] args) {
		String input = "aabaabaa";
		String pattern = "aaba";

		countNoOfAnagrams(input, pattern);

	}

	private static void countNoOfAnagrams(String input, String pattern) {
		int len = input.length();
		int windowSize = pattern.length();
		int noOfAnagrams = 0;
		HashMap<Character, Integer> characterCounts = new HashMap<Character, Integer>();

		for (int i = 0; i < pattern.length(); i++) {
			if (characterCounts.containsKey(pattern.charAt(i))) {
				characterCounts.put(pattern.charAt(i), characterCounts.get(pattern.charAt(i)) + 1);
			} else {
				characterCounts.put(pattern.charAt(i), 1);
			}
		}

		int countOfUniqueCharacters = characterCounts.size();

		int i = 0;
		int j = 0;

		while (j < len) {
			// computation required
			if (characterCounts.containsKey(input.charAt(j))) {
				characterCounts.put(input.charAt(j), characterCounts.get(input.charAt(j)) - 1);
				if (characterCounts.get(input.charAt(j)) == 0) {
					countOfUniqueCharacters--;
				}
			}

			if (j - i + 1 < windowSize) {
				j++;
			} else if (j - i + 1 == windowSize) {

				if (countOfUniqueCharacters == 0) {
					noOfAnagrams++;
				}

				// removing this already done computation for i as we move the window
				if (characterCounts.containsKey(input.charAt(i))) {
					characterCounts.put(input.charAt(i), characterCounts.get(input.charAt(i)) + 1);
					if (characterCounts.get(input.charAt(i)) == 1) {
						countOfUniqueCharacters++;
					}
				}
				
				//slide the window
				i++;
				j++;

			}

		}

		System.out.println(noOfAnagrams);
	}
}
