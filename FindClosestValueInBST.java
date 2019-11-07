import java.util.*;
class Program {
  public static int findClosestValueInBst(BST tree, int target) {
    // Write your code here.
		int smallestDiff=Integer.MAX_VALUE;
		int currentDiff=0;
			int res=0;
		while(tree!=null)
		{
			currentDiff=tree.value>target?tree.value-target:target-tree.value;
			if(currentDiff<smallestDiff){
				smallestDiff=currentDiff;
				res=tree.value;
			}
			if(target<tree.value){
				tree=tree.left;
			}
			else if(target>tree.value){
				tree=tree.right;
			}
			else {
				return tree.value;
			}
		}
		return res;
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
