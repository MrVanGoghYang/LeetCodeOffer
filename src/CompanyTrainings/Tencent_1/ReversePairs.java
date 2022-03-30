package CompanyTrainings.Tencent_1;

import java.util.*;

/*
��Ϊ����Ա��СQ���������к������˵Ĳ�̫һ�������и�����
�ϰ�����СQһ�� m�Σ�ÿ�θ���һ������, Ҫ��СQ����Щ��ÿ��Ϊһ�飬Ȼ���ÿ����з�ת��СQ��֪��ÿ�β��������������е�����Ը����Ƕ����أ�

����:
��������1 3 4 2���������(4, 2),(3, 2),������Ϊ2��
��ת֮��Ϊ2 4 3 1���������(2, 1),(4, 3), (4, 1), (3, 1),������Ϊ4��

��������:
��һ��һ����
�ڶ��и�������ʾ��ʼ������()
������һ����
������m������ʾ

�������:
m��ÿ��һ������ʾ�𰸡�

��������1:
2
2 1 4 3
4
1 2 0 2

�������1:
0
6
6
0

����˵��1:
��ʼ����2 1 4 3
2^{q_1} = 2 ->
��һ�Σ�1 2 3 4 -> �������Ϊ0
2^{q_2} = 4 ->
�ڶ��Σ�4 3 2 1 -> �������Ϊ6
2^{q_3} = 1 ->
�����Σ�4 3 2 1 -> �������Ϊ6
2^{q_4} = 4 ->
���ĴΣ�1 2 3 4 -> �������Ϊ0

˼·�����ȣ��鲢����������ԣ���ָOffer 51��
���⣺�ڹ鲢����Ĺ鲢�����У�ʹ�����������¼�� ��2^iΪһ��Ԫ��ʱ�������reversePairs[i] ��ͬʱ��¼����2^iΪһ��Ԫ��ʱ�������orderPairs[i]�����������¼�˵��鲢������ε�ÿ��Ԫ������Ϊ2^iʱ��������������ԡ�
������󷨣������鷭ת����õ�����Լ�Ϊ����ԣ�
���� 4 3 2 1 ������Ϊ2^2����������������ĳ���Ϊ �η��� + 1 �� 2 + 1 = 3 ������������Ϊ[0,2,4]�����������Ϊ[0,0,0]�����ǣ�
��i=0ʱ����2^0=1��Ԫ��Ϊһ��֣�����ͳ�������֮�ͣ�����Ԫ�ؾ�������ԣ����Ϊ0��
i=1ʱ����2��Ԫ��һ��֣����Ϊ2��[4,3] [2,1]���鲢�������Ϊ[3,4,1,2]
i=2ʱ��[3,4,1,2]��4��Ԫ��һ��֣����Ϊ4��[3,1] [3,2] [4,1] [4,2]   ��������������ƣ�ֻ�Ǵ����ʼ����Ϊ��ת���[1 2 3 4]

���ÿ�η�ת����һ���������ôʱ�临�Ӷ�̫�ߣ�����ֻ��ʼ��һ�ε�����Ժ�����ԣ������ķ�ת��ʵ���Ƕ��������������н���������
��Ϊ��2^qΪһ�鷭ת����ʵ���ǹ鲢�����һ��ά��Ϊq��ÿ��Ԫ��Ϊ2^q��һ����ת����ô��������ⷭת����Ӧ�������������Ԫ�صĽ�����

����2^qΪһ���ÿ�鷭תʱ������ �±� 1 - q �������Ԫ���������Ԫ��һһ������Ϊʲô��
����[4 3 2 1] �����[0 0 0] �����[0 2 4]��������е�ÿ��Ԫ�ض���֮ǰ�Ĺ鲢������ɺ��������ģ���4����[3 4 1 2]�Ļ������������
��ô�����ʱq = 2������4Ԫ��һ�鷭ת�����Ϊ[1 2 3 4] ����Ϊ�� [4 3]��ת���[3 4]��[2 1]��ת���[1 2]��[3 4 1 2]��ת���[1 2 3 4]�γɵģ������ڶ��ֵ����ṹ
��ô���ڶ��ֺ��ÿ���ӷ�ת��������Ϊ��Ӧ��ά���±�λ�õ������Ԫ���������Ԫ�ؽ�����

 */
public class ReversePairs
{
    public static void main(String[] args)
    {
        ReversePairs solution = new ReversePairs();
        Scanner sc = new Scanner(System.in);
        //        Integer[] nums = {7,5,6,4};
        int n = sc.nextInt();
        long[] order = new long[(int)Math.pow(2, n)];
        long[] reOrder = new long[(int)Math.pow(2, n)];
        for (int i = 0; i < (int)Math.pow(2, n); i++)
        {
            order[i] = sc.nextInt();
            reOrder[(int)Math.pow(2, n) - 1 - i] = order[i];
        }
        long[] orderPairs = new long[n + 1];
        long[] reversePairs = new long[n + 1];
        // ����������鲢���򣬵õ�����������reversePairs
        solution.mergeSort(order, 0, order.length - 1, reversePairs, n);
        // ����������鲢���򣬵õ�����������orderPairs
        solution.mergeSort(reOrder, 0, order.length - 1, orderPairs, n);

        //            System.out.println(Arrays.toString(reversePairs));
        //            System.out.println(Arrays.toString(orderPairs));
        int m = sc.nextInt();
        for(int i = 0; i < m; i++)
        {
            int q = sc.nextInt();
            for(int j = 1; j <= q; j++)
            {
                orderPairs[j] += reversePairs[j];
                reversePairs[j] = orderPairs[j] - reversePairs[j];
                orderPairs[j] -= reversePairs[j];
            }
            long count = 0;
            for(int j = 1; j < reversePairs.length; j++)
                count += reversePairs[j];
            System.out.println(count);
        }
    }

    public void mergeSort(long[] nums, int left, int right, long[] reversePairs, int dim)
    {
        if(left < right)
        {
            int mid = (left + right) >> 1;
            mergeSort(nums, left, mid, reversePairs, dim - 1);
            mergeSort(nums, mid + 1, right, reversePairs, dim - 1);
            merge(nums, left, mid, mid + 1, right, reversePairs, dim);
        }
    }

    public void merge(long[] nums, int left1, int right1, int left2, int right2, long[] reversePairs, int dim)
    {
        long res = 0;
        if(nums[right1] > nums[left2])
        {
            long[] save = new long[right1 - left1 + right2 - left2 + 2];
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
            reversePairs[dim] += res;
            System.arraycopy(save, 0, nums, left1, save.length);
        }
    }
}
