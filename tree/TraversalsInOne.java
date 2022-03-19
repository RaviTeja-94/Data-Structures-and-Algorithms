package tree;

import java.util.*;

public class TraversalsInOne {
    class BinaryTreeNode<T> {
        T data;
        BinaryTreeNode<T> left;
        BinaryTreeNode<T> right;

        public BinaryTreeNode(T data) {
            this.data = data;
        }
    }

    public static class Pair {
        BinaryTreeNode node;
        int num;

        Pair(BinaryTreeNode node, int num) {
            this.node = node;
            this.num = num;
        }
    }
    public static List<List<Integer>> getTreeTraversal(BinaryTreeNode<Integer> root) {
        // Write your code here.
        Stack<Pair> st = new Stack<>();
        List<List<Integer>> res= new ArrayList<>();
        List<Integer> preOrder = new ArrayList<>();
        List<Integer> inOrder = new ArrayList<>();
        List<Integer> postOrder = new ArrayList<>();
        if(root == null) {
            return res;
        }

        st.push(new Pair(root, 1));

        while(!st.isEmpty()) {
            Pair pair = st.pop();

            if(pair.num==1) {
                preOrder.add((Integer)(pair.node.data));
                pair.num++;
                st.push(pair);

                if(pair.node.left != null) {
                    st.push(new Pair(pair.node.left, 1));
                }
            }
            if(pair.num==2) {
                inOrder.add((Integer)(pair.node.data));
                pair.num++;
                st.push(pair);

                if(pair.node.right != null) {
                    st.push(new Pair(pair.node.right, 1));
                }
            }

            else {
                postOrder.add((Integer)(pair.node.data));
            }
        }

        res.add(inOrder);
        res.add(preOrder);
        res.add(postOrder);

        return res;
    }
}

