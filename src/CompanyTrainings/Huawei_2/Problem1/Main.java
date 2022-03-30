package CompanyTrainings.Huawei_2.Problem1;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext())
        {
            int N = sc.nextInt();
            int[] scores = new int[N];
            int M = sc.nextInt();
            String[][] ope = new String[M][3];
            for(int i = 0; i < N; i++)
                scores[i] = sc.nextInt();
            sc.nextLine();
            for(int i = 0; i < M; i++)
            {
                ope[i] = sc.nextLine().split(" ");
                if(ope[i][0].equals("Q"))
                {
                    int max = 0;
                    for(int k = Math.min(Integer.parseInt(ope[i][1]) - 1, Integer.parseInt(ope[i][2]) - 1); k <= Math.max(Integer.parseInt(ope[i][1]) - 1, Integer.parseInt(ope[i][2]) - 1); k++)
                        max = Math.max(max, scores[k]);
                    System.out.println(max);
                }
                else
                {
                    scores[Integer.parseInt(ope[i][1]) - 1] = Integer.parseInt(ope[i][2]);
                }
            }
        }
    }
}