package ProblemsByType.Array;

public class No_240_Search2DMatrix
{
    public boolean searchMatrix(int[][] matrix, int target) {
        for(int i = 0; i < matrix.length; i++){
            if(matrix[i][0] <= target && matrix[i][matrix[0].length - 1] >= target){
                if(binarySearch(matrix[i], target))
                    return true;
            }
        }
        return false;
    }

    public boolean binarySearch(int[] matrix, int target)
    {
        int left = 0;
        int right = matrix.length - 1;
        while(left <= right){
            int mid = left + ((right - left + 1) >> 1);
            // System.out.println(left + " " + right + " " + mid);
            if(matrix[mid] == target)
                return true;
            else if(matrix[mid] < target){
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }
        return false;
    }
}
