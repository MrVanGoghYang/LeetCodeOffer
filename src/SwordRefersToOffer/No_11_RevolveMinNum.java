package SwordRefersToOffer;
/* LeetCode.11
 * 从前往后扫描当扫描到后一个数比前一个数小时，记后一个数为Min;
 */
public class No_11_RevolveMinNum
{
	 public int minArray(int[] numbers) 
	 {
	        if(numbers.length == 1)		return numbers[0];
	    	else if(numbers.length >= 2)
	    	{
	    		int min = numbers[0];
		    	int cur;
		    	for(int i = 1; i < numbers.length ; i++)
		    	{
		    		cur = numbers[i];
		    		if(cur < min)	
					{	
		    			min = cur;
		    			break;
					}
		    	}
		    	return min;
	    	}
	    	else return -1;
	 }
}
