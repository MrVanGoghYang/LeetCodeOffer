package TencentProblems;

import java.util.*;

/*
 ˼·�� ����ջ��ԭ����վ��һ��¥���ҿ����ܹ�������¥���ǲ�ߵ����ģ�
       ʵ�֣���������ɨ����ջ��ά��һ��¥��߶ȵ����ݼ���ջ����ô��ɨ�赽��i��¥ʱ��i + 1¥�ܿ�����¥���������ǵ�ǰ����ջ���Ԫ��������ֱ�ӽ�ջԪ�������ӵ�����У�
       Ȼ���������ɨ�裬ͬ��ά��һ��¥��߶ȵ����ݼ���ջ����ô��ɨ�赽��i��¥ʱ��i - 1¥�ܿ�����¥���������ǵ�ǰ����ջ���Ԫ��������ֱ�ӽ�ջԪ�������ӵ�����У�
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
