package Problems;
/*
 * 	LeetCode.12
 * 	�ȱ�������������Ԫ����word��һ����ĸ��ͬ��λ�ã�����Щλ�ÿ�ʼ������ʹ��flag�������Ѿ���������λ�ã��ӵ�ǰλ�÷ֱ����������ҵݹ���������һ��������·���򷵻أ�
 */
public class PathInMatrix {
	
    public boolean exist(char[][] board, String word) {
		int row = board.length;
		int col = ( row == 0 ? 0: board[0].length);
		int[][] flag = new int[row][col];
		boolean res = false;
		for(int i = 0; i < row; i++)
		{
			for(int j = 0; j < col; j++)
			{
				if(board[i][j] == word.charAt(0))
				{
					res = search(board,i,j,word,0,flag);
					if(res)
						return true;
				}
			}
		}
		return false;
    }
	
	public boolean search(char[][] board,int row,int col,String word,int index,int[][] flag)
	{
		if(board[row][col] != word.charAt(index) || flag[row][col] == 1)	return false;
		else {
			if(index + 1 == word.length())		return true;
			flag[row][col] = 1;
			if((row - 1) >= 0 && flag[row-1][col] == 0)
			{
				if(search(board,row-1,col,word,index+1,flag))
				{
					return true;
				}
			}
			if((row + 1) < board.length && flag[row+1][col] == 0)
			{
				if(search(board,row+1,col,word,index+1,flag))
				{
					return true;
				}
			}
			if((col - 1) >= 0 && flag[row][col-1] == 0)
			{
				if(search(board,row,col-1,word,index+1,flag))
				{
					return true;
				}
			}
			if((col + 1) < board[row].length && flag[row][col+1] == 0)
			{
				if(search(board,row,col+1,word,index+1,flag))
				{
					return true;
				}
			}
			flag[row][col] = 0;
		}
		return false;
	}
}
