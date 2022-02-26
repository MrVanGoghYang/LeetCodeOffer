package Problems;
/* LeetCode.05
 * 每个空格换为3个字符因此定义3倍长度的字符数组，然后对字符串扫描，对空格和非空格情况分别赋值并记录长度最后返回;
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
