package CompanyTrainings.Tencent_1;

import java.util.*;

/*
作为程序员的小Q，他的数列和其他人的不太一样，他有个数。
老板问了小Q一共 m次，每次给出一个整数, 要求小Q把这些数每分为一组，然后把每组进行翻转，小Q想知道每次操作后整个序列中的逆序对个数是多少呢？

例如:
对于序列1 3 4 2，逆序对有(4, 2),(3, 2),总数量为2。
翻转之后为2 4 3 1，逆序对有(2, 1),(4, 3), (4, 1), (3, 1),总数量为4。

输入描述:
第一行一个数
第二行个数，表示初始的序列()
第三行一个数
第四行m个数表示

输出描述:
m行每行一个数表示答案。

输入例子1:
2
2 1 4 3
4
1 2 0 2

输出例子1:
0
6
6
0

例子说明1:
初始序列2 1 4 3
2^{q_1} = 2 ->
第一次：1 2 3 4 -> 逆序对数为0
2^{q_2} = 4 ->
第二次：4 3 2 1 -> 逆序对数为6
2^{q_3} = 1 ->
第三次：4 3 2 1 -> 逆序对数为6
2^{q_4} = 4 ->
第四次：1 2 3 4 -> 逆序对数为0

思路：首先，归并排序求逆序对，剑指Offer 51，
本题：在归并排序的归并过程中，使用两个数组记录下 以2^i为一组元素时的逆序对reversePairs[i] ，同时记录下以2^i为一组元素时的正序对orderPairs[i]，两个数组记录了当归并排序分治到每组元素数量为2^i时所产生的正逆序对。
正序对求法：将数组翻转后求得的逆序对即为正序对；
比如 4 3 2 1 ，长度为2^2，因此正逆序对数组的长度为 次方数 + 1 即 2 + 1 = 3 求得逆序对数组为[0,2,4]，正序对数组为[0,0,0]含义是：
当i=0时，按2^0=1个元素为一组分，各组统计逆序对之和，单个元素均无逆序对，结果为0；
i=1时，按2个元素一组分，结果为2即[4,3] [2,1]，归并后的数组为[3,4,1,2]
i=2时，[3,4,1,2]按4个元素一组分，结果为4即[3,1] [3,2] [4,1] [4,2]   正序对数组求法类似，只是传入初始数组为反转后的[1 2 3 4]

如果每次翻转都求一次逆序对那么时间复杂度太高，考虑只求开始第一次的正序对和逆序对，后续的翻转其实都是对正逆序对数组进行交换操作。
因为以2^q为一组翻转，其实就是归并排序的一个维度为q即每组元素为2^q的一个翻转，那么这个子问题翻转即对应的正逆序对数组元素的交换。

当以2^q为一组对每组翻转时，即对 下标 1 - q 的正序对元素与逆序对元素一一交换，为什么：
考虑[4 3 2 1] 正序对[0 0 0] 逆序对[0 2 4]，逆序对中的每个元素都在之前的归并排序完成后计算出来的，如4是在[3 4 1 2]的基础上算出来的
那么如果此时q = 2，即以4元素一组翻转，结果为[1 2 3 4] 可视为由 [4 3]翻转结果[3 4]、[2 1]翻转结果[1 2]、[3 4 1 2]翻转结果[1 2 3 4]形成的，类似于二分的树结构
那么对于二分后的每个子翻转，其结果即为对应的维度下标位置的正序对元素与逆序对元素交换。

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
        // 对正序输入归并排序，得到数组的逆序对reversePairs
        solution.mergeSort(order, 0, order.length - 1, reversePairs, n);
        // 对逆序输入归并排序，得到数组的正序对orderPairs
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
