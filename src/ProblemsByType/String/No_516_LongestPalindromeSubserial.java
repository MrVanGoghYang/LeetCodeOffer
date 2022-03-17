package ProblemsByType.String;

/*
dp[i][j]:从i到j的字符子串中包含的最长回文序列长度
return dp[1][n]
base case: dp[i][i] = 1
状态转移: if(s.charAt(i) == s.charAt(j))    dp[i][j] = dp[i + 1][j - 1] + 2;    else    dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j])
*/

public class No_516_LongestPalindromeSubserial
{
    public int longestPalindromeSubseq(String s) {
        int len = s.length();
        if(len < 2)
            return len;
        int[] dp = new int[calIndex(len, len - 1, len - 1) + 1];
        for(int i = 0; i < len; i++)
            dp[calIndex(len, i, i)] = 1;
        for(int i = len - 1; i >= 0; i--)
        {
            for(int j = i + 1; j < len; j++)
            {
                int cur = calIndex(len, i, j);
                int leftDown = calIndex(len, i + 1, j - 1);
                int left = calIndex(len, i, j - 1);
                int down = calIndex(len, i + 1, j);
                // System.out.print("i: " + s.charAt(i) + "  j: " + s.charAt(j) + "  dp: ");
                if(s.charAt(i) == s.charAt(j))
                {
                    if(leftDown >= 0 && leftDown < dp.length)
                    {
                        dp[cur] = dp[leftDown] + 2;
                        // System.out.println("@ " + dp[cur]);
                    }
                }
                else
                {
                    dp[cur] = Math.max(dp[left], dp[down]);
                    // System.out.println("# " + dp[cur]);
                }
            }
        }
        return dp[calIndex(len, 0, len - 1)];
    }

    public int calIndex(int len, int i, int j)
    {
        return (int)(i * len - i * (i - 1) / 2 + (j - i));
    }
}
