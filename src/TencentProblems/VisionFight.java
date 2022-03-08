package TencentProblems;

import java.util.*;

/*
10:28
СQ�ڽ���һ��������Ϸ,�ⳡ��Ϸ��ʤ���ؼ��������ܷ�������һ������ΪL�ĺӵ�,�����Կ�����[0,L]��һ�����ᡣ
������Ϸ������n�������ṩ��Ұ�ĵ���?��������,��i�����������ܹ���������[xi,yi]������СQ��֪�������ü������������Ϳ��Ը������κӵ���
��������:
�������n+1�С�
��һ�а�������������n��L(1<=n<=10^5,1<=L<=10^9)
��������n��,ÿ������������xi,yi(0<=xi<=yi<=10^9),��ʾ��i�������������ǵ����䡣
�������:
һ����������ʾ������Ҫ��������������, ����޽�, ���-1��
��������1:
4 6
3 6
2 4
0 2
4 7

4 9
0 2
2 5
4 6
1 8

9 11
0 3
2 4
4 5
5 6
6 9
9 10
10 11
1 8
7 10
�������1:
3

��������:(1) 0 2 0 4 0 6 2 6; (2) 0 2 0 4 2 4 2 5;
˼·��̰���㷨���� ���������������δ�С�������е����䣬Ҫʹ��ѡȡ�����������٣���ÿ��ѡȡ�������ܵ������Զ����Զ��
ʵ�֣��ȶ�������������Ȼ��indexһ��ɨ�����������飬�������������<=��ǰ�����������Զ�˵㣬��ô�Ϳ���ɨ�裬���� > �Ļ����Ҳ�������Ϊ����������С�Ķ�>��Զ�˵㣬����Ŀ϶�Ҳ>��Զ�˵㣬�� �Ͽ��ˣ�
    ɨ����̣����������� <= ��ǰ�����������Զ�˵�ʱ������++��ͬʱ����ÿ�������յ�����ֵ����Ϊ�Ѱ����������Զ�ˣ�
    ɨ���˳�ѭ���󣬵õ�һ���ɵ������Զ�˵����䣬cnt++��ͬʱ�����Ѱ����������Զ�ˣ������ɨ�赽���һ���������Զ��>=L����ֹѭ��������������Զ�˻�<L����ô�ټ���ѭ����һ��ʹ�����Ҷ���Զ�����䡣
 */

public class VisionFight
{
    public static void main(String[] args)
    {
        VisionFight solution = new VisionFight();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int L = sc.nextInt();
        int[][] arr = new int[n][2];
        for(int i = 0; i < n; i++)
        {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }
        Arrays.sort(arr, new Comparator<int[]>()
        {
            @Override
            public int compare(int[] o1, int[] o2)
            {
                return o1[0]- o2[0] == 0 ?  o1[1]- o2[1] : o1[0]- o2[0];
            }
        });
        System.out.println(solution.leastDefenderNum(arr, L));
    }

    public int leastDefenderNum(int[][] arr, int l)
    {
        int cnt = 0;
        int endPoint = 0;
        int farestEnd = 0;
        int index = 0;
        //  ����ɨ�� ��� <= endPoint�����������У�ѡ�� ��Զ�ܵ�����յ㣬��������յ���Ϊ��ǰѡ������������ܵ�����Զ�㣬��һ������ɨ����� <= �����Զ�����Щ���䣻
        while(endPoint < l)
        {
            if (arr[index][0] > endPoint) return -1;
            farestEnd = 0;
            while (index < arr.length && arr[index][0] <= endPoint)
            {
                farestEnd = Math.max(farestEnd, arr[index][1]);
                index++;
            }
            cnt++;
            endPoint = farestEnd;

            if (endPoint >= l || index == arr.length)
                break;
        }
        return endPoint >= l ? cnt : -1;
    }
}
