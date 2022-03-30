package ProblemsByType.BipartiteTree;
import java.util.*;

public class No_96_UniqueBinSearchTrees
{
    /*
    calBinSearchTree是自己的做法，calBinSearchTree2是看了题解后的修改做法。
    注意到结果值与元素值并无关，只与包含的元素个数有关。那么递归函数可以改进去掉visited、beigin与end只保留count，如果保留那些参数的话可以得到选择顺序的值，生成一棵树出来，但是此题不需要只需要数值即可。
    然后发现count相同会有很多重复计算，使用备忘录HashMap存储计算过的结果减少重复计算。并且设置n为0时返回结果1，那么就不需要涉及有0时做加法了。
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
