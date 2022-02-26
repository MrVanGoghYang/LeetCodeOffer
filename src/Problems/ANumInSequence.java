package Problems;
/*	LeetCode.44
 *  1.首先根据n的值可以计算出指向一个几位数并记录index值为指向第一个几位数的最高位1；(比如为4位数，index指向1000的最高位1)
 *  2.根据index与n的差判断是第几个4位数以及指向的是数的从高到低第几位，如果刚好取余为0则说明是指向最低位，记为从高到低第4位；
 *  3.根据是第几个4位数可以得到指向的真正数字的数值；
 *  4.根据真实数值以及指向的是该值从高到低的第几位可得到这个数字；
 */
public class ANumInSequence {
	public int findNthDigit(int n) {
		int numsCount = 0;  //记录数为几位数
		int index = 0;		//记录当前扫描到第几位了
		int offset = 0; 	//记录当index指向10000的1时,n指向的位数偏移了多少位 即 n - index + 1
		int nthNum = 0;		//记录offset共占了多少个numsCount位的数
		int highNum = 0; 	//记录是第nthNum个numsCount位数中从高往低数第几个数字
		int num = 0;		//n指向的数
		int scanNum = 0; 	//记录已经扫描过的数的个数 比如到在扫描2位数时，已扫描过10个数，扫描3位数时，以扫描过100个数
		// 获取指向几位数，记录入numsCount，且index指向numsCount位数字的第一个
		if(n == 0)	return 0;
		for(int i = 0; i < 9; i++)
		{
			scanNum = (i == 0 ? 0 : (int)Math.pow(10,i));
			if( n >= index && n < index + (Math.pow(10,i + 1) -scanNum) * ( i + 1))
			{
				numsCount = i + 1;
				break;
			}
			index += (Math.pow(10,i + 1) -scanNum) * ( i + 1);		//若为4位数，则index指向1000的1
		}
		offset = n - index + 1;
		highNum = offset % numsCount == 0 ? numsCount : offset % numsCount;
		nthNum = offset / numsCount;
		nthNum = highNum == numsCount ? nthNum - 1 : nthNum; 
		num = numsCount == 1 ? nthNum : (int)Math.pow(10,numsCount - 1) + nthNum ;
		return (num / (int)Math.pow(10,numsCount - highNum)) % 10;
    }
}
