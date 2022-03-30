package ProblemsByType.DP;

public class No_198_HouseRobber
{
    /*
    思路：动态规划，dp[i]定义为到第i家可以抢到的最多钱数量，那么对于第i家可以选择 抢 / 不抢，抢的话就dp[i] = dp[i - 2] + nums[i]，不抢的话就还是dp[i] = dp[i - 1]，两者取大。
      */
    public int rob(int[] nums) {
        int len = nums.length;
        if(len == 1)
            return nums[0];
        if(len == 2)
            return Math.max(nums[0], nums[1]);
        int[] dp = new int[len + 1];
        dp[1] = nums[0];
        for(int i = 2; i <= len; i++)
        {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
        }
        return dp[len];
    }
}
