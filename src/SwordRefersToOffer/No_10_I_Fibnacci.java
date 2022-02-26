package SwordRefersToOffer;
/* LeetCode.10.1
 * 使用迭代法计算F(n)，但是涉及到溢出问题需要取余，采用循环取余法：
 * 原理：(A + B) % mod = (A % mod + B % mod) % mod；
 * 故：F100 % mod = (F99 % mod + F98 % mod) % mod;	F99 % mod = (F98 % mod + F97 % mod) % mod;
 * 		...		F2 % mod = (F0 % mod + F1 % mod) % mod;
 */
public class No_10_I_Fibnacci
{
    public int fib(int n) {
        int minus1 = 1, minus2 = 0;
		int sum = minus1;
		int mod = 1000000007;
		if(n == 0 || n == 1)	return n;
		else if( n >= 2)
		{
			for(int i = 2;i <= n; i++)
			{
				sum = (sum + minus2) % mod;
				minus2 = minus1;
				minus1 = sum;
			}
			return sum;
		}
		return -1;
    }
}
