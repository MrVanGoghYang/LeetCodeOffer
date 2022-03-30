package ProblemsByType.BipartiteTree;

import SwordRefersToOffer.DataDefine.TreeNode;

import java.util.HashSet;

public class No_124_BinTreeMaxPathSum
{
    // ʹ��ȫ�ֱ�����¼ÿ���ӽ���Ƿ���Ը��¸�ȫ�����ֵ
    int res = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxContribute(root);
        return res;
    }

    // �ݹ麯�������㾭��root���µ����·���ͣ����root����ֻ��ѡһ����֧ȥ�߻���һ������ѡ������ѡ������֧һ����
    public int maxContribute(TreeNode root)
    {
        if(root == null)
            return 0;
        // ���ӽڵ㹱��ֵΪ0�����ʾ��ѡ����ӷ�֧
        int leftContri = Math.max(0, maxContribute(root.left));
        int rightContri = Math.max(0, maxContribute(root.right));
        // �õ������ӽ������Ϊ�����ӽ���϶������ڵ���0������root.val+����+�ҽ����ʵ�Ͱ��������Ҷ�ѡ+root�����Ҷ���ѡֻ��root������ֻѡһ����֧+root�����
        // ��ѡrootֻѡ��һ���ӷ�֧����������ӵݹ����Ѿ����������˴˴�ֻ���������root��������ɡ�
        res = Math.max(res, leftContri + rightContri + root.val);
        // ���ڼ�����Ǳ��뾭��root�����·���ͣ����ֻ��ѡ�����ӷ�֧��max����root.val
        return root.val + Math.max(leftContri, rightContri);
    }
}
