package ProblemsByType.BipartiteTree;

import SwordRefersToOffer.DataDefine.TreeNode;

import java.util.*;

public class No_101_SymmetricTree
{
    // ����һ���ݹ飬�����ж���������ֵ��Ȼ���ж� left.left �� right.right�Ƿ�Գƣ�left.right��right.left�Ƿ�Գơ�
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

    /* ��������������ʹ�ö��У�ÿ�ηֱ𽫰���left.left right.right left.right right.left��˳����ӣ�ÿ��ȡ����Ԫ�س����ж��Ƿ���ͬ
        �˴�ʹ�ö����ǿ��ǵ������ж�˳������ӵ�һ�Խ��������Ҫ����˳�����ҳ��ӣ���ArrayDequeʵ�ֵĶ��в��ɼ���null��LinkedListʵ�ֵĶ��п��Լ���null��
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
