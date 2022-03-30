package ProblemsByType.Array;

import java.util.*;

public class No_128_LongestConsecutiveSequence
{
    // 方法一：使用了TreeSet实际内部还是排序了，时间复杂度不满足O(n)
    // public int longestConsecutive(int[] nums) {
    //     if(nums.length == 0)
    //         return 0;
    //     Set<Integer> set = new TreeSet<>();
    //     for(int item : nums)
    //         set.add(item);
    //     Iterator<Integer> ite = set.iterator();
    //     Integer pre = Integer.MIN_VALUE;
    //     int res = 1;
    //     int subres = 1;
    //     while(ite.hasNext())
    //     {
    //         Integer cur = ite.next();
    //         if(cur - pre == 1)
    //         {
    //             subres++;
    //             res = Math.max(res, subres);
    //         }
    //         else
    //             subres = 1;
    //         pre = cur;
    //     }
    //     return res;
    // }

    // 方法二：当扫描到某个元素ele时，依次扫描其ele + 1, ele + 2,...ele + y是否存在，记下连续长度，下次遇到ele + 1到 ele + y直接跳过，注意扫描set即可不需要扫描nums
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0)
            return 0;
        Set<Integer> set = new HashSet<>();
        for(int item : nums)
            set.add(item);
        int res = 1;

        for(Integer item : set)
        {
            if(!set.contains(item - 1))
            {
                int subres = 1;
                int curNum = item;
                while(set.contains(curNum + 1))
                {
                    subres++;
                    curNum++;
                }
                res = Math.max(res, subres);
            }
        }
        return res;
    }
}
