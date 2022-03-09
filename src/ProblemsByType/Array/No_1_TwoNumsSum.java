package ProblemsByType.Array;

import java.util.HashMap;

/*
1. 两数之和
给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
你可以按任意顺序返回答案。
示例 1：
输入：nums = [2,7,11,15], target = 9
输出：[0,1]
解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
示例 2：
输入：nums = [3,2,4], target = 6
输出：[1,2]
示例 3：
输入：nums = [3,3], target = 6
输出：[0,1]

思路：使用HashMap储存元素值与下标的映射关系，但注意为了防止有重复元素如上示例3导致Key冲突，应该先判断HashMap中是否存在target - nums[i]再加入。
因为需要返回下标，所以不能对数组排序会丢失下标信息。
 */
public class No_1_TwoNumsSum
{
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++)
        {
            if(map.containsKey(target - nums[i]))
            {
                res[0] = map.get(target - nums[i]);
                res[1] = i;
                break;
            }
            else
            {
                map.put(nums[i], i);
            }
        }
        return res;
    }
}