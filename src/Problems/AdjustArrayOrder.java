package Problems;
/*
 * 	LeetCode.21
 * 	快速排序首位双指针扫描交换的变体形式;
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
