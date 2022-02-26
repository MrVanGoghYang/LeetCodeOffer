package SwordRefersToOffer;
/*
 * 	LeetCode.16
 * 	����һ���������η��Լ��Ƿ�Ϊ2�Ĵη��ֱ�ʹ����λ��������
 *  �������������ݼ���⣻
 * 
 */
public class No_16_PowOfNum
{
	public double myPow(double x, int n) {
		boolean fushuSquare;
		boolean fushuX;
		boolean oddSquare;
		double res = 0;
		
		fushuX = (x < 0);
		fushuSquare = (n < 0);
		oddSquare = (n % 2 == 1);
		
		if(n == 0 || x == 1)	return 1;
		if(x == -1)	return oddSquare ? -1 : 1;
		
		if(fushuX)
		{
			x = -x;
		}
		if(fushuSquare)
		{
			n = -n;
		}
		if(fushuSquare && n < 0)
		{
			return 0;
		}
		
		if(!fushuSquare)	//�����η�
		{
			if(x == 2)		// 2����n�η���λ
			{
				res = (int)1 << n;
			}
			else 	// ��2������С����n�η�ֱ�ӳ�
			{
				res = 1;
				for(int i = 0; i < n; i++)
				{
					res *= x;
				}
			}
		}
		else	// �����η������ֱ�ӳ�������1�����ڳ˵Ĺ����л����
		{
			if(x == 2)	  //2��n�η���λ
			{
				res = (int)1 << n;
				res = 1 / res;
			}
			else 		//��2������С����n�η�ֱ�ӳ�
			{
				res = 1;
				for(int i = 0; i < n; i++)
				{
					res /= x;
				}
			}
		}
		if(fushuX && oddSquare)	res = 0 - res;
		return res;
    }
}
