package ProblemsByType.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
思路：由二数和、三数和、四数和可得到递归的N数和，n = 2为base case，直接做两数和，n > 3则递归调用
 */
public class nNumsSum
{
    public static void main(String[] args)
    {
        int[] nums = {1,0,-1,0,-2,2};
        int target = 0;
        int n = 4;
        Arrays.sort(nums);
        System.out.println(new nNumsSum().recurseNSum(nums, n, 0, target));
    }

    public List<List<Integer>> recurseNSum(int[] nums, int n, int begin, int target)
    {
        List<List<Integer>> res = new ArrayList<>();
        // base case 两数和
        if(n == 2)
        {
            int p = begin;
            int q = nums.length - 1;
            while(p < q)
            {
                int sum = nums[p] + nums[q];
                if(sum < target)
                {
                    // 第一个数p指针去重移动
                    while (p < q && nums[++p] == nums[p - 1]) ;
                }
                else if(sum > target)
                {
                    // 第二个数q指针去重移动
                    while(p < q && nums[--q] == nums[q + 1]);
                }
                else
                {
                    res.add(new ArrayList<Integer>(Arrays.asList(nums[p], nums[q])));
                    // 第一个数p指针去重移动
                    while (p < q && nums[++p] == nums[p - 1]) ;
                    // 第二个数q指针去重移动
                    while(p < q && nums[--q] == nums[q + 1]);
                }
            }
        }
        else // 大于两数和递归调用
        {
            // 固定第1位
            for(int i = begin; i <= nums.length - n; i++)
            {
                // 递归解决子问题，从i + 1开始扫描，目标为找到n - 1个和为target - nums[i]的结果；
                List<List<Integer>> subRes = recurseNSum(nums, n - 1, i + 1, target - nums[i]);
                // 对于所得n-1数和结果，加入当前固定的第1位数，得到n数和
                for(List list : subRes)
                {
                    list.add(nums[i]);
                    res.add(list);
                }
                // 对第1位数去重移动
                while(i + 1 <= nums.length - n && nums[i + 1] == nums[i])   i++;
            }
        }
        return res;
    }
}
