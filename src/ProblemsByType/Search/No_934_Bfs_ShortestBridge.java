package ProblemsByType.Search;
// LeetCode.934
import java.util.LinkedList;
import java.util.Queue;

public class No_934_Bfs_ShortestBridge
{
	
	class Coordinate
	{
		int x;
		int y;
		public Coordinate(int x,int y) {this.x = x; this.y = y;}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		No_934_Bfs_ShortestBridge solution = new No_934_Bfs_ShortestBridge();
		int[][] A = {{1,1,1,1,1,1},{1,0,0,0,0,1},{1,0,0,0,0,1},{1,0,0,0,0,1},{1,0,0,0,0,1},{1,0,0,1,0,0}};
		//int{][] A = {{0,1,0},{0,0,0},{0,0,1}};
		//int[][] A = {{0,0,1,0,1},{0,1,1,0,1},{0,1,0,0,1},{0,0,0,0,0},{0,0,0,0,0}};
		System.out.println(solution.shortestBridge(A));

	}
	
    public int shortestBridge(int[][] A) {
    	//BFS������С���ۣ��˳���������һ��δ�����ʹ���1�������
    	int row = A.length;
    	int col = A[0].length;
    	int[][] flag = new int[row][col];
    	boolean jump = false;
    	Queue<Coordinate> queue = new LinkedList<>();
    	Queue<Coordinate> queue2 = new LinkedList<>();
    	Coordinate item;

    	// Find the position of first 1;
    	for(int i = 0; i < row; i++)
    	{
    		for(int j = 0; j < col; j++)
    		{
    			if(A[i][j] == 1)
    			{
    				queue.offer(new Coordinate(i,j));
    				queue2.offer(new Coordinate(i,j));
    				flag[i][j] = 1;
    				jump =true;
    				break;
    			}
    		}
    		if(jump)
    			break;
    	}
    	// Enqueue all 1 of first group.
    	while(!queue2.isEmpty())
    	{
    		item = queue2.poll();
    		// Up
    		if(item.x - 1 >= 0) // Legal
    		{
    			if(A[item.x - 1][item.y] == 1 && flag[item.x - 1][item.y] == 0)
    			{
    				queue2.offer(new Coordinate(item.x - 1,item.y));
					queue.offer(new Coordinate(item.x - 1,item.y));
					flag[item.x - 1][item.y] = 1;
    			}	
    		}
    		// Down
    		if(item.x + 1 < row)
    		{
    			if(A[item.x + 1][item.y] == 1 && flag[item.x + 1][item.y] == 0)
    			{
    				queue2.offer(new Coordinate(item.x + 1,item.y));
					queue.offer(new Coordinate(item.x + 1,item.y));
					flag[item.x + 1][item.y] = 1;
    			}	
    		}
    		// Left
    		if(item.y - 1 >= 0)
    		{
    			if(A[item.x][item.y - 1] == 1 && flag[item.x][item.y - 1] == 0)
    			{
    				queue2.offer(new Coordinate(item.x,item.y - 1));
					queue.offer(new Coordinate(item.x,item.y - 1));
					flag[item.x][item.y - 1] = 1;
    			}	
    		}
    		// Right
    		if(item.y + 1 < col)
    		{
    			if(A[item.x][item.y + 1] == 1 && flag[item.x][item.y + 1] == 0)
    			{
    				queue2.offer(new Coordinate(item.x,item.y + 1));
					queue.offer(new Coordinate(item.x,item.y + 1));
					flag[item.x][item.y + 1] = 1;
    			}	
    		}
    	}
    	// Start calculate min cost using bfs
    	while(!queue.isEmpty())
    	{
    		item = queue.poll();
    		// Up
    		if(item.x - 1 >= 0) // Legal
    		{
    			if(A[item.x - 1][item.y] == 1 && flag[item.x - 1][item.y] == 0)	//��ɨ�赽δ�����ʹ���1����Ϊ��2���������ص�����ĸ��Ӵ���-1
    			{
    				return flag[item.x][item.y] - 1;
    			}	
    			else if(A[item.x - 1][item.y] == 0)	// Ϊ0�������Ǵ�δɨ�������Ҫ������� ����ɨ����˴�ʱ��cost��С��Ҳ��Ҫ�������
    			{
					if ( (flag[item.x][item.y] + 1 < flag[item.x - 1][item.y]) || (flag[item.x - 1][item.y] == 0) ) 
	    			{
		    			queue.offer(new Coordinate(item.x - 1,item.y));
						flag[item.x - 1][item.y] = flag[item.x][item.y] + 1;
	    			}
    			}
    		}
    		// Down
    		if(item.x + 1 < row)
    		{
    			if(A[item.x + 1][item.y] == 1 && flag[item.x + 1][item.y] == 0)	//��ɨ�赽δ�����ʹ���1����Ϊ��2���������ص�����ĸ��Ӵ���-1
    			{
    				return flag[item.x][item.y] - 1;
    			}	
    			else if(A[item.x + 1][item.y] == 0)	// Ϊ0�������Ǵ�δɨ�������Ҫ������� ����ɨ����˴�ʱ��cost��С��Ҳ��Ҫ�������
    			{
					if ( (flag[item.x][item.y] + 1 < flag[item.x + 1][item.y]) || (flag[item.x + 1][item.y] == 0) ) 
	    			{
		    			queue.offer(new Coordinate(item.x + 1,item.y));
						flag[item.x + 1][item.y] = flag[item.x][item.y] + 1;
	    			}
    			}
    		}
    		// Left
    		if(item.y - 1 >= 0)
    		{
    			if(A[item.x][item.y - 1] == 1 && flag[item.x][item.y - 1] == 0)	//��ɨ�赽δ�����ʹ���1����Ϊ��2���������ص�����ĸ��Ӵ���-1
    			{
    				return flag[item.x][item.y] - 1;
    			}	
    			else if(A[item.x][item.y - 1] == 0)	// Ϊ0�������Ǵ�δɨ�������Ҫ������� ����ɨ����˴�ʱ��cost��С��Ҳ��Ҫ�������
    			{
					if ( (flag[item.x][item.y] + 1 < flag[item.x][item.y - 1]) || (flag[item.x][item.y - 1] == 0) ) 
	    			{
		    			queue.offer(new Coordinate(item.x,item.y - 1));
						flag[item.x][item.y - 1] = flag[item.x][item.y] + 1;
	    			}
    			}
    		}
    		// Right
    		if(item.y + 1 < col)
    		{
    			if(A[item.x][item.y + 1] == 1 && flag[item.x][item.y + 1] == 0)	//��ɨ�赽δ�����ʹ���1����Ϊ��2���������ص�����ĸ��Ӵ���-1
    			{
    				return flag[item.x][item.y] - 1;
    			}	
    			else if(A[item.x][item.y + 1] == 0)	// Ϊ0�������Ǵ�δɨ�������Ҫ������� ����ɨ����˴�ʱ��cost��С��Ҳ��Ҫ�������
    			{
					if ( (flag[item.x][item.y] + 1 < flag[item.x][item.y + 1]) || (flag[item.x][item.y + 1] == 0) ) 
	    			{
		    			queue.offer(new Coordinate(item.x,item.y + 1));
						flag[item.x][item.y + 1] = flag[item.x][item.y] + 1;
	    			}
    			}
    		}
    	}
    	return 1;
    }
}
