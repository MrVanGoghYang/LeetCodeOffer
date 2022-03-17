package ProblemsByType.SlidingWindow;

/*
思路：滑动窗口，当不满足要求时窗口右端一直右移扩大窗口，直到满足要求时尝试缩小窗口让窗口左端点右移，直至无法缩小则找到一个最小覆盖集，但不一定是全局最小，全局最小需要扫描结束才知道；
实现：1. 使用长度为128的int数组tCnt模拟HashMap统计t中字符出现的次数，使用另外一个int数组sCnt模拟窗口中扫描到的t中字符的计数；
2.设置全局最小窗口指针和每次扫描的最小窗口指针，还有一个关键的cnt表示当前窗口内还有多少个字符的计数不满足t中的要求，当扫描过程中某个字符sCnt增大到与tCnt中相同时，cnt减小；当每拿出一个窗口中的元素导致sCnt < tCnt时，cnt增大。
滑动窗口 甘霖娘 做+看题解花了5个小时 又是怀疑人生的一天
 */
public class No_76_MinimumOverlapSubstring
{
    public String minWindow(String s, String t) {
        int slen = s.length();
        int tlen = t.length();
        if(slen < tlen)
            return "";
        int[] tCnt = new int[128];
        int[] sCnt = new int[128];
        // 还需要满足cnt个元素的计数才找到覆盖
        int cnt = 0;
        int windowl = 0;
        int windowr = 0;
        int resl = 0;
        int resr = slen + 1;
        // 使用ASCII数组模拟HashMap统计t中各个元素的计数
        for(int i = 0; i < tlen; i++)
        {
            Character c = t.charAt(i);
            if(tCnt[c] == 0)
                cnt++;
            tCnt[c]++;
        }
        // 滑动窗口，先windowr右移直至满足所有要求（即cnt减为0）
        while(windowr < slen)
        {
            Character c = s.charAt(windowr);
            // 只修改t中有的元素的计数，t中没有的元素直接跳过
            if(tCnt[c] == 0)
            {
                windowr++;
                continue;
            }
            // 修改计数，相当于将其加入窗口右边，后续windowr一定要++保持一致。修改后如果等于t中的计数，那么说明已满足1个字母的计数，cnt--
            sCnt[c]++;
            if(sCnt[c] == tCnt[c])
                cnt--;
            // 当cnt == 0 即已满足t中所有字母的计数，窗口左端点开始缩小,此时windowr指向最后一个t所需的元素
            if(cnt == 0)
            {
                // 窗口左端点缩小，需要左端点小于右端点且左右端点之间的元素数目大于等于tlen
                while(windowl <= windowr && windowr - windowl + 1 >= tlen)
                {
                    Character cc = s.charAt(windowl);
                    // 只修改t中有的元素的计数，t中没有的元素直接跳过
                    if(tCnt[cc] == 0)
                    {
                        windowl++;
                        continue;
                    }
                    // 修改计数，相当于将其移出窗口左边。修改后如果计数小于了t中的计数，说明如果将其丢弃窗口再右移一位，该字母的数目不满足t中要求，滑动窗口已经缩到不符合要求了，下次所需要的寻找的cnt数目加一。
                    sCnt[cc]--;
                    if(sCnt[cc] < tCnt[cc])
                    {
                        cnt++;
                        break;
                    }
                    // 否则如果修改计数后不影响窗口满足要求，那么就继续缩小
                    windowl++;  // sCnt减小windowl也需要右移才能保持一致
                }
                // 窗口左端点缩小完成后，windowl指向满足要求的最小窗口的左端点，该位置的sCnt已经修改
                if((windowr - windowl) < (resr - resl))
                {
                    resl = windowl;
                    resr = windowr;
                    // System.out.println("Update result: " + s.substring(resl, resr) + "  windowl: " + windowl + " windowr: " + windowr);
                }
                windowl++;  // sCnt减小windowl也需要右移才能保持一致，因为之前break跳出了而且更新res中需要使用原有值，没有右移，此处将其右移保持sCnt和windowl的一致性
            }
            // sCnt增加了，窗口右端点必须扩大，保持一致，只是因为if(cnt==0)中要使用所以放到最后再自增
            windowr++;
        }
        return resr == slen + 1 ? "" : s.substring(resl, resr + 1);
    }
}
