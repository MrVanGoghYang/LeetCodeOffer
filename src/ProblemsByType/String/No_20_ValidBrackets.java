package ProblemsByType.String;

import java.util.Stack;

public class No_20_ValidBrackets
{
    public boolean isValid(String s) {
        StringBuilder sb = new StringBuilder();
        int index = 0;
        char initCh= s.charAt(index++);
        if(initCh == ')' || initCh == '}' || initCh == ']')
            return false;
        Stack<Character> stack = new Stack<>();
        stack.push(initCh);
        // 扫描所有字符，直至完成或中途退出
        while(index < s.length())
        {
            Character ch = s.charAt(index++);
            // 扫描到左括号入栈
            if(ch == '(' || ch == '{' || ch == '[')
                stack.push(ch);
                // 扫描到右括号试图从栈顶匹配左括号
            else
            {
                // 如果栈空，则无左括号可匹配，失败
                if(stack.isEmpty())
                    return false;
                // 若栈不空，如果栈顶元素与当前右括号不匹配，也失败
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
        // 若成功扫描则应扫描至字符串末尾且栈为空
        return index == s.length() && stack.isEmpty();
    }
}
