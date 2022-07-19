package ProblemsByType.Array;

public class No_238_ProductOfArrayExceptSelft
{
    public int[] productExceptSelf(int[] nums) {
        int[] answer = new int[nums.length];
        // һ��ѭ�������ÿ��Ԫ�ص�ǰ׺������answer������
        answer[0] = 1;
        for(int i = 1; i < nums.length; i++){
            answer[i] = nums[i - 1] * answer[i - 1];
            // System.out.println(i + ": " + answer[i]);
        }
        // �ڶ���ѭ������ÿ��Ԫ�صĺ�׺��ʹ�ñ������棬ͬʱ����answer
        int right = 1;
        for(int i = nums.length - 2; i >= 0; i--){
            right *= nums[i + 1];
            answer[i] *= right;
            // System.out.println(i + ": " + answer[i]);
        }
        return answer;
    }
}
