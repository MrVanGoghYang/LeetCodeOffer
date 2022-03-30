package ProblemsByType.Stack;

import java.util.*;

/*
˼·��ʹ��һ��ջstack�����洢Ԫ�أ�����ʹ��һ����СջminStack���洢��Ӧ��stack�е���СԪ�أ�ÿ��pushʱ��Ҫ��push��stack�У�ҲҪ��Ŀǰ���Ƚϵõ�����Сֵpush��minStack�У�
     ÿ��popʱ����ջ��Ҫpop������minΪpop���ջ����Ϊ�˱���pop��Ϊ��ջ����Ԫ�أ��ڳ�ʼ��minStackʱpushһ��Integer.MAX_VALUE��
 */
public class No_155_MinStack
{
    Deque<Integer> stack;
    Deque<Integer> minStack;
    int min;
    public No_155_MinStack() {
        stack = new ArrayDeque<>();
        minStack = new ArrayDeque<>();
        min = Integer.MAX_VALUE;
        minStack.push(min);
    }

    public void push(int val) {
        stack.push(val);
        min = min <= val ? min : val;
        minStack.push(min);
    }

    public void pop() {
        stack.pop();
        minStack.pop();
        min = minStack.peek();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
}
