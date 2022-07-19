package CompanyExams.TencentExams.Problem2;

import java.util.*;

public class Main
{

    public static void main(String[] args)
    {
        Main solution = new Main();
//        int[] a = new int[]{3,1,1,4,5,6};
        int[] a = new int[]{1,2,3,4};
        System.out.println(solution.getNumber(a));
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param a int整型一维数组
     * @return int整型
     */
    public int getNumber(int[] a) {
        // write code here
//        Set<Integer> set = new HashSet<>();
//        int maxIndex = 200001;
//        int[] flag = new int[maxIndex];
//        for(int i = 2; i < maxIndex; i++)
//        {
//            if(flag[i] == 0)
//            {
//                set.add(i);
//                int j = i + i;
//                while(j < maxIndex)
//                {
//                    flag[j] = 1;
//                    j += i;
//                }
//             }
//        }
//        System.out.println(set);
        List<Integer> list = new ArrayList<Integer>();
        for(int i = 0; i < a.length; i++)
            list.add(a[i]);
        while(list.size() > 1)
        {
            List<Integer> temp = new ArrayList<>();
            for(int i = 0; i < list.size(); i++)
            {
                if(isSuShu(i + 1))
                    temp.add(list.get(i));
            }
            list = temp;
        }
        return list.get(0);
    }

    public boolean isSuShu(int number)
    {
        boolean flag = true;
        if(number == 1)
            return false;
        for(int i = 2; i <= Math.sqrt(number); i++)
        {
            if(number % i == 0)
            {
                flag = false;
                break;
            }
        }
        return flag;
    }
}
