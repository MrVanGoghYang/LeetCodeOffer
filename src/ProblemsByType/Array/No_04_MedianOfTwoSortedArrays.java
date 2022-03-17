package ProblemsByType.Array;

public class No_04_MedianOfTwoSortedArrays
{
    // 思路：两个有序数组的中位数，可转化为寻找两个数组中第K小的元素，K为m + n的中值，采用二分递增后比较的方式查找第K小的元素，具体方法看题解解释。
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        if(len1 == 0 && len2 == 0)
            return 0;
        else if(len1 == 0)
            return len2 % 2 == 0 ? (nums2[len2 / 2] + nums2[len2 / 2 - 1]) * 0.5 : nums2[len2 / 2]; // 注意取两个数的平均数要 * 0.5 不能用 / 2或 >> 1 因为结果只会为整数
        else if(len2 == 0)
                return len1 % 2 == 0 ? (nums1[len1 / 2] + nums1[len1 / 2 - 1]) * 0.5 : nums1[len1 / 2];

        int k1 = -1;
        int k2 = -1;
        int k1MinNum = Integer.MAX_VALUE;
        int k2MinNum = Integer.MAX_VALUE;
        k1 = (len1 + len2 + 1) >> 1;
        if((len1 + len2) % 2 == 0)
            k2 = k1 + 1;
        k1MinNum = findKthMinNum(nums1, 0, nums2, 0, k1);
        // System.out.println("Find min k1: " + k1 + "  k1MinNum: " + k1MinNum);
        if(k2 != -1)
        {
            k2MinNum = findKthMinNum(nums1, 0, nums2, 0, k2);
            // System.out.println("Find min k2: " + k2 + "  k2MinNum: " + k2MinNum);
        }
        return k2MinNum == Integer.MAX_VALUE ? (double)k1MinNum : (double)((k1MinNum + k2MinNum) * 0.5);
    }

    public int findKthMinNum(int[] nums1, int begin1, int[] nums2, int begin2, int k)
    {
        while(k > 1)
        {
            // 若一个数组已经走到最后，那么直接取另外一个数组中的第K个元素
            if(begin1 == nums1.length)
                return nums2[begin2 + k - 1];
            if(begin2 == nums2.length)
                return nums1[begin1 + k - 1];
            // System.out.print("k: " + k);
            // 比较两个数组中从beigin开始的第 k/2 个元素，将小的那个元素比较位置移动到 k / 2个元素的下一个位置，即抛弃k / 2个不可能为第K小的元素。
            int halfOfk = k >> 1;
            // 比较位置需要避免数组越界，若越界则比较最后一个
            int comprareIdx1 = (begin1 + halfOfk) >= nums1.length ? nums1.length - 1 : begin1 + halfOfk - 1;
            int comprareIdx2 = (begin2 + halfOfk) >= nums2.length ? nums2.length - 1 : begin2 + halfOfk - 1;
            // 将较小的一个数组中的前 k / 2个元素丢弃，下标右移，减小K，因为它们不可能为第K小的元素
            if(nums1[comprareIdx1] <= nums2[comprareIdx2])
            {
                k -= comprareIdx1 - begin1 + 1;
                begin1 = comprareIdx1 + 1;
            }
            else
            {
                k -= comprareIdx2 - begin2 + 1;
                begin2 = comprareIdx2 + 1;
            }
            // System.out.println("  halfOfk: " + halfOfk + " begin1: " + begin1 + " begin2: " + begin2);
        }
        // 当退出后即k == 1，有一个数组走到头，那么直接取另一个数组的第1个元素；否则取两个指针指向元素的最小值
        if(begin1 >= nums1.length)
            return nums2[begin2];
        else if(begin2 >= nums2.length)
            return nums1[begin1];
        else
            return Math.min(nums1[begin1], nums2[begin2]);
    }
}
