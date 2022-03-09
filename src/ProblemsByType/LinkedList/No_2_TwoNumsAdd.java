package ProblemsByType.LinkedList;

/*
˼·�����ַ����ӷ����ƣ�ֻ�ǲ��õĴ洢�ṹ��һ������ͷ����β�巨����l1.val + l2.val + pre����λ������������������󲢼��½�λ�����������н�λ��ôֱ�ӽ����������
 */
public class No_2_TwoNumsAdd
{
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        int pre = 0;
        int addRes = 0;
        ListNode p = head;
        while(l1 != null && l2 != null)
        {
            int sum = l1.val + l2.val + pre;
            pre = sum / 10;
            addRes = sum % 10;
            p.next = new ListNode(addRes);
            p = p.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        ListNode remain = l1 != null ? l1 : l2;
        while(remain != null)
        {
            int sum = remain.val + pre;
            pre = sum / 10;
            addRes = sum % 10;
            p.next = new ListNode(addRes);
            p = p.next;
            remain = remain.next;
        }
        if(pre != 0)
        {
            p.next = new ListNode(pre);
        }
        return head.next;
    }
}
