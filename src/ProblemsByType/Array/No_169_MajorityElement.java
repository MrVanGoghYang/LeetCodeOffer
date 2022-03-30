package ProblemsByType.Array;

public class No_169_MajorityElement
{
    /*
    思路：摩尔投票法，维护一个candidate与一个count，初始时candidate为任意，count为0，依次扫描数组元素：当count = 0 时换届选举更换candidate，否则扫描到相同candidate，count++，扫描到不同candidate，count--，最后的candidate即为众数；
    原理：当candidate不是众数时，那么会遭到众数的反对导致count < 0下台换届；
         当candidate是众数时，会遭到非众数的反对，但是即使count被反对减为0，那么最坏情况也是同归于尽（耗费相等数量的众数消耗掉所有非众数）最后还会剩下一些众数直接当选。
     */
    public int majorityElement(int[] nums) {
        // 摩尔投票法
        if(nums.length == 1)
            return nums[0];
        int candidate = nums[0];
        int count = 0;
        for(int i = 0; i < nums.length; i++)
        {
            if(count == 0)
                candidate = nums[i];
            if(nums[i] == candidate)
                count++;
            else
                count--;
        }
        return candidate;
    }
}
