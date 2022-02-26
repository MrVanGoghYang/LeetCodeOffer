package SwordRefersToOffer;
/*	LeetCode.04
 * 由于行列均为递增有序，故扫描target可能在哪一行，然后对那一行二分查找；
 */
public class No_04_TwoDimensionArraySearch
{
	public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int n = matrix.length;
		int m;
		m = (n == 0) ? 0: matrix[0].length;
		if( n > 0 && m > 0)
		{
			if((target < matrix[0][0]) || (target > matrix[n-1][m-1]))
					return false;
			for(int i = 0; i < n; i++)
			{
				if(target >= matrix[i][0] && target <= matrix[i][m-1])
				{
					if(binSearch(matrix[i],0,m-1,target))
						return true;
				}
			}
		}
		return false;
    }

    public boolean binSearch(int[] arr,int low,int high,int target)
	{
		if(low > high)	return false;
		else if(low == high) return (arr[low] == target);
		else
		{
			if(arr[(low+high)/2] == target)
			{
				return true;
			}
			else if(arr[(low+high)/2] > target)
			{
				return binSearch(arr, low, (low+high)/2 - 1, target);
			}
			else 
			{
				return binSearch(arr, (low+high)/2 + 1, high, target);
			}
		}
	}
}
