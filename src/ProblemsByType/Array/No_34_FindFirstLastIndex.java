package ProblemsByType.Array;
/*
˼·����ĿҪ��ʱ�临�Ӷ�ΪO(logN)�����������������뵽�����������������⣬���Ķ�����������������������С�����Ԫ�أ�������������������仹���Ұ����䡣
 */
public class No_34_FindFirstLastIndex
{
    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0)
            return new int[]{-1, -1};
        // ����target����С�±�
        int minId = binSearch(nums, 0, nums.length - 1, target, 1);
        // System.out.println(minId);
        // ����target������±�
        int maxId = binSearch(nums, 0, nums.length - 1, target, 2);
        // System.out.println(maxId);
        if(minId == -1 || maxId == -1)
            return new int[]{-1, -1};
        else
            return new int[]{minId, maxId};
    }

    // type : 1����������С�±꣬2������������±�
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
