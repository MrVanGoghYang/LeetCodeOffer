package ProblemsByType.BinaryTree;

import SwordRefersToOffer.DataDefine.TreeNode;

public class No_98_ValidateBinarySearchTree
{
    // // 中序遍历非递归版本
    // public boolean isValidBST(TreeNode root) {
    //     long pre = Long.MIN_VALUE;
    //     Deque<TreeNode> stack = new ArrayDeque<>();
    //     TreeNode find = root;
    //     while(find != null || !stack.isEmpty())
    //     {
    //         while(find != null)
    //         {
    //             stack.push(find);
    //             find = find.left;
    //         }
    //         TreeNode top = stack.pop();
    //         if(top.val <= pre)
    //             return false;
    //         pre = top.val;
    //         find = top.right;
    //     }
    //     return true;
    // }

    // 递归写法二：改进版，传入上下界参数，不需要每次递归都判断前驱和后继，Best choice.
    public boolean isValidBST(TreeNode root) {
        return validBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean validBST(TreeNode root, long min, long max)
    {
        if(root == null)
            return true;
        if(root.val <= min || root.val >= max)
            return false;
        return validBST(root.left, min, root.val) && validBST(root.right, root.val, max);
    }


    // 递归写法一：递归判断二叉搜索树，写法不好，没有考虑到上下界，导致写了其他函数找前驱和后继，其实只要递归函数中传入上下界就可以直接判断，会简单很多。
    // public boolean isValidBST(TreeNode root) {
    //     if(root == null)
    //         return true;
    //     else if(root.left == null && root.right == null)
    //         return true;
    //     else
    //     {
    //         if(root.left != null)
    //         {
    //             int findNum = findIn(root.left, 0);
    //             if(findNum >= root.val)
    //                 return false;
    //         }

    //         if(root.right != null)
    //         {
    //             int findNum = findIn(root.right, 1);
    //             if(findNum <= root.val)
    //                 return false;
    //         }
    //     }
    //     return isValidBST(root.left) && isValidBST(root.right);
    // }
    // // left : 0   right : 1
    // public int findIn(TreeNode root, int oper)
    // {
    //     TreeNode findBegin = root;
    //     Integer findNum = root.val;
    //     if(oper == 0)
    //     {
    //         while(findBegin != null)
    //         {
    //             findNum = Math.max(findNum, findBegin.val);
    //             if(findBegin.right != null)
    //                 findBegin = findBegin.right;
    //             else
    //                 findBegin = findBegin.left;
    //         }
    //     }
    //     else
    //     {
    //         while(findBegin != null)
    //         {
    //             findNum = Math.min(findNum, findBegin.val);
    //             if(findBegin.left != null)
    //                 findBegin = findBegin.left;
    //             else
    //                 findBegin = findBegin.right;
    //         }
    //     }
    //     return findNum;
    // }
}
