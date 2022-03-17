package ProblemsByType.String;

import java.util.Arrays;

public class No_300_LongestIncSubseq
{
    /*
    ˼·һ�����ö�̬�滮������dp[i]Ϊ�� i λ���ַ���β������������еĳ��ȣ���ôdp[i]������dp[0] - dp[i - 1]ת�Ƶ������Լ���һ�±��֪��dp[i]ʱ��Ҫ��ǰ�������� j ʹnum[j] <num[i] ��������Щ���������� j ��ѡ��Max(dp[?j ])��ʱ�临�Ӷ�ΪO(n^2)���ռ临�Ӷ�ΪO(n)��
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
    ˼·������̬�滮 + ���ֲ��ң���ΪҪ������������ô��Ҫʹ���е����һλ������С������һ��̰��˼�롣��¼��ÿ�ֳ��ȵ������еĽ�βԪ����Сֵ��
    ʵ�֣�ʹ��һ������dp[]��dp[i]������Ϊi�ĵ��������е����һ��Ԫ�ص���Сֵ�����ڹ����м�¼�³��ֵ�����г���maxLen�������dp����ĵڼ���λ�á�
    �����ɨ���Ԫ�ش���dp[maxLen]��������󳤶ȵ������еĽ�β��Сֵ����ô˵������maxLen + 1��
    ������ɨ��Ԫ��С��dp[maxLen]����ô�����������г��ȣ����ǿ���ʹ���䳢�Ը���dp[0] - dp[maxLen]ʹ��dp���㶨�壬������¹��̾����ҵ�dp������С�ڸ�Ԫ�صĵ�һ��λ�ã�������λ�õĺ�һ��λ�ý��и��£����Զ��ֲ�����Ҫ���µ�λ�á�
    ���Ҳ���˵��dp[0 - maxLen]�������Ԫ��С����ô�͸���dp[1]����С��һ�������replacePos��ʼ��Ϊ1��
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
