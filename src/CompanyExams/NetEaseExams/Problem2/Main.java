package CompanyExams.NetEaseExams.Problem2;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        int len = input.length();
        if(len <= 1)
        {
            System.out.println(0);
            return;
        }
        int[] arr = new int[len];
        for(int i = 0; i < len; i ++)
            arr[i] = input.charAt(i) - 'a' + 1;
        int[] dp = new int[len + 1];
        dp[1] = 0;
        for(int i = 2; i <= len; i++)
        {
            if(arr[i - 1] == arr[i - 2] || Math.abs(arr[i - 1] - arr[i - 2]) == 1)
            {
                dp[i] = Math.max(dp[i - 2] + arr[i - 2] + arr[i - 1], dp[i - 1]);
            }
            else
            {
                dp[i] = dp[i - 1];
            }
        }
        System.out.println(dp[len]);
    }
}

