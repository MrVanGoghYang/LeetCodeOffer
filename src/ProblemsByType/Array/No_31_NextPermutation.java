package ProblemsByType.Array;

public class No_31_NextPermutation
{
    /*
    ˼·��Ҫ�ҵ����ڵ�ǰ���е���С��һ�֣���Ҫǰ�澡���ܲ�����ֻ�仯���ľ������ٵ�Ԫ�������������һ�����С�
    ʵ�֣��Ӻ���ǰ�ҵ���һ�������ϷǼ����е�Ԫ�� i�����Ԫ����Ҫ�����������棬�Ӻ����Ԫ���дӺ���ǰ�ҵ�һ�����ڸ�ֵ��Ԫ��j������Ԫ�ؽ�������ʱiλ��֮������Ԫ�س��ֵݼ���Ҫ��ֵ��С����i֮������Ԫ�ؽ�����תreverse��
     */
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while(i >= 0 && nums[i] >= nums[i + 1])
        {
            i--;
        }
        if(i != -1)
        {
            for(int j = nums.length - 1; j > i; j--)
            {
                if(nums[j] > nums[i])
                {
                    nums[j] += nums[i];
                    nums[i] = nums[j] - nums[i];
                    nums[j] -= nums[i];
                    break;
                }
            }
        }
        for(int k = i + 1; k < ((i + 1 + nums.length) >> 1); k++)
        {
            nums[k] += nums[nums.length - 1 - (k - i - 1)];
            nums[nums.length - 1 - (k - i - 1)] = nums[k] - nums[nums.length - 1 - (k - i - 1)];
            nums[k] -= nums[nums.length - 1 - (k - i - 1)];
        }
    }
}
