package recursion;

import java.util.ArrayList;

public class Subsequences {
    public static void main(String[] args) {
        int[] a = {4,1,3};
        printSubsequnces(a,0,new ArrayList<Integer>());
    }

    //every element has two choices, either to be inlcuded in resultant arr
    // or excluded from resultant arr
    //t:O(2^n)
    //space:O(2^n), for resultant array
    private static void printSubsequnces(int[] a, int curIndex, ArrayList<Integer> result) {
        if(curIndex>=a.length) {
            System.out.println(result.toString());
            return;
        }
        result.add(a[curIndex]); //include
        printSubsequnces(a,curIndex+1,result);
        result.remove(result.size()-1); //exclude
        printSubsequnces(a,curIndex+1,result);
    }

}
