package CompanyTrainings.Huawei_1.Problem3;
/*
https://www.nowcoder.com/question/next?pid=1088888&qid=36827&tid=54543925
��������:
����һ��ʮ�����Ƶ���ֵ�ַ�����


�������:
�������ֵ��ʮ�����ַ�������ͬ��Ĳ���������\n������


��������1:
0xAA

�������1:
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
