package ProblemsByType.DP;

public class No_152_MaxProductSubArray
{
    /*
    ˼·����̬�滮��dpmax[i]�洢iλ����ǰ�����������е����ֵ  dpmin[i]�洢iλ����ǰ�����������е���Сֵ  ��Ϊ�����и���������Ҫ����dp���飬���iλ��Ϊ��������ô�п�����֮ǰ����С�ĸ�����˿ɵø��������
    dpmax[i] = Max(nums[i - 1] , dpmax[i - 1] * nums[i - 1], dpmin[i - 1] * nums[i - 1]);
    dpmin[i] = Min(nums[i - 1] , dpmax[i - 1] * nums[i - 1], dpmin[i - 1] * nums[i - 1]);
    ����dpmax[i] / dpmin[i] ֻ�� dpmax[i - 1] �� dpmin[i - 1]�йأ����Կ��Խ�dp����ռ���СΪ������maxdp mindp
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
