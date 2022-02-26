package SwordRefersToOffer;
/*	
 * LeetCode.57
 * ����һ���������鵱��ֵС�ں�ʱ���п���Ϊ���֮һ�����������������(��-�����)�ڸ����������Ұ��н��ж��ֲ��ң�����һ����Ҳ����ʱ����������������ɣ�
 * ��������ǰ��˫ָ��i,jָ������ĵ�һ���������һ���������������s����s>target����ʱ��jǰ��һλ����С��ͣ���s<targetʱ��i����һλ��������ͣ�ֱ������targetʱֹͣ��
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
