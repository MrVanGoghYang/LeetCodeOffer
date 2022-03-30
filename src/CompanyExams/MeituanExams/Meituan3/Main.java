package CompanyExams.MeituanExams.Meituan3;

import java.util.HashSet;
import java.util.Scanner;
// 求区间交集，未AC
public class Main
{
    /*
    样例输入
10 2 3
1 1
10 9
1 2 3
7 5 4
    样例输出
    4
     */
    public static void main(String[] args)
    {
        // Common input process
        Main solution = new Main();
        Scanner sc = new Scanner(System.in);
        int fileNum = sc.nextInt();
//        boolean[] flag = new boolean[fileNum];
//        boolean[] flag2 = new boolean[fileNum];
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        int interCnt1 = sc.nextInt();
        int[][] inter1 = new int[interCnt1][2];
        int interCnt2 = sc.nextInt();
        int[][] inter2 = new int[interCnt2][2];
        for(int caseIndex = 0; caseIndex < interCnt1; caseIndex++)
        {
            inter1[caseIndex][0] = sc.nextInt();
        }
        for(int caseIndex = 0; caseIndex < interCnt1; caseIndex++)
        {
            inter1[caseIndex][1] = sc.nextInt();
        }
        for(int caseIndex = 0; caseIndex < interCnt2; caseIndex++)
        {
            inter2[caseIndex][0] = sc.nextInt();
        }
        for(int caseIndex = 0; caseIndex < interCnt2; caseIndex++)
        {
            inter2[caseIndex][1] = sc.nextInt();
        }
        int reflictCnt = 0;
        for(int i = 0; i < interCnt1; i++)
        {
            for(int j = inter1[i][0]; j <= inter1[i][1]; j++)
            {
                if(!set.contains(j - 1))
                    set.add(j - 1);
            }
        }
        for(Integer item : set)
        {
            for(int i = 0; i < interCnt2; i++)
            {
                if(!set2.contains(item) && item + 1 >= inter2[i][0] && item + 1 <= inter2[i][1])
                {
                    reflictCnt++;
                    set2.add(item);
                    break;
                }
            }
        }
//        for(int i = 0; i < interCnt2; i++)
//        {
//            for(int j = inter2[i][0]; j <= inter2[i][1]; j++)
//            {
//                if(set.contains(j - 1) && !set2.contains(j - 1))
//                {
//                    reflictCnt++;
//                    set2.add(j - 1);
//                }
//            }
//        }
        System.out.print(reflictCnt);
    }
}
