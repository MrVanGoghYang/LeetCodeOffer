package ProblemsByType.Array;

public class No_11_MaxVolumeContainer
{
    /*
    思路：首尾双指针相向移动，每次移动高较小的一个指针，可保证不丢失最大面积。
     */
    public int maxArea(int[] height) {
        int max = 0;
        int p = 0;
        int q = height.length - 1;
        while(p < q)
        {
            max = Math.max(max, (q - p) * Math.min(height[p], height[q]));
            if(height[p] <= height[q])
                p++;
            else
                q--;
        }
        return max;
    }
}
