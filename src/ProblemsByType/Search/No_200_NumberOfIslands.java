package ProblemsByType.Search;

public class No_200_NumberOfIslands
{
    /*
    ˼·����ͨ�������⣬����ʹ��dfs��bfs��ע�⣺1.����Ҫʹ�ö���visited���飬����ֱ���޸������Ķ�ά��������ѷ��ʣ� 2.bfsʱ����Ԫ�ز�Ҫ��Ƴ����飬�ᳬ���ڴ����ơ�
     */
    private static int[][] dir = new int[][]{{-1, 0},{0, 1},{1, 0},{0, -1}};
    private static int rows = 0;
    private static int cols = 0;
    public int numIslands(char[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int res = 0;
        for(int i = 0; i < rows; i++)
        {
            for(int j = 0; j < cols; j++)
            {
                if(grid[i][j] == '1' && !visited[i][j])
                {
                    res++;
                    dfs(grid, visited, i, j);
                }
            }
        }
        return res;
    }

    public void dfs(char[][] grid, boolean[][] visited, int x, int y)
    {
        visited[x][y] = true;
        for(int l = 0; l < 4; l++)
        {
            int newx = x + dir[l][0];
            int newy = y + dir[l][1];
            if(valid(newx, newy) && grid[newx][newy] == '1' && !visited[newx][newy])
                dfs(grid, visited, newx, newy);
        }
    }

    public boolean valid(int x, int y)
    {
        return x >= 0 && x < rows && y >= 0 && y < cols;
    }
}
