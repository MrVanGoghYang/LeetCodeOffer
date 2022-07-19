package ProblemsByType.DP;

public class No_221_MaxSquare
{
    public int maximalSquare(char[][] matrix) {
        int res = 0;
        // dp[i][j]:��matrix[i][j]Ϊ���½ǵ���������α߳�
        // �Լ���˼·dp[i+1][j+1] = dp[i][j] + 1 when dp[i][j] == 1 && for k in (j-dp[i][j]+1, j+1): matrix[i+1][k] == 1 && for k in (i-dp[i][j]+1, i+1): matrix[k][j+1] == 1
        // ��ȷת�Ʒ��̣� dp[i + 1][j + 1] = min(dp[i][j], dp[i + 1][j], dp[i][j + 1]) + 1;
        int[][] dp = new int[matrix.length][matrix[0].length];
        // dp����߽��ʼ��
        for(int i = 0; i < matrix[0].length; i++){
            if(matrix[0][i] == '1'){
                dp[0][i] = 1;
                res = 1;
            }
        }
        for(int i = 0; i < matrix.length; i++){
            if(matrix[i][0] == '1'){
                dp[i][0] = 1;
                res = 1;
            }
        }
        // dp���  ������������
        for(int i = 1; i < dp.length; i++){
            for(int j = 1; j < dp[0].length; j++){
                if(matrix[i][j] == '1'){
                    // �Լ�˼·�����Դ����Ͻǵ���������չ
                    // for(int expand = dp[i - 1][j - 1]; expand >= 0 && dp[i][j] == 0; expand--){
                    //     for(int k = expand; k >= 0; k--){
                    //         if(matrix[i][j - k] == '0' || matrix[i - k][j] == '0')
                    //             break;
                    //         if(k == 0)
                    //             dp[i][j] = 1 + expand;
                    //     }
                    // }
                    // ��ȷ״̬ת��˼·��
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i - 1][j]), dp[i][j - 1]) + 1;

                }
                // System.out.println("dp[" + i + "][" + j + "]:" + dp[i][j]);
                res = Math.max(res, dp[i][j]);
            }
        }
        return res * res;
    }
}
