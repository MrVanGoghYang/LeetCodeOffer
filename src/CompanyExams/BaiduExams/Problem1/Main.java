package CompanyExams.BaiduExams.Problem1;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int max = 0;
        for(int i = 1; i <= k; i++)
        {
            int multi = n * i;
//            System.out.println(multi);
            StringBuilder sb = new StringBuilder(String.valueOf(multi));
            sb.reverse();
            int reverse = Integer.parseInt(sb.toString());
            max = Math.max(max, reverse);
        }
//        System.out.println();
        System.out.println(max);
    }
}