package ProblemsByType.BipartiteTree;
import java.util.*;

public class No_96_UniqueBinSearchTrees
{
    /*
    calBinSearchTree���Լ���������calBinSearchTree2�ǿ���������޸�������
    ע�⵽���ֵ��Ԫ��ֵ���޹أ�ֻ�������Ԫ�ظ����йء���ô�ݹ麯�����ԸĽ�ȥ��visited��beigin��endֻ����count�����������Щ�����Ļ����Եõ�ѡ��˳���ֵ������һ�������������Ǵ��ⲻ��Ҫֻ��Ҫ��ֵ���ɡ�
    Ȼ����count��ͬ���кܶ��ظ����㣬ʹ�ñ���¼HashMap�洢������Ľ�������ظ����㡣��������nΪ0ʱ���ؽ��1����ô�Ͳ���Ҫ�漰��0ʱ���ӷ��ˡ�
    */
    HashMap<Integer, Integer> map = new HashMap<>();

    public int numTrees(int n) {
        boolean[] visited = new boolean[n + 1];
        // return calBinSearchTree(visited, 1, n, n);
        return calBinSearchTree2(n);
    }

    public int calBinSearchTree2(int count)
    {
        if(count == 0 || count == 1)
            return 1;
        if(map.containsKey(count))
            return map.get(count);
        int res = 0;
        for(int i = 1; i <= count; i++)
        {
            int left = calBinSearchTree2(i - 1);
            int right = calBinSearchTree2(count - i);
            res += left * right;
            map.put(count, res);
        }
        return res;
    }

    public int calBinSearchTree(boolean[] visited, int begin, int end, int count)
    {
        if(begin > end)
            return 0;
        if(count == 1 || count == 2)
            return count;

        int res = 0;
        for(int i = begin; i <= end; i++)
        {
            if(!visited[i])
            {
                visited[i] = true;
                int left = calBinSearchTree(visited, begin, i - 1, i - begin);
                int right = calBinSearchTree(visited, i + 1, end, end - i);
                visited[i] = false;

                if(left == 0 || right == 0)
                    res += (left + right);
                else
                    res += left * right;
            }
        }
        return res;
    }
}
