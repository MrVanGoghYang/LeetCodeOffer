package ProblemsByType.DP;

/* 115. 不同的子序列
 * 递归问题不加循环，转换为小1规模的子问题即可，并定义问题规模为1 最小时的递归出口。
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
	 * 记忆法递归，使用二维数组记录递归搜索结果，当要递归搜索时先到结果数组中找，有结果直接取出，避免重复搜索
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
//    public int dfs_search(char[] source,int s_index,char[] target,int t_index) // 递归过程，搜索 source 串从 s_index 之后的子串匹配 target 串从 t_index 之后的子串共有多少种匹配方式；
//    {
//    	if(source.length - s_index < target.length - t_index)	return 0;	// 如果source串剩余长度小于target串剩余待匹配的长度则必定找不到，返回0
//    	if(t_index == target.length)	return 1;							// 如果target串匹配到最后，则说明已匹配完毕，匹配空串必返回1；
//    	
//    	if(searchRecord[s_index][t_index] != -1)							// 记忆性递归，如果该过程的搜索结果之前已得到并储存下来，则直接取出用
//    		return searchRecord[s_index][t_index];
//    	
//    	if(source[s_index] == target[t_index])			// 当前字母匹配有两种选择 ：1.选择source中的该字符与target中字符匹配，都向后移动一位； 2.不选择target中字符匹配，选择其后串中的字符与target当前位置的字符匹配；
//    		searchRecord[s_index][t_index] = dfs_search(source, s_index + 1, target, t_index) + 
//    										 dfs_search(source, s_index + 1, target, t_index + 1);      // 两种匹配方式的和即为当前递归结果； 
//    	else
//    		searchRecord[s_index][t_index] = dfs_search(source, s_index + 1, target, t_index);		//若当前字符不匹配，则只有一种情况，source继续后移来匹配；
//    	return searchRecord[s_index][t_index];
//    }
	
	
	/*
	 * 动态规划，填表，从右下往左上计算。
	 * 当s扫描到字符串最后即g之后_时，剩余字符串为空，去匹配t的任何非空字符串，结果均为0，即无法从空字符串中选出非空字符串；
	 * 当t扫描到字符串最后即g之后_时，剩余字符串为空，任何字符串匹配空字符串结果均为1；
	 * 如s = "babgbag", t = "bag"
	 * 制表 ：   #  b	 a 	b  g  b	 a	g  _
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
