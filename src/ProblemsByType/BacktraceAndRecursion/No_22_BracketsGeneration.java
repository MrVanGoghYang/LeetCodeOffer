package ProblemsByType.BacktraceAndRecursion;

import java.util.ArrayList;
import java.util.List;

public class No_22_BracketsGeneration
{
    /*
    ˼·����ʵ���Ƕ�����ѡ������⣬��2n��λ�ã�ÿ��λ�ÿ���ѡ�����(�����)���֣�����ֱ��DFS�����������ܵ������
    ��֦������һ���Ϸ����Ŵ��Ĵ���������ӹ����У�����������һ�������������������������ȼ�һ�������ţ��϶���Υ������ġ���˵���������������������������ֱ�ӷ��ء�
     */
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        recurseGen(n, n, sb, res);
        return res;
    }

    public void recurseGen(int lremain, int rremain, StringBuilder cur, List<String> res)
    {
        // �Ƿ����룬ֱ��return��ע���κκϷ����Ŵ��������ŵ���Ŀ�϶�������������Ŀ
        if(lremain < 0 || rremain < 0 || lremain > rremain)
            return;
        // �Ϸ�����
        if(lremain == 0 && rremain == 0)
        {
            res.add(cur.toString());
            return;
        }
        // ѡ��һ�����
        cur.append('(');
        // �ݹ�
        recurseGen(lremain - 1, rremain, cur, res);
        // ����ѡ��
        cur.deleteCharAt(cur.length() - 1);

        // ѡ����һ�����
        cur.append(')');
        // �ݹ�
        recurseGen(lremain, rremain - 1, cur, res);
        // ����ѡ��
        cur.deleteCharAt(cur.length() - 1);
    }
}
