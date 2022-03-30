package ProblemsByType.BipartiteTree;

import SwordRefersToOffer.DataDefine.TreeNode;
import java.util.*;

public class No_104_BinTreeMaxDepth
{
    public static void main(String[] args)
    {
        int[] preorder = new int[] {3,9,20,15,7};
        int[] inorder = new int[] {9,3,15,20,7};
        System.out.println(new No_104_BinTreeMaxDepth().buildTree(preorder,inorder));
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Deque<Integer> stack = new ArrayDeque<>();
        int preIndex = 0;
        int inIndex = 0;
        TreeNode root = null;
        TreeNode resRoot = null;
        boolean findRoot = false;
        while(preIndex < preorder.length && inIndex < inorder.length)
        {
            while(preIndex < preorder.length)
            {
                stack.push(preorder[preIndex++]);
                System.out.print(stack.peek() + " ");
                if(stack.peek() == inorder[inIndex])
                    break;
            }
            System.out.println();
            // for(Integer item : stack)
            //     System.out.print(item + " ");
            TreeNode pre = null;
            while(!stack.isEmpty() && inIndex < inorder.length && stack.peek() == inorder[inIndex])
            {
                stack.pop();
                root = new TreeNode(inorder[inIndex]);
                root.left = pre;
                pre = root;
                inIndex++;
            }
            if(!findRoot)
            {
                resRoot = root;
                findRoot = true;
            }
            root = root.right;
        }
        return resRoot;
    }

    // 方法一：递归
    // public int maxDepth(TreeNode root) {
    //     if(root == null)
    //         return 0;
    //     else if(root.left == null && root.right == null)
    //         return 1;
    //     return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    // }

    // 方法二：层次遍历
    public int maxDepth(TreeNode root) {
        if(root == null)
            return 0;
        Deque<TreeNode> queue = new ArrayDeque<>();
        int depth = 0;
        queue.offer(root);
        while(!queue.isEmpty())
        {
            int size = queue.size();
            for(int i = 0; i < size; i++)
            {
                TreeNode top = queue.poll();
                if(top.left != null)
                    queue.offer(top.left);
                if(top.right != null)
                    queue.offer(top.right);
            }
            depth++;
        }
        return depth;
    }
}
