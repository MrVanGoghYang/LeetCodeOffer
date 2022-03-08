package ProblemsByType.Graph;

/*
ʾ�� 1��
���룺graph = [[1,2,3],[0,2],[0,1,3],[0,2]]
�����false
���ͣ����ܽ��ڵ�ָ�������������Ӽ�����ʹÿ���߶���ͨһ���Ӽ��е�һ���ڵ�����һ���Ӽ��е�һ���ڵ㡣
ʾ�� 2��
���룺graph = [[1,3],[0,2],[1,3],[0,2]]
�����true
���ͣ����Խ��ڵ�ֳ�����: {0, 2} �� {1, 3}

˼·��DFS����ͼ������Ⱦ�ɲ�ͬ����ɫ��0δȾɫ��1��ɫ��2��ɫ���������ڽ��ͱ������ɫ��ͬ��˵���޷�����
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
        // ѭ���������ͬͼ
        for(int i = 0; i < graph.length; i++)
        {
            // ��¼�¸���ͬͼ�Ķ��ֽ��
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
        //δȾɫ Ĭ����Ⱦ1 ����ν1 2
        if(color[begin] == 0)
            color[begin] = 1;
        for(int i = 0; i < graph[begin].length; i++)
        {
            // �ڽ��δȾɫ����ô��Ⱦ�ɲ�ͬ��ɫ����DFS�ݹ飬��¼�ݹ��������ڽ�㿪ʼ�������Ⱦɫ�Ķ��ֽ��
            if(color[graph[begin][i]] == 0)
            {
                color[graph[begin][i]] = 3 - color[begin];
                flag = dfs(graph, color, graph[begin][i]);
            }
            // ���ڽ����ɫ�뱾�����ͬ�򲻿ɶ���
            else if(color[graph[begin][i]] == color[begin])
            {
                flag = false;
            }
            // һ��flag��Ϊfalse�ˣ���˵����ǰbegin��ʼ����ͬͼ���ɶ��֣���ֹѭ��
            if(!flag)
                break;
        }
        return flag;
    }
}
