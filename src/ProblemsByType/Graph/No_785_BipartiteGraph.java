package ProblemsByType.Graph;

/*
示例 1：
输入：graph = [[1,2,3],[0,2],[0,1,3],[0,2]]
输出：false
解释：不能将节点分割成两个独立的子集，以使每条边都连通一个子集中的一个节点与另一个子集中的一个节点。
示例 2：
输入：graph = [[1,3],[0,2],[1,3],[0,2]]
输出：true
解释：可以将节点分成两组: {0, 2} 和 {1, 3}

思路：DFS遍历图，领结点染成不同的颜色，0未染色，1黑色，2白色，当发现邻结点和本结点颜色相同则说明无法二分
 */
public class No_785_BipartiteGraph
{
    public static void main(String[] args)
    {
        No_785_BipartiteGraph solution = new No_785_BipartiteGraph();
//        int[][] graph = new int[][]{{1,2,3}, {0,2}, {0,1,3}, {0,2}};
        int[][] graph = new int[][]{{1,3}, {0,2,3}, {1,3}, {0,1,2}};
        System.out.println(solution.isBipartite(graph));
    }

    public boolean isBipartite(int[][] graph) {
        boolean flag = true;
        int[] color = new int[graph.length];
        // 循环避免非连同图
        for(int i = 0; i < graph.length; i++)
        {
            // 记录下该连同图的二分结果
            if(color[i] == 0)
                flag = dfs(graph, color, i);
            if(!flag)
                break;
        }
        return flag;
    }

    public boolean dfs(int[][] graph, int[] color, int begin)
    {
        boolean flag = true;
        //未染色 默认先染1 无所谓1 2
        if(color[begin] == 0)
            color[begin] = 1;
        for(int i = 0; i < graph[begin].length; i++)
        {
            // 邻结点未染色，那么就染成不同颜色，并DFS递归，记录递归结果即从邻结点开始往后继续染色的二分结果
            if(color[graph[begin][i]] == 0)
            {
                color[graph[begin][i]] = 3 - color[begin];
                flag = dfs(graph, color, graph[begin][i]);
            }
            // 即邻结点颜色与本结点相同则不可二分
            else if(color[graph[begin][i]] == color[begin])
            {
                flag = false;
            }
            // 一旦flag变为false了，则说明当前begin开始的连同图不可二分，终止循环
            if(!flag)
                break;
        }
        return flag;
    }
}
