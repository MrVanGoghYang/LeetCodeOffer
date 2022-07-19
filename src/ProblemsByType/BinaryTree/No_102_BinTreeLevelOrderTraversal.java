package ProblemsByType.BinaryTree;

import SwordRefersToOffer.DataDefine.TreeNode;

import java.util.*;

public class No_102_BinTreeLevelOrderTraversal
{
    /*
    ˼·������һ��������ֻ��Ҫһ�����м��ɣ������������Ҫ��ÿһ�����һ��List�������Ҫһ��һ��õ������ʹ��BFS��˼�룬һ�����һ��Ľ�㣬һ��ȡһ��ֱ��ȡ��Ϊ�գ���ô�ô�ȡ�������н��һ��Ϊͬһ�㡣
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res =  new ArrayList<>();
        if(root == null)
            return res;
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while(!queue.isEmpty())
        {
            int temp = queue.size();
            List<Integer> subRes = new ArrayList<>();
            for(int i = 0; i < temp; i++)
            {
                TreeNode top = queue.poll();
                subRes.add(top.val);
                if(top.left != null)
                    queue.offer(top.left);
                if(top.right != null)
                    queue.offer(top.right);
            }
            res.add(subRes);
        }
        return res;
    }
}
