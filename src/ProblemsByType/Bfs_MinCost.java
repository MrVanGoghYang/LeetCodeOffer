package ProblemsType;
import java.util.LinkedList;
import java.util.Queue;

//LeetCode.1368
/*
 * 思路： 求最短代价用BFS，对代价使用贪心搜索。使用到队列，Java队列使用：Queue<BlankInfo> q = new LinkedList<>(); 使用LinkedList实现。
 * 		对每个格子，可以走上下左右四个方向。，如果走所给方向，则代价无需增加，否则改变方向代价增加1。
 * 		如果到达一个格子所花费的代价比记录最小代价cost中的值小，说明可以由此路径获得更小的代价，则将该格子入队。
 * 		当队列为空时，cost数组中储存了到达所给表中每个空格的最小代价。
 * 总结： 求min问题，考虑BFS用队列贪心算法逐步向外求解。
 */
public class Bfs_MinCost {
	class BlankInfo
	{
		int x;
		int y;
		public BlankInfo(int x,int y) {this.x = x; this.y = y;}
	}
	
	public static void main(String[] args) {
		Bfs_MinCost solution = new Bfs_MinCost();
		//int [][] grid = {{1,1,1,1},{2,2,2,2},{1,1,1,1},{2,2,2,2}};
		//int [][] grid = {{1,2},{4,3}};
		//int [][] grid = {{2,2,2},{2,2,2}};
		int [][] grid = {{4}};
		System.out.println(solution.minCost(grid));
		
	}

	public int minCost(int[][] grid) {
		int row = grid.length;
		int col = (row == 0 ? 0 : grid[0].length);
		Queue<BlankInfo> q = new LinkedList<>();	// BFS data struct
		int[][] cost = new int[row][col];	// The min cost that needed to walk to <i,j>
		BlankInfo item;
		// Exit judgement
		if((row == 1 && col == 1) || row == 0 || col == 0)	return 0;
		// Set cost array max
		for(int i = 0; i < row; i++)
		{
			for(int j = 0; j < col; j++)
				cost[i][j] = 9999;
		}
		// Start search from grid[0][0]
		q.offer(new BlankInfo(0,0));
		cost[0][0] = 0;
		// Search four directions.Cost add 1 if is a direction that need to change grid's value;Otherwise not add cost.
		while(!q.isEmpty())		
		{
			item = q.poll();
			// Up
			if(item.x - 1 >= 0)	// Legal move.
			{
				if(grid[item.x][item.y] == 4)	// Direction do not need to change
				{
					if(cost[item.x][item.y] < cost[item.x - 1][item.y])	// Cost is less,change cost and enqueue;
					{
						cost[item.x - 1][item.y] = cost[item.x][item.y];	//Cost remains,does not change.
						q.offer(new BlankInfo(item.x - 1,item.y));	// Blank enqueue;
					}
				}
				else	// Direction need to change
				{
					if(cost[item.x][item.y] < cost[item.x - 1][item.y])	// Cost is less,change cost and enqueue;
					{
						cost[item.x - 1][item.y] = cost[item.x][item.y] + 1;	//Cost changes.
						q.offer(new BlankInfo(item.x - 1,item.y));	// Blank enqueue;
					}
				}
			}
			// Down
			if(item.x + 1 < row)
			{
				if(grid[item.x][item.y] == 3)	// Direction do not need to change
				{
					if(cost[item.x][item.y] < cost[item.x + 1][item.y])	// Cost is less,change cost and enqueue;
					{
						cost[item.x + 1][item.y] = cost[item.x][item.y];	//Cost remains,does not change.
						q.offer(new BlankInfo(item.x + 1,item.y));	// Blank enqueue;
					}
				}
				else	// Direction need to change
				{
					if(cost[item.x][item.y] + 1 < cost[item.x + 1][item.y] )	// Cost is less,change cost and enqueue;
					{
						cost[item.x + 1][item.y] = cost[item.x][item.y] + 1;	//Cost changes.
						q.offer(new BlankInfo(item.x + 1,item.y));	// Blank enqueue;
					}
				}
			}
			// Left
			if(item.y - 1 >= 0)
			{
				if(grid[item.x][item.y] == 2)	// Direction do not need to change
				{
					if(cost[item.x][item.y] < cost[item.x][item.y - 1])	// Cost is less,change cost and enqueue;
					{
						cost[item.x][item.y - 1] = cost[item.x][item.y];	//Cost remains,does not change.
						q.offer(new BlankInfo(item.x,item.y - 1));	// Blank enqueue;
					}
				}
				else	// Direction need to change
				{
					if(cost[item.x][item.y] + 1 < cost[item.x][item.y - 1] )	// Cost is less,change cost and enqueue;
					{
						cost[item.x][item.y - 1] = cost[item.x][item.y] + 1;	//Cost changes.
						q.offer(new BlankInfo(item.x,item.y - 1));	// Blank enqueue;
					}
				}
			}
			// Right
			if(item.y + 1 < col)
			{
				if(grid[item.x][item.y] == 1)	// Direction do not need to change
				{
					if(cost[item.x][item.y] < cost[item.x][item.y + 1])	// Cost is less,change cost and enqueue;
					{
						cost[item.x][item.y + 1] = cost[item.x][item.y];	//Cost remains,does not change.
						q.offer(new BlankInfo(item.x,item.y + 1));	// Blank enqueue;
					}
				}
				else	// Direction need to change
				{
					if(cost[item.x][item.y] + 1 < cost[item.x][item.y + 1] )	// Cost is less,change cost and enqueue;
					{
						cost[item.x][item.y + 1] = cost[item.x][item.y] + 1;	//Cost changes.
						q.offer(new BlankInfo(item.x,item.y + 1));	// Blank enqueue;
					}
				}
			}
		}
		return cost[row-1][col-1];
	}
}
