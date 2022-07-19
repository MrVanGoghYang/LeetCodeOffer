package CompanyExams.TencentMusicExams.Problem3;

import java.util.*;
public class Main
{
    public static void main(String[] args)
    {
//        String input = "aaabcd";
//        int k = 2;
        String input = "aacbcbdefghijklmnopqrstuvwxyz";
        int k = 1;
        Main solution = new Main();
        System.out.println(solution.howMany(input, k));
    }

    public int howMany (String S, int k) {
        // write code here
        Map<Character, Integer> map = new HashMap<>();
        Set<Character> res = new HashSet<>();
        for(int i = 0; i < S.length(); i++)
        {
            char ch = S.charAt(i);
            if(ch >= 'a' && ch <= 'z')
            {
                int preRes = map.getOrDefault(ch, 0);
                map.put(ch, preRes + 1);
                if(preRes + 1 >= k && !res.contains(ch))
                    res.add(ch);
            }
        }
        return res.size();
    }
}
