package ProblemsType;
import java.util.LinkedList;
import java.util.Queue;

//LeetCode.1368
/*
 * ˼·�� ����̴�����BFS���Դ���ʹ��̰��������ʹ�õ����У�Java����ʹ�ã�Queue<BlankInfo> q = new LinkedList<>(); ʹ��LinkedListʵ�֡�
 * 		��ÿ�����ӣ����������������ĸ����򡣣��������������������������ӣ�����ı䷽���������1��
 * 		�������һ�����������ѵĴ��۱ȼ�¼��С����cost�е�ֵС��˵�������ɴ�·����ø�С�Ĵ��ۣ��򽫸ø�����ӡ�
 * 		������Ϊ��ʱ��cost�����д����˵�����������ÿ���ո����С���ۡ�
 * �ܽ᣺ ��min���⣬����BFS�ö���̰���㷨��������⡣
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
