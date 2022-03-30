package CompanyExams.MeituanExams.Meituan1;

import java.util.Scanner;

// 外卖问题，求是折扣价更低还是满减优惠更低
public class Main
{
    public static void main(String[] args)
    {
        // Common input process
        Scanner sc = new Scanner(System.in);
        int itemNum = sc.nextInt();
        int[] oriPrice = new int[itemNum];
        int[] disPrice = new int[itemNum];
        for(int caseIndex = 0; caseIndex < itemNum; caseIndex++)
        {
            oriPrice[caseIndex] = sc.nextInt();
        }
        for(int caseIndex = 0; caseIndex < itemNum; caseIndex++)
        {
            disPrice[caseIndex] = sc.nextInt();
        }
        int reduceNum = sc.nextInt();
        int[][] reduce = new int[reduceNum][2];
        for(int caseIndex = 0; caseIndex < reduceNum; caseIndex++)
        {
            reduce[caseIndex][0] = sc.nextInt();
        }
        for(int caseIndex = 0; caseIndex < reduceNum; caseIndex++)
        {
            reduce[caseIndex][1] = sc.nextInt();
        }
        int oriSum= 0;
        int disSum = 0;
        for(int i = 0; i <itemNum; i++)
        {
            oriSum += oriPrice[i];
            int reduceIndex = -1;
            for(int j = 0; j < reduceNum; j++)
            {
                if(oriSum >= reduce[j][0])
                    reduceIndex = Math.max(reduceIndex, j);
            }
            disSum += disPrice[i];
            if(reduceIndex >= 0)
            {
                if (oriSum - reduce[reduceIndex][1] > disSum)
                    System.out.print("Z");
                else if (oriSum - reduce[reduceIndex][1] < disSum)
                    System.out.print("M");
                else System.out.print("B");
            }
            else
            {
                if (oriSum > disSum)
                    System.out.print("Z");
                else
                    System.out.print("B");
            }
        }
    }
}
