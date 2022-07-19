package CompanyExams.XiechengExams.Problem1;
import java.util.*;
public class Main
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Main solution = new Main();
        solution.drawU(n);
    }

    public void drawU(int n)
    {
        for(int i = 0; i < 3 * n; i++)
        {
            for(int j = 0; j < n; j++)
                System.out.print("*");
            for(int j = 0; j < 2 * n; j++)
                System.out.print(".");
            for(int j = 0; j < n; j++)
            {
                System.out.print("*");
//                if(j != n - 1)
//                    System.out.print("");
            }
            System.out.println();
        }

        for(int i = 0; i < n; i++)
        {
            int firstPoint = i + 1;
            int secondStar = n;
            int thirdPoint = n - (firstPoint);

            for(int k = 0; k < firstPoint; k++)
                System.out.print(".");
            for(int k = 0; k < secondStar; k++)
                System.out.print("*");
            for(int k = 0; k < thirdPoint; k++)
            {
                System.out.print(".");
            }

            for(int k = 0; k < thirdPoint; k++)
                System.out.print(".");
            for(int k = 0; k < secondStar; k++)
                System.out.print("*");
            for(int k = 0; k < firstPoint; k++)
            {
                System.out.print(".");
//                if(k != firstPoint - 1)
//                    System.out.print(" ");
            }
            if(i != n - 1)
                System.out.println();
        }
    }
}
