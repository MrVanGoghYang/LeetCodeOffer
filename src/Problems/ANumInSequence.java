package Problems;
/*	LeetCode.44
 *  1.���ȸ���n��ֵ���Լ����ָ��һ����λ������¼indexֵΪָ���һ����λ�������λ1��(����Ϊ4λ����indexָ��1000�����λ1)
 *  2.����index��n�Ĳ��ж��ǵڼ���4λ���Լ�ָ��������ĴӸߵ��͵ڼ�λ������պ�ȡ��Ϊ0��˵����ָ�����λ����Ϊ�Ӹߵ��͵�4λ��
 *  3.�����ǵڼ���4λ�����Եõ�ָ����������ֵ���ֵ��
 *  4.������ʵ��ֵ�Լ�ָ����Ǹ�ֵ�Ӹߵ��͵ĵڼ�λ�ɵõ�������֣�
 */
public class ANumInSequence {
	public int findNthDigit(int n) {
		int numsCount = 0;  //��¼��Ϊ��λ��
		int index = 0;		//��¼��ǰɨ�赽�ڼ�λ��
		int offset = 0; 	//��¼��indexָ��10000��1ʱ,nָ���λ��ƫ���˶���λ �� n - index + 1
		int nthNum = 0;		//��¼offset��ռ�˶��ٸ�numsCountλ����
		int highNum = 0; 	//��¼�ǵ�nthNum��numsCountλ���дӸ��������ڼ�������
		int num = 0;		//nָ�����
		int scanNum = 0; 	//��¼�Ѿ�ɨ��������ĸ��� ���絽��ɨ��2λ��ʱ����ɨ���10������ɨ��3λ��ʱ����ɨ���100����
		// ��ȡָ��λ������¼��numsCount����indexָ��numsCountλ���ֵĵ�һ��
		if(n == 0)	return 0;
		for(int i = 0; i < 9; i++)
		{
			scanNum = (i == 0 ? 0 : (int)Math.pow(10,i));
			if( n >= index && n < index + (Math.pow(10,i + 1) -scanNum) * ( i + 1))
			{
				numsCount = i + 1;
				break;
			}
			index += (Math.pow(10,i + 1) -scanNum) * ( i + 1);		//��Ϊ4λ������indexָ��1000��1
		}
		offset = n - index + 1;
		highNum = offset % numsCount == 0 ? numsCount : offset % numsCount;
		nthNum = offset / numsCount;
		nthNum = highNum == numsCount ? nthNum - 1 : nthNum; 
		num = numsCount == 1 ? nthNum : (int)Math.pow(10,numsCount - 1) + nthNum ;
		return (num / (int)Math.pow(10,numsCount - highNum)) % 10;
    }
}
