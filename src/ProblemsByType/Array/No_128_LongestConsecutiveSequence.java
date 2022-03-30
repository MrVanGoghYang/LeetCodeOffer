package ProblemsByType.Array;

import java.util.*;

public class No_128_LongestConsecutiveSequence
{
    // ����һ��ʹ����TreeSetʵ���ڲ����������ˣ�ʱ�临�ӶȲ�����O(n)
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

    // ����������ɨ�赽ĳ��Ԫ��eleʱ������ɨ����ele + 1, ele + 2,...ele + y�Ƿ���ڣ������������ȣ��´�����ele + 1�� ele + yֱ��������ע��ɨ��set���ɲ���Ҫɨ��nums
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
