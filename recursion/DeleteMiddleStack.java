package recursion;

import java.util.Stack;

public class DeleteMiddleStack {

	public static void main(String[] args) {

		Stack<Integer> st = new Stack<Integer>();

		st.push(1);
		st.push(2);
		st.push(3);
		st.push(7);
		st.push(4);
		st.push(5);

		deleteMiddleElementFromStack(st);
		System.out.println(st.toString());

	}

	private static void deleteMiddleElementFromStack(Stack<Integer> st) {
		
		//find middle for even and odd number of elements
		
		if(st.isEmpty()) {
			return;
		}
		
		int  middle = st.size()/2 +1;
		
		deleteMiddleElementFromStackUtil(st, middle);

	}

	private static void deleteMiddleElementFromStackUtil(Stack<Integer> st, int middle) {
		
		if(middle==1) {
			st.pop();
			return;
		}
		
		Integer topElement = st.pop();
		
		deleteMiddleElementFromStackUtil(st, middle-1);
		
		st.push(topElement);
		return;
	}
}
