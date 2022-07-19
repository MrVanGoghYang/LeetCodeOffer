package CompanyExams.HuaweiExams.Interview;

import java.util.HashMap;
import java.util.Map;

/*
给定两个字符串 s1 和 s2，请编写一个程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。

输入: s1 = "abc", s2 = "bca"

 */
public class Main
{
    public static void main(String[] args)
    {
        String s1 = "abdrloeddra";
        String s2 = "aabdddrrloe";
        String s3 = "aabdddrrlo";
        String s4 = "aabdddrrloef";
        String s5 = "";

        Main solution = new Main();
        System.out.println(solution.canChangeto(s1, s2));
        System.out.println(solution.canChangeto(s1, s3));
        System.out.println(solution.canChangeto(s1, s4));
        System.out.println(solution.canChangeto(s1, s5));
    }

    public boolean canChangeto(String origin, String target)
    {
        Map<Character, Integer> mapOri = new HashMap<>();
        for (int i = 0; i < origin.length(); i++)
        {
            char ch = origin.charAt(i);
            int count = mapOri.getOrDefault(ch, 0);
            mapOri.put(ch, count + 1);
        }

        Map<Character, Integer> mapTar = new HashMap<>();
        for (int i = 0; i < target.length(); i++)
        {
            char ch = target.charAt(i);
            int count = mapTar.getOrDefault(ch, 0);
            mapTar.put(ch, count + 1);
        }

        for (Character key : mapOri.keySet())
        {
            Integer value = mapOri.get(key);
            if(!mapTar.containsKey(key) || mapTar.get(key) != value)
                return false;
            mapTar.remove(key);
        }

        for (Character key : mapTar.keySet())
        {
            Integer value = mapTar.get(key);
            if(!mapOri.containsKey(key) || mapOri.get(key) != value)
                return false;
        }

        return true;
    }
}
