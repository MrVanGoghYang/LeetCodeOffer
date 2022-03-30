package ProblemsByType.Array;

import java.util.PriorityQueue;

public class No_215_KthMaxElementInArray
{
    /*
     ����һ����С�ѣ�ʹ�����ȶ���ʵ�֣���ʼ�ձ��ֶ�����K��Ԫ�أ���ô�Ѷ�ʼ���ǵ�K���Ԫ�أ���Ϊ��������K - 1��Ԫ�ض�������
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
    �������� ���ڿ�������Ļ���˼�룬Ѱ�ҵ�K��Ԫ��ת��Ϊ�±�һ�µ�Ѱ�ҵ�len - k + 1��Ԫ�ء�
            �ݹ���̣������[begin, end]�������ҵ���һ��pivort�Ļ���λ��indexΪ��begin��ʼ�ĵ�k�����±�Ϊbegin + k - 1����ô�ͷ��أ�
            ����������ҵ�pivort�Ļ���λ��index���ڵ�k��֮ǰ���� index < begin + k - 1����ô˵����pivortΪֹ�Ѿ�����index - begin + 1����СԪ�أ�ֻ��Ҫ��index + 1��ʼ��Ѱ�ҵ� k - (index - begin + 1)����СԪ�ؼ��ɣ�
            ���� �ҵ�pivort�Ļ���λ��index���ڵ�k��֮�󣬼� index > begin + k - 1����ô˵����pivortλ���Ѿ�����index - begin + 1����СԪ�أ�������Ҫ��beigin��ʼ��index - 1Ѱ�ҵ�kС��Ԫ�ء�
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
