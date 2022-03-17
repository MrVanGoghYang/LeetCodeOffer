package ProblemsByType.String;

import java.util.Arrays;

public class No_300_LongestIncSubseq
{
    /*
    思路一：单用动态规划，定义dp[i]为以 i 位置字符结尾的最长递增子序列的长度，那么dp[i]可以由dp[0] - dp[i - 1]转移得来，自己填一下表可知填dp[i]时需要向前搜索所有 j 使num[j] <num[i] ，并在这些满足条件的 j 中选出Max(dp[?j ])。时间复杂度为O(n^2)，空间复杂度为O(n)。
     */
//    public int lengthOfLIS(int[] nums) {
//        int n = nums.length;
//        int[] dp = new int[n];
//        int res = 1;
//        Arrays.fill(dp, 1);
//        for(int i = 1; i < n; i++)
//        {
//            int maxDp = 0;
//            for(int j = 0; j < i; j++)
//            {
//                if(nums[j] < nums[i] && dp[j] > maxDp)
//                    maxDp = dp[j];
//            }
//            dp[i] = maxDp + 1;
//            res = Math.max(res, dp[i]);
//        }
//        return res;
//    }

    /*
    思路二：动态规划 + 二分查找，因为要想递增序列最长那么需要使序列的最后一位尽可能小，这是一种贪心思想。记录下每种长度的子序列的结尾元素最小值。
    实现：使用一个数组dp[]，dp[i]代表长度为i的递增子序列的最后一个元素的最小值，并在过程中记录下出现的最长序列长度maxLen，即填到了dp数组的第几个位置。
    如果新扫描的元素大于dp[maxLen]即大于最大长度递增序列的结尾最小值，那么说明可以maxLen + 1；
    否则若扫描元素小于dp[maxLen]，那么不能增加序列长度，但是可以使用其尝试更新dp[0] - dp[maxLen]使得dp满足定义，这个更新过程就是找到dp数组中小于该元素的第一个位置，并将该位置的后一个位置进行更新，可以二分查找需要更新的位置。
    若找不到说明dp[0 - maxLen]均比这个元素小，那么就更新dp[1]即最小的一个，因此replacePos初始化为1。
     */
    public int lengthOfLIS(int[] nums) {
        StringBuilder sb = new StringBuilder();
        int n = nums.length;
        int[] dp = new int[n + 1];
        int maxLen = 1;
        dp[maxLen] = nums[0];
        for(int i = 1; i < n; i++)
        {
            if(nums[i] > dp[maxLen])
            {
                maxLen++;
                dp[maxLen] = nums[i];
                // System.out.println("maxLen: " + maxLen + " " + Arrays.toString(dp));
            }
            else if(nums[i] < dp[maxLen])
            {
                int left = 1;
                int right = maxLen;
                int replacePos = 1;
                while(left <= right)
                {

                    int mid = (left + right) >> 1;
                    // System.out.print("left: " + left + " right: " + right + " mid: " + mid);
                    if(dp[mid] >= nums[i])
                    {
                        right = mid - 1;
                    }
                    else
                    {
                        replacePos = mid + 1;
                        left = mid + 1;
                    }
                }
                dp[replacePos] = nums[i];

                // System.out.println(" replacePos: " + replacePos + "  " + Arrays.toString(dp));
            }
        }
        return maxLen;
    }
}
