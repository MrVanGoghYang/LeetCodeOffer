package TencentProblems;

import java.util.*;

/*
小Q在周末的时候和他的小伙伴来到大城市逛街，一条步行街上有很多高楼，共有n座高楼排成一行。
小Q从第一栋一直走到了最后一栋，小Q从来都没有见到这么多的楼，所以他想知道他在每栋楼的位置处能看到多少栋楼呢？（当前面的楼的高度大于等于后面的楼时，后面的楼将被挡住）
示例1
输入
[5,3,8,3,2,5]
输出
[3,3,5,4,4,4]
说明
当小Q处于位置3时，他可以向前看到位置2,1处的楼，向后看到位置4,6处的楼，加上第3栋楼，共可看到5栋楼。当小Q处于位置4时，他可以向前看到位置3处的楼，向后看到位置5,6处的楼，加上第4栋楼，共可看到4栋楼。

备注:
输入为一个数组，表示每一栋楼的高度w[i]
1<=数组长度<=100000;
1<=wi<=100000;

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
