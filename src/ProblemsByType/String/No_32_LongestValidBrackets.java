package ProblemsByType.String;

public class No_32_LongestValidBrackets
{
    /*
    ˼·����dp��̬�滮�����ڽ��"�����ַ���ɨ��ƥ��" �� ��"�Ӵ���ֵ" �����⣬����һάdp���飬����dp[i]Ϊ��iλ���ַ���β�����Ч���ų��ȣ�������֪��Ч��һ������)��β�ģ���������s[i] = '('�ľ�dp[i] = 0��
    ״̬ת�Ʒ��̣�ͨ���Լ���д����ҹ��ɡ�
    s  ( ( ) ( ( ) )
    id 0 1 2 3 4 5 6
    dp 0 0 2 0 0 2 4+2=6

    s  ( ) ( ( ) )
    id 0 1 2 3 4 5
    dp 0 2 0 0 2 6
     (1) ��s[i] == '('  ��dp[i] = 0��
     (2) ��s[i] == ')' ����Ҫ��s[i - 1]:
        ��s[i - 1] = '(' ��dp[i] = dp[i - 2] + 2��
        ��s[i - 1] = ')' �� s[i - 1 - dp[i - 1]] = '('��ǰ��Ҳ��ƥ��������ţ���s[i] = dp[i - 2] + 2 + dp[(i - 1) - dp[i - 1] - 1]������Ҫ��dp[i - 1]��ǰ���ҵ���ǰ��Ŀ���������ǰ����Ч����
    */
    public int longestValidParentheses(String s) {
        if(s.length() == 0)
            return 0;
        int[] dp = new int[s.length()];
        int max = 0;
        for(int i = 0; i < s.length(); i++)
        {
            if(s.charAt(i) == '(')
                dp[i] = 0;
            else
            {
                if(i - 1 >= 0 && s.charAt(i - 1) == '(')
                {
                    dp[i] = i - 2 >= 0 ? dp[i - 2] + 2 : 2;
                    // System.out.println("@ dp[" + i + "]: " + dp[i]);
                }
                else if((i - 1 >= 0 && s.charAt(i - 1) == ')') && i - 1 - dp[i - 1] >= 0 && s.charAt(i - 1 - dp[i - 1]) == '(')
                {
                    dp[i] = i - 2 >= 0 ? dp[i - 1] + 2 : 2;
                    // System.out.println("# dp[" + i + "]: " + dp[i]);
                    int frontId = (i - 1) - dp[i - 1] - 1;
                    if(frontId >= 0)
                        dp[i] += dp[frontId];
                    // System.out.println("# dp[" + i + "]: " + dp[i] + " front: " + frontId);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
    /*
    ˼·һ�����úϷ����Ŵ������ʣ���������ɨ�裬�����ŵļ���һ������ڵ��������ŵļ���������Ƿ��������������෴��ͨ���������ź������ż�����ʵ����Ч���Ŵ�����ͳ�ƣ��������������ʱ���г������Ӵ����൱��ʹ��ջƥ��ʱջΪ�գ�;���߷Ƿ�ʱ����������0��
    ��������ڣ�һЩ�ַ������ƿ��Լ���ƥ�������ŵ����������ƥ�䲻��������ʱ���ᵼ��û�м��������������"((()()(()"������ɨ����������(һֱ��)����ô����ʱ��Ϊ�ǺϷ��ļ���Ѱ��)ȥƥ�䣬������������Ҳ����Ļ�����ջ�ǿգ��ᵼ�£�
    Ҫô��1�� ÿ����һ��)��ƥ����+2�ļ�����ʽ �ᵼ�� ��ʹ�м�����˼�ϵ�(���滹�Ǽ���ͳ���ˣ����ԣ����¼��������ࣻ ��2�� ÿ���������ż�����ͬʱ��ƥ����+ 2*����  �ᵼ��  һֱû�г����������ż�����ͬ����һֱû�иı�ƥ���������¼��������١�
    Ϊ�˽�����֡�������ʱ�Ϸ��������Ҳ�ȫ�������������������һ���ٵ�����һ������������������ż�����ͬʱ�ı�ƥ�����ķ�������Ϊ�ڣ�1���ּ������Ը����޷���֤�м��������Ϸ��ģ��Ǵ��������������ȫƥ���ջ�ղż�����֤�����Ϸ�����
    */
    // public int longestValidParentheses(String s) {
    //     if(s.length() == 0)
    //         return 0;
    //     int rightCnt = 0;
    //     int leftCnt = 0;
    //     int max = 0;
    //     int curCnt = 0;
    //     for(int i = s.length() - 1; i >= 0; i--)
    //     {
    //         if(s.charAt(i) == ')')
    //             rightCnt++;
    //         else if(s.charAt(i) == '(')
    //             leftCnt++;

    //         if(leftCnt == rightCnt)
    //         {
    //             curCnt += leftCnt * 2;
    //             leftCnt = 0;
    //             rightCnt = 0;
    //             max = Math.max(max, curCnt);
    //         }
    //         else if(leftCnt > rightCnt)
    //         {
    //             leftCnt = 0;
    //             rightCnt = 0;
    //             curCnt = 0;
    //         }
    //     }

    //     curCnt = 0;
    //     rightCnt = 0;
    //     leftCnt = 0;
    //     for(int i = 0; i < s.length() - 1; i++)
    //     {
    //         if(s.charAt(i) == ')')
    //             rightCnt++;
    //         else if(s.charAt(i) == '(')
    //             leftCnt++;

    //         if(leftCnt == rightCnt)
    //         {
    //             curCnt += leftCnt * 2;
    //             leftCnt = 0;
    //             rightCnt = 0;
    //             max = Math.max(max, curCnt);
    //         }
    //         else if(rightCnt > leftCnt)
    //         {
    //             leftCnt = 0;
    //             rightCnt = 0;
    //             curCnt = 0;
    //         }
    //     }
    //     return max;
    // }
}
