package ProblemsByType.String;

import java.util.*;

/*
˼·���������ڣ�ʹ��HashMap��Ԫ��ȥ���Լ��ڳ����ظ�Ԫ��ʱ����������ƣ��ڴ����Ҷ˵���»���˵���º󣬼����µĻ������ڴ�С������maxLen��
 */
public class No_03_LongestNorepeatSubstring
{
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        if(len == 0 || len == 1)
            return len;
        HashMap<Character, Integer> substringSet = new HashMap<>(); // �ַ�������ֵ�����±��ӳ��
        int maxLen = 0;
        int i = 0; // �����������
        int j = 0; // ���������Ҷ�
        while(j < len)
        {
            if(substringSet.containsKey(s.charAt(j)))
            {
                int repeatIndex = substringSet.get(s.charAt(j));
                i = Math.max(i, repeatIndex + 1); // �����ظ��ַ�����λ��С�ڻ����������
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
