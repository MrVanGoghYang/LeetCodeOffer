package CompanyExams.XiechengExams.Problem3;

import java.util.*;

public class Main
{
    public static void main(String[] args) {
        Main solution = new Main();
        Scanner sc = new Scanner(System.in);
        char[] input = sc.nextLine().toCharArray();
        char[] input2 = Arrays.copyOf(input, input.length);
        Queue<Integer> zeroQueue = new PriorityQueue<>();
        Queue<Integer> oneQueue = new PriorityQueue<>();
        Queue<Integer> zeroQueue2 = new PriorityQueue<>();
        Queue<Integer> oneQueue2 = new PriorityQueue<>();

        int zeroCnt = 0;
        int oneCnt = 0;
        int len = input.length;
        for(int i = 0; i < len; i++)
        {
            if(input[i] == '0')
            {
                zeroQueue.offer(i);
                zeroQueue2.offer(i);
                zeroCnt++;
            }
            else
            {
                oneQueue.offer(i);
                oneQueue2.offer(i);
                oneCnt++;
            }
        }
        //不同0 1
        StringBuilder target = new StringBuilder();
        if(zeroCnt > oneCnt)
            target.append('0');
        else
            target.append('1');
        for(int i = 0; i < len - 1; i++)
        {
            if(target.charAt(target.length() - 1) == '0')
                target.append('1');
            else
                target.append('0');
        }
        // 相同0 1
        StringBuilder target2 = new StringBuilder();
        if(zeroCnt == oneCnt)
        {
            for(int i = 0; i < len; i++)
            {
                if(target.charAt(i) == '0')
                    target2.append('1');
                else
                    target2.append('0');
            }
        }

        int res = 0;
        int index = 0;
        for(int i = 0; i < len; i++)
        {
            if(input[i] != target.charAt(i))
            {
                index = input[i] == '0' ? oneQueue.poll() : zeroQueue.poll();
                input[i] = input[i] == '0' ? '1' : '0';
                input[index] = input[i] == '0' ? '1' : '0';
                res += index - i;
            }
            else
            {
                if(input[i] == '0')
                    zeroQueue.poll();
                else
                    oneQueue.poll();
            }
        }

        if(zeroCnt == oneCnt)
        {
            int res3 = 0;
            for(int i = 0; i < len; i++)
            {
                if(input2[i] != target2.charAt(i))
                {
                    index = input2[i] == '0' ? oneQueue2.poll() : zeroQueue2.poll();
                    input2[i] = input2[i] == '0' ? '1' : '0';
                    input2[index] = input2[i] == '0' ? '1' : '0';
                    res3 += index - i;
                }
                else
                {
                    if(input2[i] == '0')
                        zeroQueue2.poll();
                    else
                        oneQueue2.poll();
                }
            }
            System.out.println(Math.min(res ,res3));
        }
        else
            System.out.println(res);
    }
}
