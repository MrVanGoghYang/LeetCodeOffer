package CompanyTrainings.Huawei_2.Problem3;

import java.util.*;
public class Main
{
    private static String[] points = new String[]{"3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2", "joker", "JOKER"};
    private static Map<String, Integer> map= new HashMap<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i < points.length; i++)
            map.put(points[i], i);

        String[] inpout = sc.nextLine().split("-");
        String[] first = inpout[0].split(" ");
        int firstType = type(first, first.length);
        String[] second = inpout[1].split(" ");
        int secondType = type(second, second.length);

        // 存在王炸情况直接输出
        if(firstType == 6 || secondType == 6)
        {
            if (firstType == 6) System.out.println(first[0] + " " + first[1]);
            if (secondType == 6) System.out.println(second[0] + " " + second[1]);
            return;
        }
        // 存在炸弹，比较炸弹大小
        else if(firstType == 4 || secondType == 4)
        {
            if (firstType == 4 && secondType == 4)
            {
                if (map.get(first[0]) > map.get(second[0])) System.out.println(inpout[0]);
                else System.out.println(inpout[1]);
            }
            else if (firstType == 4)
                System.out.println(inpout[0]);
            else System.out.println(inpout[1]);
            return;
        }
        // 不包含王炸和炸弹，必须类型相同才能比较
        if(firstType == secondType)
        {
            if (map.get(first[0]) > map.get(second[0])) System.out.println(inpout[0]);
            else System.out.println(inpout[1]);
        }
        else
            System.out.println("ERROR");
    }

    // 判断牌型，个子 1 对子 2 三个 3 炸弹 4 顺子 5 王炸6 其余0
    public static int type(String[] arr, int len)
    {
        if(len == 1)
            return 1;
        else if(len == 2 && arr[0].equals(arr[1]))
            return 2;
        else if(len == 2 && (arr[0].equals("joker") && arr[1].equals("JOKER")) || (arr[0].equals("JOKER") && arr[1].equals("joker")))
            return 6;
        else if(len == 3 && arr[0].equals(arr[1]) && arr[1].equals(arr[2]))
            return 3;
        else if(len == 4 && arr[0].equals(arr[1]) && arr[1].equals(arr[2]) && arr[2].equals(arr[3]))
            return 4;
        else if(len == 5 && map.get(arr[1]) == map.get(arr[0]) + 1 && map.get(arr[2]) == map.get(arr[1]) + 1 && map.get(arr[3]) == map.get(arr[2]) + 1
                            && map.get(arr[4]) == map.get(arr[3]) + 1 && map.get(arr[4]) <= 11)
            return 5;
        return 0;
    }

}