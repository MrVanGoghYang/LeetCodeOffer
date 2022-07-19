package CompanyExams.HuaTaiExams;

import java.util.*;


public class Solution {
    public static void main(String[] args)
    {
        int[] arr = new int[]{100,4,200,1,3,2};
        System.out.println(new Solution().MLS(arr));
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * max increasing subsequence
     * @param arr int整型一维数组 the array
     * @return int整型
     *
     * [100,4,200,1,3,2]
     * 4
     */
    public int MLS (int[] arr) {
        // write code here
        Arrays.sort(arr);
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < arr.length; i++) {
            if(!map.containsKey(arr[i]))
                map.put(arr[i], i);
        }
        int[] dp = new int[arr.length];
        int max = -1;
        for(int i = 0; i < arr.length; i++) {
            int preIndex = map.getOrDefault(arr[i] - 1, -1);
            if(preIndex != -1) {
                dp[i] = dp[preIndex] + 1;
                max = Math.max(max, dp[i]);
            }
        }
        return max;
    }
}