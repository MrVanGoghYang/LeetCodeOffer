package CompanyExams.PDDExams;

// 本题为考试单行多行输入输出规范示例，无需提交，不计分。
import java.util.*;
public class Main {
    static int[] flag1 = new int[20001];
    static int[] flag2 = new int[20001];

    public static void main(String[] args) {
        long res = Long.MAX_VALUE;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr1 = new int[n];
        int[] arr2 = new int[n];

        for(int i = 0; i < n; i++)
        {
            arr1[i] = sc.nextInt();
            flag1[cal(arr1[i])]++;
        }
        for(int i = 0; i < n; i++)
        {
            arr2[i] = sc.nextInt();
            flag2[cal(arr2[i])]++;
        }
        if(n == 1)
        {
            res = (long)Math.pow((arr1[0] - arr2[0]), 2);
            System.out.print(res);
            return;
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        long itemRes = 0;
        if(Math.abs(arr1[n - 1]) < Math.abs(arr2[n - 1]))
        {
            int[] item = arr1;
            arr1 = arr2;
            arr2 = item;
            item = flag1;
            flag1 = flag2;
            flag2 = item;
        }
        itemRes = 0;
        for(int i = n - 1; i >= 0; i--)
        {
            itemRes += (long)Math.pow((arr1[i] - findNearest(flag2, arr1[i])), 2);
        }
        res = Math.min(res, itemRes);

//        if(Math.abs(arr1[0]) < Math.abs(arr2[0]))
//        {
//            int[] item = arr1;
//            arr1 = arr2;
//            arr2 = item;
//            item = flag1;
//            flag1 = flag2;
//            flag2 = item;
////            itemRes = 0;
////            for(int i = 0; i < n; i++)
////            {
////                itemRes += (long)Math.pow((arr1[i] - findNearest(flag2, arr1[i])), 2);
////            }
////            res = Math.min(res, itemRes);
//        }
//        itemRes = 0;
//        for(int i = 0; i < n; i++)
//        {
//            itemRes += (long)Math.pow((arr1[i] - findNearest(flag2, arr1[i])), 2);
//        }
//        res = Math.min(res, itemRes);

        System.out.print(res);
    }

    public static int findNearest(int[] flag, int target)
    {
        int res = 10001;
        int inter = 0;
        while(true)
        {
            int id1 = cal(target + inter);
            if(id1 >= 0 && id1 <= 20000 && flag[id1] > 0)
            {
                flag[id1]--;
                res = cal2(id1);
                break;
            }
            int id2 = cal(target - inter);
            if(id2 >= 0 && id2 <= 20000 && flag[id2] > 0)
            {
                flag[id2]--;
                res = cal2(id2);
                break;
            }
            inter++;
        }
        return res;
    }

    public static int cal(int index)
    {
        int res = index;
        if(index == 0)
            return 0;
        else if(index < 0)
            return 0 - index;
        else
            return 10000 + index;
    }

    public static int cal2(int index)
    {
        int res = index;
        if(index == 0)
            return 0;
        else if(index > 0 && index <= 10000)
            return 0 - index;
        else
            return index - 10000;
    }
}
