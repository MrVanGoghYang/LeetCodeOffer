package ProblemsByType.LinkedList;

public class No_160_IntersectionOfTwoLinkedList
{
    /*
    方法一：双指针。
    pa pb同时next，当pa为null时指向HeadB / 当pb 为null 时指向HeadA
    证明：设A B链表相交之前部分长度为 a b（设a < b），相交之后部分长度为c，那么pa先到表尾走过a + c个结点后指向HeadB，那么当pa从B链表的路径走到相交处走过 a + c + b；而对于pb当走到表尾走过了b + c步，再从A表头开始走到相交处走了 b + c + a。pa pb走过距离相同。
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null)
            return null;
        ListNode pa = headA;
        ListNode pb = headB;
        while(pa != pb)
        {
            pa = pa.next;
            pb = pb.next;
            if(pa == null && pb == null)
                break;
            else if(pa == null)
                pa = headB;
            else if(pb == null)
                    pb = headA;
        }
        return pa;
    }

    /*
    方法二：也是双指针，但是做法是：先pa pb一起后移一直到较短的一个链表假设为pb到达null，此时设定一个长链表指针pa从头开始和未到达null的指针pb一起移动，直至pb到达null那么此时pa剩余的结点数和headB的所有结点数相同，那么pa和headB开始同时移动即可。
     */
    // public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    //     if(headA == null || headB == null)
    //         return null;
    //     ListNode longList = headA;
    //     ListNode shortList = headB;
    //     // 两个链表均每次走一步，要么中途相遇，要么有一个链表率先为null
    //     while(longList != null && shortList != null)
    //     {
    //         if(longList.equals(shortList))
    //             return longList;
    //         longList = longList.next;
    //         shortList = shortList.next;
    //     }
    //     // 记录下非空链表位置，为了计算两个链表长度之差
    //     ListNode remain = longList == null ? shortList : longList;
    //     // longlist指向长链表表头即非空链表的表头，shortList指向短链表表头
    //     if(longList == null)
    //     {
    //         longList = headB;
    //         shortList = headA;
    //     }
    //     else
    //     {
    //         longList = headA;
    //         shortList = headB;
    //     }
    //     // 非空链表走一步即长短链表差多一步，非空链表和长链表表头同时走，当非空链表到达null时长链表到达相差结点处
    //     while(remain != null)
    //     {
    //         remain = remain.next;
    //         longList = longList.next;
    //     }
    //     // 此时longList剩余结点数量和shortList剩余结点数量相同，一起移动一定可以到达相交结点或一起到达null
    //     while(longList != shortList)
    //     {
    //         longList = longList.next;
    //         shortList = shortList.next;
    //     }
    //     return longList;
    // }
}
