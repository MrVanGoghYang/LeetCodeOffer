package ProblemsByType.String;

/*
˼·��������չ����s��ÿ��Ԫ��iλ����Ϊ��㣬(left,riht)��(i, i)��(i, i + 1)�ֱ�ʼ���������������ַ���ͬ��left--,right++����������������ǿ�������Ĵ�����Ϊ���ż�������
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
