package SwordRefersToOffer;
/*
 * 	LeetCode.10.2
 * 	Fibnacci数列的另一种形式，N为剩余台阶数，F(N-1)代表本次跳1个台阶后剩余的跳法，F(N-2)代表本次跳2个台阶后剩余的跳法，F(N) = F(N-1) + F(N-2);
 */
public class No_10_II_FrogJumpStairs
{
    public int numWays(int n) {
        int minus1 = 1, minus2 = 1;
		int sum = 0;
		int mod = 1000000007;
		
		if(n == 0 || n == 1)	return 1;
		else if( n >= 2)
		{
			for(int i = 0; i < n-1; i++)
			{
				sum = (minus1 + minus2) % mod;
				minus2 = minus1;
				minus1 = sum;
			}
			return sum;
		}
		else return -1;
    }
}
