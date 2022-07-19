package CompanyExams.HuaweiExams.Problem2;

import java.util.*;

public class Main
{
    static class Node
    {
        int val;
        int inDegree;
        List<Integer> neighbor;
        Node(int val, int inDegree, List<Integer> neighbor)
        {
            this.val = val;
            this.inDegree = inDegree;
            this.neighbor = neighbor;
        }
    }
    static List<Integer> res = new ArrayList<>();
    public static void main(String[] args) {
        // please define the JAVA input here. For example: Scanner s = new Scanner(System.in);
        // please finish the function body here.
        // please define the JAVA output here. For example: System.out.println(s.nextInt());
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int target = sc.nextInt();
        Node[] graph = new Node[N];
        sc.nextLine();
        for(int i = 0; i < N; i++)
            graph[i] = new Node(i, 0, new ArrayList<>());
        for(int i = 0; i < N; i++)
        {
            String[] depen = sc.nextLine().split(",");
            int neighCnt = Integer.parseInt(depen[0]);
            graph[i].inDegree += neighCnt;
            for(int j = 1; j <= neighCnt; j++)
            {
                int neighbor = Integer.parseInt(depen[j]);
                graph[neighbor].neighbor.add(i);
            }
        }
        boolean canStart = topo(graph, target);
        if(!canStart)
        {
            System.out.print(-1);
            return;
        }
        else
            getRes(graph, target);
        if(res.size() == 0)
        {
            System.out.print("null");
            return;
        }
        Collections.sort(res);
        for(int i = 0; i < res.size(); i++)
        {
            System.out.print(res.get(i));
            if(i != res.size() - 1)
                System.out.print(',');
        }
    }

    public static boolean topo(Node[] graph, int target)
    {
        Queue<Integer> queue = new ArrayDeque<>();
        for(int i = 0; i < graph.length; i++)
        {
            if(graph[i].inDegree == 0)
                queue.offer(i);
        }
        while(!queue.isEmpty())
        {
            Integer top = queue.poll();
            if(top == target)
                return true;
            for(Integer item : graph[top].neighbor)
            {
                graph[item].inDegree -= 1;
                if(graph[item].inDegree == 0)
                    queue.offer(item);
            }
        }
        return false;
    }

    public static void getRes(Node[] graph, int target)
    {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(target);
        while(!queue.isEmpty())
        {
            Integer top = queue.poll();
            if(top != target)
                res.add(top);
            for(int i = 0; i < graph.length; i++)
            {
                if(graph[i].neighbor.contains(top) && !res.contains(i))
                    queue.offer(i);
            }
        }
    }
}
