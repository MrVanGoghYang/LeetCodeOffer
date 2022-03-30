package CompanyExams.NetEaseGameExams.Problem1;

import java.util.*;

/*
3 3
1 1
2 5 4
2 7 8
2 3 0
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rows = sc.nextInt();
        int cols = sc.nextInt();
        int[][] arr = new int[rows][cols];
        int wantX = sc.nextInt();
        int wantY = sc.nextInt();
        int sum = 0;
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                arr[i][j] = sc.nextInt();
                if(i != wantX - 1 || j != wantY - 1)
                    sum += arr[i][j];
                else
                    sum += 1;
            }
        }
        System.out.print(sum);
    }
}