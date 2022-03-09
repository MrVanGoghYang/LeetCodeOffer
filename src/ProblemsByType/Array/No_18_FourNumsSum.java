package ProblemsByType.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
思路：先对数组排序，然后固定第一个加数下标i从0至length - 3，固定第二个加数下标j从i+1至length - 2，再使用双指针分别指向 p = ,j + 1 和 q = length - 1，
     双指针相向移动，三数和小与target就p++，三数和大于target就q--，三数和等于target就放入结果并p++,q++
注意：四个数的指针i j p q移动时均需去重，即移动一位后所得数与移动之前相同，就需要继续移动直至找到不同的为止。  Arrays.asList(T.. num)
可以将n数和抽象为递归函数 nSum(int[] nums, int n, int begin, int target)
 */
public class No_18_FourNumsSum
{
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 3; i++)
        {
            for(int j = i + 1; j < nums.length - 2; j++)
            {
                int p = j + 1;
                int q = nums.length - 1;
                while(p < q)
                {
                    int sum = nums[i] + nums[j] + nums[p] + nums[q];
                    if(sum < target)
                    {
                        // 第三个数p指针去重移动
                        while(p < q && nums[++p] == nums[p - 1]);
                    }
                    else if(sum > target)
                    {
                        // 第四个数q指针去重移动
                        while(p < q && nums[--q] == nums[q + 1]);
                    }
                    else
                    {
                        res.add(new ArrayList<Integer>(Arrays.asList(nums[i], nums[j], nums[p], nums[q])));
                        // 第三个数p指针去重移动
                        while(p < q && nums[++p] == nums[p - 1]);
                        // 第四个数q指针去重移动
                        while(p < q && nums[--q] == nums[q + 1]);
                    }
                }
                // 第二个数去重移动
                while(j + 1 < nums.length - 2 && nums[j] == nums[j + 1])   j++;
            }
            // 第一个数去重移动
            while(i + 1 < nums.length - 3 && nums[i] == nums[i + 1])   i++;
        }
        return res;
    }
}
