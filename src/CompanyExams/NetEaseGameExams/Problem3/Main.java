package CompanyExams.NetEaseGameExams.Problem3;

import java.util.*;

/*
20 3
I am coordinator of the Latin video games Federation. I'm born, member of the UWOOyan game Developers Association.
 */
public class Main
{
    private static List<StringBuilder> res = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        sc.nextLine();
        String sentence = sc.nextLine();
        process(sentence, N, M);
        for(int i = 0; i < res.size(); i++)
        {
            System.out.print(res.get(i));
            if(i != res.size() - 1) System.out.println();
        }
    }

    // 1.ÿ�ηָ��ͷ����ĩ�пո񣨶�Ҫȥ���� / ��ͷ�б�㣨ǿ�����ƣ��� 2. ÿ�γ��Էָ�ʱĩβ���ʷŲ��£�������/�������ݣ���
    public static void process(String sentence, int N, int M)
    {
        char[] arr = sentence.toCharArray();
        StringBuilder subRes;
        int i = 0;
        while(i < arr.length)
        {
            subRes = new StringBuilder();
            char beginChar = arr[i];
            // 2.��ͷ�б�㣨ǿ�����ƣ�
            if(!(beginChar == ' ' || (beginChar >= 'a' && beginChar <= 'z') || (beginChar >= 'A' && beginChar <= 'Z')))
            {
                res.get(res.size() - 1).append(beginChar);
                i += 2;
            }
            // 1.ÿ�ηָ��ͷ�пո�ȥ����
            else if(beginChar == ' ')
                i++;
            int insert = i + N >= arr.length ? arr.length - i : N;
            subRes.insert(subRes.length(), arr, i, insert);
            i += insert;
            // 3.ĩβ�пո�ȥ����
            char endChar = subRes.charAt(subRes.length() - 1);
            if(endChar == ' ')
                subRes.deleteCharAt(subRes.length() - 1);
            // 4. ÿ�γ��Էָ�ʱĩβ���ʷŲ��£�������/�������ݣ���
            else if(i < arr.length && ((arr[i - 1] >= 'a' && arr[i - 1] <= 'z') || (arr[i - 1] >= 'A' && arr[i - 1] <= 'Z'))
                    && ((arr[i] >= 'a' && arr[i] <= 'z') || (arr[i] >= 'A' && arr[i] <= 'Z')))
            {
                char item = arr[i];
                int cursor = i;
                while(cursor < arr.length && ((arr[cursor] >= 'a' && arr[cursor] <= 'z') || (arr[cursor] >= 'A' && arr[cursor] <= 'Z')))
                    cursor++;
                int insertLen = cursor - i;
                // �ŵ���
                if(insertLen <= M)
                {
                    subRes.insert(subRes.length(), arr, i, insertLen);
                    i += insertLen;
                }
                // �Ų���
                else
                {
                    cursor = i - 1;
                    while(cursor >= 0 && ((arr[cursor] >= 'a' && arr[cursor] <= 'z') || (arr[cursor] >= 'A' && arr[cursor] <= 'Z')))
                        cursor--;
                    int deleteLen = i - 1 - cursor;
                    subRes.delete(subRes.length() - deleteLen, subRes.length());
                    if(subRes.length() > 0 && subRes.charAt(subRes.length() - 1) == ' ')
                        subRes.deleteCharAt(subRes.length() - 1);
                    i = cursor;
                }
            }
            if(subRes.length() > 0 && subRes.length() <= N + M)
                res.add(subRes);
        }
    }
}