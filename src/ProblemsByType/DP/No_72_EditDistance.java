package ProblemsByType.DP;

/*
思路：动态规划，定义dp[i][j]含义为word1中前i + 1个元素串要变为word2中前j + 1个元素所需要的最少变换次数；
通过示例串填表过程，可知：
1. base case: 第1行dp[1][i]与第1列dp[i][1]填充方式相同，以第一行为例：若word1.charAt(i) == word2.charAt(0)即word1最后一个字符与word2第一个字符相同，dp[1][i] = i - 1即只需要删除之前所有字符即可；若不同则 = dp[1][i - 1] + 1，由前一个变换得到；
2. 如果word1.charAt(j - 1) == word2.charAt(i - 1),那么dp[i][j] =  (1)直接取最后一个元素相同，前i - 1个变换至前 j - 1个即dp[i - 1][j - 1]; (2)前i个元素变换至前j - 1个元素，并添加第j个元素； （3）前i - 1个元素变换至前j个元素，并删除第i个元素。3者取小值。
   否则：dp[i][j] = (1)前i - 1个变换至前 j - 1个元素，第i个元素再替换为第j个元素，即dp[i - 1][j - 1] + 1; (2)前i个元素变换至前j - 1个元素，并添加第j个元素； 即dp[i][j - 1] + 1（3）前i - 1个元素变换至前j个元素，并删除第i个元素，即dp[i - 1][j] + 1。3者取小值。
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
