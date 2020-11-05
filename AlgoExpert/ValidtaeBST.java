class Program {
  public static boolean validateBst(BST tree) {
    // Write your code here.
		return isBinaryTreeBST(tree,Integer.MIN_VALUE,Integer.MAX_VALUE);
		
  }
	public static boolean isBinaryTreeBST(BST node,int min,int max) {
		if(node ==null) {
			return true;
		}
		if(node.value<min || node.value>=max) {
			return false;
		}
		
		return isBinaryTreeBST(node.left,min,node.value) && isBinaryTreeBST(node.right,node.value,max);
		
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
