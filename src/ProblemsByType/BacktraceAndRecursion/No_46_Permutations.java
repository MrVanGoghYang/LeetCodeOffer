package ProblemsByType.BacktraceAndRecursion;

import java.util.*;

/*
思路：回溯，使用可变集合List控制可能选择的数量减少无效比较。
 */
public class No_46_Permutations
{
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        int n = nums.length;
        List<Integer> numList = new ArrayList<>();
        for(int i = 0; i < n; i++)
            numList.add(nums[i]);
        dfs(numList, n, 1, new ArrayList<Integer>());
        return res;
    }

    public void dfs(List<Integer> nums, int n, int dim, List<Integer> curList)
    {
        // System.out.println("dim: " + dim + "  curList: " + curList);
        if(dim > n)
        {
            if(curList.size() == n)
                res.add(new ArrayList<>(curList));
            return;
        }
        for(int i = 0; i < nums.size(); i++)
        {
            int choice = nums.get(i);
            curList.add(choice);
            nums.remove(i);
            dfs(nums, n, dim + 1, curList);
            nums.add(i, choice);
            curList.remove(curList.size() - 1);
        }
    }
}
