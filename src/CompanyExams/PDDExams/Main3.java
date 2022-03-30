package CompanyExams.PDDExams;

import java.util.*;

public class Main3
{
    public static void main(String[] args)
    {
        Main3 solution = new Main3();
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int i = 0; i < T; i++)
        {
            int res = 0;
            int fieldCnt = sc.nextInt();
            int[] dayArr = new int[3001];
            int early = 1;
            int late = 1;
            int[][] arr = new int[fieldCnt][3];
            int maxPerDay = sc.nextInt();
            for(int j = 0; j < fieldCnt; j++)
            {
                arr[j][0] = sc.nextInt();
                arr[j][1] = sc.nextInt();
                early = Math.min(early, arr[j][1]);
                arr[j][2] = sc.nextInt();
                late = Math.max(late, arr[j][2]);
//                for(int k = arr[j][1]; k <= arr[j][2]; k++)
//                    dayArr[k] += arr[j][0];
            }
            Arrays.sort(arr, new Comparator<int[]>()
            {
                @Override
                public int compare(int[] o1, int[] o2)
                {
                    return o1[1] - o2[1];
                }
            });
            int curDay;
            for(curDay = early; curDay <= late; curDay++)
            {
                int fieldId = 0;
                int remain = 3;
                while(arr[fieldId][1] < curDay || arr[fieldId][0] <= 0)
                    fieldId++;
                if(arr[fieldId][0] < 3)
                {
                    remain = 3 - arr[fieldId][0];
                    res += arr[fieldId][0];
                    while(arr[fieldId++][0] <= remain)
                    {
                        arr[fieldId][0] = 0;
                        remain -= arr[fieldId][0];
                        res += arr[fieldId][0];
                    }
                    arr[fieldId][0] = 0;
                    remain = 0;
                }
                else
                {
                    arr[fieldId][0] -= maxPerDay;
                    res += arr[fieldId][0];
                }
            }
            System.out.print(res);
        }
    }
}
