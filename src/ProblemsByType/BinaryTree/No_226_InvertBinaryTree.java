package ProblemsByType.BinaryTree;

import SwordRefersToOffer.DataDefine.TreeNode;

public class No_226_InvertBinaryTree
{
    public TreeNode invertTree(TreeNode root) {
        if(root == null)
            return root;
        invertTree(root.left);
        invertTree(root.right);
        TreeNode item = root.left;
        root.left = root.right;
        root.right = item;
        return root;
    }
}
