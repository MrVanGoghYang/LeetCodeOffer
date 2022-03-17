package ProblemsByType.Array;

public class No_55_JumpGame
{
    /*
    思路一：贪心。明确两个点：1.如果从某个位置i能到达某个位置j，那么肯定也能到达j左边的所有位置[i, j]； 2.当扫描0 - i所记录下的最远距离farest < i + 1，说明到不了i + 1，也到不了i + 1以后所有位置了。
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
    思路二：动态规划，dp[i]代表从0开始能否到达i，dp[i] = if EXIST j ∈ [0, i + 1] 且 dp[j] == true 且nums[j] >= i - j，若存在则dp[i]为true，不存在则为false。
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
    思路三：队列实现BFS，看每一次能到的所有位置，且使用visited不重复入栈已计算的位置，其实没必要记录可达的每个位置，只需要关心最远即可。
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
