package ProblemsByType.Array;

import java.util.*;

/*
思路：先对数组排序，然后固定第一个加数下标i从0至length - 3，再使用双指针分别指向 p = i + 1 和 q = length - 1，双指针相向移动，三数和小0就p++，三数和大0就q--，三数和等于0就放入结果并p++,q++
注意：三个数的指针移动时均需去重，即移动一位后所得数与移动之前相同，需要继续移动直至找到不同的为止。  Arrays.asList(T.. num)
 */
public class No_15_ThreeNumsSum
{
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2; i++)
        {
            int p = i + 1;
            int q = nums.length - 1;
            while(p < q)
            {
                int sum = nums[i] + nums[p] + nums[q];
                if(sum < 0)
                {
                    // 第二个数p指针去重移动
                    while(p < q && nums[p] == nums[p + 1])  p++;
                    p++;
                }
                else if(sum > 0)
                {
                    // 第三个数q指针去重移动
                    while(p < q && nums[q] == nums[q - 1])  q--;
                    q--;
                }
                else
                {
//                    ArrayList<Integer> list = new ArrayList<>();
//                    list.add(nums[i]);
//                    list.add(nums[p]);
//                    list.add(nums[q]);
//                    res.add(list);
                    res.add(new ArrayList<Integer>(Arrays.asList(nums[i], nums[p], nums[q])));
                    // 第二个数p指针去重移动
                    while(p < q && nums[p] == nums[p + 1])  p++;
                    p++;
                    // 第三个数q指针去重移动
                    while(p < q && nums[q] == nums[q - 1])  q--;
                    q--;
                }
            }
            // 第一个数去重移动
            while(i + 1 < nums.length - 2 && nums[i] == nums[i + 1])   i++;
        }
        return res;
    }
}
