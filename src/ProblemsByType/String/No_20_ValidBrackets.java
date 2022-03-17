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
        // ɨ�������ַ���ֱ����ɻ���;�˳�
        while(index < s.length())
        {
            Character ch = s.charAt(index++);
            // ɨ�赽��������ջ
            if(ch == '(' || ch == '{' || ch == '[')
                stack.push(ch);
                // ɨ�赽��������ͼ��ջ��ƥ��������
            else
            {
                // ���ջ�գ����������ſ�ƥ�䣬ʧ��
                if(stack.isEmpty())
                    return false;
                // ��ջ���գ����ջ��Ԫ���뵱ǰ�����Ų�ƥ�䣬Ҳʧ��
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
        // ���ɹ�ɨ����Ӧɨ�����ַ���ĩβ��ջΪ��
        return index == s.length() && stack.isEmpty();
    }
}
