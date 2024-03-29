package SwordRefersToOffer;

import SwordRefersToOffer.DataDefine.ListNode;

public class No_25_MergeTwoLists
{
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null)
            return null;
        else if(l1 == null)   return l2;
        else if(l2 == null)   return l1;
            else
            {
                if(l1.val <= l2.val)
                {
                    l1.next = mergeTwoLists(l1.next,l2);
                    return l1;
                }
                if(l2.val <= l1.val)
                {
                    l2.next = mergeTwoLists(l1,l2.next);
                    return l2;
                }
            }
        return l1.val < l2.val ? l1 : l2;
    }
}
