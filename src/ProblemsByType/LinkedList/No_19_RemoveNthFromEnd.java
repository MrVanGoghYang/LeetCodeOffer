package ProblemsByType.LinkedList;

/*
˼·������ָ��һ��ɨ�裬��ָ��һ���ƶ�n + 1����ָ��һ���ƶ�1������ָ���ƶ����������ƶ�n + 1ʱ������ָ��֮�����k * n + qMove�����룬��Ϊ����qMove������0.
Ȼ��pָ����ǰ�ƶ�(k - 1) * n + qMove �����ƶ� qMove - n(k = 0 �����)���ƶ�֮��p����һ��Ԫ�ؾ���Ҫɾ���������㣬ɾ�����ɣ�ע��������� qMove - n = -1 ��˵��k = 0 ��Ҫɾ����һ����㣬ֱ�ӷ���head.next��
 */
public class No_19_RemoveNthFromEnd
{
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p = head;
        ListNode q = head;
        int nIntervalCnt = 0;
        int qMove = 0;
        // ��ָ��һ�� n + 1,��ָ��һ�� 1
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
        // ��������֮�󣬼���pҪ�ƶ��ľ��룬Ҫô nIntervalCnt > 0 �ƶ�qMove + (nIntervalCnt - 1) * n����ʱp.nextΪ��ɾ����㣻
        // Ҫô nIntervalCnt < 0 �ƶ� qMove - n���ƶ���Ҫôp.next��ɾ����ҪôpΪ��ɾ����㣨pMove = -1�����ֿ������ɡ�
        int pMove = nIntervalCnt > 0 ? qMove + (nIntervalCnt - 1) * n : qMove - n;
        // nIntervalCnt < 0 �� ��ɾ�����Ϊ������n������һ�����
        if(pMove < 0)
        {
            head = head.next;
            return head;
        }
        // ��p�ƶ�����Ĳ���pMove
        while(p.next != null && pMove > 0)
        {
            p = p.next;
            pMove--;
        }
        // ��ʱp.nextΪ��ɾ����㣬ɾ������
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
