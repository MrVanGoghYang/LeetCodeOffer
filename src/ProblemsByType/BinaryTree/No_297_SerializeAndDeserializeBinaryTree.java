package ProblemsByType.BinaryTree;

import SwordRefersToOffer.DataDefine.TreeNode;

import java.util.*;

public class No_297_SerializeAndDeserializeBinaryTree
{
    // �ǵݹ������������https://blog.csdn.net/h1091068389/article/details/124997564
    // ������ǵݹ�˼�룬�ݹ�ǰ��õ����л���������ݹ�õ������л��������ǰ������õ� ��->��->�� �Ľ������ô�����л������ó���һ��Ԫ����Ϊroot�����ӽ����ȥ����һ��Ԫ�أ����ݹ���ȡ��һ��Ԫ�ع��������������Ǹ���ǰ��ݹ��˼�뷴�ݹ黹ԭ��
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        String preOrder = preOrder(root, new StringBuilder());
        // System.out.println(preOrder);
        return preOrder.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] pre = new StringBuilder(data).deleteCharAt(data.length() - 1).toString().split(">");
        List<String> preList = new ArrayList<>();
        for(String item : pre)
            preList.add(item);
        return buildTree(preList);
    }

    public String preOrder(TreeNode root, StringBuilder sb){
        if(root == null){
            sb.append("#>");
        }
        else{
            sb.append(String.valueOf(root.val) + ">");
            preOrder(root.left, sb);
            preOrder(root.right, sb);
        }
        return sb.toString();
    }

    public TreeNode buildTree(List<String> preList)
    {
        TreeNode root = preList.get(0).equals("#") ? null : new TreeNode(Integer.parseInt(preList.get(0)));
        preList.remove(0);
        if(root != null){
            root.left = buildTree(preList);
            root.right = buildTree(preList);
        }
        return root;
    }
}
