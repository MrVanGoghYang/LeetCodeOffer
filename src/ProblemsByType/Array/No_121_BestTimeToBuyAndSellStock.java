package ProblemsByType.Array;

public class No_121_BestTimeToBuyAndSellStock
{
    // ˼·����¼��ÿ�����֮ǰ����Сֵ�����ĳ������ֵ��֮ǰ����Сֵ��С�������Сֵ��������½��
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
