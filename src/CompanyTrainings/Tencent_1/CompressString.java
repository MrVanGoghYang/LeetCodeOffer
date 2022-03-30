package CompanyTrainings.Tencent_1;

import java.util.Scanner;
import java.util.Stack;

/*
小Q想要给他的朋友发送一个神秘字符串，但是他发现字符串的过于长了，于是小Q发明了一种压缩算法对字符串中重复的部分进行了压缩，对于字符串中连续的m个相同字符串S将会压缩为[m|S](m为一个整数且1<=m<=100)，例如字符串ABCABCABC将会被压缩为[3|ABC]，现在小Q的同学收到了小Q发送过来的字符串，你能帮助他进行解压缩么？
输入描述:
输入第一行包含一个字符串s，代表压缩后的字符串。
S的长度<=1000;
S仅包含大写字母、[、]、|;
解压后的字符串长度不超过100000;
压缩递归层数不超过10层;
输出描述:
输出一个字符串，代表解压后的字符串。
示例1
输入
HG[3|B[2|CA]]F
输出
HGBCACABCACABCACAF
说明
HG[3|B[2|CA]]F?>HG[3|BCACA]F?>HGBCACABCACABCACAF

思路：字符串处理题，考思路。
将所有[]中的内容替换为解压缩后的串，，每次遇到'['时将所在位置压栈因为[的位置不会改变，每次遇到']'时弹栈得到对应'['的位置并对'[' ']'范围内的压缩串进行替换处理。
测试用例：1.无压缩； 2.全压缩； 3.压缩迭代3层，每层中分为(1)常规字符 + 压缩部分 + 常规字符； (2) 压缩部分 + 常规字符 + 压缩部分; 4.并排压缩
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
