package Problems;
/*
 * 	LeetCode.53.1
 * 	所给数组有序，则首先找到第一个与目标数字相等的位置，从该位置开始往后搜索统计target出现的次数即可;
 */
public class SearchInOrderArray {
    public int search(int[] nums, int target) 
    {
    	int i = 0;
    	int count = 0;
    	for(i = 0; i < nums.length; i++)
    	{
    		if(nums[i] == target)
    			break;
    	}
    	if(i < nums.length)
    	{
	    	while(i < nums.length && nums[i] == target)
	    	{
	    		count++;
	    		i++;
	    	}
    	}
    	return count;
    }
}
