package ProblemsByType.Graph;

import java.util.*;

/*
链接：https://leetcode-cn.com/problems/possible-bipartition

示例 1：
输入：n = 4, dislikes = [[1,2],[1,3],[2,4]]
输出：true
解释：group1 [1,4], group2 [2,3]

示例 2：
输入：n = 3, dislikes = [[1,2],[1,3],[2,3]]
输出：false

示例 3：
输入：n = 5, dislikes = [[1,2],[2,3],[3,4],[4,5],[1,5]]
输出：false

思路：DFS遍历图，领结点染成不同的颜色，0未染色，1黑色，2白色，当发现邻结点和本结点颜色相同则说明无法二分
 */
public class No_886_PossibleBipartite
{
    public static void main(String[] args)
    {
        No_886_PossibleBipartite solution = new No_886_PossibleBipartite();
        int n = 5;
        int[][] dislikes = new int[][]{{1,2},{2,3},{3,4},{4,5},{1,5}};
        System.out.println(solution.possibleBipartition(n, dislikes));
    }

    // bfs求是否能二分
    public boolean possibleBipartition(int n, int[][] dislikes) {
        if(dislikes.length == 0)
            return true;
        // 染色数组，0 代表未染色 1 代表染白色即第一组 2 代表黑色即第二组
        int[] color = new int[n];
        boolean flag = true;
        // 构建图的领接表,List数组存储
        ArrayList<Integer>[] graph = new ArrayList[n];
        for(int i = 0; i < n; i++)
        {
            graph[i] = new ArrayList<>();
        }
        for(int[] edge : dislikes)
        {
            graph[edge[1] - 1].add(edge[0] - 1);
            graph[edge[0] - 1].add(edge[1] - 1);

        }
        // BFS判断是graph否为二分图
        Queue<Integer> queue = new LinkedList<>();
        // 每个未染色结点都开始一次，避免非连同图
        for(int i = 0; i < n; i++)
        {
            if(color[i] == 0)
            {
                color[i] = 1;
                queue.offer(i);
                while(!queue.isEmpty())
                {
                    int top = queue.poll();
                    for(int j = 0; j < graph[top].size(); j++)
                    {
                        int neigh = graph[top].get(j);
                        if(color[neigh] == 0)
                        {
                            color[neigh] = 3 - color[top];
                            queue.offer(neigh);
                        }
                        else if(color[neigh] == color[top])
                        {
                            flag = false;
                            break;
                        }
                    }
                }
                // 每个连通图跳出while循环判断是否失败，失败就返回。但不需要判断染色结点的个数是否等于结点总数。
                if(!flag)
                    break;
            }
        }
        return flag;
    }
}
