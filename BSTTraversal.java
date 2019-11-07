import java.util.ArrayList;

class Program {
  public static ArrayList<Integer> inOrderTraverse(BST tree, ArrayList<Integer> array) {
    // Write your code here.
		if(tree!=null)
		{
			
		inOrderTraverse(tree.left,array);
		array.add(tree.value);
		inOrderTraverse(tree.right,array);
		}
		return array;
		
  }

  public static ArrayList<Integer> preOrderTraverse(BST tree, ArrayList<Integer> array) {
    // Write your code here.
		if(tree!=null)
		{
			array.add(tree.value);
		preOrderTraverse(tree.left,array);
		
		preOrderTraverse(tree.right,array);
		}
		return array;
	}

  public static ArrayList<Integer> postOrderTraverse(BST tree, ArrayList<Integer> array) {
    // Write your code here.
			if(tree!=null)
		{
			
		postOrderTraverse(tree.left,array);
		
		postOrderTraverse(tree.right,array);
				array.add(tree.value);
		}
		return array;
  }

  static class BST {
    public int value;
    public BST left;
    public BST right;

    public BST(int value) {
      this.value = value;
    }
  }
}
