package ProblemsByType.Array;

import java.util.HashMap;

public class No_48_RotateImage
{
    /*
    ˼·�����������㵽�ڲ�һ��һ�������ת����ת���̣��Ե�һ�е�ǰlen - 1��Ԫ�أ�����Ѱ������ת���λ�� pos ������ǰλ��δ����֮ǰ��ֵ����Ϊitem��Ȼ����ĵ�ǰλ�õ�ֵΪ��һ�μ�¼�µ�ֵlastVal������lastValΪitem�����֮��ǰλ�ñ�Ϊpos��
     */
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int dim = 0;
        while(n >= 2)
        {
            rotateEdge(matrix, n, dim);
            // ά��ÿ��-2������ /2
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
            // �˴�ѭ��Ϊ5�Σ���Ϊ��һ��Ϊ��Чѭ����
            for(int j = 0; j < 5; j++)
            {
                int desX = y;
                int dexY = matrix.length - 1 - x;
                // System.out.println("Rotate from ( " + x + ", " + y + ")  ->  (" + desX + ", " + dexY + ")");
                // �˴��洢��ǰԪ��ֵ���˺þã�Ҫʹ��һ����������ڸı䣨x,y��֮ǰ�洢����ԭ����ֵ��
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
