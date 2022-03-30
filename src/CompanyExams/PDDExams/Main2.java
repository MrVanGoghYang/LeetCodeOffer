package CompanyExams.PDDExams;

import java.util.*;;

public class Main2
{
    public static void main(String[] args)
    {
        Main2 solution = new Main2();
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        sc.nextLine();
        String input = sc.nextLine();
        System.out.print(solution.decode(input, k));
    }

    public String decode(String input, int k)
    {
        int len = input.length();
        StringBuilder res = new StringBuilder();
        TreeSet<Integer> set = new TreeSet<>();
        for(int i = len - 1; i >= 0; i--)
        {
            if(input.charAt(i) == '1')
            {
                if((i + k < len && set.contains(i + k)) || (i - k >= 0 && set.contains(i - k)))
                    continue;
                if(i + k < len)
                {
                    if(!set.contains(i + k))
                        set.add(i + k);
                    else
                        continue;
                }
                else if(i - k >= 0)
                {
                    if(!set.contains(i - k))
                        set.add(i - k);
                    else
                        continue;
                }
            }
        }
        int pre = 0;
        for(Integer item : set)
        {
            for(int i = pre; i < item; i++)
                res.append('0');
            res.append('1');
            pre = item + 1;
        }
        while(res.length() < input.length())
            res.append('0');
        return res.toString();
    }
}
