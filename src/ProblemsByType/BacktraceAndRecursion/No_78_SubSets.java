package ProblemsByType.BacktraceAndRecursion;

import java.util.*;

public class No_78_SubSets
{
    /*
    ˼·һ���ݹ�д�������Ӽ����㷽ʽ: nums[unionNumIndex] �� ʣ��Ԫ�ص����Ӽ��е�ÿ����� �� nums[unionNumIndex]����ʣ��Ԫ�ص����Ӽ��е�ÿ���������ô��ÿ��ѡ��ʣ��Ԫ�صĵ�1����nums[unionNumIndex]��������ʣ��Ԫ�ص����Ӽ���������
    */
//    public List<List<Integer>> subsets(int[] nums) {
//        List<List<Integer>> res = new ArrayList<>();
//        res.add(new ArrayList<Integer>());
//        dfs(nums, 0, res);
//        return res;
//    }
//
//    public void dfs(int[] nums, int unionNumIndex, List<List<Integer>> curRes)
//    {
//        // ��ʼ����
//        List<Integer> singleList = new ArrayList<>();
//        singleList.add(nums[unionNumIndex]);
//        curRes.add(singleList);
//        // �ݹ��˳��������ڴ�����жϣ��� = nums.length - 1ʱ�˳�������д���ڴ���ǰ�жϵ� = nums.lenth�˳���д����һ����Ч�ݹ飬Ч�ʸ��ߡ�
//        if(unionNumIndex == (nums.length - 1))
//            return;
//        //��һ��ݹ�
//        List<List<Integer>> subRes = new ArrayList<>();
//        dfs(nums, unionNumIndex + 1, subRes);
//        // �ݹ����
//        for(List<Integer> list : subRes)
//        {
//            curRes.add(list);
//            List<Integer> subRes1 = new ArrayList<Integer>(list);
//            subRes1.add(nums[unionNumIndex]);
//            curRes.add(subRes1);
//        }
//    }

    /*
    ˼·��������д������ÿ�ο���ѡ���Ԫ��Ҳ���Բ�ѡ���Ԫ�أ���������ôÿ��Ԫ�ض�ѡ�õ��ľ���ԭ���ϣ�ÿ��Ԫ�ض���ѡ�õ��ľ��ǿռ������Ƕ�������������
     */
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> curres = new ArrayList<>();
        dfs(nums, 0, curres);
        return res;
    }

    public void dfs(int[] nums, int index, List<Integer> curRes)
    {
        // �˳�����
        if(index == nums.length)
        {
            res.add(new ArrayList<>(curRes));
            return;
        }
        // �������п��ܵ�ѡ�� ��Ԫ��ѡ / ��Ԫ�ز�ѡ
        // ѡ��
        curRes.add(nums[index]);
        // �ݹ�
        dfs(nums, index + 1, curRes);
        // ���ݳ���ѡ��
        curRes.remove(curRes.size() - 1);
        // ��ѡ�� �ݹ� �޻���
        dfs(nums, index + 1, curRes);
    }

}
