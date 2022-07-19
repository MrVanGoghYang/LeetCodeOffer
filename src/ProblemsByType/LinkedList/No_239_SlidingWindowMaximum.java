package ProblemsByType.LinkedList;

import java.util.*;

public class No_239_SlidingWindowMaximum
{
    // O(1)时间内找到滑动窗口内的最大值：使用双端单调递减队列（类似优先队列），每次直接取队首；
    // 相对于优先队列的优点：优先队列对所有加入元素用堆进行排序；而单调队列当加入新的元素值大于队列内已有元素值时，可以删除队列内已有元素值因为不可能是后续的结果了。
    // 减小队列维护规模而且在查找最大值时只需要看队首最多两个元素即可，不可能出现“队首两个最大值都在窗口外的情况”而优先队列会出现这种情况。
    // 考虑优先队列k = 3，但是某一次加入元素后队列[内 外 外 内]，此时队首为结果，下一次加入元素队列变为[外 外 外 内 内]，那么出现了多个窗口外元素在队首；
    // 而对于双端单调队列不会出现[内 外 外 内]的情况，因为第一个“内”加入时由于比后面大因此后面的“外”已被出队，只可能有[外 内 内 内]的情况即最多队首1个元素在窗口外。
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> queue = new LinkedList<>(); // new ArrayDeque<>();
        for(int i = 0; i < nums.length; i++){
            // 单调队列，入队时需要检查队尾元素保证队尾元素大于入队元素，否则队尾元素不可能是后续结果直接出队
            while(!queue.isEmpty() && nums[queue.peekLast()] < nums[i]){
                queue.pollLast();
            }
            queue.offer(i);
            // 当到达初始窗口右端时开始赋值
            if(i >= k - 1){
                // 当走到k位置往后，可能出现队列中最大值不在滑动窗口内，需要出队不在窗口内的最大值
                if(queue.peekFirst() < (i - k + 1)){
                    queue.pollFirst();
                }
                res[i - k + 1] = nums[queue.peekFirst()];
            }
        }
        return res;
    }

    // 优先队列
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
    //            // 此处为优先队列与单调双端队列的区别，优先队列可能出现队首有多于1个元素在窗口外的情况，需要循环出队
    //            while(queue.peek() < (i - k + 1)){
    //                queue.poll();
    //            }
    //            res[i - k + 1] = nums[queue.peek()];
    //        }
    //    }
    //     return res;
    // }
}
