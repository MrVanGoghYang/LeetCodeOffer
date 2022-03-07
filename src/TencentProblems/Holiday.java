package TencentProblems;

import java.util.Scanner;

/*
����ҵ�����㣬��˾��СQ���� n ��ļ٣���Ϊ�������СQ�������ڼ����й���������������Ϣ�����и���ֵ�ϰ�ߣ������������칤���������
ֻ�е���˾Ӫҵʱ��СQ����ȥ������ֻ�е�����Ӫҵʱ��СQ����ȥ����СQһ��ֻ�ܸ�һ���¡����������й�˾��������Ӫҵ�������СQ������Ҫ��Ϣ���졣
��������:
��һ��һ������  ��ʾ�ż�����
�ڶ��� n ���� ÿ����Ϊ0��1,�� i ������ʾ��˾�ڵ� i ���Ƿ�Ӫҵ
������ n ���� ÿ����Ϊ0��1,�� i ������ʾ�����ڵ� i ���Ƿ�Ӫҵ
��1ΪӪҵ 0Ϊ��Ӫҵ��
�������:
һ����������ʾСQ��Ϣ����������
��������1:
4
1 1 0 0
0 1 1 0
6
0 0 0 0 0 0
0 0 0 0 0 0
6
1 1 1 1 1 1
1 1 1 1 1 1
6
1 1 1 0 0 0
0 0 0 1 1 1
6
1 0 1 0 1 0
0 1 0 1 0 1
�������1:
2
����˵��1:
СQ�����ڵ�һ�칤�����ڶ��������콡��СQ������Ϣ2��

����������ȫ0 ȫ��Ϣ������ȫ1 ����Ϣ����һ��ǰ��1���0  �ڶ���ǰ��0���1����һ�к͵ڶ���0 1����
dfs�ݹ� -> dfs����  visit���飺0δ���ʡ�1�ϰࡢ2������3��Ϣ
 */
public class Holiday
{
    public static void main(String[] args)
    {
        Holiday solution = new Holiday();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean[] company = new boolean[n];
        boolean[] gym = new boolean[n];
        int[] visited = new int[n];
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++)
        {
            company[i] = sc.nextInt() == 1 ? true : false;
        }
        for (int i = 0; i < n; i++)
        {
            gym[i] = sc.nextInt() == 1 ? true : false;
        }
        if(company[0])
            res = Math.min(res, solution.dfs(company, gym, visited, 0, 1));
        if(gym[0])
            res = Math.min(res, solution.dfs(company, gym, visited, 0, 2));
        if(!company[0] && !gym[0])
            res = Math.min(res, solution.dfs(company, gym, visited, 0, 3));
        System.out.println(res);
    }

    // ���شӵ�idx+1�쿪ʼ������ĻΪactiʱ���ۼ���Ϣ����������
    public int dfs(boolean[] company, boolean[] gym, int[] visited, int idx, int acti)
    {
        // �ݹ���ֹ
        if(idx == company.length || visited[idx] != 0)
            return 0;
        // ��ʼ����
        int res = 0;

        visited[idx] = acti;
        // ���п���ѡ��
        for(int i = 1; i <= 3; i++)
        {
            boolean[] item = getActiArr(company, gym, acti);
            if(item != null && )
            // ѡ��һ��
            // �ӵݹ�
            int saveRes = res;
            res += dfs(company, gym, visited, idx + 1, i);
            // ����ѡ�� ����
            if(idx + 1 < company.length)
                visited[idx + 1] = 0;
        }
        return res;
    }

    public boolean[] getActiArr(boolean[] company, boolean[] gym, int acti)
    {
        if(acti == 1)
            return company;
        else if(acti == 2)
            return gym;
        return null;
    }

}
