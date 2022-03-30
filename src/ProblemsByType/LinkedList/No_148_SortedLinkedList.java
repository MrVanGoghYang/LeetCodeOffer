package ProblemsByType.LinkedList;

/*
思路：使用两两归并排序的思想对左半和右半链表分别排序，然后将左右两个有序的链表进行合并；
注意点：1.如何寻找链表中间结点？  使用快慢指针，快指针指向tail时，slow指向中间结点   2.找到中间结点后需要记下中间结点的next值并将next置空，否则无法使用null条件来进行merge操作的终止判断。
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
        // 快慢指针，当fast到表尾时，slow应该指向中间结点的前一个结点
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
