package ProblemsByType.BinaryTree;

import SwordRefersToOffer.DataDefine.TreeNode;

import java.util.*;

public class No_105_ConstructBinTree
{
    // ��������������ʹ��ջ���ߵ�ǰ�����������ʹջ��Ԫ�ط���˳��ҲΪ�����У� ��index ָ��inOrder����preOrder[i] != inOrder[index]ʱ preOrder[i]һֱ��ջ���� == ʱ��ʼ��ջ��
    // ͬʱindex++��ֱ������ջ������inOrder[index]����ʱ��inOrder[index]Ӧ�����������һ����ȵĽ����������ϣ�Ȼ��ѭ��������̡�
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || preorder.length == 0)
            return null;
        Deque<TreeNode> stack = new ArrayDeque<>();
        int preIndex = 0;
        int inIndex = 0;
        TreeNode root = new TreeNode(preorder[0]);
        TreeNode res = root;
        stack.push(root);
        for(int i = 1; i < preorder.length; i++)
        {
            if(stack.peek().val != inorder[inIndex])
            {
                root.left = new TreeNode(preorder[i]);
                stack.push(root.left);
                root = root.left;
            }
            else
            {
                while(!stack.isEmpty() && inIndex < inorder.length && stack.peek().val == inorder[inIndex])
                {
                    root = stack.pop();
                    inIndex++;
                }
                if(inIndex < inorder.length)
                {
                    root.right = new TreeNode(preorder[i]);
                    stack.push(root.right);
                    root = root.right;
                }
            }
        }
        return res;
    }
    // ����һ�� �ݹ齨��
    // HashMap<Integer, Integer> map = new HashMap<>();
    // public TreeNode buildTree(int[] preorder, int[] inorder) {
    //     for(int i = 0; i < inorder.length; i++)
    //     {
    //         map.put(inorder[i], i);
    //     }
    //     return build(new TreeNode(), preorder, 0, inorder, 0, inorder.length - 1);
    // }

    // public TreeNode build(TreeNode root, int[] preorder,int preBegin, int[] inorder, int inorderBegin, int inorderEnd)
    // {
    //     if(preBegin < preorder.length)
    //     {
    //         int rootVal = preorder[preBegin];
    //         root.val = rootVal;
    //         int rootValIndex = map.get(rootVal);
    //         if(inorderBegin <= rootValIndex - 1)
    //             root.left = build(new TreeNode(), preorder, preBegin + 1, inorder, inorderBegin, rootValIndex - 1);
    //         if(rootValIndex + 1 <= inorderEnd)
    //             root.right = build(new TreeNode(), preorder, preBegin + 1 + rootValIndex - inorderBegin, inorder, rootValIndex + 1, inorderEnd);
    //     }
    //     return root;
    // }
}
