package ProblemsByType.LinkedList;

public class No_160_IntersectionOfTwoLinkedList
{
    /*
    ����һ��˫ָ�롣
    pa pbͬʱnext����paΪnullʱָ��HeadB / ��pb Ϊnull ʱָ��HeadA
    ֤������A B�����ཻ֮ǰ���ֳ���Ϊ a b����a < b�����ཻ֮�󲿷ֳ���Ϊc����ôpa�ȵ���β�߹�a + c������ָ��HeadB����ô��pa��B�����·���ߵ��ཻ���߹� a + c + b��������pb���ߵ���β�߹���b + c�����ٴ�A��ͷ��ʼ�ߵ��ཻ������ b + c + a��pa pb�߹�������ͬ��
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
    ��������Ҳ��˫ָ�룬���������ǣ���pa pbһ�����һֱ���϶̵�һ���������Ϊpb����null����ʱ�趨һ��������ָ��pa��ͷ��ʼ��δ����null��ָ��pbһ���ƶ���ֱ��pb����null��ô��ʱpaʣ��Ľ������headB�����н������ͬ����ôpa��headB��ʼͬʱ�ƶ����ɡ�
     */
    // public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    //     if(headA == null || headB == null)
    //         return null;
    //     ListNode longList = headA;
    //     ListNode shortList = headB;
    //     // ���������ÿ����һ����Ҫô��;������Ҫô��һ����������Ϊnull
    //     while(longList != null && shortList != null)
    //     {
    //         if(longList.equals(shortList))
    //             return longList;
    //         longList = longList.next;
    //         shortList = shortList.next;
    //     }
    //     // ��¼�·ǿ�����λ�ã�Ϊ�˼�������������֮��
    //     ListNode remain = longList == null ? shortList : longList;
    //     // longlistָ�������ͷ���ǿ�����ı�ͷ��shortListָ��������ͷ
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
    //     // �ǿ�������һ��������������һ�����ǿ�����ͳ������ͷͬʱ�ߣ����ǿ�������nullʱ������������㴦
    //     while(remain != null)
    //     {
    //         remain = remain.next;
    //         longList = longList.next;
    //     }
    //     // ��ʱlongListʣ����������shortListʣ����������ͬ��һ���ƶ�һ�����Ե����ཻ����һ�𵽴�null
    //     while(longList != shortList)
    //     {
    //         longList = longList.next;
    //         shortList = shortList.next;
    //     }
    //     return longList;
    // }
}
