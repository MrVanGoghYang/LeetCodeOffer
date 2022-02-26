package SwordRefersToOffer;
/*	LeetCode.58.2
 * 	����һ����Stringת��Ϊ�ַ����飬��ǰnλ�ַ����ã��ٶԺ�length - nλ�ַ����ã����������������ã�
 * 	��������ʹ��StringBuilder�����ַ���ƴ�ӣ���ʹ��Stringֱ��ȡ�Ӵ���+��ƴ�ӣ�
 */
public class No_58_II_LeftReverseString
{
	 public String reverseLeftWords(String s, int n) {
	    	char[] input= s.toCharArray();
	    	reverse(input,0,n - 1);
	    	reverse(input,n,input.length - 1);
	    	reverse(input,0,input.length - 1);
	    	return String.valueOf(input);
	    }
	    
	    public void reverse(char[] in,int low,int high)
	    {
	    	char item;
	    	if(low >= high)	return;
	    	if(low + high < 2)
	    	{
				item = in[low];
				in[low] = in[high];
				in[high] = item;
				return;
	    	}
	    	for(int i = 0 ; low + i <= (low + high) / 2; i++)
	    	{
	    		if(in[low + i] != in[high - i])
	    		{
	    			in[low + i] += in[high - i];
	    			in[high - i] = (char)(in[low + i] - in[high - i]);
	    			in[low + i] -= in[high -i];
	    		}
	    	}
	    }
	    
	    public String reverseLeftWords2(String s, int n) {
	    	StringBuilder str = new StringBuilder(s.substring(n,s.length()));
	    	String res = str.append(s.substring(0,n)).toString();
	    	return res;
	    }
}
