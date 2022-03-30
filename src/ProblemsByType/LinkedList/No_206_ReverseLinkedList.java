package ProblemsByType.LinkedList;

public class No_206_ReverseLinkedList
{
    // 迭代反转：定义反转链表头结点，使用头插法把所有链表元素插入到反转链表的第一个位置
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
    // 递归反转，先将结点p的后续所有结点反转后，p.next指向的结点就变成了反转后的最后一个结点所以将p.next.next = p 即将p尾插到反转后的链表最后
    // 注意还要设置p.next = null因此此时p为反转链表的最后一个指针了。
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
