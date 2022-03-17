package ProblemsByType.LinkedList;

/*
思路：快慢指针一遍扫描，快指针一次移动n + 1，慢指针一次移动1，当快指针移动到不能再移动n + 1时，快慢指针之间相隔k * n + qMove个距离，因为可能qMove不等于0.
然后将p指针往前移动(k - 1) * n + qMove 或者移动 qMove - n(k = 0 的情况)，移动之后p的下一个元素就是要删除的链表结点，删除即可，注意特殊情况 qMove - n = -1 即说明k = 0 且要删除第一个结点，直接返回head.next。
 */
public class No_19_RemoveNthFromEnd
{
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p = head;
        ListNode q = head;
        int nIntervalCnt = 0;
        int qMove = 0;
        // 快指针一次 n + 1,慢指针一次 1
        while(q.next != null)
        {
            q = q.next;
            qMove++;
            if(qMove % (n + 1) == 0)
            {
                p = p.next;
                nIntervalCnt++;
                qMove = 0;
            }
        }
        // 快慢结束之后，计算p要移动的距离，要么 nIntervalCnt > 0 移动qMove + (nIntervalCnt - 1) * n，此时p.next为待删除结点；
        // 要么 nIntervalCnt < 0 移动 qMove - n，移动后要么p.next待删除，要么p为待删除结点（pMove = -1），分开处理即可。
        int pMove = nIntervalCnt > 0 ? qMove + (nIntervalCnt - 1) * n : qMove - n;
        // nIntervalCnt < 0 且 待删除结点为倒数第n个即第一个结点
        if(pMove < 0)
        {
            head = head.next;
            return head;
        }
        // 将p移动计算的步数pMove
        while(p.next != null && pMove > 0)
        {
            p = p.next;
            pMove--;
        }
        // 此时p.next为待删除结点，删除即可
        if(p.next != null)
        {
            if(p.next.next != null)
                p.next = p.next.next;
            else
                p.next = null;
        }
        return head;
    }
}
