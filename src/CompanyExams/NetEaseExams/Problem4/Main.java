package CompanyExams.NetEaseExams.Problem4;

import java.util.Scanner;

public class Main
{
    private static int res = Integer.MAX_VALUE;
    private static int tarX = 0;
    private static int tarY = 0;
    private static int[][] visited;
    private static int[][] dir = new int[][]{{0, -1}, {0, 1}, {1, 0}};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rows = sc.nextInt();
        tarX = rows - 1;
        int cols = sc.nextInt();
        tarY = cols - 1;
        int[][] matrix = new int[rows][cols];
        visited = new int[rows][cols];
        for(int i = 0; i < rows; i++)
            for(int j = 0; j < cols; j++)
                matrix[i][j] = sc.nextInt();
        dfs(matrix, 0, 0, 0);
        System.out.println(res);
    }

    public static void dfs(int[][] matrix,int x, int y, int cost)
    {
        if(x == tarX && y == tarY)
        {
            if(cost < res)
                res = cost;
            return;
        }
        for(int i = 0; i < 3; i++)
        {
            int newx = x + dir[i][0];
            int newy = y + dir[i][1];
            if(valid(newx, newy) && visited[newx][newy] == 0)
            {
                visited[newx][newy] = 1;
                int movecost = matrix[newx][newy] == matrix[x][y] ? 1 : 2;
                dfs(matrix, newx, newy, cost + movecost);
                visited[newx][newy] = 0;
            }
        }
    }

    public static boolean valid(int x, int y)
    {
        return x >= 0 && x <= tarX && y >= 0 && y <= tarY;
    }
}