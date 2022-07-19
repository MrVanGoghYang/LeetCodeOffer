package ProblemsByType.BinaryTree;

import SwordRefersToOffer.DataDefine.TreeNode;

import java.util.*;

public class No_102_BinTreeLevelOrderTraversal
{
    /*
    思路：本来一般层序遍历只需要一个队列即可，但本题输出需要将每一层组成一个List，因此需要一层一层得到结果。使用BFS的思想，一次添加一层的结点，一次取一层直至取到为空，那么该次取出的所有结点一定为同一层。
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
