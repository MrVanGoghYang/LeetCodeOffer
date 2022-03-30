package ProblemsByType.Stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class No_85_MaxRectangle
{
    /*
    ˼·һ�������ⷨ��ʹ��һ��dp���鴢��ÿ��Ԫ���������ж��ٸ�������1��Ȼ���ÿ��1��λ�ÿ�ʼ��һֱ������ͬ������Ϊ1����Ԫ�أ�ÿ�θı�߶Ⱥ���С��ȵõ�һ���¼���ľ�����������������ľ���������ֵ���ɡ�
    */
//    public int maximalRectangle(char[][] matrix) {
//        int rows = matrix.length;
//        int cols = matrix[0].length;
//        if(rows == 0)
//            return 0;
//        int[][] dpWidth = new int[rows + 1][cols + 1];
//        int max = 0;
//
//        for(int i = 0; i < rows; i++)
//        {
//            for(int j = 0; j < cols; j++)
//            {
//
//                if(matrix[i][j] == '1')
//                {
//                    dpWidth[i + 1][j + 1] = dpWidth[i + 1][j] + 1;
//                }
//            }
//        }
//
//        for(int i = 0; i < rows; i++)
//        {
//            for(int j = 0; j < cols; j++)
//            {
//                if(matrix[i][j] == '1')
//                {
//                    int minWidth = dpWidth[i + 1][j + 1];
//                    for(int k = i; k >= 0; k--)
//                    {
//                        if(matrix[k][j] == '0')
//                            break;
//                        minWidth = Math.min(minWidth, dpWidth[k + 1][j + 1]);
//                        max = Math.max(max, minWidth * (i - k + 1));
//                    }
//                }
//            }
//        }
//        return max;
//    }

    /*
    ˼·����ͬ84�⣬ʹ�õ���ջѰ��ÿһ��i��߸߶�С��height[i]�ĵ�һ�е��±꣬ʹ�õ���ջ�����Ա�֤ÿһ��push��ʱ��ջ��Ԫ�ؾ�������Ҫ���±ꡣ
    �Ե�i�е���һ��ֱ��ͼ�ĵף�ÿһ���дӵ����ϵ�����1������Ϊ���еĸߣ���ֱ��ͼ�е����������������84�����Ŀ�����Ը��á�
     */

    public int maximalRectangle(char[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        if(rows == 0)
            return 0;
        int[] heights = new int[cols];
        int max = 0;
        for(int i = 0; i < rows; i++)
        {
            for(int j = 0; j < cols; j++)
            {
                heights[j] = matrix[i][j] == '0' ? 0 : heights[j] + 1;
            }
            max = Math.max(max, largestRectangleArea(heights));
        }
        return max;
    }

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
