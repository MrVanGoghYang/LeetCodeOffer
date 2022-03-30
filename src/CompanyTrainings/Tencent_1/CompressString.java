package CompanyTrainings.Tencent_1;

import java.util.Scanner;
import java.util.Stack;

/*
СQ��Ҫ���������ѷ���һ�������ַ����������������ַ����Ĺ��ڳ��ˣ�����СQ������һ��ѹ���㷨���ַ������ظ��Ĳ��ֽ�����ѹ���������ַ�����������m����ͬ�ַ���S����ѹ��Ϊ[m|S](mΪһ��������1<=m<=100)�������ַ���ABCABCABC���ᱻѹ��Ϊ[3|ABC]������СQ��ͬѧ�յ���СQ���͹������ַ��������ܰ��������н�ѹ��ô��
��������:
�����һ�а���һ���ַ���s������ѹ������ַ�����
S�ĳ���<=1000;
S��������д��ĸ��[��]��|;
��ѹ����ַ������Ȳ�����100000;
ѹ���ݹ����������10��;
�������:
���һ���ַ����������ѹ����ַ�����
ʾ��1
����
HG[3|B[2|CA]]F
���
HGBCACABCACABCACAF
˵��
HG[3|B[2|CA]]F?>HG[3|BCACA]F?>HGBCACABCACABCACAF

˼·���ַ��������⣬��˼·��
������[]�е������滻Ϊ��ѹ����Ĵ�����ÿ������'['ʱ������λ��ѹջ��Ϊ[��λ�ò���ı䣬ÿ������']'ʱ��ջ�õ���Ӧ'['��λ�ò���'[' ']'��Χ�ڵ�ѹ���������滻����
����������1.��ѹ���� 2.ȫѹ���� 3.ѹ������3�㣬ÿ���з�Ϊ(1)�����ַ� + ѹ������ + �����ַ��� (2) ѹ������ + �����ַ� + ѹ������; 4.����ѹ��
 */
public class CompressString
{
    public static void main(String[] args)
    {
        CompressString solution = new CompressString();
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        System.out.println(solution.decode(input));
//        String res = solution.decode("HG[3|B[2|CA]]F");
//        System.out.println("HGBCACABCACABCACAF");
//        System.out.println(res);
//        res = solution.decode("HGFEA");
//        System.out.println("HGFEA");
//        System.out.println(res);
//        res = solution.decode("[3|B[2|C[2|E[2|HI]G]A]D]");
//        System.out.println("BCEHIHIGEHIHIGACEHIHIGEHIHIGADBCEHIHIGEHIHIGACEHIHIGEHIHIGADBCEHIHIGEHIHIGACEHIHIGEHIHIGAD");
//        System.out.println(res);
//        res = solution.decode("[3|[2|[2|FG]CA[2|HI]]B[2|[2|JK]DE[2|LM]]]"); // FGFGCAHIHIFGFGCAHIHIBJKJKDELMLMJKJKDELMLMFGFGCAHIHIFGFGCAHIHIBJKJKDELMLMJKJKDELMLMFGFGCAHIHIFGFGCAHIHIBJKJKDELMLMJKJKDELMLM
//        System.out.println("FGFGCAHIHIFGFGCAHIHIBJKJKDELMLMJKJKDELMLMFGFGCAHIHIFGFGCAHIHIBJKJKDELMLMJKJKDELMLMFGFGCAHIHIFGFGCAHIHIBJKJKDELMLMJKJKDELMLM");
//        System.out.println(res);
//        res = solution.decode("[3|[2|[2|FG]CA[2|HI]]B[2|[2|JK]DE[2|LM]]][3|B[2|C[2|E[2|HI]G]A]D]");// FGFG
//        System.out.println("FGFGCAHIHIFGFGCAHIHIBJKJKDELMLMJKJKDELMLMFGFGCAHIHIFGFGCAHIHIBJKJKDELMLMJKJKDELMLMFGFGCAHIHIFGFGCAHIHIBJKJKDELMLMJKJKDELMLMBCEHIHIGEHIHIGACEHIHIGEHIHIGADBCEHIHIGEHIHIGACEHIHIGEHIHIGADBCEHIHIGEHIHIGACEHIHIGEHIHIGAD");
//        System.out.println(res);
    }

    public String decode(String compress)
    {
        StringBuilder res = new StringBuilder(compress);
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        while(i < res.length())
        {
            if(res.charAt(i) == '[')
                stack.push(i);
            else if(res.charAt(i) == ']')
            {
                i = process(res, stack.pop(), i);
                continue;
            }
            i++;
        }
        return res.toString();
    }

    public int process(StringBuilder sb, int left, int right)
    {
        int repNum = 0;
        int scanId = left + 1;
        while(sb.charAt(scanId) >= '0' && sb.charAt(scanId) <= '9')
        {
            scanId++;
        }
        repNum = Integer.valueOf(sb.substring(left + 1, scanId));
        String repStr = sb.substring(scanId + 1, right);
        sb.delete(left, right + 1);
        for(int i = 0; i < repNum; i++)
            sb.insert(left, repStr);
        return left + repNum * repStr.length();
    }
}
