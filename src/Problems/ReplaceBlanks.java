package Problems;
/* LeetCode.05
 * ÿ���ո�Ϊ3���ַ���˶���3�����ȵ��ַ����飬Ȼ����ַ���ɨ�裬�Կո�ͷǿո�����ֱ�ֵ����¼������󷵻�;
 */
public class ReplaceBlanks {
	
    public String replaceSpace(String s) {
        return s.replaceAll(" ", "%20");
    }
    
    public String replaceSpace2(String s) {
        int length = s.length();
    	int newlength = 0;
    	int j = 0;
    	char[] res = new char[length*3];
    	for(int i = 0; i < length; i++)
    	{
    		char c = s.charAt(i);
    		if(c == ' ')
    		{
    			res[j++] = '%';
    			res[j++] = '2';
    			res[j++] = '0';
    			newlength += 3;
    		}
    		else 
    		{
    			res[j++] = c;
    			newlength += 1;
			}
    	}
    	return String.valueOf(res).substring(0,newlength);
    }
}
