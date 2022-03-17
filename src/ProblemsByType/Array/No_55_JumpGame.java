package ProblemsByType.Array;

public class No_55_JumpGame
{
    /*
    ˼·һ��̰�ġ���ȷ�����㣺1.�����ĳ��λ��i�ܵ���ĳ��λ��j����ô�϶�Ҳ�ܵ���j��ߵ�����λ��[i, j]�� 2.��ɨ��0 - i����¼�µ���Զ����farest < i + 1��˵��������i + 1��Ҳ������i + 1�Ժ�����λ���ˡ�
     */
    public boolean canJump(int[] nums) {
        int farest = 0;
        for(int i = 0; i < nums.length; i++)
        {
            if(farest >= i)
            {
                farest = Math.max(farest, i + nums[i]);
                if(farest >= nums.length - 1)
                    return true;
            }
        }
        return false;
    }

    /*
    ˼·������̬�滮��dp[i]�����0��ʼ�ܷ񵽴�i��dp[i] = if EXIST j �� [0, i + 1] �� dp[j] == true ��nums[j] >= i - j����������dp[i]Ϊtrue����������Ϊfalse��
     */
    // public boolean canJump(int[] nums) {
    //     boolean[] dp = new boolean[nums.length];
    //     // Arrays.fill(dp, false);
    //     dp[0] = true;
    //     for(int i = 1; i < nums.length; i++)
    //     {
    //         int j = i - 1;
    //         for(j = i - 1; j >= 0; j--)
    //         {
    //             if(dp[j] && nums[j] >= (i - j))
    //             {
    //                 dp[i] = true;
    //                 break;
    //             }
    //         }
    //         if(j == -1)
    //             dp[i] = false;
    //     }
    //     return dp[nums.length - 1];
    // }

    /*
    ˼·��������ʵ��BFS����ÿһ���ܵ�������λ�ã���ʹ��visited���ظ���ջ�Ѽ����λ�ã���ʵû��Ҫ��¼�ɴ��ÿ��λ�ã�ֻ��Ҫ������Զ���ɡ�
     */
    // public boolean canJump(int[] nums) {
    //     Queue<Integer> queue = new LinkedList<>();
    //     boolean[] visited = new boolean[nums.length];
    //     Arrays.fill(visited, false);
    //     queue.offer(0);
    //     while(!queue.isEmpty())
    //     {
    //         int cur = queue.poll();
    //         if(cur == nums.length - 1)
    //             return true;
    //         for(int i = 1; i <= nums[cur]; i++)
    //         {
    //             if(cur + i < nums.length && cur + i == nums.length - 1)
    //                 return true;
    //             if(cur + i < nums.length && !visited[cur + i])
    //             {
    //                 queue.offer(cur + i);
    //                 visited[cur + i] = true;
    //             }
    //         }
    //     }
    //     return false;
    // }


}
