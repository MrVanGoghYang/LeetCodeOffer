package Problems;
/*
 * 	LeetCode.53.1
 * 	�������������������ҵ���һ����Ŀ��������ȵ�λ�ã��Ӹ�λ�ÿ�ʼ��������ͳ��target���ֵĴ�������;
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
