package ProblemsByType.DP;

public class No_279_PerfectSquares
{
    // �������Ϊ��[1,4,9,...,100]��ô��Ӳ�ң���������ȡ����öӲ�ҿ��Դյ�target���������⣬һ����Ҫ��DP��
    // bfs
    // public int numSquares(int n) {
    //     Queue<Integer> queue = new ArrayDeque<>();
    //     int level = 0;
    //     queue.offer(n);
    //     while(!queue.isEmpty()){
    //         int size = queue.size();
    //         level++;
    //         for(int i = 0; i < size; i++){
    //             Integer top = queue.poll();
    //             for(int j = (int)Math.sqrt(top); j >= 1; j--){
    //                 if(j * j == top)
    //                     return level;
    //                 queue.offer(top - j * j);
    //             }
    //         }
    //     }
    //     return 0;
    // }

    // DP
    public int numSquares(int n) {
        if(Math.pow((int)Math.sqrt(n), 2) == n)
            return 1;
        int[] dp = new int[n + 1];
        for(int i = 1; i <= n; i++){
            int min = n;
            for(int j = 1; j <= 100 && j * j <= i; j++){
                min = Math.min(min, dp[i - j * j] + 1);
            }
            dp[i] = min;
            // System.out.println("dp[" + i + "]: " + dp[i]);
        }
        return dp[n];
    }
}
