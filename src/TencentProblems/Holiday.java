package TencentProblems;

import java.util.Arrays;
import java.util.Scanner;

/*
由于业绩优秀，公司给小Q放了 n 天的假，身为工作狂的小Q打算在在假期中工作、锻炼或者休息。他有个奇怪的习惯：不会连续两天工作或锻炼。
只有当公司营业时，小Q才能去工作，只有当健身房营业时，小Q才能去健身，小Q一天只能干一件事。给出假期中公司，健身房的营业情况，求小Q最少需要休息几天。
输入描述:
第一行一个整数  表示放假天数
第二行 n 个数 每个数为0或1,第 i 个数表示公司在第 i 天是否营业
第三行 n 个数 每个数为0或1,第 i 个数表示健身房在第 i 天是否营业
（1为营业 0为不营业）
输出描述:
一个整数，表示小Q休息的最少天数
输入例子1:
4
1 1 0 0
0 1 1 0
6
0 0 0 0 0 0
0 0 0 0 0 0
6
1 1 1 1 1 1
1 1 1 1 1 1
6
1 1 1 0 0 0
0 0 0 1 1 1
6
1 0 1 0 1 0
0 1 0 1 0 1
输出例子1:
2
例子说明1:
小Q可以在第一天工作，第二天或第三天健身，小Q最少休息2天

测试用例：两行全0 全休息、两行全1 不休息、第一行前半1后半0  第二行前半0后半1、第一行和第二行0 1交替
思路：动态规划：dp[i][0]代表第i天休息时所累计的最少休息天数 dp[i][1]代表第i天工作时所累计的最少休息天数 dp[i][2]代表第i天健身
dp[i][0] = 1 + min(dp[i-1][0],dp[i-1][1],dp[i-1][2]) dp[i][1] = min(dp[i-1][0],dp[i-1][2])  dp[i][2] = min(dp[i-1][0],dp[i-1][1])
res = min(dp[n][0],dp[n][1],dp[n][2])
 */
public class Holiday
{
    public static void main(String[] args)
    {
        Holiday solution = new Holiday();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean[] company = new boolean[n];
        boolean[] gym = new boolean[n];
        for (int i = 0; i < n; i++)
        {
            company[i] = sc.nextInt() == 1 ? true : false;
        }
        for (int i = 0; i < n; i++)
        {
            gym[i] = sc.nextInt() == 1 ? true : false;
        }
        System.out.println(solution.dp(company, gym));
    }

    public int dp(boolean[] company, boolean[] gym)
    {
        int[][] dp = new int[company.length + 1][3];
        for(int i = 1; i <= company.length; i++)
        {
            Arrays.fill(dp[i], company.length + 1);
        }
        for (int i = 1; i <= company.length; i++)
        {
            dp[i][0] = Math.min(dp[i - 1][0], Math.min(dp[i - 1][1], dp[i - 1][2])) + 1;
            if(company[i - 1])
                dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]);
            if(gym[i - 1])
                dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]);
        }
        return Math.min(dp[company.length][0], Math.min(dp[company.length][1], dp[company.length][2]));
    }
}
