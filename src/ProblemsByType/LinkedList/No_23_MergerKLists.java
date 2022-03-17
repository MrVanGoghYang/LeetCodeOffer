package ProblemsByType.LinkedList;

import java.util.Comparator;
import java.util.PriorityQueue;

public class No_23_MergerKLists
{
    // ��С��д����ֱ�������ȶ���ʵ��
     public ListNode mergeKLists(ListNode[] lists) {
         PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>(){
             @Override
             public int compare(ListNode o1, ListNode o2)
             {
                 return o1.val - o2.val;
             }
         });
         for(ListNode list : lists)
         {
             if(list != null)
                 queue.offer(list);
         }
         ListNode res = new ListNode();
         ListNode p = res;
         while(!queue.isEmpty())
         {
             p.next = queue.poll();
             p = p.next;
             if(p.next != null)
                 queue.offer(p.next);
         }
         return res.next;
     }

    // �����鲢�ݹ�д��
//    public ListNode mergeKLists(ListNode[] lists) {
//        return mergeLists(lists, 0, lists.length - 1);
//    }
//
//    public ListNode mergeLists(ListNode[] lists, int left, int right)
//    {
//        // �ݹ��˳�����
//        // 1. �±�Ƿ�������null
//        if(left > right)
//            return null;
//            // 2. �±���ͬ����������һ��
//        else if(left == right)
//            return lists[left];
//            // 3. ����listֱ����������ϲ�����
//        else if(right - left == 1)
//            {
//                return mergeTwoLists(lists[left], lists[right]);
//            }
//        int mid = left + ((right - left) >> 1);
//        // �ȶ�����k/2��lists�ϲ�ʹ������
//        ListNode lres = mergeLists(lists, left, mid);
//        ListNode rres = mergeLists(lists, mid + 1, right);
//        // �ٶ���������list�鲢
//        return mergeTwoLists(lres, rres);
//    }
//
//    public ListNode mergeTwoLists(ListNode l1, ListNode l2)
//    {
//        ListNode res = new ListNode();
//        ListNode p = res;
//        while(l1 != null && l2 != null)
//        {
//            if(l1.val <= l2.val)
//            {
//                p.next = l1;
//                l1 = l1.next;
//            }
//            else
//            {
//                p.next = l2;
//                l2 = l2.next;
//            }
//            p = p.next;
//        }
//        ListNode remain = l1 == null ? l2 : l1;
//        while(remain != null)
//        {
//            p.next = remain;
//            p = p.next;
//            remain = remain.next;
//        }
//        return res.next;
//    }
}
