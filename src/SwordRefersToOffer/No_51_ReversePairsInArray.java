package SwordRefersToOffer;

/*
�������е��������֣����ǰ��һ�����ִ��ں�������֣����������������һ������ԡ�����һ�����飬�����������е�����Ե�������

ʾ�� 1:
����: [7,5,6,4]
���: 5

˼·������� = �鲢���򣡣���
����������������鲢ʱ��ʹ��˫ָ�룬���ڸ��������������ߵ�����Ԫ�ط���洢����ʱ��˵�������������ұ��Ѿ�����洢�����е�Ԫ�أ��� ��ߴ����ұ� ��
��ô����Ե������Ϳ��Լ����ұ�����ָ���λ������
 */
public class No_51_ReversePairsInArray
{
    public static void main(String[] args)
    {
        No_51_ReversePairsInArray solution = new No_51_ReversePairsInArray();
        int[] nums = {7,5,6,4};
        System.out.println(solution.reversePairs(nums));
    }

    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    public int mergeSort(int[] nums, int left, int right)
    {
        int res = 0;
        if(left < right)
        {
            int mid = (left + right) >> 1;
            res += mergeSort(nums, left, mid);
            res += mergeSort(nums, mid + 1, right);
            res += merge(nums, left, mid, mid + 1, right);
        }
        return res;
    }

    public int merge(int[] nums, int left1, int right1, int left2, int right2)
    {
        int res = 0;
        if(nums[right1] > nums[left2])
        {
            int[] save = new int[right1 - left1 + right2 - left2 + 2];
            int p = left1;
            int q = left2;
            int idx = 0;
            while(p <= right1 && q <= right2)
            {
                if(nums[p] <= nums[q])
                {
                    save[idx++] = nums[p];
                    p++;
                    res += q - left2;
                }
                else
                {
                    save[idx++] = nums[q];
                    q++;
                }
            }
            while (q <= right2)
            {
                save[idx++] = nums[q++];
            }
            while (p <= right1)
            {
                save[idx++] = nums[p++];
                res += q - left2;
            }

            System.arraycopy(save, 0, nums, left1, save.length);
        }
        return res;
    }
}
