package CompanyExams.NetEaseExams.Problem1;

import java.util.*;

public class Main
{
    private static int singleDamage = 0;
    private static int everyDamage = 0;
    private static int res = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Main solution = new Main();
        int a = sc.nextInt();
        int b = sc.nextInt();
        singleDamage = sc.nextInt();
        everyDamage = sc.nextInt();
        System.out.println(solution.calculateMinTimes(a, b, 0));
    }

    public int calculateMinTimes(int a, int b, int times)
    {
        if(a <= 0 && b <= 0)
            return times;
        int subres = Integer.MAX_VALUE;
        if(a > 0 && b > 0 && times + 1 < res)
        {
            subres = calculateMinTimes(a - everyDamage, b - everyDamage, times + 1);
            if(subres != Integer.MAX_VALUE)
                res = Math.min(res, subres);
        }
        if(a > 0 && times + 1 < res)
        {
            subres = calculateMinTimes(a - singleDamage, b, times + 1);
            if (subres != Integer.MAX_VALUE) res = Math.min(res, subres);
        }
        if(b > 0 && times + 1 < res)
        {
            subres = calculateMinTimes(a, b - singleDamage, times + 1);
            if (subres != Integer.MAX_VALUE) res = Math.min(res, subres);
        }
        return res;
    }
}
