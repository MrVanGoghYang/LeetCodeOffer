package Problems;
/* LeetCode.06
 * 先对链表逆置，然后从头到尾赋值数组返回;
 * 其中逆置：p,q双指针一前一后移动，r临时记录q的下一个节点，用3个指针实现；
 */
public class ReversePrintLinkedList {
	public int[] reversePrint(ListNode head) {
        ListNode p = head,q = null,r=null;
        int[] res = {};
        int length = 0;
        
        if(head != null)
        {
	        if(p != null)	q = p.next;
	        while(q != null)
	        {
	        	r = q.next;
	        	q.next = p;	
	        	p = q;
	        	q = r;
	        	length += 1;
	        }
	        length += 1;
	        head.next = null;
	        head = p;
	        
	        res = new int[length];
	        for(int i = 0;i < length; i++)
	        {
	        	res[i] = head.val;
	        	head = head.next;
	        }
        }
        
        return res;  
    }
}
