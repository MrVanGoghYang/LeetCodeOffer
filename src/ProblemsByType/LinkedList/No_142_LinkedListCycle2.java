package ProblemsByType.LinkedList;

public class No_142_LinkedListCycle2
{
    // 快慢指针相遇点往前一位开始，与一个head的指针同时每次走一步，那么会在环入口处相遇。
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null)
            return null;
        ListNode slow = head;
        ListNode fast = head.next;
        while(slow != fast)
        {
            if(fast == null || fast.next == null)
                return null;
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode p = head;
        slow = slow.next;
        while(slow != p)
        {
            slow = slow.next;
            p = p.next;
        }
        return slow;
    }
}
