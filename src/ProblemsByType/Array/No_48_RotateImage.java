package ProblemsByType.Array;

import java.util.HashMap;

public class No_48_RotateImage
{
    /*
    思路：将方阵从外层到内层一层一层进行旋转，旋转过程：对第一行的前len - 1个元素，依次寻找其旋转后的位置 pos ，将当前位置未更改之前的值记下为item，然后更改当前位置的值为上一次记录下的值lastVal，更新lastVal为item。完成之后当前位置变为pos。
     */
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int dim = 0;
        while(n >= 2)
        {
            rotateEdge(matrix, n, dim);
            // 维度每次-2而不是 /2
            n -= 2;
            dim++;
        }
    }

    public void rotateEdge(int[][] matrix, int len, int dim)
    {

        // System.out.println(dim);
        for(int i = dim; i < matrix.length - 1 - dim; i++)
        {
            int x = dim;
            int y = i;
            int lastVal = matrix[x][y];
            int item = matrix[x][y];
            // 此处循环为5次，因为第一次为无效循环。
            for(int j = 0; j < 5; j++)
            {
                int desX = y;
                int dexY = matrix.length - 1 - x;
                // System.out.println("Rotate from ( " + x + ", " + y + ")  ->  (" + desX + ", " + dexY + ")");
                // 此处存储当前元素值搞了好久，要使用一个额外变量在改变（x,y）之前存储下来原来的值。
                item = matrix[x][y];
                matrix[x][y] = lastVal;
                lastVal = item;

                x = desX;
                y = dexY;
                // System.out.println("( " + x + ", " + y + ")  desVal" + desVal);
            }
        }
    }
}
