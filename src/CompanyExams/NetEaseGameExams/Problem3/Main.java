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

    // 1.每次分割后开头或行末有空格（都要去掉） / 开头有标点（强制上移）； 2. 每次尝试分割时末尾单词放不下（可扩容/不可扩容）；
    public static void process(String sentence, int N, int M)
    {
        char[] arr = sentence.toCharArray();
        StringBuilder subRes;
        int i = 0;
        while(i < arr.length)
        {
            subRes = new StringBuilder();
            char beginChar = arr[i];
            // 2.开头有标点（强制上移）
            if(!(beginChar == ' ' || (beginChar >= 'a' && beginChar <= 'z') || (beginChar >= 'A' && beginChar <= 'Z')))
            {
                res.get(res.size() - 1).append(beginChar);
                i += 2;
            }
            // 1.每次分割后开头有空格（去掉）
            else if(beginChar == ' ')
                i++;
            int insert = i + N >= arr.length ? arr.length - i : N;
            subRes.insert(subRes.length(), arr, i, insert);
            i += insert;
            // 3.末尾有空格（去掉）
            char endChar = subRes.charAt(subRes.length() - 1);
            if(endChar == ' ')
                subRes.deleteCharAt(subRes.length() - 1);
            // 4. 每次尝试分割时末尾单词放不下（可扩容/不可扩容）；
            else if(i < arr.length && ((arr[i - 1] >= 'a' && arr[i - 1] <= 'z') || (arr[i - 1] >= 'A' && arr[i - 1] <= 'Z'))
                    && ((arr[i] >= 'a' && arr[i] <= 'z') || (arr[i] >= 'A' && arr[i] <= 'Z')))
            {
                char item = arr[i];
                int cursor = i;
                while(cursor < arr.length && ((arr[cursor] >= 'a' && arr[cursor] <= 'z') || (arr[cursor] >= 'A' && arr[cursor] <= 'Z')))
                    cursor++;
                int insertLen = cursor - i;
                // 放得下
                if(insertLen <= M)
                {
                    subRes.insert(subRes.length(), arr, i, insertLen);
                    i += insertLen;
                }
                // 放不下
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