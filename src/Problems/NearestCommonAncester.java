package Problems;
/*
 * 	LeetCode.68.2
 * 	方法一：
 * 	定义了新的一个节点信息NodeInfo类额外记录父节点以及该节点的深度。
 * 	1.首先使用新的数据结构重建二叉树，每个节点拥有了深度信息和父节点信息；
 * 	2.在新的树中找到待搜索的两个节点记为left和right；
 * 	3.使用left和right节点进行递归搜索公共祖先：当两节点值相等时返回；若节点值不等则： 
 * 		1.左节点的depth大于右节点即左矮右高，则递归返回左节点的父节点与右节点的公共祖先；
 * 		2.左节点depth小，则左高右矮，递归返回左节点与右节点的父节点的公共祖先；
 * 		3.两节点depth一样，则递归返回左节点的父节点与右节点的父节点的公共祖先
 * 
 * 	方法二：
 * 	看注释；
 */
public class NearestCommonAncester {
	class NodeInfo
    {
        int value;
        int depth;
        NodeInfo left;
        NodeInfo right;
        NodeInfo parent;
        NodeInfo(TreeNode now,NodeInfo par,int dep)
        { 
            if(now != null)
            {
                value = now.val;
                depth = dep;
            }
            parent = par;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        NodeInfo rootNode;
        NodeInfo first,second;

        rootNode = treeMapInit(root,null,1);
        first = findIn(rootNode,p.val);
        second = findIn(rootNode,q.val);

        return search(first,second);
    }

    public NodeInfo treeMapInit(TreeNode root,NodeInfo parent,int depth)
    {
        NodeInfo rootNode;
        if(root == null)    return null;
        rootNode = new NodeInfo(root,parent,depth);
        rootNode.left = treeMapInit(root.left,rootNode,depth+1);
        rootNode.right = treeMapInit(root.right,rootNode,depth+1);
        return rootNode;
    }

    public NodeInfo findIn(NodeInfo root,int val)
    {
        NodeInfo leftRes,rightRes;
        if(root == null)    return null;
        if(root.value == val)    return root;
        leftRes = findIn(root.left,val);
        if(leftRes != null)     return leftRes;
        rightRes = findIn(root.right,val);
        if(rightRes != null)     return rightRes;
        return null;
    }
    
    public TreeNode search(NodeInfo first,NodeInfo second)
    {
        if(first == null || second == null) return null;
        if(first.value == second.value) return new TreeNode(first.value);
        if(first.depth > second.depth)
        {
            return search(first.parent,second);
        }
        else if(first.depth < second.depth)
        {
            return search(first,second.parent);
        }
        else
        {
            return search(first.parent,second.parent);
        }
    }
    
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null; // 如果树为空，直接返回null
        if(root == p || root == q) return root; // 如果 p和q中有等于 root的，那么它们的最近公共祖先即为root（一个节点也可以是它自己的祖先）
        TreeNode left = lowestCommonAncestor(root.left, p, q); // 递归遍历左子树，只要在左子树中找到了p或q，则先找到谁就返回谁
        TreeNode right = lowestCommonAncestor(root.right, p, q); // 递归遍历右子树，只要在右子树中找到了p或q，则先找到谁就返回谁
        if(left == null) return right; // 如果在左子树中 p和 q都找不到，则 p和 q一定都在右子树中，右子树中先遍历到的那个就是最近公共祖先（一个节点也可以是它自己的祖先）
        else if(right == null) return left; // 否则，如果 left不为空，在左子树中有找到节点（p或q），这时候要再判断一下右子树中的情况，如果在右子树中，p和q都找不到，则 p和q一定都在左子树中，左子树中先遍历到的那个就是最近公共祖先（一个节点也可以是它自己的祖先）
        else return root; //否则，当 left和 right均不为空时，说明 p、q节点分别在 root异侧, 最近公共祖先即为 root
    }
}
