package ProblemsByType.Array;

/*
思路一：计数：第一遍扫描分别统计0 1 2 的个数，第二遍扫描进行赋值，2次遍历；
思路二：单指针：使用一个指针p，第一遍扫描将所有的0换到p指针位置并p++，第二遍扫描将所有的1换到Pp指针位置p++，2次遍历；
思路三：双指针：使用p0、p1两个指针分别指向下一个0或下一个1的插入位置，一遍扫描，当遇到1时换到p1位置，p1++；当遇到0时，换到p0位置，注意：此处如果p0 < p1那么说明此次交换覆盖了1个1，有1个1被交换到i位置，需要再将i位置与p1位置交换。完成后需要p0++ p1++因为插入0会导致下一个插入1的位置也后移。
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
