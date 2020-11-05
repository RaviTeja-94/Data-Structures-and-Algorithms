package recursion;

import java.util.Stack;

public class StackReverse {

	
	public static void main(String[] args) {
		Stack<Integer> st= new Stack<Integer>();
		st.push(1);
		st.push(2);
		st.push(3);
		st.push(7);
		st.push(4);
		st.push(5);

		System.out.println(st.toString());
		reverseAStack(st);
		
		System.out.println(st.toString());

	}

	private static void reverseAStack(Stack<Integer> st) {
		if(st.isEmpty() || st.size()==1) {
			return;
		}
		
		Integer topValue = st.pop();
		reverseAStack(st);
		
		popAllElementsAndInsert(st,topValue);
		return;
	}

	private static void popAllElementsAndInsert(Stack<Integer> st, Integer topValue) {
		if(st.isEmpty()) {
			st.push(topValue);
			return;
		}
		
		Integer topValueNew = st.pop();
		
		popAllElementsAndInsert(st, topValue);
		
		st.push(topValueNew);
		
		return;
	}
}
