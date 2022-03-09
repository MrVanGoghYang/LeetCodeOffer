package ProblemsByType.Graph;

import java.util.*;

/*
输入：times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
输出：2

示例 2：
输入：times = [[1,2,1]], n = 2, k = 1
输出：1

示例 3：
输入：times = [[1,2,1]], n = 2, k = 2
输出：-1

 */
public class No_743_NetDelayTimes
{
    class Edge
    {
        int toPoint;
        int weight;
        Edge(int toPoint, int weight)
        {
            this.toPoint = toPoint;
            this.weight = weight;
        }
    }

    public static void main(String[] args)
    {
        No_743_NetDelayTimes solution = new No_743_NetDelayTimes();
//        int[][] times = new int[][]{{2,1,1},{2,3,1},{3,4,1}};
//        int n = 4;
//        int k = 2;
        int[][] times = new int[][]{{1,2,1},{1,3,1},{2,4,2},{3,4,1},{4,5,1}};
        int n = 5;
        int k = 1;
//        int[][] times = new int[][]{{1,2,1}};
//        int n = 2;
//        int k = 2;
        System.out.println(solution.networkDelayTime(times, n, k));
    }

    public int networkDelayTime(int[][] times, int n, int k)
    {
        k = k - 1;
        // 根据带权边构建图的邻结表
        ArrayList<Edge>[] graph = new ArrayList[n];
        for(int i = 0; i < n; i++)
        {
            graph[i] = new ArrayList<>();
        }
        for(int i = 0; i < times.length; i++)
        {
            graph[times[i][0] - 1].add(new Edge(times[i][1] - 1, times[i][2]));
        }
        // Dijkstra计算单源最短路径
        return dijkstra(graph, k);
    }

    public int dijkstra(ArrayList<Edge>[] graph, int begin)
    {
        int maxDis = -1;
        HashSet<Integer> includeNodes = new HashSet<>();
        int[] disArr = new int[graph.length];
        Arrays.fill(disArr, Integer.MAX_VALUE);
        disArr[begin] = 0;
        while (includeNodes.size() < graph.length)
        {
            int min = Integer.MAX_VALUE;
            int minIndex = -1;
            for (int i = 0; i < disArr.length; i++)
            {
                if(!includeNodes.contains(i) && disArr[i] < min)
                {
                    min = disArr[i];
                    minIndex = i;
                }
            }
            // 已找不到最小距离但还未到达所有结点，说明不可达
            if(min == Integer.MAX_VALUE || minIndex == -1)
            {
                maxDis = -1;
                break;
            }
            includeNodes.add(minIndex);
            if(includeNodes.size() < graph.length)
            {
                for (int i = 0; i < graph[minIndex].size(); i++)
                {
                    Edge edge = graph[minIndex].get(i);
                    disArr[edge.toPoint] = Math.min(disArr[edge.toPoint], edge.weight + disArr[minIndex]);
                }
            }
            else
                maxDis = disArr[minIndex];
        }
        return maxDis;
    }
}
