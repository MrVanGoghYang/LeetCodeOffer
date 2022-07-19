package CompanyExams.TencentExams.Problem1;

import java.util.*;

public class Main
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] input = new String[n];
        sc.nextLine();
        for(int i = 0; i < n; i++)
            input[i] = sc.nextLine();

        int len = input[0].length();
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < len; i++)
        {
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < n; j++)
                sb.append(input[j].charAt(i));
            Integer subRes = Integer.valueOf(sb.toString());
            list.add(subRes);
        }
        Collections.sort(list);
        for(int i = 0; i < list.size(); i++)
        {
            System.out.print(list.get(i));
            if(i != list.size() - 1) System.out.print(" ");
        }
    }
}
