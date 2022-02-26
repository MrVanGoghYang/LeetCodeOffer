package Problems;
/* LeetCode.06
 * �ȶ��������ã�Ȼ���ͷ��β��ֵ���鷵��;
 * �������ã�p,q˫ָ��һǰһ���ƶ���r��ʱ��¼q����һ���ڵ㣬��3��ָ��ʵ�֣�
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
