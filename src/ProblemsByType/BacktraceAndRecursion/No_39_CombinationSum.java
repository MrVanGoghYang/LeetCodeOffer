package ProblemsByType.BacktraceAndRecursion;

import java.util.*;

public class No_39_CombinationSum
{
    /*
    思路一： 递归回溯，每次有n种选择，选一种满足条件的往下，改变target与curRes，当target为0时将子结果加入总结果Set中，加入之前对子结果使用排序+结果Set进行去重。
     */
    // List<List<Integer>> res;
    // Set<List<Integer>> set = new HashSet<>();
    // public List<List<Integer>> combinationSum(int[] candidates, int target) {
    //     Arrays.sort(candidates);
    //     dfs(candidates, target, new ArrayList<Integer>());
    //     res = new ArrayList<>(set);
    //     return res;
    // }

    // public void dfs(int[] candidates, int target, List<Integer> subRes)
    // {
    //     // System.out.println("target: " + target + "  " + subRes + "  " + set);
    //     if(target <= 0)
    //     {
    //         if(target == 0)
    //         {
    //             List<Integer> itemList = new ArrayList(subRes);
    //             Collections.sort(itemList);
    //             if(!set.contains(itemList))
    //                 set.add(new ArrayList<>(itemList));
    //         }
    //         return;
    //     }

    //     for(int i = 0; i < candidates.length; i++)
    //     {
    //         if(target - candidates[i] >= 0)
    //         {
    //             subRes.add(candidates[i]);
    //             dfs(candidates, target - candidates[i], subRes);
    //             subRes.remove(subRes.size() - 1);
    //         }
    //         else
    //             break;
    //     }

    // }

    /*
    思路二： 基于以上的基本递归+回溯思想，考虑在搜索过程中就按照顺序搜索，不搜索重复的情况，这样的话就不需要对子结果排序+使用Set去重，更重要的是可以减少很多重复结果的分支。
    实现：在每次选择了第i个之后往下递归的时候，只需要从第i个开始再选就可以，不需要从0再开始。
    比如父递归选了第2个数之后，往下的后续子递归的选择都是从第2个数开始，不会从第1个开始。因为开始选了第1个数的所有分支已经包含了答案中出现candidates[0]即第一个数字的所有所有情况，我们后续搜索过程如果出现了第一个数字，那么所得到的答案一定已经在之前计算过。
     */
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(candidates, target, 0, new ArrayList<Integer>());
        return res;
    }

    public void dfs(int[] candidates, int target, int begin, List<Integer> subRes)
    {
        if(target <= 0)
        {
            if(target == 0)
                res.add(new ArrayList<>(subRes));
            return;
        }

        for(int i = begin; i < candidates.length; i++)
        {
            if(target - candidates[i] >= 0)
            {
                subRes.add(candidates[i]);
                dfs(candidates, target - candidates[i], i,subRes);
                subRes.remove(subRes.size() - 1);
            }
            else
                break;
        }

    }
}
