package recursion;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumI {

    //time:O(2^t * k) where t is the target, k is the average length of comb
    //space:O(k*x), k is the average length of comb and x is the no. of combinations
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        combinationSumUtil(0,candidates, target, new ArrayList<Integer>(), res);
        return res;
    }

    public void combinationSumUtil(int index, int[] candidates, int target, ArrayList<Integer> curRes, List<List<Integer>> finalRes) {

        if(index>=candidates.length) {
            if(target==0){
                finalRes.add(new ArrayList<Integer>(curRes));
            }
            return;
        }


        if(candidates[index]<=target) {
            curRes.add(candidates[index]);
            combinationSumUtil(index,candidates, target-candidates[index], curRes, finalRes);
            curRes.remove(curRes.size()-1);
        }

        combinationSumUtil(index+1,candidates, target, curRes, finalRes);
    }
}
