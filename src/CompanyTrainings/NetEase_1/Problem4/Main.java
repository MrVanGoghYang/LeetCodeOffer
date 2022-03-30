package CompanyTrainings.NetEase_1.Problem4;
/*
输入例子1:
5 6
1 3
2 1
3 2
3 5
4 5
5 4

输出例子1:
4
 */
import java.util.*;

public class Main
{
    private static List<Set<Integer>> sets;
    public static void main(String[] args)
    {
        Main solution = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sets = new ArrayList<>();
        for(int i = 0; i <= n; i++)
        {
            sets.add(i, new HashSet<>());
        }
        int m = sc.nextInt();
        int[][] pairs = new int[m][2];
        for(int i = 0; i < m; i++)
        {
            pairs[i][0] = sc.nextInt();
            pairs[i][1] = sc.nextInt();
            sets.get(pairs[i][0]).add(pairs[i][1]);
        }
        for(int i = 1; i <= n; i++)
        {
            solution.addPairs(i);
        }
    }

    public void addPairs(int begin)
    {

    }

}
