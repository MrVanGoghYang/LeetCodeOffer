package ProblemsByType.LinkedList;

public class No_141_LinkedListCycle
{
    // ¿ìÂýÖ¸Õë
    public boolean hasCycle(ListNode head) {
        ListNode low = head;
        ListNode fast = head;
        while(fast != null && fast.next != null)
        {
            low = low.next;
            fast = fast.next.next;
            if(low == fast)
                return true;
        }
        return false;
    }
}
