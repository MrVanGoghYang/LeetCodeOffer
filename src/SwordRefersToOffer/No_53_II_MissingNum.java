package SwordRefersToOffer;

public class No_53_II_MissingNum
{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		No_53_II_MissingNum solution = new No_53_II_MissingNum();
		int[] nums = {0,2};
		System.out.println(solution.missingNumber2(nums));
	}
	
    public int missingNumber(int[] nums) {
    	int length = nums.length;
    	int i = 0;
    	if(length != 0 && nums[0] != 0)	return 0;
    	if(length != 0 && nums[length - 1] != length)	return length;
    	while(i < length && i + 1 < length && (nums[i + 1] - nums[i] == 1 ))
    	{
    		i++;
    	}
    	return nums[i] + 1;
    }
    
    public int missingNumber2(int[] nums) {
    	int i = 0;
    	for(i = 0; i < nums.length; i++)
    	{
    		if(i + 1 < nums.length && nums[i + 1] - nums[i] != 1)
    			break;
    	}
    	return nums[i] + 1;
    }

}
