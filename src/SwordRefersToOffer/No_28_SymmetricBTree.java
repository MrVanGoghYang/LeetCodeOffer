package SwordRefersToOffer;

import SwordRefersToOffer.DataDefine.TreeNode;

/*
 * LeetCode.28
 * ����һ���ȶ������������������¼�¸ýڵ����丸�׵���ڵ㻹���ҽڵ㣬��1��2����Ϊ0;  Ȼ��ʹ�����������������ҽڵ��¼����жϣ�
 * 		���Գ����裺 1.��������������ҶԳƣ� 2.���ҽڵ��¼����Գ�λ�õ�ֵ�����෴(һ��Ϊ1һ��Ϊ2)������ͬ�����0��
 * ���������ݹ��жϡ������ڵ㿪ʼ�����ԳƵ��ҽ�����1.�������ڵ����ֵ��ͬ�� 2.��ڵ�����������ҽڵ���������Գƣ�  3.��ڵ�����������ҽڵ���������Գƣ�
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
