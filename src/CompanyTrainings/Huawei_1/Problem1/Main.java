package CompanyTrainings.Huawei_1.Problem1;

import java.util.Scanner;
public class Main
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext())
        {
            int emptyNum = sc.nextInt();
            if(emptyNum == 0)
                return;
            int res = 0;
            while(emptyNum >= 3)
            {
                int exchangeNum = emptyNum / 3;
                res += exchangeNum;
                emptyNum = emptyNum % 3 + exchangeNum;
            }
            if(emptyNum == 2)
                res += 1;
            System.out.println(res);
        }
    }
}