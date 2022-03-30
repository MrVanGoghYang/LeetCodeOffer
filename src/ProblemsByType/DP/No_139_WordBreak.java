package ProblemsByType.DP;

import java.util.*;

public class No_139_WordBreak
{
    // ˼·����̬�滮���������dp[i]��ʾ�Ƿ�����s[0, i]�Ĵ���dp[i] = true : 1. ҪôwordDictֱ�Ӱ���[0, i]������� 2. Ҫôdp[j] = true �� wordDict����[j, i]�������
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> sets = new HashSet<>(wordDict);
        int len = s.length();
        boolean[] dp = new boolean[len];
        Arrays.fill(dp, false);
        Set<Integer> trueSet = new HashSet<>();
        for(int i = 0; i < len; i++)
        {
            if(sets.contains(s.substring(0, i + 1)))
            {
                dp[i] = true;
                trueSet.add(i);
            }
            else
            {
                boolean couldBeTrue = false;
                for(Integer item : trueSet)
                {
                    if(item < i && sets.contains(s.substring(item + 1, i + 1)))
                    {
                        dp[i] = true;
                        couldBeTrue = true;
                        break;
                    }
                }
                if(couldBeTrue)
                    trueSet.add(i);
            }
            // System.out.println("dp[" + i + "] : " + s.substring(0, i + 1) + " " + dp[i]);
        }
        return dp[len - 1];
    }
}
