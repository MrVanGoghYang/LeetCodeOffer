package ProblemsByType.String;

/*
思路：中心扩展，从s的每个元素i位置作为起点，(left,riht)从(i, i)与(i, i + 1)分别开始向两边搜索，若字符相同则left--,right++。分两种情况搜索是考虑最长回文串长度为奇或偶的情况。
 */
public class No_05_LongestPalindrome
{
    public String longestPalindrome(String s) {
        int len = s.length();
        if(len == 0)
            return "";
        String res = String.valueOf(s.charAt(0));
        int max = 1;
        for (int i = 0; i < len - 1; i++)
        {
            if(len - i <= max >> 1)
                break;
            String sub1 = findPalindrome(s, len, i, i);
            String sub2 = findPalindrome(s, len, i, i + 1);
            if(sub1.length() > max)
            {
                res = sub1;
                max = sub1.length();
            }
            if(sub2.length() > max)
            {
                res = sub2;
                max = sub2.length();
            }
        }
        return res;
    }

    public String findPalindrome(String s, int len, int left, int right)
    {
        while(left >=0 && right < len && s.charAt(left) == s.charAt(right))
        {
            left--;
            right++;
        }
        return s.substring(left + 1, right);
    }
}
