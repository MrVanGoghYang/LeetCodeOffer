package ProblemsByType.Array;

import java.util.*;

/*
思路：设置一个区间左右指针，在扫描过程中如果有重合部分就更新右指针，直到没有重合的时候将左右指针组成区间加入结果，并设置左右指针为新的区间左右端点。
 */
public class No_56_MergeIntervals
{
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b)
            {
                return a[0] != b[0] ? a[0] - b[0] : b[1] - a[1];
            }
        });
        List<int[]> resList = new ArrayList<>();
        int[][] res;
        int left = intervals[0][0];
        int right = intervals[0][1];
        for(int i = 1; i < intervals.length; i++)
        {
            if(intervals[i][0] >= left && intervals[i][0] <= right)
            {
                right = Math.max(right, intervals[i][1]);
                // System.out.println("1 (" + left + ", " + right + ")");
            }
            else
            {
                resList.add(new int[]{left, right});
                left = intervals[i][0];
                right = intervals[i][1];
                // System.out.println("2 (" + left + ", " + right + ")");
            }
            while(i + 1 < intervals.length && intervals[i + 1][0] == intervals[i][0])
                i++;
        }
        resList.add(new int[]{left, right});
        // res = new int[resList.size()][2];
        // int index = 0;
        // for(int[] item : resList)
        // {
        //     System.arraycopy(item, 0, res[index++], 0, 2);
        // }
        return resList.toArray(new int[resList.size()][2]);
    }
}
