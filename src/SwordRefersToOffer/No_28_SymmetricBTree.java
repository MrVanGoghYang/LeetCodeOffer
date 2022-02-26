package SwordRefersToOffer;

import SwordRefersToOffer.DataDefine.TreeNode;

/*
 * LeetCode.28
 * 方法一：先对树进行中序遍历并记录下该节点是其父亲的左节点还是右节点，左1右2树根为0;  然后使用中序遍历结果和左右节点记录结果判断：
 * 		若对称则需： 1.中序遍历数组左右对称； 2.左右节点记录数组对称位置的值必须相反(一边为1一边为2)不能相同或存在0；
 * 方法二：递归判断。两个节点开始的树对称当且仅当：1.这两个节点的数值相同； 2.左节点的左子树与右节点的右子树对称；  3.左节点的右子树与右节点的左子树对称；
 */
public class No_28_SymmetricBTree
{
	public boolean isSymmetric(TreeNode root) {
		int[] treeVal = new int[1000];
		int[] flag = new int[1000];
		int num = 0;
		if(root == null || (root.left == null && root.right == null))	return true;
		if((root.left == null && root.right != null) || (root.left != null && root.right == null)
				|| (root.left.val != root.right.val))
			return false;
		num = inOrderTraverse(root,treeVal,flag,0,0);
		return isSymmetricArray(treeVal,flag,num);
    }
	
	public int inOrderTraverse(TreeNode root,int[] treeVal,int[] flag,int index,int LorR)
	{
		if(root == null)
		{
			return index;
		}
		index = inOrderTraverse(root.left,treeVal,flag,index,1);
		treeVal[index++] = root.val;
		if(LorR != 0)
		{
			flag[index] = LorR;
		}
		index = inOrderTraverse(root.right,treeVal,flag,index,2);
		return index;
	}
	
	public boolean isSymmetricArray(int[] arr,int[] flag,int num)
	{
		if(num == 0 || num == 1)	return true;
		for(int i = 0; i < num / 2; i++)
		{
			if(arr[i] != arr[num - i - 1] || flag[i + 1] == flag[num - i] || (flag[i + 1] == 0 && flag[num - i] != 0) 
					|| (flag[i + 1] != 0 && flag[num - i] == 0) )
				return false;
		}
		return true;
	}
	
	public boolean isSymmetric2(TreeNode root) {
		if(root == null || (root.left == null && root.right == null))	return true;
		return symmetricTree(root.left,root.right);
    }
	
	public boolean symmetricTree(TreeNode left,TreeNode right)
	{
		if(left == null && right == null)	return true;
		if((left == null && right != null) || (left != null && right == null)
				|| (left.val != right.val))
			return false;
		if(left.left == null && left.right == null && right.left == null && right.right == null)
			return true;
		return symmetricTree(left.left,right.right) && symmetricTree(left.right,right.left);
	}
}
