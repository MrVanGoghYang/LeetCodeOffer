package ProblemsByType.BinaryTree;

import SwordRefersToOffer.DataDefine.TreeNode;

public class No_114_FlatternBinTreeToLinkedlist
{
    // ����һ���ݹ�д��
    // public void flatten(TreeNode root) {
    //     if(root == null || root != null && root.left == null && root.right == null)
    //         return;

    //     if(root.left != null)
    //         flatten(root.left);
    //     if(root.right != null)
    //         flatten(root.right);

    //     TreeNode cur = root.left;
    //     while(cur != null && cur.right != null)
    //         cur = cur.right;
    //     if(cur != null && cur.right == null)
    //         cur.right = root.right;
    //     if(root.left != null)
    //         root.right = root.left;
    //     root.left = null;
    // }
    // ��������������ÿ���������������ҽڵ㣬����root.right��Ȼ���ٰ�����������ӵ��������ϣ��������ÿգ�Ȼ�������ơ�
    public void flatten(TreeNode root) {
        TreeNode res = root;
        while(root != null)
        {
            TreeNode cur = root.left;
            if(cur != null)
            {
                while(cur != null && cur.right != null)
                    cur = cur.right;
                cur.right = root.right;
                root.right = root.left;
                root.left = null;
            }
            root = root.right;
        }
        root = res;
    }
}
