package ProblemsByType.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
˼·���ɶ����͡������͡������Ϳɵõ��ݹ��N���ͣ�n = 2Ϊbase case��ֱ���������ͣ�n > 3��ݹ����
 */
public class nNumsSum
{
    public static void main(String[] args)
    {
        int[] nums = {1,0,-1,0,-2,2};
        int target = 0;
        int n = 4;
        Arrays.sort(nums);
        System.out.println(new nNumsSum().recurseNSum(nums, n, 0, target));
    }

    public List<List<Integer>> recurseNSum(int[] nums, int n, int begin, int target)
    {
        List<List<Integer>> res = new ArrayList<>();
        // base case ������
        if(n == 2)
        {
            int p = begin;
            int q = nums.length - 1;
            while(p < q)
            {
                int sum = nums[p] + nums[q];
                if(sum < target)
                {
                    // ��һ����pָ��ȥ���ƶ�
                    while (p < q && nums[++p] == nums[p - 1]) ;
                }
                else if(sum > target)
                {
                    // �ڶ�����qָ��ȥ���ƶ�
                    while(p < q && nums[--q] == nums[q + 1]);
                }
                else
                {
                    res.add(new ArrayList<Integer>(Arrays.asList(nums[p], nums[q])));
                    // ��һ����pָ��ȥ���ƶ�
                    while (p < q && nums[++p] == nums[p - 1]) ;
                    // �ڶ�����qָ��ȥ���ƶ�
                    while(p < q && nums[--q] == nums[q + 1]);
                }
            }
        }
        else // ���������͵ݹ����
        {
            // �̶���1λ
            for(int i = begin; i <= nums.length - n; i++)
            {
                // �ݹ��������⣬��i + 1��ʼɨ�裬Ŀ��Ϊ�ҵ�n - 1����Ϊtarget - nums[i]�Ľ����
                List<List<Integer>> subRes = recurseNSum(nums, n - 1, i + 1, target - nums[i]);
                // ��������n-1���ͽ�������뵱ǰ�̶��ĵ�1λ�����õ�n����
                for(List list : subRes)
                {
                    list.add(nums[i]);
                    res.add(list);
                }
                // �Ե�1λ��ȥ���ƶ�
                while(i + 1 <= nums.length - n && nums[i + 1] == nums[i])   i++;
            }
        }
        return res;
    }
}
