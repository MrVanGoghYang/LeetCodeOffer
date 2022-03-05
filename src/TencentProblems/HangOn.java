package TencentProblems;

import java.util.*;

/*
 思路： 单调栈，原理：当站在一座楼左右看，能够看到的楼都是层高递增的；
       实现：从左往右扫描入栈，维护一个楼层高度单调递减的栈，那么当扫描到第i个楼时，i + 1楼能看到的楼的数量就是当前单调栈里的元素数量，直接将栈元素数量加到结果中；
       然后从右往左扫描，同理，维护一个楼层高度单调递减的栈，那么当扫描到第i个楼时，i - 1楼能看到的楼的数量就是当前单调栈里的元素数量，直接将栈元素数量加到结果中；
 */
public class HangOn
{

    public int[] findBuilding (int[] heights) {
        // write code here
        int[] res = new int[heights.length];
        Arrays.fill(res, 1);
        Stack<Integer> lStack = new Stack<>();
        for(int i = 0; i < heights.length - 1; i++)
        {
            while(!lStack.isEmpty() && heights[lStack.peek()] <= heights[i])
                lStack.pop();
            lStack.push(i);
            res[i + 1] += lStack.size();
        }
        Stack<Integer> rStack = new Stack<>();
        for(int i = heights.length - 1; i > 0; i--)
        {
            while(!rStack.isEmpty() && heights[rStack.peek()] <= heights[i])
                rStack.pop();
            rStack.push(i);
            res[i - 1] += rStack.size();
        }
        return res;
    }
}
