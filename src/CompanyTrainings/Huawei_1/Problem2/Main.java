package CompanyTrainings.Huawei_1.Problem2;

/*
https://www.nowcoder.com/question/next?pid=1088888&qid=36846&tid=54543925

输入例子1:
3
2
2
1
输出例子1:
1
2
 */
import java.util.*;
public class Main
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int[] arr = new int[len];
        for(int i = 0; i < len; i++)
            arr[i] = sc.nextInt();
        if(len == 1)
            return;
        quicksort(arr, 0, len - 1);
//        System.out.println(Arrays.toString(arr));
        int slow = 0;
        int fast = 0;
        while(fast < len)
        {
            while(fast > 0 && fast < len && arr[fast] == arr[fast - 1])
                fast++;
            if(fast < len)
                arr[slow++] = arr[fast++];
        }
        for(int i = 0; i < slow; i++)
            System.out.println(arr[i]);

    }

    public static void quicksort(int[] arr, int begin, int end)
    {
        if(begin >= end)
            return;
        int mid = partition(arr, begin, end);
        if(begin < mid - 1)
            quicksort(arr, begin, mid - 1);
        if(mid + 1 < end)
            quicksort(arr, mid + 1, end);
    }

    public static int partition(int[] arr, int begin, int end)
    {
        int pivort = arr[begin];
        int p = begin;
        int q = end;
        while(p < q)
        {
            while(p < q && arr[q] >= pivort)
                q--;
            if(p < q)
                arr[p] = arr[q];
            while(p < q && arr[p] <= pivort)
                p++;
            if(p < q)
                arr[q] = arr[p];
        }
        arr[p] = pivort;
        return p;
    }
}
