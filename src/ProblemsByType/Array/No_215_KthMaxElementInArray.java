package ProblemsByType.Array;

import java.util.PriorityQueue;

public class No_215_KthMaxElementInArray
{
    /*
     方法一：最小堆（使用优先队列实现），始终保持堆中有K个元素，那么堆顶始终是第K大的元素，因为其下面有K - 1个元素都比他大
     */
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int num : nums) {
            heap.add(num);
            if (heap.size() > k) {
                heap.poll();
            }
        }
        return heap.peek();
    }

    /*
    方法二： 基于快速排序的划分思想，寻找第K大元素转换为下标一致的寻找第len - k + 1个元素。
            递归过程，如果在[begin, end]区间内找到的一个pivort的划分位置index为从begin开始的第k个即下标为begin + k - 1，那么就返回；
            否则如果：找到pivort的划分位置index在在第k个之前，即 index < begin + k - 1，那么说明到pivort为止已经有了index - begin + 1个最小元素，只需要从index + 1开始再寻找第 k - (index - begin + 1)个最小元素即可；
            否则： 找到pivort的划分位置index在在第k个之后，即 index > begin + k - 1，那么说明到pivort位置已经有了index - begin + 1个最小元素，还是需要从beigin开始到index - 1寻找第k小的元素。
     */
    // public int findKthLargest(int[] nums, int k) {
    //     int len = nums.length;
    //     return findKthLeast(nums, 0, len - 1, len - k + 1);
    // }

    // public int findKthLeast(int[] nums, int begin, int end, int k)
    // {
    //     int index = partition(nums, begin, end);
    //     // System.out.println("index: " + index + " begin: " + begin + " end: " + end + " k: " + k);
    //     // System.out.println(Arrays.toString(nums));
    //     if(index == begin + k - 1)
    //         return nums[index];
    //     else if(index < begin + k - 1)
    //         return findKthLeast(nums, index + 1, end, k - (index - begin + 1));
    //     else
    //         return findKthLeast(nums, begin, index - 1, k);
    // }

    // public int partition(int[] nums, int begin, int end)
    // {
    //     if(begin >= end)
    //         return begin;
    //     int p = begin;
    //     int q = end;
    //     int pivort = nums[begin];
    //     // System.out.println(pivort);
    //     while(p < q)
    //     {
    //         while(p < q && nums[q] > pivort)
    //             q--;
    //         if(p < q)
    //             nums[p] = nums[q];
    //         while(p < q && nums[p] <= pivort)
    //             p++;
    //         if(p < q)
    //             nums[q] = nums[p];
    //     }
    //     nums[p] = pivort;
    //     return p;
    // }
}
