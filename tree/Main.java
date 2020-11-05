package tree;

public class Main {

	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		bst.insert(7);
		bst.insert(5);
		bst.insert(4);
		bst.insert(6);
		bst.insert(8);
		bst.insert(10);
		bst.insert(9);
		System.out.println(bst.min());
		
	}
}
