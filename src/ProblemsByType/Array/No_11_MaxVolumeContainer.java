package ProblemsByType.Array;

public class No_11_MaxVolumeContainer
{
    /*
    ˼·����β˫ָ�������ƶ���ÿ���ƶ��߽�С��һ��ָ�룬�ɱ�֤����ʧ��������
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
