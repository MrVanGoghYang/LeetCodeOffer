package ProblemsByType.Array;

/*
˼·һ����������һ��ɨ��ֱ�ͳ��0 1 2 �ĸ������ڶ���ɨ����и�ֵ��2�α�����
˼·������ָ�룺ʹ��һ��ָ��p����һ��ɨ�轫���е�0����pָ��λ�ò�p++���ڶ���ɨ�轫���е�1����Ppָ��λ��p++��2�α�����
˼·����˫ָ�룺ʹ��p0��p1����ָ��ֱ�ָ����һ��0����һ��1�Ĳ���λ�ã�һ��ɨ�裬������1ʱ����p1λ�ã�p1++��������0ʱ������p0λ�ã�ע�⣺�˴����p0 < p1��ô˵���˴ν���������1��1����1��1��������iλ�ã���Ҫ�ٽ�iλ����p1λ�ý�������ɺ���Ҫp0++ p1++��Ϊ����0�ᵼ����һ������1��λ��Ҳ���ơ�
 */
public class No_75_SortColors
{
    public void sortColors(int[] nums) {
        if(nums.length == 1)
            return;
        int p0 = 0;
        int p1 = 0;
        for(int i = 0; i < nums.length; i++)
        {
            if(nums[i] == 1)
            {
                int item = nums[p1];
                nums[p1] = 1;
                nums[i] = item;
                p1++;
            }
            else if(nums[i] == 0)
            {
                int item = nums[p0];
                nums[p0] = 0;
                nums[i] = item;
                if(p0 < p1)
                {
                    item = nums[p1];
                    nums[p1] = nums[i];
                    nums[i] = item;
                }
                p0++;
                p1++;
            }
        }
    }
}
