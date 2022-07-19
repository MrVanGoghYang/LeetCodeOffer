package ProblemsByType.LinkedList;

import java.util.*;

public class No_239_SlidingWindowMaximum
{
    // O(1)ʱ�����ҵ����������ڵ����ֵ��ʹ��˫�˵����ݼ����У��������ȶ��У���ÿ��ֱ��ȡ���ף�
    // ��������ȶ��е��ŵ㣺���ȶ��ж����м���Ԫ���öѽ������򣻶��������е������µ�Ԫ��ֵ���ڶ���������Ԫ��ֵʱ������ɾ������������Ԫ��ֵ��Ϊ�������Ǻ����Ľ���ˡ�
    // ��С����ά����ģ�����ڲ������ֵʱֻ��Ҫ�������������Ԫ�ؼ��ɣ������ܳ��֡������������ֵ���ڴ����������������ȶ��л�������������
    // �������ȶ���k = 3������ĳһ�μ���Ԫ�غ����[�� �� �� ��]����ʱ����Ϊ�������һ�μ���Ԫ�ض��б�Ϊ[�� �� �� �� ��]����ô�����˶��������Ԫ���ڶ��ף�
    // ������˫�˵������в������[�� �� �� ��]���������Ϊ��һ�����ڡ�����ʱ���ڱȺ������˺���ġ��⡱�ѱ����ӣ�ֻ������[�� �� �� ��]�������������1��Ԫ���ڴ����⡣
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> queue = new LinkedList<>(); // new ArrayDeque<>();
        for(int i = 0; i < nums.length; i++){
            // �������У����ʱ��Ҫ����βԪ�ر�֤��βԪ�ش������Ԫ�أ������βԪ�ز������Ǻ������ֱ�ӳ���
            while(!queue.isEmpty() && nums[queue.peekLast()] < nums[i]){
                queue.pollLast();
            }
            queue.offer(i);
            // �������ʼ�����Ҷ�ʱ��ʼ��ֵ
            if(i >= k - 1){
                // ���ߵ�kλ�����󣬿��ܳ��ֶ��������ֵ���ڻ��������ڣ���Ҫ���Ӳ��ڴ����ڵ����ֵ
                if(queue.peekFirst() < (i - k + 1)){
                    queue.pollFirst();
                }
                res[i - k + 1] = nums[queue.peekFirst()];
            }
        }
        return res;
    }

    // ���ȶ���
    // public int[] maxSlidingWindow(int[] nums, int k) {
    //    int[] res = new int[nums.length - k + 1];
    //    Queue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>(){
    //        @Override
    //        public int compare(Integer a, Integer b){
    //            return nums[b] - nums[a];
    //        }
    //    });
    //    for(int i = 0; i < nums.length; i++){
    //        queue.offer(i);
    //        if(i >= k - 1){
    //            // �˴�Ϊ���ȶ����뵥��˫�˶��е��������ȶ��п��ܳ��ֶ����ж���1��Ԫ���ڴ�������������Ҫѭ������
    //            while(queue.peek() < (i - k + 1)){
    //                queue.poll();
    //            }
    //            res[i - k + 1] = nums[queue.peek()];
    //        }
    //    }
    //     return res;
    // }
}
