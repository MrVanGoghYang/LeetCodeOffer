package ProblemsByType.DP;

/*
思路：DP. dp[i][j]定义为从左上角到达[i][j]位置共有多少条路径。
     1. 每个格子只能由左边格子右移一步到达或由上边格子下移一步到达；dp[i][j] = dp[i - 1][j] + dp[i][j - 1]；
     2. 第一行和第一列的格子dp值均为1，因为只能一直往右走或者一直往下走一条路径。
 */
public class No_63_UniquePaths
{
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int i = 0; i < n; i++)
            dp[0][i] = 1;
        for(int i = 0; i < m; i++)
            dp[i][0] = 1;
        for(int i = 1; i < m; i++)
        {
            for(int j = 1; j < n; j++)
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
        }
        return dp[m - 1][n - 1];
    }
}
