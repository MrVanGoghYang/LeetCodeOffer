package ProblemsByType.Array;

public class No_04_MedianOfTwoSortedArrays
{
    // ˼·�����������������λ������ת��ΪѰ�����������е�KС��Ԫ�أ�KΪm + n����ֵ�����ö��ֵ�����Ƚϵķ�ʽ���ҵ�KС��Ԫ�أ����巽���������͡�
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        if(len1 == 0 && len2 == 0)
            return 0;
        else if(len1 == 0)
            return len2 % 2 == 0 ? (nums2[len2 / 2] + nums2[len2 / 2 - 1]) * 0.5 : nums2[len2 / 2]; // ע��ȡ��������ƽ����Ҫ * 0.5 ������ / 2�� >> 1 ��Ϊ���ֻ��Ϊ����
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
            // ��һ�������Ѿ��ߵ������ôֱ��ȡ����һ�������еĵ�K��Ԫ��
            if(begin1 == nums1.length)
                return nums2[begin2 + k - 1];
            if(begin2 == nums2.length)
                return nums1[begin1 + k - 1];
            // System.out.print("k: " + k);
            // �Ƚ����������д�beigin��ʼ�ĵ� k/2 ��Ԫ�أ���С���Ǹ�Ԫ�رȽ�λ���ƶ��� k / 2��Ԫ�ص���һ��λ�ã�������k / 2��������Ϊ��KС��Ԫ�ء�
            int halfOfk = k >> 1;
            // �Ƚ�λ����Ҫ��������Խ�磬��Խ����Ƚ����һ��
            int comprareIdx1 = (begin1 + halfOfk) >= nums1.length ? nums1.length - 1 : begin1 + halfOfk - 1;
            int comprareIdx2 = (begin2 + halfOfk) >= nums2.length ? nums2.length - 1 : begin2 + halfOfk - 1;
            // ����С��һ�������е�ǰ k / 2��Ԫ�ض������±����ƣ���СK����Ϊ���ǲ�����Ϊ��KС��Ԫ��
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
        // ���˳���k == 1����һ�������ߵ�ͷ����ôֱ��ȡ��һ������ĵ�1��Ԫ�أ�����ȡ����ָ��ָ��Ԫ�ص���Сֵ
        if(begin1 >= nums1.length)
            return nums2[begin2];
        else if(begin2 >= nums2.length)
            return nums1[begin1];
        else
            return Math.min(nums1[begin1], nums2[begin2]);
    }
}
