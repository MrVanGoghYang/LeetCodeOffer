package CompanyExams.TencentExams.Problem4;

import java.util.*;


public class Main
{
     public class ListNode {
         int val;
         ListNode next = null;
         public ListNode(int val) {
             this.val = val;
     }
}
    public ListNode solve (ListNode[] a) {
        // write code here
        List<List<Integer>> lists=new ArrayList<>();
        for (int i=0;i<a.length;i++){
            List<Integer> list=new ArrayList<>();
            ListNode tem=a[i];
            list.add(tem.val);
            while (tem.next!=null){
                tem=tem.next;
                list.add(tem.val);
            }
            lists.add(list);
        }

        Set<Integer> set=new HashSet<>();
        for (int i=0;i<lists.get(0).size();i++){
            set.add(lists.get(0).get(i));
        }
        while (lists.size()>1){
            int lo=1;
            for (int j=1;j<lists.size();j++){
                boolean flag =false;
                for (int i=0;i<lists.get(j).size();i++){
                    if(set.contains(lists.get(j).get(i))){
                        flag=true;
                        break;
                    }
                }
                if(flag){
                    lo=j;
                    break;
                }
            }

            //forward
            int fl=0;
            for (int i=0;i<lists.get(lo).size();i++){
                if(set.contains(lists.get(lo).get(i))){
                    fl=1;
                    continue;
                }
                if(fl==0){
                    lists.get(0).add(0,lists.get(lo).get(i));
                }else {
                    lists.get(0).add(lists.get(lo).get(i));
                }
                set.add(lists.get(lo).get(i));
            }
            lists.remove(lo);
        }

        int min_lo=0;
        int min=lists.get(0).get(0);
        for (int i=1;i<lists.get(0).size();i++){
            if(lists.get(0).get(i)<min){
                min=lists.get(0).get(i);
                min_lo=i;
            }
        }

        int back=0;
        int forward=0;
        if(min_lo==0){
            back=1;
            forward=lists.get(0).size()-1;
        }else if(min_lo==lists.get(0).size()-1){
            back=0;
            forward=min_lo-1;
        }else {
            back=min_lo+1;
            forward=min_lo-1;
        }

        List<Integer> result =new ArrayList<>();
        if(lists.get(0).get(back)<lists.get(0).get(forward)){
            for (int i=min_lo;i<lists.get(0).size();i++){
                result.add(lists.get(0).get(i));
            }
            for (int i=0;i<min_lo;i++){
                result.add(lists.get(0).get(i));
            }
        }else {
            for (int i=min_lo;i>=0;i--){
                result.add(lists.get(0).get(i));
            }
            for (int i=lists.get(0).size()-1;i>min_lo;i--){
                result.add(lists.get(0).get(i));
            }
        }

        ListNode head = new ListNode(0);
        ListNode ret = head;
        for(Integer item : result)
        {
            ListNode node = new ListNode(item);
            head.next = node;
            head = head.next;
        }
        return ret.next;
    }
}
