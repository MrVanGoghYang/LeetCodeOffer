package ProblemsByType.DP;

/* 115. ��ͬ��������
 * �ݹ����ⲻ��ѭ����ת��ΪС1��ģ�������⼴�ɣ������������ģΪ1 ��Сʱ�ĵݹ���ڡ�
 */
public class No_115_DifferentSubSeq
{
	private int[][] searchRecord;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String s = "rabbbit";
//		String t = "rabbit";
//		String s = "aaabbb";
//		String t = "ab";
		String s = "adbdadeecadeadeccaeaabdabdbcdabddddabcaaadbabaaedeeddeaeebcdeabcaaaeeaeeabcddcebddebeebedaecccbdcbcedbdaeaedcdebeecdaaedaacadbdccabddaddacdddc";
		String t = "bcddceeeebecbc";
		No_115_DifferentSubSeq solution = new No_115_DifferentSubSeq();
		System.out.println(solution.numDistinct(s, t));
	}
	/*
	 * ���䷨�ݹ飬ʹ�ö�ά�����¼�ݹ������������Ҫ�ݹ�����ʱ�ȵ�����������ң��н��ֱ��ȡ���������ظ�����
	 */
//    public int numDistinct(String s, String t) {
//    	char[] source = s.toCharArray();
//    	char[] target = t.toCharArray();
//    	searchRecord = new int[source.length][target.length];
//    	for(int i = 0; i < source.length; i++)
//    	{
//    		for(int j = 0; j < target.length; j++)
//    			searchRecord[i][j] = -1;
//    	}
//    	return dfs_search(source,0,target,0);
//    }
//    
//    public int dfs_search(char[] source,int s_index,char[] target,int t_index) // �ݹ���̣����� source ���� s_index ֮����Ӵ�ƥ�� target ���� t_index ֮����Ӵ����ж�����ƥ�䷽ʽ��
//    {
//    	if(source.length - s_index < target.length - t_index)	return 0;	// ���source��ʣ�೤��С��target��ʣ���ƥ��ĳ�����ض��Ҳ���������0
//    	if(t_index == target.length)	return 1;							// ���target��ƥ�䵽�����˵����ƥ����ϣ�ƥ��մ��ط���1��
//    	
//    	if(searchRecord[s_index][t_index] != -1)							// �����Եݹ飬����ù��̵��������֮ǰ�ѵõ���������������ֱ��ȡ����
//    		return searchRecord[s_index][t_index];
//    	
//    	if(source[s_index] == target[t_index])			// ��ǰ��ĸƥ��������ѡ�� ��1.ѡ��source�еĸ��ַ���target���ַ�ƥ�䣬������ƶ�һλ�� 2.��ѡ��target���ַ�ƥ�䣬ѡ������е��ַ���target��ǰλ�õ��ַ�ƥ�䣻
//    		searchRecord[s_index][t_index] = dfs_search(source, s_index + 1, target, t_index) + 
//    										 dfs_search(source, s_index + 1, target, t_index + 1);      // ����ƥ�䷽ʽ�ĺͼ�Ϊ��ǰ�ݹ����� 
//    	else
//    		searchRecord[s_index][t_index] = dfs_search(source, s_index + 1, target, t_index);		//����ǰ�ַ���ƥ�䣬��ֻ��һ�������source����������ƥ�䣻
//    	return searchRecord[s_index][t_index];
//    }
	
	
	/*
	 * ��̬�滮����������������ϼ��㡣
	 * ��sɨ�赽�ַ������g֮��_ʱ��ʣ���ַ���Ϊ�գ�ȥƥ��t���κηǿ��ַ����������Ϊ0�����޷��ӿ��ַ�����ѡ���ǿ��ַ�����
	 * ��tɨ�赽�ַ������g֮��_ʱ��ʣ���ַ���Ϊ�գ��κ��ַ���ƥ����ַ��������Ϊ1��
	 * ��s = "babgbag", t = "bag"
	 * �Ʊ� ��   #  b	 a 	b  g  b	 a	g  _
	 * 		   b    				   0
	 *		   a  					   0
	 *		   g  					   0
	 *    	   _  1  1  1  1  1	 1	1  1
	 */
    public int numDistinct(String s, String t) {
    	char[] source = s.toCharArray();
    	char[] target = t.toCharArray();
    	int[][] dp = new int[target.length + 1][source.length + 1];
    	for(int i = 0; i <= source.length; i++)		dp[target.length][i] = 1;
    	for(int i = 0; i < target.length; i++)		dp[i][source.length] = 0;
    	
    	for(int i = target.length - 1; i >= 0; i--)
    	{
    		for(int j = source.length - 1; j >= 0; j--)
    		{
    			if(source[j] == target[i])
    				dp[i][j] = dp[i + 1][j + 1] + dp[i][j + 1];
    			else
    				dp[i][j] = dp[i][j + 1];
    		}
    	}
    	return dp[0][0];
    }
    
}
