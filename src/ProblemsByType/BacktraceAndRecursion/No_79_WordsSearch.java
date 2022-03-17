package ProblemsByType.BacktraceAndRecursion;

import java.util.*;

/*
思路：常规回溯 + 方向数组 + visited数组
 */
public class No_79_WordsSearch
{
    int[][] dir = new int[][]{{-1, 0},{0, 1},{1, 0},{0, -1}};
    int[][] visited;
    int m = 0;
    int n = 0;
    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        visited = new int[m][n];
        for(int i = 0; i < m; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(dfs(board, i, j, word, 0))
                    return true;

            }
        }
        return false;
    }

    public boolean dfs(char[][] board, int x, int y, String word, int index)
    {
        if(board[x][y] != word.charAt(index))
            return false;
        else if(index == word.length() - 1)
            return true;
        visited[x][y] = 1;
        for(int i = 0; i < 4; i++)
        {
            if(valid(x + dir[i][0], y + dir[i][1]) && visited[x + dir[i][0]][y + dir[i][1]] == 0)
            {
                visited[x + dir[i][0]][y + dir[i][1]] = 1;
                if(dfs(board, x + dir[i][0], y + dir[i][1], word, index + 1))
                    return true;
                visited[x + dir[i][0]][y + dir[i][1]] = 0;
            }
        }
        visited[x][y] = 0;
        return false;
    }

    public boolean valid(int x, int y)
    {
        if(x < 0 || x >= m)
            return false;
        if(y < 0 || y >= n)
            return false;
        return true;
    }
}
