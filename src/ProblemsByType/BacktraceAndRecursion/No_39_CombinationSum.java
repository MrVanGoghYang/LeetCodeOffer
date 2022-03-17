package ProblemsByType.BacktraceAndRecursion;

import java.util.*;

public class No_39_CombinationSum
{
    /*
    ˼·һ�� �ݹ���ݣ�ÿ����n��ѡ��ѡһ���������������£��ı�target��curRes����targetΪ0ʱ���ӽ�������ܽ��Set�У�����֮ǰ���ӽ��ʹ������+���Set����ȥ�ء�
     */
    // List<List<Integer>> res;
    // Set<List<Integer>> set = new HashSet<>();
    // public List<List<Integer>> combinationSum(int[] candidates, int target) {
    //     Arrays.sort(candidates);
    //     dfs(candidates, target, new ArrayList<Integer>());
    //     res = new ArrayList<>(set);
    //     return res;
    // }

    // public void dfs(int[] candidates, int target, List<Integer> subRes)
    // {
    //     // System.out.println("target: " + target + "  " + subRes + "  " + set);
    //     if(target <= 0)
    //     {
    //         if(target == 0)
    //         {
    //             List<Integer> itemList = new ArrayList(subRes);
    //             Collections.sort(itemList);
    //             if(!set.contains(itemList))
    //                 set.add(new ArrayList<>(itemList));
    //         }
    //         return;
    //     }

    //     for(int i = 0; i < candidates.length; i++)
    //     {
    //         if(target - candidates[i] >= 0)
    //         {
    //             subRes.add(candidates[i]);
    //             dfs(candidates, target - candidates[i], subRes);
    //             subRes.remove(subRes.size() - 1);
    //         }
    //         else
    //             break;
    //     }

    // }

    /*
    ˼·���� �������ϵĻ����ݹ�+����˼�룬���������������оͰ���˳���������������ظ�������������Ļ��Ͳ���Ҫ���ӽ������+ʹ��Setȥ�أ�����Ҫ���ǿ��Լ��ٺܶ��ظ�����ķ�֧��
    ʵ�֣���ÿ��ѡ���˵�i��֮�����µݹ��ʱ��ֻ��Ҫ�ӵ�i����ʼ��ѡ�Ϳ��ԣ�����Ҫ��0�ٿ�ʼ��
    ���縸�ݹ�ѡ�˵�2����֮�����µĺ����ӵݹ��ѡ���Ǵӵ�2������ʼ������ӵ�1����ʼ����Ϊ��ʼѡ�˵�1���������з�֧�Ѿ������˴��г���candidates[0]����һ�����ֵ�����������������Ǻ�������������������˵�һ�����֣���ô���õ��Ĵ�һ���Ѿ���֮ǰ�������
     */
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(candidates, target, 0, new ArrayList<Integer>());
        return res;
    }

    public void dfs(int[] candidates, int target, int begin, List<Integer> subRes)
    {
        if(target <= 0)
        {
            if(target == 0)
                res.add(new ArrayList<>(subRes));
            return;
        }

        for(int i = begin; i < candidates.length; i++)
        {
            if(target - candidates[i] >= 0)
            {
                subRes.add(candidates[i]);
                dfs(candidates, target - candidates[i], i,subRes);
                subRes.remove(subRes.size() - 1);
            }
            else
                break;
        }

    }
}
