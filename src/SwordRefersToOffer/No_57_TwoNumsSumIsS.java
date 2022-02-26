package SwordRefersToOffer;
/*	
 * LeetCode.57
 * 方法一：遍历数组当数值小于和时即有可能为结果之一，由于数组有序则对(和-这个数)在该数的左半或右半中进行二分查找，当另一个数也存在时，输出该两个数即可；
 * 方法二：前后双指针i,j指向数组的第一个数和最后一个数，并计算其和s，当s>target过大时，j前移一位来缩小其和；当s<target时，i后移一位来增大其和，直到等于target时停止；
 */
public class No_57_TwoNumsSumIsS
{
    public int[] twoSum(int[] nums, int target) {
    	int[] res =new int[2];
    	int low = 0;
    	int high = nums.length - 1;
    	boolean exist = false;
    	for(int i = 0; i < nums.length; i++)
    	{
    		if(nums[i] >= target)	break;
    		res[0] = nums[i];
    		exist = (target - nums[i]) > nums[i] ? 
    				exist(nums,i + 1,high,target - nums[i]) : exist(nums,low,i - 1,target - nums[i]);
    		if(exist)
    		{
    			res[1] = target - nums[i];
    			break;
    		}
    	}
    	return res;
    }
    
    public boolean exist(int[] nums,int low,int high,int target)
    {
    	int index = (low + high) / 2;
    	if(low > high)	return false;
    	if(low == high)
    	{
    		return nums[index] == target;
    	}
    	if(nums[index] == target)	return true;
    	else if(nums[index] < target)	return exist(nums,index + 1,high,target);
    	else return exist(nums,low,index - 1,target);
    }
}
