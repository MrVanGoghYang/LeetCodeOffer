package CompanyExams.TencentExams.Problem3;

import java.util.*;

public class Main
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
//        long[] attackSum = new long[n + 1];
//        long[] defendSum = new long[n + 1];
        long min = Long.MAX_VALUE;
        sc.nextLine();
        String input = sc.nextLine();
        long defend = 0;
        for(int i = 0; i < n; i++)
        {
            char front = input.charAt(i);
            if(front == '1')
                defend += i + 1;
        }
        long attack = 0;
        for(int i = 0; i < n; i++)
        {
            char front = input.charAt(i);
            if(front == '0')
                attack += i + 1;
            else
                defend -= i + 1;
            min = Math.min(min, Math.abs(attack - defend));
        }
        System.out.print(min);
    }
}
