package TencentProblems;

import java.util.Arrays;
import java.util.Scanner;

/*
����ҵ�����㣬��˾��СQ���� n ��ļ٣���Ϊ�������СQ�������ڼ����й���������������Ϣ�����и���ֵ�ϰ�ߣ������������칤���������
ֻ�е���˾Ӫҵʱ��СQ����ȥ������ֻ�е�����Ӫҵʱ��СQ����ȥ����СQһ��ֻ�ܸ�һ���¡����������й�˾��������Ӫҵ�������СQ������Ҫ��Ϣ���졣
��������:
��һ��һ������  ��ʾ�ż�����
�ڶ��� n ���� ÿ����Ϊ0��1,�� i ������ʾ��˾�ڵ� i ���Ƿ�Ӫҵ
������ n ���� ÿ����Ϊ0��1,�� i ������ʾ�����ڵ� i ���Ƿ�Ӫҵ
��1ΪӪҵ 0Ϊ��Ӫҵ��
�������:
һ����������ʾСQ��Ϣ����������
��������1:
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
�������1:
2
����˵��1:
СQ�����ڵ�һ�칤�����ڶ��������콡��СQ������Ϣ2��

��������������ȫ0 ȫ��Ϣ������ȫ1 ����Ϣ����һ��ǰ��1���0  �ڶ���ǰ��0���1����һ�к͵ڶ���0 1����
˼·����̬�滮��dp[i][0]�����i����Ϣʱ���ۼƵ�������Ϣ���� dp[i][1]�����i�칤��ʱ���ۼƵ�������Ϣ���� dp[i][2]�����i�콡��
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
