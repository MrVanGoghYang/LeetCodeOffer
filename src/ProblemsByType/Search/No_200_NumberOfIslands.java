package ProblemsByType.Search;

public class No_200_NumberOfIslands
{
    /*
    思路：普通的搜索题，可以使用dfs或bfs，注意：1.不需要使用额外visited数组，可以直接修改所给的二维数组代表已访问； 2.bfs时队列元素不要设计成数组，会超出内存限制。
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
