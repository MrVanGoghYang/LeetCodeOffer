package ProblemsByType.DP;

/*
动态规划，定义dp[i]为以i位置结尾的子数组的最大和,dp[i] = max(dp[i - 1] + nums[i], nums[i])，由于每个状态值只和前一个状态有关因此可以简化空间使用两个变量。
 */
public class No_53_MaxSumOfSubarray
{
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int lastMax = nums[0];
        int curMax = nums[0];
        for(int i = 2; i <= nums.length; i++)
        {
            curMax = Math.max(nums[i - 1], lastMax + nums[i - 1]);
            max = Math.max(max, curMax);
            lastMax = curMax;
        }
        return max;
    }
}
