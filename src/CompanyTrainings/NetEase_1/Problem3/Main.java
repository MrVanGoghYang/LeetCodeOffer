package CompanyTrainings.NetEase_1.Problem3;

import java.util.*;

public class Main
{
    public static void main(String[] args)
    {
        Main solution = new Main();
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        if(solution.ispalindrome(input))
        {
            System.out.println(input);
            return;
        }
        else
        {
            StringBuilder res = new StringBuilder(input);
            Deque<Character> stack = new ArrayDeque<>();
            for(int i = 0; i < input.length() - 1; i++)
            {
                stack.push(input.charAt(i));
                if(solution.ispalindrome(input.substring(i + 1, input.length())))
                    break;
            }
            while(!stack.isEmpty())
                res.append(stack.pop());
            System.out.println(res.toString());
        }
    }

    public boolean ispalindrome(String str)
    {
        for(int i = 0; i < str.length() >> 1; i++)
        {
            if(str.charAt(i) != str.charAt(str.length() - 1 - i))
                return false;
        }
        return true;
    }
}
