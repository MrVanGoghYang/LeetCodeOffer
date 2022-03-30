package ProblemsByType.Stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class No_85_MaxRectangle
{
    /*
    思路一：暴力解法，使用一个dp数组储存每个元素往左数有多少个连续的1，然后从每个1的位置开始，一直往上找同列连续为1的相元素，每次改变高度和最小宽度得到一个新计算的矩形面积，计算计算出的矩形面积最大值即可。
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
    思路二：同84题，使用单调栈寻找每一列i左边高度小于height[i]的第一列的下标，使用单增栈，可以保证每一次push的时候栈顶元素就是所需要的下标。
    以第i行当做一个直方图的底，每一列中从第往上的连续1的数量为该列的高，求直方图中的最大矩形面积，就是84题的题目，可以复用。
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
