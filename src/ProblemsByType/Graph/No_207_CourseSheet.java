package ProblemsByType.Graph;

import java.util.*;

/*
https://leetcode-cn.com/problems/course-schedule/
示例 1：
输入：numCourses = 2, prerequisites = [[1,0]]
输出：true
解释：总共有 2 门课程。学习课程 1 之前，你需要完成课程 0 。这是可能的。
示例 2：

输入：numCourses = 2, prerequisites = [[1,0],[0,1]]
输出：false
解释：总共有 2 门课程。学习课程 1 之前，你需要先完成课程 0 ；并且学习课程 0 之前，你还应先完成课程 1 。这是不可能的。

思路：拓扑排序判断环，如果用DFS就相当于图的遍历，不需要inDegrees标识；BFS需要inDegrees标识。图采用领接表存储效率高。
*/
public class No_207_CourseSheet
{
    private boolean hasCycle = false;
    public static void main(String[] args)
    {
        No_207_CourseSheet solution = new No_207_CourseSheet();
//        int numCourses = 4;
//        int[][] pre = new int[][]{{1,0},{2,0},{2,1},{3,2}};
//        int numCourses = 4;
//        int[][] pre = new int[][]{{1,0},{2,0},{2,1},{3,2},{1,3}};
        int numCourses = 20;
        int[][] pre = new int[][]{{0,10},{3,18},{5,5},{6,11},{11,14},{13,1},{15,1},{17,4}};
        System.out.println(solution.canFinish(numCourses, pre));
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites == null || prerequisites.length == 0)
            return true;
        // 构建图的领接表,List数组存储
        ArrayList<Integer>[] graph = new ArrayList[numCourses];
        int[] inDegrees = new int[numCourses];
        for(int i = 0; i < numCourses; i++)
        {
            graph[i] = new ArrayList<>();
        }
        for(int[] edge : prerequisites)
        {
            graph[edge[1]].add(edge[0]);
            inDegrees[edge[0]]++;
        }

        // DFS遍历
        int[] visited = new int[numCourses]; // 0:未访问 1：访问中 2：已访问
        for(int i = 0; i < numCourses; i++)
        {
            // 避免非连同图
            if(visited[i] == 0)
                dfs(graph, visited, i);
            // dfs之后如果有环，直接退出不继续循环，剪枝
            if(hasCycle)
                break;
        }

//        // BFS遍历
//        bfs(graph, inDegrees);
        return !hasCycle;
    }

    public void bfs(ArrayList<Integer>[] graph, int[] inDegrees)
    {
        int cnt = 0;
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < inDegrees.length; i++)
        {
            if(inDegrees[i] == 0)
                queue.offer(i);
        }
        while (!queue.isEmpty())
        {
            int head = queue.poll();
            cnt++;
            for(Integer end : graph[head])
            {
                inDegrees[end]--;
                if(inDegrees[end] == 0)
                    queue.offer(end);
            }
        }
        if(cnt == inDegrees.length)
            hasCycle = false;
        else
            hasCycle = true;
    }

    public void dfs(ArrayList[] graph, int[] visited, int begin)
    {
        // 该顶点在当前正在访问的路径上，说明有环
        if(visited[begin] == 1)
        {
            hasCycle = true;
            return;
        }
        // 该顶点之前被访问过，那么说明从其出发是无环的，不需要再继续从它出发访问
        if(visited[begin] == 2)
        {
            return;
        }
        // 选择该点，修改visited = 1 标识该点正在访问的路径上
        visited[begin] = 1;
        // 对begin的所有邻接点递归
        for(int i = 0; i < graph[begin].size(); i++)
        {
            int neighbor = (int)graph[begin].get(i);
            dfs(graph,visited,neighbor);
            // dfs之后如果有环，直接退出不继续循环，剪枝
            if(hasCycle)
                return;
        }
        // 撤销选择，修改visited = 2 标识已经访问过
        visited[begin] = 2;
    }
}
