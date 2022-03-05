package SwordRefersToOffer;

/*
在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。

示例 1:
输入: [7,5,6,4]
输出: 5

思路：逆序对 = 归并排序！！！
利用两个有序数组归并时候使用双指针，由于各自有序，因此在左边的数组元素放入存储数组时，说明它大于所有右边已经加入存储数组中的元素（即 左边大于右边 ）
那么逆序对的数量就可以加上右边数组指针的位移量。
 */
public class No_51_ReversePairsInArray
{
    public static void main(String[] args)
    {
        No_51_ReversePairsInArray solution = new No_51_ReversePairsInArray();
        int[] nums = {7,5,6,4};
        System.out.println(solution.reversePairs(nums));
    }

    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    public int mergeSort(int[] nums, int left, int right)
    {
        int res = 0;
        if(left < right)
        {
            int mid = (left + right) >> 1;
            res += mergeSort(nums, left, mid);
            res += mergeSort(nums, mid + 1, right);
            res += merge(nums, left, mid, mid + 1, right);
        }
        return res;
    }

    public int merge(int[] nums, int left1, int right1, int left2, int right2)
    {
        int res = 0;
        if(nums[right1] > nums[left2])
        {
            int[] save = new int[right1 - left1 + right2 - left2 + 2];
            int p = left1;
            int q = left2;
            int idx = 0;
            while(p <= right1 && q <= right2)
            {
                if(nums[p] <= nums[q])
                {
                    save[idx++] = nums[p];
                    p++;
                    res += q - left2;
                }
                else
                {
                    save[idx++] = nums[q];
                    q++;
                }
            }
            while (q <= right2)
            {
                save[idx++] = nums[q++];
            }
            while (p <= right1)
            {
                save[idx++] = nums[p++];
                res += q - left2;
            }

            System.arraycopy(save, 0, nums, left1, save.length);
        }
        return res;
    }
}
