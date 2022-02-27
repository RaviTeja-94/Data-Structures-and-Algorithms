package recursion;

import java.util.ArrayList;

public class Subsequences {
    public static void main(String[] args) {
        int[] a = {1,1,2};
        printSubsequnces(a,0,new ArrayList<Integer>());
        System.out.println();
        int sum = 2;
        ArrayList<ArrayList<Integer>> res = printSubsequncesOfGivenSum(0, a,sum,new ArrayList<Integer>(),new ArrayList<ArrayList<Integer>>());
        System.out.println(res.toString());
        System.out.println();
        printOneSubsequnceOfGivenSum(0, a,sum,new ArrayList<Integer>());
        System.out.println();
        int count = countSubsequencesOfGivenSum(0, a,sum);
        System.out.println(count);

    }

    private static int countSubsequencesOfGivenSum(int i, int[] a, int sum) {
        if(i>=a.length) {
            if(sum == 0) {
                return 1;
            }
            return 0;
        }
        int count1 = countSubsequencesOfGivenSum(i+1,a, sum -a [i]);
        int count2 = countSubsequencesOfGivenSum(i+1,a, sum);
        return count1+count2;
    }

    private static boolean printOneSubsequnceOfGivenSum(int i, int[] a, int sum, ArrayList<Integer> curRes) {
        if(i>=a.length) {
            if(sum == 0) {
                System.out.println(curRes.toString());
                return true;
            }
            return false;
        }

        curRes.add(a[i]);
        if(printOneSubsequnceOfGivenSum(i+1,a, sum -a [i],curRes))
            return true;
        curRes.remove(curRes.size()-1);
        if(printOneSubsequnceOfGivenSum(i+1,a,sum,curRes))
            return true;
        return false;
    }

    private static ArrayList<ArrayList<Integer>>  printSubsequncesOfGivenSum(int i, int[] a, int sum, ArrayList<Integer> curRes, ArrayList<ArrayList<Integer>> finalRes) {

        if(i>=a.length) {
            if(sum == 0) {
                finalRes.add(new ArrayList(curRes));
                return finalRes;
            }
            return new ArrayList<ArrayList<Integer>>();
        }

        curRes.add(a[i]);
        printSubsequncesOfGivenSum(i+1,a, sum -a [i],curRes, finalRes);
        curRes.remove(curRes.size()-1);
        printSubsequncesOfGivenSum(i+1,a,sum,curRes,finalRes);
        return finalRes;
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
