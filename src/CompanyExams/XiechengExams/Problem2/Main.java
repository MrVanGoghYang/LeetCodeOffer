package CompanyExams.XiechengExams.Problem2;

import java.util.*;

public class Main
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int[] arr = new int[len];
        Main solution = new Main();
        for(int i = 0; i < len; i++)
            arr[i] = sc.nextInt();
        sc.nextLine();
        String color = sc.nextLine();
        char[] colorArr = new char[len];
        for(int i = 0; i < color.length(); i++)
            colorArr[i] = color.charAt(i);
        System.out.println(solution.differentWays(arr, colorArr, len));
    }

    public int differentWays(int[] arr, char[] colorArr, int n)
    {
        int res = 0;
        Map<Integer, Integer> redMap = new HashMap<>();
        Map<Integer, Integer> blueMap = new HashMap<>();
        for(int i = 0; i < n; i++)
        {
            int redValue = redMap.getOrDefault(arr[i], 0);
            int blueValue = blueMap.getOrDefault(arr[i], 0);
            if(colorArr[i] == 'R')
                redMap.put(arr[i], redValue + 1);
            else
                blueMap.put(arr[i], blueValue + 1);
        }

        for(Map.Entry<Integer, Integer> item : redMap.entrySet())
        {
            if(blueMap.containsKey(item.getKey()))
                res += item.getValue() * blueMap.get(item.getKey());
        }
        return res;
    }
}
