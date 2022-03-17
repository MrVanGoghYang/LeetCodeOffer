package ProblemsByType.DP;

import java.util.HashMap;

/*
思路同63：动态规划
1. base case: 第一行 或 第一列 的每个位置的dp值为之前所有位置dp值之和，因为只能从起点一直往右走或往下走到达；
2. 状态转移: dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j]，即从上面格子或右边格子选一个来到达该位置。
 */
public class No_64_MinPathSum
{
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        for(int i = 1; i < n; i++)
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        for(int i = 1; i < m; i++)
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        for(int i = 1; i < m; i++)
        {
            for(int j = 1; j < n; j++)
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
        }
        return dp[m - 1][n - 1];
    }
}
