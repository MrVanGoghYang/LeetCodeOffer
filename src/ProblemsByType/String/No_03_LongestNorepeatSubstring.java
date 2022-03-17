package ProblemsByType.String;

import java.util.*;

/*
思路：滑动窗口，使用HashMap对元素去重以及在出现重复元素时窗口左端右移，在窗口右端点更新或左端点更新后，计算新的滑动窗口大小并更新maxLen。
 */
public class No_03_LongestNorepeatSubstring
{
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        if(len == 0 || len == 1)
            return len;
        HashMap<Character, Integer> substringSet = new HashMap<>(); // 字符和其出现的最大下标的映射
        int maxLen = 0;
        int i = 0; // 滑动窗口左端
        int j = 0; // 滑动窗口右端
        while(j < len)
        {
            if(substringSet.containsKey(s.charAt(j)))
            {
                int repeatIndex = substringSet.get(s.charAt(j));
                i = Math.max(i, repeatIndex + 1); // 避免重复字符所在位置小于滑动窗口起点
                if(len - i <= maxLen)
                    break;
            }
            maxLen = Math.max(maxLen, j - i + 1);
            substringSet.put(s.charAt(j), j);
            j++;
        }
        return maxLen;
    }
}
