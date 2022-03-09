package ProblemsByType.Graph;

import java.util.*;

/*
https://leetcode-cn.com/problems/course-schedule/
ʾ�� 1��
���룺numCourses = 2, prerequisites = [[1,0]]
�����true
���ͣ��ܹ��� 2 �ſγ̡�ѧϰ�γ� 1 ֮ǰ������Ҫ��ɿγ� 0 �����ǿ��ܵġ�
ʾ�� 2��

���룺numCourses = 2, prerequisites = [[1,0],[0,1]]
�����false
���ͣ��ܹ��� 2 �ſγ̡�ѧϰ�γ� 1 ֮ǰ������Ҫ����ɿγ� 0 ������ѧϰ�γ� 0 ֮ǰ���㻹Ӧ����ɿγ� 1 �����ǲ����ܵġ�

˼·�����������жϻ��������DFS���൱��ͼ�ı���������ҪinDegrees��ʶ��BFS��ҪinDegrees��ʶ��ͼ������ӱ�洢Ч�ʸߡ�
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
        // ����ͼ����ӱ�,List����洢
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

        // DFS����
        int[] visited = new int[numCourses]; // 0:δ���� 1�������� 2���ѷ���
        for(int i = 0; i < numCourses; i++)
        {
            // �������ͬͼ
            if(visited[i] == 0)
                dfs(graph, visited, i);
            // dfs֮������л���ֱ���˳�������ѭ������֦
            if(hasCycle)
                break;
        }

//        // BFS����
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
        // �ö����ڵ�ǰ���ڷ��ʵ�·���ϣ�˵���л�
        if(visited[begin] == 1)
        {
            hasCycle = true;
            return;
        }
        // �ö���֮ǰ�����ʹ�����ô˵������������޻��ģ�����Ҫ�ټ���������������
        if(visited[begin] == 2)
        {
            return;
        }
        // ѡ��õ㣬�޸�visited = 1 ��ʶ�õ����ڷ��ʵ�·����
        visited[begin] = 1;
        // ��begin�������ڽӵ�ݹ�
        for(int i = 0; i < graph[begin].size(); i++)
        {
            int neighbor = (int)graph[begin].get(i);
            dfs(graph,visited,neighbor);
            // dfs֮������л���ֱ���˳�������ѭ������֦
            if(hasCycle)
                return;
        }
        // ����ѡ���޸�visited = 2 ��ʶ�Ѿ����ʹ�
        visited[begin] = 2;
    }
}
