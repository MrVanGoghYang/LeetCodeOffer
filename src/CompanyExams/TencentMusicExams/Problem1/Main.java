package CompanyExams.TencentMusicExams.Problem1;

import java.util.*;

public class Main
{
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val) {
          this.val = val;
        }
    }

    private static ArrayList<TreeNode> res = new ArrayList<>();
    public static void main(String[] args)
    {
        Main solution = new Main();
        TreeNode root = solution.buildTree();
//        ArrayList<Integer> ope = new ArrayList<>();
//        ope.add(1);
//        ope.add(3);
//        solution.deleteLevel(root, ope);
        solution.xorTree(root, null);


    }
    private HashMap<Integer, TreeNode> map = new HashMap<>();
    public TreeNode xorTree (TreeNode root, ArrayList<ArrayList<Integer>> op) {
        // write code here
        TreeNode root1 = buildTree1(root);
        for(ArrayList<Integer> item : op)
        {
            int index = item.get(0);
            int value = item.get(1);
            TreeNode node = map.get(index);
            xor(node, value);
        }
        return  root1;
    }

    public TreeNode buildTree1(TreeNode root)
    {
        if(root == null)
            return null;
        TreeNode node = new TreeNode(0);
        map.put(root.val, node);
        if(root.left != null)
            node.left = buildTree1(root.left);
        if(root.right != null)
            node.right = buildTree1(root.right);
        return node;
    }

    public void xor(TreeNode root, int val)
    {
        if(root == null)
            return;
        root.val = root.val ^ val;
        xor(root.left, val);
        xor(root.right, val);
    }

    public TreeNode buildTree()
    {
        TreeNode a1 = new TreeNode(1);
        TreeNode b1 = new TreeNode(1);
        TreeNode b2 = new TreeNode(1);
        TreeNode c1 = new TreeNode(1);
        TreeNode c2 = new TreeNode(1);
        TreeNode c3 = new TreeNode(1);
        TreeNode d1 = new TreeNode(1);
        TreeNode d2 = new TreeNode(1);
        TreeNode d3 = new TreeNode(1);
        TreeNode e1 = new TreeNode(1);
        TreeNode e2 = new TreeNode(1);

        a1.left = b1;
        a1.right = b2;
        b1.left = c1;
        b1.right = c2;
        b2.left = c3;
        c1.left = d1;
        c1.right = d2;
        c2.right = d3;
        d1.right = e1;
        d2.left = e2;

        return a1;
    }



    public ArrayList<TreeNode> deleteLevel (TreeNode root, ArrayList<Integer> a) {
        // write code here
        ArrayList<TreeNode> res = new ArrayList<>();
        kLevelSetZero(root, a, 1);
        res = levelTraverse(root);
        System.out.println(res.toString());
        return res;
    }

    public void kLevelSetZero (TreeNode root, ArrayList<Integer> a, int curDep) {
        // write code here
        if(root == null)
            return;
        if(root != null && a.contains(curDep) && root.val == 1)
            root.val = 0;
        if(root.left != null)
            kLevelSetZero(root.left, a, curDep + 1);
        if(root.right != null)
            kLevelSetZero(root.right, a, curDep + 1);
    }

    public ArrayList<TreeNode> levelTraverse(TreeNode root)
    {
        if(root == null)
            return null;

        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        if(root.val == 1)
            res.add(root);
        while(!queue.isEmpty())
        {
            int size = queue.size();
            for(int i = 0; i < size; i++)
            {
                TreeNode top = queue.poll();
                if(top.val == 0)
                {
                    if(top.left != null)
                        levelTraverse(top.left);
                    if(top.right != null)
                        levelTraverse(top.right);
                }
                else
                {
                    if(top.left != null)
                    {
                        queue.offer(top.left);
                        if(top.left.val == 0)
                            top.left = null;
                    }
                    if(top.right != null)
                    {
                        queue.offer(top.right);
                        if (top.right.val == 0)
                            top.right = null;
                    }
                }
            }
        }
        return res;
    }
}
