package ProblemsByType.Array;

import java.util.HashMap;

/*
1. ����֮��
����һ���������� nums ��һ������Ŀ��ֵ target�������ڸ��������ҳ� ��ΪĿ��ֵ target  ���� ���� ���������������ǵ������±ꡣ
����Լ���ÿ������ֻ���Ӧһ���𰸡����ǣ�������ͬһ��Ԫ���ڴ��ﲻ���ظ����֡�
����԰�����˳�򷵻ش𰸡�
ʾ�� 1��
���룺nums = [2,7,11,15], target = 9
�����[0,1]
���ͣ���Ϊ nums[0] + nums[1] == 9 ������ [0, 1] ��
ʾ�� 2��
���룺nums = [3,2,4], target = 6
�����[1,2]
ʾ�� 3��
���룺nums = [3,3], target = 6
�����[0,1]

˼·��ʹ��HashMap����Ԫ��ֵ���±��ӳ���ϵ����ע��Ϊ�˷�ֹ���ظ�Ԫ������ʾ��3����Key��ͻ��Ӧ�����ж�HashMap���Ƿ����target - nums[i]�ټ��롣
��Ϊ��Ҫ�����±꣬���Բ��ܶ���������ᶪʧ�±���Ϣ��
 */
public class No_1_TwoNumsSum
{
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++)
        {
            if(map.containsKey(target - nums[i]))
            {
                res[0] = map.get(target - nums[i]);
                res[1] = i;
                break;
            }
            else
            {
                map.put(nums[i], i);
            }
        }
        return res;
    }
}