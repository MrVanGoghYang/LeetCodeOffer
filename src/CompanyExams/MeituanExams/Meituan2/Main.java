package CompanyExams.MeituanExams.Meituan2;

import java.util.Scanner;
// 字符串编解码，编码取 n/2 处字符加入结果然后删除该字符，解码反之
public class Main
{
    public static void main(String[] args)
    {
        // Common input process
        Scanner sc = new Scanner(System.in);
        Main solution = new Main();
        int strlen = sc.nextInt();
        int ope = sc.nextInt();
        sc.nextLine();
        String input = sc.nextLine();
        if(ope == 1)
            System.out.print(solution.encode(input, strlen));
        else
            System.out.print(solution.decode(input, strlen));
    }

    public String encode(String input, int len)
    {
        StringBuilder ori = new StringBuilder(input);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < input.length(); i++)
        {
            int mid = (len + 1) >> 1;
            sb.append(ori.charAt(mid - 1));
            ori.deleteCharAt(mid - 1);
            len -= 1;
        }
        return sb.toString();
    }

    /*
6 1
abcdef
cdbeaf
6 2
cdbeaf
 */
    public String decode(String input, int len)
    {
        StringBuilder sb = new StringBuilder();
        int flag = 0; // 0: rear 1: tail
        for(int i = 0; i < len; i++)
        {
            if(flag == 0)
            {
                sb.insert(0, input.charAt(i));
                flag = 1;
            }
            else
            {
                sb.insert(sb.length(), input.charAt(i));
                flag = 0;
            }
        }
        return sb.toString();
    }
}
