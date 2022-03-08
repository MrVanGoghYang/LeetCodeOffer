package TencentProblems;

import java.util.*;

/*
10:28
小Q在进行一场竞技游戏,这场游戏的胜负关键就在于能否能争夺一条长度为L的河道,即可以看作是[0,L]的一条数轴。
这款竞技游戏当中有n个可以提供视野的道具?真视守卫,第i个真视守卫能够覆盖区间[xi,yi]。现在小Q想知道至少用几个真视守卫就可以覆盖整段河道。
输入描述:
输入包括n+1行。
第一行包括两个正整数n和L(1<=n<=10^5,1<=L<=10^9)
接下来的n行,每行两个正整数xi,yi(0<=xi<=yi<=10^9),表示第i个真视守卫覆盖的区间。
输出描述:
一个整数，表示最少需要的真视守卫数量, 如果无解, 输出-1。
输入例子1:
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
输出例子1:
3

测试用例:(1) 0 2 0 4 0 6 2 6; (2) 0 2 0 4 2 4 2 5;
思路：贪心算法，即 对于在数轴上依次从小到大排列的区间，要使得选取的区间数最少，则每次选取区间所能到达的最远端最远。
实现：先对输入区间排序，然后index一遍扫描排序后的数组，如果该区间的起点<=当前包含区间的最远端点，那么就可以扫描，否则 > 的话就找不到（因为区间已有序，小的都>最远端点，后面的肯定也>最远端点，即 断开了）
    扫描过程：当区间的起点 <= 当前包含区间的最远端点时，区间++，同时记下每个区间终点的最大值，作为已包含区间的最远端；
    扫描退出循环后，得到一个可到达的最远端的区间，cnt++，同时更新已包含区间的最远端，如果已扫描到最后一个区间或最远端>=L则终止循环，否则若该最远端还<L，那么再继续循环找一个使区间右端最远的区间。
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
        //  倒着扫描 起点 <= endPoint的所有区间中，选择 最远能到达的终点，记下这个终点作为当前选择的区间中所能到的最远点，下一步继续扫描起点 <= 这个最远点的那些区间；
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
