package Problems;
/*
 * 	LeetCode.68.2
 * 	����һ��
 * 	�������µ�һ���ڵ���ϢNodeInfo������¼���ڵ��Լ��ýڵ����ȡ�
 * 	1.����ʹ���µ����ݽṹ�ؽ���������ÿ���ڵ�ӵ���������Ϣ�͸��ڵ���Ϣ��
 * 	2.���µ������ҵ��������������ڵ��Ϊleft��right��
 * 	3.ʹ��left��right�ڵ���еݹ������������ȣ������ڵ�ֵ���ʱ���أ����ڵ�ֵ������ 
 * 		1.��ڵ��depth�����ҽڵ㼴���Ҹߣ���ݹ鷵����ڵ�ĸ��ڵ����ҽڵ�Ĺ������ȣ�
 * 		2.��ڵ�depthС��������Ұ����ݹ鷵����ڵ����ҽڵ�ĸ��ڵ�Ĺ������ȣ�
 * 		3.���ڵ�depthһ������ݹ鷵����ڵ�ĸ��ڵ����ҽڵ�ĸ��ڵ�Ĺ�������
 * 
 * 	��������
 * 	��ע�ͣ�
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
        if(root == null) return null; // �����Ϊ�գ�ֱ�ӷ���null
        if(root == p || root == q) return root; // ��� p��q���е��� root�ģ���ô���ǵ�����������ȼ�Ϊroot��һ���ڵ�Ҳ���������Լ������ȣ�
        TreeNode left = lowestCommonAncestor(root.left, p, q); // �ݹ������������ֻҪ�����������ҵ���p��q�������ҵ�˭�ͷ���˭
        TreeNode right = lowestCommonAncestor(root.right, p, q); // �ݹ������������ֻҪ�����������ҵ���p��q�������ҵ�˭�ͷ���˭
        if(left == null) return right; // ������������� p�� q���Ҳ������� p�� qһ�������������У����������ȱ��������Ǹ���������������ȣ�һ���ڵ�Ҳ���������Լ������ȣ�
        else if(right == null) return left; // ������� left��Ϊ�գ��������������ҵ��ڵ㣨p��q������ʱ��Ҫ���ж�һ���������е������������������У�p��q���Ҳ������� p��qһ�������������У����������ȱ��������Ǹ���������������ȣ�һ���ڵ�Ҳ���������Լ������ȣ�
        else return root; //���򣬵� left�� right����Ϊ��ʱ��˵�� p��q�ڵ�ֱ��� root���, ����������ȼ�Ϊ root
    }
}
