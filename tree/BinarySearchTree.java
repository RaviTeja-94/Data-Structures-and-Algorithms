package tree;

import java.util.Stack;

public class BinarySearchTree {

	private class Node {
		int value;
		Node leftChild;
		Node rightChild;

		public Node(int value) {
			this.value = value;
		}

		@Override
		public String toString() {
			return "Node= " + value;
		}
	}

	Node root;

	public void insert(int value) {
		Node node = new Node(value);

		// for empty tree
		if (root == null) {
			root = node;
			return;
		}

		Node current = root;

		while (true) {
			if (value < current.value) {
				if (current.leftChild == null) {
					current.leftChild = node;
					break;
				}
				current = current.leftChild;
			}

			else {
				if (current.rightChild == null) {
					current.rightChild = node;
					break;
				}
				current = current.rightChild;
			}
		}
	}

	public boolean find(int value) {

		Node current = root;

		while (current != null) {
			if (value < current.value) {
				current = current.leftChild;
			} else if (value > current.value) {
				current = current.rightChild;
			} else {
				return true;
			}
		}
		return false;
	}

	public void inOrderTraversal() {
		inOrderTraversal(root);
	}

	private void inOrderTraversal(Node root) {
		if (root == null) {
			return;
		}
		inOrderTraversal(root.leftChild);
		System.out.println(root.value);
		inOrderTraversal(root.rightChild);
	}

	// recursive depth first algorithms
	public void preOrderTraversal() {
		preOrderTraversal(root);
	}

	private void preOrderTraversal(Node root) {
		if (root == null) {
			return;
		}

		System.out.println(root.value);
		preOrderTraversal(root.leftChild);
		preOrderTraversal(root.rightChild);
	}

	public void postOrderTraversal() {
		postOrderTraversal(root);
	}

	private void postOrderTraversal(Node root) {
		if (root == null) {
			return;
		}
		inOrderTraversal(root.leftChild);
		inOrderTraversal(root.rightChild);
		System.out.println(root.value);
	}

	// Tree traversal algorithms without using recursion

	public void preOrderTraversalWithoutRecursion() {
		preOrderTraversalWithoutRecursion(root);
	}

	private void preOrderTraversalWithoutRecursion(Node root) {

		Stack<Node> st = new Stack<Node>();

		st.push(root);

		while (!st.isEmpty()) {

			System.out.println(st.peek().value);

			Node node = st.pop();

			if (node.rightChild != null) {
				st.push(node.rightChild);
			}
			if (node.leftChild != null) {
				st.push(node.leftChild);
			}
		}

	}

	public int findHeight() {
		return findHeight(root);
	}

	//O(n)
	private int findHeight(Node root) {

		if (root == null) {
			return -1;
		}

		if (root.leftChild == null && root.rightChild == null) {
			return 0;
		}

		return 1 + Math.max(findHeight(root.leftChild), findHeight(root.rightChild));

	}

	public int min() {
		return min(root);
	}

	//O(n)
	private int min(Node root) {
		int leftSubtreeValue=Integer.MAX_VALUE;
		int rightSubtreeValue=Integer.MAX_VALUE;
		
		if(root==null) {
			throw new IllegalStateException();
		}

		if (root.leftChild == null && root.rightChild == null) {
			return root.value;
		}
		if (root.leftChild != null)
			leftSubtreeValue = min(root.leftChild);
		if (root.rightChild != null)
			rightSubtreeValue = min(root.rightChild);

		return Math.min(Math.min(leftSubtreeValue, rightSubtreeValue), root.value);

	}

}
