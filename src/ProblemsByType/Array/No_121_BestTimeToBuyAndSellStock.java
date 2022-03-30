package ProblemsByType.Array;

public class No_121_BestTimeToBuyAndSellStock
{
    // 思路：记录下每个结点之前的最小值，如果某个结点的值比之前的最小值更小则更新最小值，否则更新结果
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int res = 0;
        for(int i = 0; i < prices.length; i++)
        {
            if(prices[i] < min)
                min = prices[i];
            else if(prices[i] > min)
                res = Math.max(res, prices[i] - min);
        }
        return res;
    }
}
