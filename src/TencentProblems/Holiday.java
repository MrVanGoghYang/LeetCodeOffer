package TencentProblems;

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

用例：两行全0 全休息、两行全1 不休息、第一行前半1后半0  第二行前半0后半1、第一行和第二行0 1交替
dfs递归 -> dfs迭代  visit数组：0未访问、1上班、2锻炼、3休息
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
        int[] visited = new int[n];
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++)
        {
            company[i] = sc.nextInt() == 1 ? true : false;
        }
        for (int i = 0; i < n; i++)
        {
            gym[i] = sc.nextInt() == 1 ? true : false;
        }
        if(company[0])
            res = Math.min(res, solution.dfs(company, gym, visited, 0, 1));
        if(gym[0])
            res = Math.min(res, solution.dfs(company, gym, visited, 0, 2));
        if(!company[0] && !gym[0])
            res = Math.min(res, solution.dfs(company, gym, visited, 0, 3));
        System.out.println(res);
    }

    // 返回从第idx+1天开始，当天的活动为acti时，累计休息的最少天数
    public int dfs(boolean[] company, boolean[] gym, int[] visited, int idx, int acti)
    {
        // 递归终止
        if(idx == company.length || visited[idx] != 0)
            return 0;
        // 初始处理
        int res = 0;

        visited[idx] = acti;
        // 所有可能选择
        for(int i = 1; i <= 3; i++)
        {
            boolean[] item = getActiArr(company, gym, acti);
            if(item != null && )
            // 选择一种
            // 子递归
            int saveRes = res;
            res += dfs(company, gym, visited, idx + 1, i);
            // 撤销选择 回溯
            if(idx + 1 < company.length)
                visited[idx + 1] = 0;
        }
        return res;
    }

    public boolean[] getActiArr(boolean[] company, boolean[] gym, int acti)
    {
        if(acti == 1)
            return company;
        else if(acti == 2)
            return gym;
        return null;
    }

}
