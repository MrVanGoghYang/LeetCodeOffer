package ProblemsByType.LinkedList;

public class No_234_PalindromeLinkedList
{
    //˼·������ʹ�ÿ���ָ���ҵ������е㣬Ȼ������ָ�����ߵĹ�������ת���������ҵ��е��ʱ��ǰ��������Ѿ���ת����ô���м俪ʼһ��ָ����ǰһ��ָ��������αȽ��Ƿ���ȼ�
    public boolean isPalindrome(ListNode head) {
        if(head.next == null)
            return true;
        if(head.next.next == null)
            return head.val == head.next.val;

        ListNode fast = head;
        ListNode slow = head;
        ListNode slow_next = slow.next;
        ListNode slow_next_next = slow_next.next;

        // ����ָ�����е�ͬʱ��ָ����תǰ�������
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow_next_next = slow_next.next;
            slow_next.next = slow;
            slow = slow_next;
            slow_next = slow_next_next;
        }
        // ���е�һ����ǰһ�������ж�ǰ�����Ƿ�Գ�
        ListNode half = slow_next;
        ListNode half_reverse = fast.next == null ? slow.next : slow;
        while(half != null && half.val == half_reverse.val){
            half = half.next;
            half_reverse = half_reverse.next;
        }
        return half == null;
    }
}
