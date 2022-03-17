package ProblemsByType.Stack;

import java.util.*;

/*
思路：单调栈寻找 位置i往左或往右 高度小于该位置i的最近的一个位置j，由于找小于的位置，因此使用单调递增栈，那么每次push时栈顶元素就是其左或右边比它小的第一个位置的下标。
注意：以后使用栈结构时，使用 Deque<Integer> stack = new ArrayDeque<Integer>() 双端队列的结构，不要使用LinkedList，效率太低了，低了10倍的效率。
 */
public class No_84_MaxRectangleInHistogram
{
    public int largestRectangleArea(int[] heights) {
        int max = 0;
        Deque<Integer> stack = new ArrayDeque<Integer>();
        int[] area = new int[heights.length];
        Integer top;
        stack.push(-1);
        for(int i = 0; i < heights.length; i++)
        {
            while(stack.size() > 0 && stack.peek() >= 0 && heights[stack.peek()] >= heights[i])
                stack.pop();
            top = stack.peek();
            area[i] += heights[i] * (i - top);
            stack.push(i);
        }
        // System.out.println(Arrays.toString(area));

        stack.clear();
        stack.push(heights.length);
        for(int i = heights.length - 1; i >= 0; i--)
        {
            while(stack.size() > 0 && stack.peek() < heights.length && heights[stack.peek()] >= heights[i])
                stack.pop();
            top = stack.peek();
            area[i] += heights[i] * (top - 1 - i);
            max = Math.max(max, area[i]);
            stack.push(i);
        }
        // System.out.println(Arrays.toString(area));
        return max;
    }
}
