package ProblemsByType.DP;

public class No_152_MaxProductSubArray
{
    /*
    思路：动态规划，dpmax[i]存储i位置往前连续的数组中的最大值  dpmin[i]存储i位置往前连续的数组中的最小值  因为有正有负，所以需要两个dp数组，如果i位置为负数，那么有可能与之前的最小的负数相乘可得更大的正数
    dpmax[i] = Max(nums[i - 1] , dpmax[i - 1] * nums[i - 1], dpmin[i - 1] * nums[i - 1]);
    dpmin[i] = Min(nums[i - 1] , dpmax[i - 1] * nums[i - 1], dpmin[i - 1] * nums[i - 1]);
    由于dpmax[i] / dpmin[i] 只与 dpmax[i - 1] 和 dpmin[i - 1]有关，所以可以将dp数组空间缩小为两个数maxdp mindp
     */
    public int maxProduct(int[] nums) {
        int len = nums.length;
        if(len == 1)
            return nums[0];
        int maxdp = nums[0];
        int mindp = nums[0];
        int max = nums[0];
        for(int i = 2; i <= len; i++)
        {
            int maxMulti = maxdp * nums[i - 1];
            int minMulti = mindp * nums[i - 1];
            maxdp = Math.max(nums[i - 1], Math.max(maxMulti, minMulti));
            mindp = Math.min(nums[i - 1], Math.min(maxMulti, minMulti));
            max = max >= maxdp ? max : maxdp;
        }
        return max;
    }
}
