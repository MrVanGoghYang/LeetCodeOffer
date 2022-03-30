package CompanyTrainings.NetEase_1.Problem1;

import java.util.Arrays;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args) {
        Main solution = new Main();
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int caseIndex = 0; caseIndex < T; caseIndex++)
        {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i = 0; i < n; i++)
                arr[i] = sc.nextInt();
            Arrays.sort(arr);
            for(int i = 0; i < arr.length >> 1; i++)
            {
                arr[i] += arr[arr.length - 1 - i];
                arr[arr.length - 1 - i] = arr[i] - arr[arr.length - 1 - i];
                arr[i] -= arr[arr.length - 1 - i];
            }
            System.out.println(solution.process(arr, 0, 0, 0, 0));
        }
    }

    public int process(int[] arr, int index, int sumA, int sumB, int abortNum)
    {
        if(index == arr.length && sumA == sumB)
            return abortNum;
        else if(index < arr.length)
        {
            int subRes = -1;
            int item = -1;
            item = process(arr, index + 1, sumA + arr[index], sumB, abortNum);
            if(item != -1)
                subRes = subRes == -1 ? item : Math.min(subRes, item);
            item = process(arr, index + 1, sumA, sumB + arr[index], abortNum);
            if(item != -1)
                subRes = subRes == -1 ? item : Math.min(subRes, item);
            item = process(arr, index + 1, sumA, sumB, abortNum + arr[index]);
            if(item != -1)
                subRes = subRes == -1 ? item : Math.min(subRes, item);
            return subRes;
        }
        return -1;
    }
}
