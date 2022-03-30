package ProblemsByType.LinkedList;

/*
˼·��ʹ�������鲢�����˼��������Ұ�����ֱ�����Ȼ���������������������кϲ���
ע��㣺1.���Ѱ�������м��㣿  ʹ�ÿ���ָ�룬��ָ��ָ��tailʱ��slowָ���м���   2.�ҵ��м������Ҫ�����м����nextֵ����next�ÿգ������޷�ʹ��null����������merge��������ֹ�жϡ�
 */
public class No_148_SortedLinkedList
{
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        return mergeSort(head, null);
    }

    public ListNode mergeSort(ListNode head, ListNode tail)
    {
        if(head == tail)
            return head;
        ListNode slow = head;
        ListNode fast = head.next;
        // ����ָ�룬��fast����βʱ��slowӦ��ָ���м����ǰһ�����
        while(fast != tail && fast.next != tail)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode head2 = slow.next;
        slow.next = null;
        ListNode sorted1 = mergeSort(head, slow);
        ListNode sorted2 = mergeSort(head2, tail);
        return merge(sorted1, sorted2);
    }

    public ListNode merge(ListNode l1, ListNode l2)
    {
        if(l1 == null || l2 == null)
            return l1 == null ? l2 : l1;
        ListNode mergeTail = null;
        if(l1.val <= l2.val)
        {
            mergeTail = l1;
            l1 = l1.next;
        }
        else
        {
            mergeTail = l2;
            l2 = l2.next;
        }
        ListNode res = mergeTail;
        while(l1 != null && l2 != null)
        {
            if(l1.val <= l2.val)
            {
                mergeTail.next = l1;
                l1 = l1.next;
            }
            else
            {
                mergeTail.next = l2;
                l2 = l2.next;
            }
            mergeTail = mergeTail.next;
        }
        if(l1 != null)
            mergeTail.next = l1;
        if(l2 != null)
            mergeTail.next = l2;
        return res;
    }
}
