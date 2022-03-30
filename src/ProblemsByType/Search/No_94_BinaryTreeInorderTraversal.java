package ProblemsByType.Search;

import SwordRefersToOffer.DataDefine.TreeNode;

import java.util.*;

public class No_94_BinaryTreeInorderTraversal
{
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root == null)
            return new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        List<Integer> res = new ArrayList<>();
        while(!stack.isEmpty() || root != null)
        {
            while(root != null)
            {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }
}
