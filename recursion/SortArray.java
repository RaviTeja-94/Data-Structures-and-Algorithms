package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortArray {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		
		list.add(1);
		list.add(3);
		list.add(2);
		list.add(6);
		list.add(2);
		sort(list);
		System.out.println(list.toString());
	}

	private static void sort(List<Integer> list) {
		int last = list.size() - 1;
		if (list.isEmpty()) {
			return;
		}

		Integer temp = list.remove(last);

		sort(list);

		insert(list, temp);

		return;
	}

	private static void insert(List<Integer> list, Integer temp) {
		int last= list.size() - 1;
		if (list.isEmpty() || list.get(list.size() - 1) <= temp) {
			list.add(temp);
			return;
		}

		Integer  temp2 = list.remove(last);

		insert(list, temp);

		list.add(temp2);

		return;

	}
}
