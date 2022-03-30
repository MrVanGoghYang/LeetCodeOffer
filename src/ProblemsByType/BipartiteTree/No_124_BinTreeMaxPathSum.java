package ProblemsByType.BipartiteTree;

import SwordRefersToOffer.DataDefine.TreeNode;

import java.util.HashSet;

public class No_124_BinTreeMaxPathSum
{
    // 使用全局变量记录每次子结果是否可以更新该全局最大值
    int res = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxContribute(root);
        return res;
    }

    // 递归函数，计算经过root往下的最大路径和，因此root往下只能选一个分支去走或者一个都不选，不能选两个分支一起走
    public int maxContribute(TreeNode root)
    {
        if(root == null)
            return 0;
        // 若子节点贡献值为0，则表示不选择该子分支
        int leftContri = Math.max(0, maxContribute(root.left));
        int rightContri = Math.max(0, maxContribute(root.right));
        // 得到左右子结果后，因为左右子结果肯定都大于等于0，计算root.val+左结果+右结果其实就包含了左右都选+root、左右都不选只有root、左右只选一个分支+root的情况
        // 不选root只选择一个子分支的情况，在子递归中已经计算过，因此此处只需计算必须加root的情况即可。
        res = Math.max(res, leftContri + rightContri + root.val);
        // 由于计算的是必须经过root的最大路径和，因此只能选左右子分支的max加上root.val
        return root.val + Math.max(leftContri, rightContri);
    }
}
