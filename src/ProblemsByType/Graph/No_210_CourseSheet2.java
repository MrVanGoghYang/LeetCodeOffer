package ProblemsByType.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*
示例 1：
输入：numCourses = 2, prerequisites = [[1,0]]
输出：[0,1]
解释：总共有 2 门课程。要学习课程 1，你需要先完成课程 0。因此，正确的课程顺序为 [0,1] 。
示例 2：
输入：numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
输出：[0,2,1,3]
解释：总共有 4 门课程。要学习课程 3，你应该先完成课程 1 和课程 2。并且课程 1 和课程 2 都应该排在课程 0 之后。
因此，一个正确的课程顺序是?[0,1,2,3] 。另一个正确的排序是?[0,2,1,3] 。
示例 3：
输入：numCourses = 1, prerequisites = []
输出：[0]

思路：拓扑排序判断环，如果用DFS就相当于图的遍历，不需要inDegrees标识；BFS需要inDegrees标识。图采用领接表存储效率高。
*/
public class No_210_CourseSheet2
{
    private static ArrayList<Integer> res;
    public static void main(String[] args)
    {
        No_210_CourseSheet2 solution = new No_210_CourseSheet2();
        int numCourses = 3;
        int[][] pre = new int[][]{{1,0},{0,1},{1,2}};
//        int numCourses = 4;
//        int[][] pre = new int[][]{{1,0},{2,0},{3,1},{3,2}};

//        int numCourses = 4;
//        int[][] pre = new int[][]{{1,0},{2,0},{2,1},{3,2}};
//        int numCourses = 4;
//        int[][] pre = new int[][]{{1,0},{2,0},{2,1},{3,2},{1,3}};
//        int numCourses = 20;
//        int[][] pre = new int[][]{{0,10},{3,18},{5,5},{6,11},{11,14},{13,1},{15,1},{17,4}};
        System.out.println(Arrays.toString(solution.findOrder(numCourses, pre)));
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] graph = new ArrayList[numCourses];
        res = new ArrayList<>();
        int[] inDegrees = new int[numCourses];
        // 构造有向图并记录每个结点入度
        for(int i = 0; i < numCourses; i++)
        {
            graph[i] = new ArrayList<>();
        }
        for(int[] edge : prerequisites)
        {
            graph[edge[1]].add(edge[0]);
            inDegrees[edge[0]]++;
        }
        // bfs拓扑排序,res记录排序结果
        bfs(graph, inDegrees);
        // 将结果由List转为int[]返回
        int[] resArr = new int[0];
        if(res.size() == numCourses)
        {
            resArr = new int[res.size()];
            for (int j = 0; j < resArr.length; j++)
            {
                resArr[j] = res.get(j);
            }
        }
        return resArr;
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
            res.add(head);
            for(Integer end : graph[head])
            {
                inDegrees[end]--;
                if(inDegrees[end] == 0)
                    queue.offer(end);
            }
        }
    }

}
