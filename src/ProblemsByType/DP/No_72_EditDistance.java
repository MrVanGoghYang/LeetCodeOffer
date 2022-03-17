package ProblemsByType.DP;

/*
˼·����̬�滮������dp[i][j]����Ϊword1��ǰi + 1��Ԫ�ش�Ҫ��Ϊword2��ǰj + 1��Ԫ������Ҫ�����ٱ任������
ͨ��ʾ���������̣���֪��
1. base case: ��1��dp[1][i]���1��dp[i][1]��䷽ʽ��ͬ���Ե�һ��Ϊ������word1.charAt(i) == word2.charAt(0)��word1���һ���ַ���word2��һ���ַ���ͬ��dp[1][i] = i - 1��ֻ��Ҫɾ��֮ǰ�����ַ����ɣ�����ͬ�� = dp[1][i - 1] + 1����ǰһ���任�õ���
2. ���word1.charAt(j - 1) == word2.charAt(i - 1),��ôdp[i][j] =  (1)ֱ��ȡ���һ��Ԫ����ͬ��ǰi - 1���任��ǰ j - 1����dp[i - 1][j - 1]; (2)ǰi��Ԫ�ر任��ǰj - 1��Ԫ�أ�����ӵ�j��Ԫ�أ� ��3��ǰi - 1��Ԫ�ر任��ǰj��Ԫ�أ���ɾ����i��Ԫ�ء�3��ȡСֵ��
   ����dp[i][j] = (1)ǰi - 1���任��ǰ j - 1��Ԫ�أ���i��Ԫ�����滻Ϊ��j��Ԫ�أ���dp[i - 1][j - 1] + 1; (2)ǰi��Ԫ�ر任��ǰj - 1��Ԫ�أ�����ӵ�j��Ԫ�أ� ��dp[i][j - 1] + 1��3��ǰi - 1��Ԫ�ر任��ǰj��Ԫ�أ���ɾ����i��Ԫ�أ���dp[i - 1][j] + 1��3��ȡСֵ��
 */
public class No_72_EditDistance
{
    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        if(len1 == 0 || len2 == 0)
            return len1 == 0 ? len2 : len1;
        int[][] dp = new int[len2 + 1][len1 + 1];
        for(int i = 1; i <= len1; i++)
            dp[1][i] = word1.charAt(i - 1) == word2.charAt(0) ? i - 1 : dp[1][i - 1] + 1;
        for(int i = 1; i <= len2; i++)
            dp[i][1] = word1.charAt(0) == word2.charAt(i - 1) ? i - 1 : dp[i - 1][1] + 1;
        for(int i = 2; i <= len2; i++)
        {
            for(int j = 2; j <= len1; j++)
            {
                if(word1.charAt(j - 1) == word2.charAt(i - 1))
                {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1));
                    // System.out.println("@ dp[" + i + "][" + j + "]: " + dp[i][j] + " dp[" + (i - 1) + "][" + (j - 1) + "]: " + dp[i - 1][j - 1] + "dp[" + (i - 1) + "][" + j + "]: " + dp[i - 1][j] + "dp[" + i + "][" + (j - 1) + "]: " +  dp[i][j - 1]);
                }
                else
                {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                    // System.out.println("# dp[" + i + "][" + j + "]: " + dp[i][j] + " dp[" + (i - 1) + "][" + (j - 1) + "]: " + dp[i - 1][j - 1] + "dp[" + (i - 1) + "][" + j + "]: " + dp[i - 1][j] + "dp[" + i + "][" + (j - 1) + "]: " +  dp[i][j - 1]);
                }
            }
        }
        return dp[len2][len1];
    }
}
