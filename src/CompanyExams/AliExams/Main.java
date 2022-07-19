package CompanyExams.AliExams;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = 0;
        int y = 0;
        int row = sc.nextInt();
        int col = sc.nextInt();
        sc.nextLine();
        char[][] arr = new char[row][col];
        for(int i = 0; i < row; i++)
        {
            String input = sc.nextLine();
            for(int j = 0; j < col; j++)
            {
                arr[i][j] = input.charAt(j);
                if(arr[i][j] == '*')
                {
                    x = i;
                    y = j;
                }
            }
        }
        String command = sc.nextLine();
        int res = 0;

        for(int i = 0; i < command.length(); i++)
        {
            char dir = command.charAt(i);
            int x2 = x + moveX(dir);
            int y2 = y + moveY(dir);
            if(x2 >= 0 && x2 < row && y2 >= 0 && y2 < col)
            {
                x = x2;
                y = y2;
                if(arr[x2][y2] == '$')
                {
                    res += 1;
                    arr[x2][y2] = '.';
                }
            }

        }

        System.out.print(res);

    }

    public static int moveX(char c)
    {
        if(c == 'W')
        {
            return -1;
        }
        else if(c == 'S')
        {
            return 1;
        }
        else
        {
            return 0;
        }
    }

    public static int moveY(char c)
    {
        if(c == 'A')
        {
            return -1;
        }
        else if(c == 'D')
        {
            return 1;
        }
        else
        {
            return 0;
        }
    }
}
