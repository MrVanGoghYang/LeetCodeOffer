package SwordRefersToOffer;
/*
 * 	LeetCode.16
 * 	方法一：分正负次方以及是否为2的次方分别使用移位操作处理；
 *  方法二：快速幂见题解；
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
		
		if(!fushuSquare)	//正数次方
		{
			if(x == 2)		// 2求正n次方移位
			{
				res = (int)1 << n;
			}
			else 	// 非2整数及小数求n次方直接乘
			{
				res = 1;
				for(int i = 0; i < n; i++)
				{
					res *= x;
				}
			}
		}
		else	// 负数次方，如果直接乘了再用1除，在乘的过程中会溢出
		{
			if(x == 2)	  //2求负n次方移位
			{
				res = (int)1 << n;
				res = 1 / res;
			}
			else 		//非2整数及小数求n次方直接除
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
