package ProblemsByType.Stack;

import java.util.Stack;

public class No_20_ValidParentheses
{
    public boolean isValid(String s) {
        int index = 0;
        char initCh= s.charAt(index++);
        if(initCh == ')' || initCh == '}' || initCh == ']')
            return false;
        Stack<Character> stack = new Stack<>();
        stack.push(initCh);
        while(index < s.length())
        {
            Character ch = s.charAt(index++);
            if(ch == '(' || ch == '{' || ch == '[')
                stack.push(ch);
            else
            {
                if(stack.isEmpty())
                    return false;
                Character popEle = stack.pop();
                if(ch == ')')
                {
                    if(popEle != '(')
                        return false;
                }
                else if(ch == '}')
                {
                    if(popEle != '{')
                        return false;
                }
                else
                {
                    if(popEle != '[')
                        return false;
                }
            }
        }
        return index == s.length() && stack.isEmpty();
    }

}
