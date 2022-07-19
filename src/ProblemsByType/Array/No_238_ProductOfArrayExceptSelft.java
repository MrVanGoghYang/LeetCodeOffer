package ProblemsByType.Array;

public class No_238_ProductOfArrayExceptSelft
{
    public int[] productExceptSelf(int[] nums) {
        int[] answer = new int[nums.length];
        // 一轮循环计算出每个元素的前缀积存在answer数组中
        answer[0] = 1;
        for(int i = 1; i < nums.length; i++){
            answer[i] = nums[i - 1] * answer[i - 1];
            // System.out.println(i + ": " + answer[i]);
        }
        // 第二轮循环计算每个元素的后缀积使用变量保存，同时更新answer
        int right = 1;
        for(int i = nums.length - 2; i >= 0; i--){
            right *= nums[i + 1];
            answer[i] *= right;
            // System.out.println(i + ": " + answer[i]);
        }
        return answer;
    }
}
