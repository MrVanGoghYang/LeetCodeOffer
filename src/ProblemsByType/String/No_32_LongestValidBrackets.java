package ProblemsByType.String;

public class No_32_LongestValidBrackets
{
    /*
    思路二：dp动态规划，用于解决"两个字符串扫描匹配" 或 求"子串最值" 的问题，采用一维dp数组，定义dp[i]为以i位置字符结尾的最长有效括号长度，分析可知有效串一定是以)结尾的，所以所有s[i] = '('的均dp[i] = 0；
    状态转移方程：通过自己手写填表找规律。
    s  ( ( ) ( ( ) )
    id 0 1 2 3 4 5 6
    dp 0 0 2 0 0 2 4+2=6

    s  ( ) ( ( ) )
    id 0 1 2 3 4 5
    dp 0 2 0 0 2 6
     (1) 若s[i] == '('  则dp[i] = 0；
     (2) 若s[i] == ')' 则需要看s[i - 1]:
        若s[i - 1] = '(' 则dp[i] = dp[i - 2] + 2；
        若s[i - 1] = ')' 且 s[i - 1 - dp[i - 1]] = '('即前面也有匹配的左括号，则s[i] = dp[i - 2] + 2 + dp[(i - 1) - dp[i - 1] - 1]，即需要由dp[i - 1]向前再找到最前面的可能连续的前置有效串。
    */
    public int longestValidParentheses(String s) {
        if(s.length() == 0)
            return 0;
        int[] dp = new int[s.length()];
        int max = 0;
        for(int i = 0; i < s.length(); i++)
        {
            if(s.charAt(i) == '(')
                dp[i] = 0;
            else
            {
                if(i - 1 >= 0 && s.charAt(i - 1) == '(')
                {
                    dp[i] = i - 2 >= 0 ? dp[i - 2] + 2 : 2;
                    // System.out.println("@ dp[" + i + "]: " + dp[i]);
                }
                else if((i - 1 >= 0 && s.charAt(i - 1) == ')') && i - 1 - dp[i - 1] >= 0 && s.charAt(i - 1 - dp[i - 1]) == '(')
                {
                    dp[i] = i - 2 >= 0 ? dp[i - 1] + 2 : 2;
                    // System.out.println("# dp[" + i + "]: " + dp[i]);
                    int frontId = (i - 1) - dp[i - 1] - 1;
                    if(frontId >= 0)
                        dp[i] += dp[frontId];
                    // System.out.println("# dp[" + i + "]: " + dp[i] + " front: " + frontId);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
    /*
    思路一：利用合法括号串的性质：从左往右扫描，左括号的计数一定会大于等于右括号的计数，否则非法；从右往左则相反。通过对左括号和右括号计数来实现有效括号串长度统计：当左右括号相等时进行长度增加处理（相当于使用栈匹配时栈为空）;或者非法时左右括号清0；
    问题出现在：一些字符串看似可以继续匹配右括号但是如果后续匹配不到右括号时，会导致没有计数的情况，比如"((()()(()"这种在扫描过程中如果(一直比)多那么会暂时认为是合法的继续寻找)去匹配，但是如果后续找不到的话（即栈非空）会导致：
    要么（1） 每出现一个)就匹配数+2的计数方式 会导致 即使中间出现了间断的(后面还是继续统计了（）对，导致计算结果过多； （2） 每当左右括号计数相同时才匹配数+ 2*计数  会导致  一直没有出现左右括号计数相同所以一直没有改变匹配数，导致计算结果过少。
    为了解决这种“看似暂时合法但后续找不全”的情况，采用正着找一遍再倒着找一遍的做法，并采用括号计数相同时改变匹配数的方法（因为第（1）种计数策略根本无法保证中间是连续合法的，是错误计数法，必须全匹配或栈空才计数保证连续合法）。
    */
    // public int longestValidParentheses(String s) {
    //     if(s.length() == 0)
    //         return 0;
    //     int rightCnt = 0;
    //     int leftCnt = 0;
    //     int max = 0;
    //     int curCnt = 0;
    //     for(int i = s.length() - 1; i >= 0; i--)
    //     {
    //         if(s.charAt(i) == ')')
    //             rightCnt++;
    //         else if(s.charAt(i) == '(')
    //             leftCnt++;

    //         if(leftCnt == rightCnt)
    //         {
    //             curCnt += leftCnt * 2;
    //             leftCnt = 0;
    //             rightCnt = 0;
    //             max = Math.max(max, curCnt);
    //         }
    //         else if(leftCnt > rightCnt)
    //         {
    //             leftCnt = 0;
    //             rightCnt = 0;
    //             curCnt = 0;
    //         }
    //     }

    //     curCnt = 0;
    //     rightCnt = 0;
    //     leftCnt = 0;
    //     for(int i = 0; i < s.length() - 1; i++)
    //     {
    //         if(s.charAt(i) == ')')
    //             rightCnt++;
    //         else if(s.charAt(i) == '(')
    //             leftCnt++;

    //         if(leftCnt == rightCnt)
    //         {
    //             curCnt += leftCnt * 2;
    //             leftCnt = 0;
    //             rightCnt = 0;
    //             max = Math.max(max, curCnt);
    //         }
    //         else if(rightCnt > leftCnt)
    //         {
    //             leftCnt = 0;
    //             rightCnt = 0;
    //             curCnt = 0;
    //         }
    //     }
    //     return max;
    // }
}
