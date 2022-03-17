package ProblemsByType.DP;

/*
��̬�滮������dp[i]Ϊ��iλ�ý�β�������������,dp[i] = max(dp[i - 1] + nums[i], nums[i])������ÿ��״ֵֻ̬��ǰһ��״̬�й���˿��Լ򻯿ռ�ʹ������������
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
