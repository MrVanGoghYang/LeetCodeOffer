package SwordRefersToOffer;
/* LeetCode.03
 * 对数组排序后扫描，当出现前后重复的即返回;
 */
import java.util.Arrays;

public class No_03_RepeatNumInArray
{
	
	public int findRepeatNumber(int[] nums) {
		int pre = 0;
		int rear = 0;
		Arrays.sort(nums);
		for(int i = 0; i < nums.length; i++)
		{
			rear = i;
			if((pre != rear) && nums[pre] == nums[rear])
				return nums[pre];
			pre = rear;
		}
		return -1;
    }

    public void quicksort(int[] arr,int bot,int top)
	{
		int l = bot, h = top;
		int cur = arr[bot];
		while(bot < top)
		{
			while(arr[top] >= cur && top > bot)	top--;
			while(arr[bot] <= cur && top > bot)	bot++;
			if(bot < top)
			{
				arr[top] += arr[bot];
				arr[bot] = arr[top] - arr[bot];
				arr[top] -= arr[bot];
				
			}
		}
		if(top != l)
		{
			arr[top] += arr[l];
			arr[l] = arr[top] - arr[l];
			arr[top] -= arr[l];
		}
		
		if((top-1) >= 0 && (top-1) > l)
			quicksort(arr,l,top-1);
		if((top+1) <= h && (top+1) < h)
			quicksort(arr,top+1,h);
	}

}
