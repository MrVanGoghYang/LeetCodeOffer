package CompanyTrainings.NetEase_1.Problem2;

import java.util.Scanner;

public class Main
{
    private static int SECONDSPERHOUR = 60 * 60;
    public static void main(String[] args) {
        Main solution = new Main();
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int caseIndex = 0; caseIndex < T; caseIndex++)
        {
            int n = sc.nextInt();
            int[] selfBuy = new int[n];
            int[] togetherBuy = new int[n - 1];
            for(int i = 0; i < n; i++)
                selfBuy[i] = sc.nextInt();
            if(n == 1)
            {
                System.out.println(solution.formatTrans(selfBuy[0]));
                continue;
            }
            for(int i = 0; i < n - 1; i++)
                togetherBuy[i] = sc.nextInt();
            int leastTime = solution.calLeastTime(selfBuy, togetherBuy);
            System.out.println(solution.formatTrans(leastTime));
        }
    }

    public int calLeastTime(int[] selfBuy, int[] togetherBuy)
    {
        int[] dp = new int[selfBuy.length];
        dp[0] = selfBuy[0];
        if(selfBuy.length >= 2)
            dp[1] = Math.min(dp[0] + selfBuy[1], togetherBuy[0]);
        for(int i = 2; i < selfBuy.length; i++)
        {
            dp[i] = Math.min(dp[i - 2] + togetherBuy[i - 1], dp[i - 1] + selfBuy[i]);
        }
        return dp[selfBuy.length - 1];
    }

    public String formatTrans(int time)
    {
        StringBuilder sb = new StringBuilder();
        int spendHour = 8 + time / SECONDSPERHOUR;
        boolean isAm = spendHour < 13;
        if(spendHour > 12)
            spendHour -= 12;
        if(spendHour < 10)
            sb.append("0" + spendHour);
        else
            sb.append(spendHour);
        int spendMin = (time % SECONDSPERHOUR) / 60;
        if(spendMin < 10)
            sb.append(":0" + spendMin);
        else
            sb.append(":" + spendMin);
        int spendSec = (time % SECONDSPERHOUR) % 60;
        if(spendSec < 10)
            sb.append(":0" + spendSec);
        else
            sb.append(":" + spendSec);
        if(isAm)
            sb.append(" am");
        else
            sb.append(" pm");
        return sb.toString();
    }
}