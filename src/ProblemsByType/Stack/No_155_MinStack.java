package ProblemsByType.Stack;

import java.util.*;

/*
思路：使用一个栈stack正常存储元素，另外使用一个最小栈minStack来存储对应的stack中的最小元素，每次push时既要把push进stack中，也要把目前所比较得到的最小值push到minStack中；
     每次pop时两个栈都要pop，更新min为pop后的栈顶，为了避免pop后为空栈顶无元素，在初始化minStack时push一个Integer.MAX_VALUE。
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
