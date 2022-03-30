package ProblemsByType.LinkedList;

public class No_206_ReverseLinkedList
{
    // ������ת�����巴ת����ͷ��㣬ʹ��ͷ�巨����������Ԫ�ز��뵽��ת����ĵ�һ��λ��
    // public ListNode reverseList(ListNode head) {
    //     ListNode reverse = new ListNode();
    //     ListNode revNext = reverse.next;
    //     ListNode oriNext = head;
    //     while(head != null)
    //     {
    //         oriNext = head.next;
    //         revNext = reverse.next;
    //         head.next = revNext;
    //         reverse.next = head;
    //         head = oriNext;
    //     }
    //     return reverse.next;
    // }
    // �ݹ鷴ת���Ƚ����p�ĺ������н�㷴ת��p.nextָ��Ľ��ͱ���˷�ת������һ��������Խ�p.next.next = p ����pβ�嵽��ת����������
    // ע�⻹Ҫ����p.next = null��˴�ʱpΪ��ת��������һ��ָ���ˡ�
    ListNode reverse = new ListNode();
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode ret = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return ret;
    }
}
