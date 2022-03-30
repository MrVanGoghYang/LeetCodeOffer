package CompanyTrainings.Huawei_1.Problem3;
/*
https://www.nowcoder.com/question/next?pid=1088888&qid=36827&tid=54543925
输入描述:
输入一个十六进制的数值字符串。


输出描述:
输出该数值的十进制字符串。不同组的测试用例用\n隔开。


输入例子1:
0xAA

输出例子1:
170
 */
import java.util.Locale;
import java.util.Scanner;
public class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String hex = sc.nextLine();
        char[] hexArr = hex.substring(2, hex.length()).toUpperCase(Locale.ROOT).toCharArray();
        int len = hexArr.length;
        int res = 0;
        int weight = 1;
        for(int i = len - 1; i >= 0; i--)
        {
            int val = hexArr[i];
            if(val >= '0' && val <= '9')
                val -= '0';
            else
                val = (val - 'A') + 10;
            res += val * weight;
            weight *= 16;
        }
        System.out.println(res);
    }
}
