package ProblemsByType.Search;
// LeetCode.54
/*
 * ˼·��������������walk(x,y,dir,map)��ʾ������(x,y)����dir����������Ȼ���� �������߽� �� ���������������ڵ� ������������ֱ������������ѡ����һ�������Լ������еݹ�������
 */
import java.util.LinkedList;
import java.util.List;

public class No_54_SpiralMatrix
{
	private List<Integer> res = new LinkedList<>();
	public static void main(String[] args) {
		No_54_SpiralMatrix solution = new No_54_SpiralMatrix();
		int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		solution.spiralOrder(matrix);
		solution.print();
	}
	
    public List<Integer> spiralOrder(int[][] matrix) {
    	// Define Up:1 Down:2 Left:3 Right:4
    	walkTowards(0,0,4,matrix);
    	return res;
    }
    
    /*
     * Fuction: walk funcition is defined to simulate the process of search.
     * 			First start from [0][0].Search towards right;
     * 			And the search direction after up is right,after down is left,after left is up,after right is down.
     * Parameter: x,y: the coordinate of the begin of this search.
     * 			  dir: search direction.
     * 			  map: search matrix.
     */
    public void walkTowards(int x,int y,int dir,int[][] map)
    {
    	int i = 0;
    	if((res.size() == map.length * map[0].length) || (x < 0 || x>= map.length) || (y < 0 || y >= map[0].length))
    		return;
    	if(dir == 1)
    	{
    		for(i = x; i >= 0; i--)
    		{
    			if(i >= 0 && i < map.length)
    			{
    				if(res.contains(map[i][y]))	
					{
    					walkTowards(i + 1,y + 1,4,map);
    					break;
					}
    				res.add(map[i][y]);
    			}
    		}
    		if( i < 0)
    			walkTowards(i + 1,y + 1,4,map);
    	}
    	else if (dir == 2) 
    	{
    		for(i = x; i < map.length; i++)
    		{
    			if(i >= 0 && i < map.length)
    			{
    				if(res.contains(map[i][y]))	
					{
    					walkTowards(i - 1,y - 1,3,map);
    					break;
					}
    				res.add(map[i][y]);
    			}	
    		}
    		if( i == map.length)
    			walkTowards(i - 1,y - 1,3,map);
		}
    	else if (dir == 3) 
    	{
    		for(i = y; i >= 0; i--)
    		{
    			if(i >= 0 && i < map[0].length)
    			{
    				if(res.contains(map[x][i]))	
					{
    					walkTowards(x - 1,i + 1,1,map);
    					break;
					}
    				res.add(map[x][i]);
    			}
    		}
    		if( i < 0)
    			walkTowards(x - 1,i + 1,1,map);
		}
    	else
    	{
    		for(i = y; i < map[0].length; i++)
    		{
    			if(i >= 0 && i < map[0].length)
    			{
    				if(res.contains(map[x][i]))	
					{
    					walkTowards(x + 1,i - 1,2,map);
    					break;
					}
    				res.add(map[x][i]);
    			}	
    		}
    		if( i == map[0].length)
    			walkTowards(x + 1,i - 1,2,map);
		}
	}
    
    public void print()
    {
    	for(int i : res)
    		System.out.print(i + " ");
    }
}
