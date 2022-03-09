package ProblemsByType.Graph;

import java.util.*;

/*
���ӣ�https://leetcode-cn.com/problems/possible-bipartition

ʾ�� 1��
���룺n = 4, dislikes = [[1,2],[1,3],[2,4]]
�����true
���ͣ�group1 [1,4], group2 [2,3]

ʾ�� 2��
���룺n = 3, dislikes = [[1,2],[1,3],[2,3]]
�����false

ʾ�� 3��
���룺n = 5, dislikes = [[1,2],[2,3],[3,4],[4,5],[1,5]]
�����false

˼·��DFS����ͼ������Ⱦ�ɲ�ͬ����ɫ��0δȾɫ��1��ɫ��2��ɫ���������ڽ��ͱ������ɫ��ͬ��˵���޷�����
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

    // bfs���Ƿ��ܶ���
    public boolean possibleBipartition(int n, int[][] dislikes) {
        if(dislikes.length == 0)
            return true;
        // Ⱦɫ���飬0 ����δȾɫ 1 ����Ⱦ��ɫ����һ�� 2 �����ɫ���ڶ���
        int[] color = new int[n];
        boolean flag = true;
        // ����ͼ����ӱ�,List����洢
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
        // BFS�ж���graph��Ϊ����ͼ
        Queue<Integer> queue = new LinkedList<>();
        // ÿ��δȾɫ��㶼��ʼһ�Σ��������ͬͼ
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
                // ÿ����ͨͼ����whileѭ���ж��Ƿ�ʧ�ܣ�ʧ�ܾͷ��ء�������Ҫ�ж�Ⱦɫ���ĸ����Ƿ���ڽ��������
                if(!flag)
                    break;
            }
        }
        return flag;
    }
}
