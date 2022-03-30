package ProblemsByType.BipartiteTree;

import SwordRefersToOffer.DataDefine.TreeNode;

import java.util.*;

public class No_101_SymmetricTree
{
    // 方法一：递归，首先判断两个根的值，然后判断 left.left 与 right.right是否对称，left.right与right.left是否对称。
    // public boolean isSymmetric(TreeNode root) {
    //     if(root == null || (root.left == null && root.right == null))
    //         return true;
    //     else if((root.left == null && root.right != null) || (root.left != null && root.right == null))
    //         return false;
    //     return check(root.left, root.right);
    // }

    // public boolean check(TreeNode left, TreeNode right)
    // {
    //     if(left == null && right == null)
    //         return true;
    //     else if(left == null || right == null)
    //         return false;
    //     return left.val == right.val && check(left.left, right.right) && check(left.right, right.left);
    // }

    /* 方法二：迭代，使用队列，每次分别将按照left.left right.right left.right right.left的顺序入队，每次取两个元素出队判断是否相同
        此处使用队列是考虑到问题判断顺序，先入队的一对结点左右需要保持顺序左右出队，且ArrayDeque实现的队列不可加入null，LinkedList实现的队列可以加入null。
    */
    public boolean check(TreeNode left, TreeNode right)
    {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(left);
        queue.offer(right);
        while(!queue.isEmpty())
        {
            TreeNode p = queue.poll();
            TreeNode q = queue.poll();
            if((p == null && q != null) || (p != null && q == null) || (p != null && q != null && p.val != q.val))
                return false;
            if(p != null && q != null)
            {
                queue.offer(p.left);
                queue.offer(q.right);
                queue.offer(p.right);
                queue.offer(q.left);
            }
        }
        return true;
    }
}
