package ProblemsByType.Array;

public class No_31_NextPermutation
{
    /*
    思路：要找到大于当前排列的最小的一种，需要前面尽可能不动，只变化最后的尽可能少的元素来产生更大的一个排列。
    实现：从后往前找到第一个不符合非减排列的元素 i，这个元素需要被交换到后面，从后面的元素中从后往前找第一个大于该值的元素j，两个元素交换。此时i位置之后所有元素呈现递减，要是值最小，将i之后所有元素进行逆转reverse。
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
