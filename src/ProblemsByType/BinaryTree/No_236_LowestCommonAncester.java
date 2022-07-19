package ProblemsByType.BinaryTree;

import SwordRefersToOffer.DataDefine.TreeNode;

import java.util.*;

public class No_236_LowestCommonAncester
{
    // µü´úÐ´·¨£º
    Map<Integer, TreeNode> map = new HashMap<>();
    Set<Integer> set = new HashSet<>();
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == p || root == q || root == null)
            return root;
        dfs(root);
        TreeNode item = p;
        while(item != root){
            set.add(item.val);
            item = map.get(item.val);
        }
        item = q;
        while(item != root){
            if(set.contains(item.val))
                return item;
            item = map.get(item.val);
        }
        return null;
    }

    public void dfs(TreeNode root){
        if(root.left != null){
            map.put(root.left.val, root);
            dfs(root.left);
        }
        if(root.right != null){
            map.put(root.right.val, root);
            dfs(root.right);
        }
    }
    // µÝ¹éÐ´·¨£º
    // public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    //     if(root == p || root == q || root == null)
    //         return root;
    //     TreeNode left = lowestCommonAncestor(root.left, p, q);
    //     TreeNode right = lowestCommonAncestor(root.right, p, q);
    //     if(left == null || right == null)
    //         return left == null ? right : left;
    //     return root;
    // }
}
