package ProblemsByType.Math;

import java.util.Arrays;
import java.util.Comparator;

public class No_11_maxVolume
{
    // ˫ָ��ⷨ��֤��������height[p] <= height[q] V = min(height[p], height[q]) * (q - p)������ƶ�p��С��һ��ָ�룬��ô�����µĸ����Ҳֻ��Ϊheight[q](��ΪҪȡ����Сֵ)����p��q�ľ�����С���������V'��ȻС��V���¸�ֻ��<=�ɸߣ����¿�ֻ��<�ɿ���
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
    // ���� + n^2ʱ�临�Ӷȱ������� + ��֦���Ƚ��鷳��
//    public int maxArea(int[] height) {
//        Integer[] sortedHeight = new Integer[height.length];
//        int max = 0;
//        for(int i = 0; i < height.length; i++)
//            sortedHeight[i] = i;
//        // System.out.println(Arrays.toString(sortedHeight));
//        Arrays.sort(sortedHeight, new Comparator<Integer>()
//        {
//            @Override
//            public int compare(Integer a, Integer b)
//            {
//                if(height[a] != height[b])
//                {
//                    return height[a] > height[b] ? -1 : 1;
//                }
//                else
//                {
//                    return a - b;
//                }
//            }
//        });
//        // System.out.println(Arrays.toString(sortedHeight));
//        for(int i = 0; i < height.length; i++)
//        {
//            if(height[sortedHeight[i]] * Math.max(sortedHeight[i], height.length - sortedHeight[i]) < max)
//                continue;
//            for(int j = height.length - 1; j >= 0; j--)
//            {
//                if(sortedHeight[i] != j)
//                {
//                    int area = Math.abs(sortedHeight[i] - j) * Math.min(height[sortedHeight[i]], height[j]);
//                    max = Math.max(max, area);
//                    if(j - 1 >= 0 && Math.abs(sortedHeight[i] - j + 1) * height[sortedHeight[i]] < max)
//                        break;
//                }
//            }
//        }
//        return max;
//    }
}
