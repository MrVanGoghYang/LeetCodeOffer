package ProblemsByType.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*
ʾ�� 1��
���룺numCourses = 2, prerequisites = [[1,0]]
�����[0,1]
���ͣ��ܹ��� 2 �ſγ̡�Ҫѧϰ�γ� 1������Ҫ����ɿγ� 0����ˣ���ȷ�Ŀγ�˳��Ϊ [0,1] ��
ʾ�� 2��
���룺numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
�����[0,2,1,3]
���ͣ��ܹ��� 4 �ſγ̡�Ҫѧϰ�γ� 3����Ӧ������ɿγ� 1 �Ϳγ� 2�����ҿγ� 1 �Ϳγ� 2 ��Ӧ�����ڿγ� 0 ֮��
��ˣ�һ����ȷ�Ŀγ�˳����?[0,1,2,3] ����һ����ȷ��������?[0,2,1,3] ��
ʾ�� 3��
���룺numCourses = 1, prerequisites = []
�����[0]

˼·�����������жϻ��������DFS���൱��ͼ�ı���������ҪinDegrees��ʶ��BFS��ҪinDegrees��ʶ��ͼ������ӱ�洢Ч�ʸߡ�
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
        // ��������ͼ����¼ÿ��������
        for(int i = 0; i < numCourses; i++)
        {
            graph[i] = new ArrayList<>();
        }
        for(int[] edge : prerequisites)
        {
            graph[edge[1]].add(edge[0]);
            inDegrees[edge[0]]++;
        }
        // bfs��������,res��¼������
        bfs(graph, inDegrees);
        // �������ListתΪint[]����
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
