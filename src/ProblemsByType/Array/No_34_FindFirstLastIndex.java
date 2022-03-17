package ProblemsByType.Array;
/*
思路：题目要求时间复杂度为O(logN)，由所给数组有序想到二分搜索，根据题意，更改二分搜索函数，用于搜索最小或最大元素，区别在于先搜左边区间还是右半区间。
 */
public class No_34_FindFirstLastIndex
{
    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0)
            return new int[]{-1, -1};
        // 搜索target的最小下标
        int minId = binSearch(nums, 0, nums.length - 1, target, 1);
        // System.out.println(minId);
        // 搜索target的最大下标
        int maxId = binSearch(nums, 0, nums.length - 1, target, 2);
        // System.out.println(maxId);
        if(minId == -1 || maxId == -1)
            return new int[]{-1, -1};
        else
            return new int[]{minId, maxId};
    }

    // type : 1代表搜索最小下标，2代表搜索最大下标
    public int binSearch(int[] nums, int left, int right, int target, int type)
    {
        if(left > right || left < 0 || right < 0)
            return -1;
        if(left == right)
            return nums[left] == target ? left : -1;
        int mid = left + ((right - left) >> 1);
        // System.out.println("left: " + left + " right: " + right + " mid: " + mid);
        if(type == 1)
        {
            int minId = binSearch(nums, left, mid, target, type);
            if(minId != -1)
                return minId;
            return binSearch(nums, mid + 1, right, target, type);
        }
        else
        {
            int maxId = binSearch(nums, mid + 1, right, target, type);
            if(maxId != -1)
                return maxId;
            return binSearch(nums, left, mid, target, type);
        }

    }
}
