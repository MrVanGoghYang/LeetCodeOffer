package ProblemsByType.Array;

import java.util.List;

public class No_33_SearchInRotatedSortedArray
{
    public int search(int[] nums, int target) {
        // 先找到旋转位置，二分搜索，思想是如果从中间mid分开后看左右是否均有序，如果有序说明旋转位置为mid + 1，否则对非有序的一半再继续二分搜索，直至只有left与right相邻时特殊处理。
        int left = 0;
        int right = nums.length - 1;
        int reverse = -1;
        while(left < right)
        {
            if(right - left == 1 && nums[right] < nums[left])
            {
                reverse = right;
                break;
            }
            int mid = (left + right) >> 1;
            boolean lOrder = nums[left] <= nums[mid];
            boolean rOrder = nums[mid + 1] <= nums[nums.length - 1];
            if(lOrder && rOrder)
            {
                reverse = mid + 1;
                break;
            }
            else if(!rOrder)
            {
                left = mid + 1;
            }
            else
            {
                right = mid;
            }
        }
        // System.out.println(reverse);
        // 然后在前后两半有序数组中分别二分搜索target
        if(reverse > 0 && target >= nums[0] && target <= nums[reverse - 1])
            return binarySearch(nums, 0, reverse - 1, target);
        else if(reverse > 0 && target >= nums[reverse] && target <= nums[nums.length - 1])
            return binarySearch(nums, reverse, nums.length - 1, target);
        return nums[0] == target ? 0 : -1;
    }

    public int binarySearch(int[] nums, int l, int r, int target)
    {
        int res = -1;
        while(l < r)
        {
            int mid = (l + r) >> 1;
            // System.out.println("l: " + l + " r: " + r + " mid: " + mid);
            if(nums[mid] == target)
            {
                res = mid;
                break;
            }
            else if(nums[mid] < target)
            {
                l = mid + 1;
            }
            else
            {
                r = mid - 1;
            }
        }
        if(l == r && nums[l] == target)
            return l;
        // System.out.println("target: " + target +"  result: " + res);
        return res;
    }
}
