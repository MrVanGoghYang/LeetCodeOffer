package Problems;
/*
 * 	LeetCode.54
 * 	������K������������������˳�����������������¼����ɨ����Ľڵ�������ɨ�赽��K��ʱ��Ϊ��K�����;
 */
public class KthMaxNodeInTree {
	private TreeNode res = null;
	private int index = 0;
    public int kthLargest(TreeNode root, int k) {
    	inOrder(root,k);
    	return res == null ? -1 : res.val;
    }
    
    public int inOrder(TreeNode root,int k)
    {
    	if(root == null || res != null)	return 0;
    	inOrder(root.right,k);
    	if(res != null)		return 0;
    	index += 1;
    	if(k == index)
		{
    		res = root;
    		return index;
		}
    	inOrder(root.left,k);
    	return -1;
    }
}
