package ProblemsByType.Array;

public class No_287_FindTheDuplicateNumber
{
    // 本题关键是数组元素的范围也在数组长度内即[1, n]内，由此可以将数组元素当做下标找到下一个数组元素，即nums[1] = nums[nums[0]]
    // 顺着思路走，从nums[0]开始-> nums[nums[0]]...依次往下走，如果数组中包含重复元素，那么一定会到达之前到过的下标处（即出现了环，循环了），这个环的入口就是重复元素，转化为找带环链表的入口：快慢指针。
    public int findDuplicate(int[] nums) {
        int slow = nums[0], fast = nums[nums[0]];
        while(slow != fast){
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        slow = 0;
        while(slow != fast){
            slow = nums[slow];
            fast = nums[fast];
        }
        return fast;
    }
}
