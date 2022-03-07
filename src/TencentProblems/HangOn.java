package TencentProblems;

import java.util.*;

/*
СQ����ĩ��ʱ�������С�����������й�֣�һ�����н����кܶ��¥������n����¥�ų�һ�С�
СQ�ӵ�һ��һֱ�ߵ������һ����СQ������û�м�����ô���¥����������֪������ÿ��¥��λ�ô��ܿ������ٶ�¥�أ�����ǰ���¥�ĸ߶ȴ��ڵ��ں����¥ʱ�������¥������ס��
ʾ��1
����
[5,3,8,3,2,5]
���
[3,3,5,4,4,4]
˵��
��СQ����λ��3ʱ����������ǰ����λ��2,1����¥����󿴵�λ��4,6����¥�����ϵ�3��¥�����ɿ���5��¥����СQ����λ��4ʱ����������ǰ����λ��3����¥����󿴵�λ��5,6����¥�����ϵ�4��¥�����ɿ���4��¥��

��ע:
����Ϊһ�����飬��ʾÿһ��¥�ĸ߶�w[i]
1<=���鳤��<=100000;
1<=wi<=100000;

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
