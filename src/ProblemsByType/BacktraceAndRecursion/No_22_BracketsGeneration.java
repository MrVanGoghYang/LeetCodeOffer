package ProblemsByType.BacktraceAndRecursion;

import java.util.ArrayList;
import java.util.List;

public class No_22_BracketsGeneration
{
    /*
    思路：其实就是二叉树选择的问题，有2n个位置，每个位置可以选择放入(或放入)两种，可以直接DFS回溯搜索可能的情况。
    剪枝条件：一个合法括号串的从左往右添加过程中，左括号数量一定大于右括号数量，否则考虑先加一个右括号，肯定是违反规则的。因此当左括号数量大于右括号数量就直接返回。
     */
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        recurseGen(n, n, sb, res);
        return res;
    }

    public void recurseGen(int lremain, int rremain, StringBuilder cur, List<String> res)
    {
        // 非法输入，直接return。注意任何合法括号串，左括号的数目肯定大于右括号数目
        if(lremain < 0 || rremain < 0 || lremain > rremain)
            return;
        // 合法返回
        if(lremain == 0 && rremain == 0)
        {
            res.add(cur.toString());
            return;
        }
        // 选择一种情况
        cur.append('(');
        // 递归
        recurseGen(lremain - 1, rremain, cur, res);
        // 撤销选择
        cur.deleteCharAt(cur.length() - 1);

        // 选择另一种情况
        cur.append(')');
        // 递归
        recurseGen(lremain, rremain - 1, cur, res);
        // 撤销选择
        cur.deleteCharAt(cur.length() - 1);
    }
}
