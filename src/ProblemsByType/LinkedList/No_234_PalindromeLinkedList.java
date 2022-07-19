package ProblemsByType.LinkedList;

public class No_234_PalindromeLinkedList
{
    //思路：首先使用快慢指针找到链表中点，然后让慢指针在走的过程中逆转链表，这样找到中点的时候前半段链表已经逆转。那么从中间开始一个指针向前一个指针向后，依次比较是否相等即
    public boolean isPalindrome(ListNode head) {
        if(head.next == null)
            return true;
        if(head.next.next == null)
            return head.val == head.next.val;

        ListNode fast = head;
        ListNode slow = head;
        ListNode slow_next = slow.next;
        ListNode slow_next_next = slow_next.next;

        // 快慢指针找中点同时慢指针逆转前半段链表
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow_next_next = slow_next.next;
            slow_next.next = slow;
            slow = slow_next;
            slow_next = slow_next_next;
        }
        // 从中点一个往前一个往后判断前后半段是否对称
        ListNode half = slow_next;
        ListNode half_reverse = fast.next == null ? slow.next : slow;
        while(half != null && half.val == half_reverse.val){
            half = half.next;
            half_reverse = half_reverse.next;
        }
        return half == null;
    }
}
