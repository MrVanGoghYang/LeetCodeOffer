package CompanyExams.NetEaseExams.Problem3;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean isOdd = n % 2 == 1 ;
        for(int i = 2; i <= n; i += 2)
            System.out.print(i + " ");
        int oddBegin = isOdd ? n : n - 1;
        for(int i = oddBegin; i >= 1; i -= 2)
        {
            System.out.print(i);
            if(i != 1)
                System.out.print(" ");
        }
    }
}
