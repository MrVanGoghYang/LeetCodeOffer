package ProblemsByType.BacktraceAndRecursion;

import java.util.*;

public class No_17_LetterCombinationsOfPhoneNumbers
{
    List<String> res = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        char[][] digitToChar = new char[][]{{'a','b','c'},{'d','e','f'},{'g','h','i'},{'j','k','l'},{'m','n','o'},{'p','q','r','s'},{'t','u','v'},{'w','x','y','z'}};
        int n = digits.length();
        if(n == 0)
            return res;
        int[] digitsArr = new int[n];
        for(int i = 0; i < n; i++)
        {
            digitsArr[i] = digits.charAt(i) - '2';
        }
        dfs(digitsArr, digitToChar, n, new StringBuilder(), 1);
        return res;
    }
    public void dfs(int[] digits, char[][] digitToChar, int n, StringBuilder curStr, int dim)
    {
        // System.out.println(curStr + " " + dim);
        // �ݹ��˳�����
        if(dim > n)
        {
            if(curStr.length() == n)
            {
                res.add(curStr.toString());
                // System.out.println("Res Add : " + res);
            }
            return;
        }
        // ��������ѡ��
        for(int i = 0; i < digitToChar[digits[dim - 1]].length; i++)
        {
            // ѡ��һ��
            curStr.append(digitToChar[digits[dim - 1]][i]);
            // ������һ��ݹ�
            dfs(digits, digitToChar, n, curStr, dim + 1);
            // ����ѡ��
            curStr.deleteCharAt(curStr.length() - 1);
        }
    }
}
