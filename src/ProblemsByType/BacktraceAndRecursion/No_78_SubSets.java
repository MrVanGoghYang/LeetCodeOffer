package ProblemsByType.BacktraceAndRecursion;

import java.util.*;

public class No_78_SubSets
{
    /*
    思路一：递归写法，真子集计算方式: nums[unionNumIndex] ∪ 剩余元素的真子集中的每个结果 ∪ nums[unionNumIndex]合入剩余元素的真子集中的每个结果，那么就每次选择剩余元素的第1个做nums[unionNumIndex]，与其余剩下元素的真子集做并集。
    */
//    public List<List<Integer>> subsets(int[] nums) {
//        List<List<Integer>> res = new ArrayList<>();
//        res.add(new ArrayList<Integer>());
//        dfs(nums, 0, res);
//        return res;
//    }
//
//    public void dfs(int[] nums, int unionNumIndex, List<List<Integer>> curRes)
//    {
//        // 初始处理
//        List<Integer> singleList = new ArrayList<>();
//        singleList.add(nums[unionNumIndex]);
//        curRes.add(singleList);
//        // 递归退出条件，在处理后判断，当 = nums.length - 1时退出，这样写比在处理前判断当 = nums.lenth退出的写法少一层无效递归，效率更高。
//        if(unionNumIndex == (nums.length - 1))
//            return;
//        //下一层递归
//        List<List<Integer>> subRes = new ArrayList<>();
//        dfs(nums, unionNumIndex + 1, subRes);
//        // 递归后处理
//        for(List<Integer> list : subRes)
//        {
//            curRes.add(list);
//            List<Integer> subRes1 = new ArrayList<Integer>(list);
//            subRes1.add(nums[unionNumIndex]);
//            curRes.add(subRes1);
//        }
//    }

    /*
    思路二：回溯写法，即每次可以选择该元素也可以不选择该元素，跳过。那么每个元素都选得到的就是原集合，每个元素都不选得到的就是空集，就是二叉树的搜索。
     */
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> curres = new ArrayList<>();
        dfs(nums, 0, curres);
        return res;
    }

    public void dfs(int[] nums, int index, List<Integer> curRes)
    {
        // 退出条件
        if(index == nums.length)
        {
            res.add(new ArrayList<>(curRes));
            return;
        }
        // 对于所有可能的选择即 该元素选 / 该元素不选
        // 选择
        curRes.add(nums[index]);
        // 递归
        dfs(nums, index + 1, curRes);
        // 回溯撤销选择
        curRes.remove(curRes.size() - 1);
        // 不选择 递归 无回溯
        dfs(nums, index + 1, curRes);
    }

}
