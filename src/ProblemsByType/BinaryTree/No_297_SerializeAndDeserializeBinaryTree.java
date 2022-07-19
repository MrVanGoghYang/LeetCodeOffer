package ProblemsByType.BinaryTree;

import SwordRefersToOffer.DataDefine.TreeNode;

import java.util.*;

public class No_297_SerializeAndDeserializeBinaryTree
{
    // 非递归遍历二叉树：https://blog.csdn.net/h1091068389/article/details/124997564
    // 此题就是递归思想，递归前序得到序列化结果，反递归得到反序列化结果。即前序遍历得到 中->左->右 的结果，那么反序列化就先拿出第一个元素作为root，并从结果中去掉第一个元素，随后递归再取第一个元素构建左子树，就是根据前序递归的思想反递归还原。
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
