package ProblemsByType.Array;

public class No_283_MoveZeros
{
    public void moveZeroes(int[] nums) {
        int index = 0;
        int count = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0){
                count++;
                continue;
            }
            nums[index++] = nums[i];
        }
        for(int i = count; i > 0; i--)
            nums[index++] = 0;
    }

}
