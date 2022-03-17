package ProblemsByType.Stack;

import java.util.*;

/*
˼·������ջѰ�� λ��i��������� �߶�С�ڸ�λ��i�������һ��λ��j��������С�ڵ�λ�ã����ʹ�õ�������ջ����ôÿ��pushʱջ��Ԫ�ؾ���������ұ߱���С�ĵ�һ��λ�õ��±ꡣ
ע�⣺�Ժ�ʹ��ջ�ṹʱ��ʹ�� Deque<Integer> stack = new ArrayDeque<Integer>() ˫�˶��еĽṹ����Ҫʹ��LinkedList��Ч��̫���ˣ�����10����Ч�ʡ�
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
