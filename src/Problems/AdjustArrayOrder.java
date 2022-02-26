package Problems;
/*
 * 	LeetCode.21
 * 	����������λ˫ָ��ɨ�轻���ı�����ʽ;
 */
public class AdjustArrayOrder {
    public int[] exchange(int[] nums) {
		int length = nums.length;
		int i = 0;
		int j = length - 1;
		while(i < j)
		{
			while(j >= 0 && nums[j] % 2 == 0)	j--;
			while(i < length && nums[i] % 2 == 1)	i++;
			if(i < j && i < length && j >= 0)
			{
				nums[i] += nums[j];
				nums[j] = nums[i] - nums[j];
				nums[i] -= nums[j];
			}
		}
		return nums;
    }
}
