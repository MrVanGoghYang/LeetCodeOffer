package ProblemsByType.Stack;

import java.util.*;

// ˼·һ����Ϊ�������Ļ����������Ż�����
public class No_43_TrappingRainWater
{
    /*
    ˼·��������ĳ��λ������һֱɨ�裬���ǽ�ĸ߶�һֱ�ݼ���������ô��Щǽ֮�䶼���ܷ�����ˮ��ֱ�������ǵݼ��߶ȵĵ�һ��ǽ�����Է�����ˮ��
    ʵ�֣�����ջ���洢�����ݼ�������ǽ�߶ȣ��������ߵ�һ��ǽ��һֱ��ջ������ջ����ö¸��ߵ�ǽ�м��ܷŵ�ˮ����ջ�������ٷ����Ԫ�ء�ʱ�临�Ӷ�ΪO(n)��ÿ��λ�����һ����ջ+һ�γ�ջ��
     */
    public int trap(int[] height) {
        int res = 0;
        int n = height.length;
        Stack<Integer[]> stack = new Stack<>();
        for(int i = 0; i < n; i++)
        {
            while(!stack.isEmpty() && height[i] > stack.peek()[0])
            {
                Integer[] botHeight = stack.pop();
                if(stack.size() > 0)
                {
                    res += Math.min((stack.peek()[0] - botHeight[0]), height[i] - botHeight[0]) * (i - stack.peek()[1] - 1);
                }
            }
            stack.push(new Integer[]{height[i], i});
        }
        return res;
    }

    /*
    ˼·һ�� �������ո񣬼��������Ŀ���Ƚ��鷳ʱ�临�Ӷ�ΪO(n^2)
     */
//    public int trap(int[] height) {
//        // ����ͳ��ÿ���߶ȳ��ֵ��±꣬�߶Ȱ��Ӵ�С���У�ÿ���߶ȳ��ֵ��±갴��С��������
//        Map<Integer, List<Integer>> map = new TreeMap<>(new Comparator<Integer>(){
//            @Override
//            public int compare(Integer p, Integer q)
//            {
//                return q - p;
//            }
//        });
//        int n = height.length;
//        boolean[] visited = new boolean[n];
//        int res = 0;
//        for(int i = 0; i < n; i++)
//        {
//            // initArea += height[i];
//            if(!map.containsKey(height[i]))
//            {
//                List<Integer> list = new ArrayList<>();
//                list.add(i);
//                map.put(height[i], list);
//            }
//            else
//            {
//                List<Integer> list = map.get(height[i]);
//                list.add(i);
//                map.replace(height[i], list);
//            }
//        }
//        // Ȼ��Ӹ߶ȴӸߵ���ȡ��ÿ���߶ȶ�Ӧ���±�List���Ӹø߶ȵ�ÿ��λ�ã��������Ҽ��������ȱʧ�Ŀո�鲢�������ĸ���������res�������ľͼ�¼��visitedΪtrue������ɨ�赽��λ�þͲ���Ҫ����ɨ�衣
//        for(Integer id : map.keySet())
//        {
//            if(id > 0)
//            {
//                List<Integer> list = map.get(id);
//                // System.out.println("#1 Height: " + id + " list: " + list);
//                for(Integer index : list)
//                {
//                    if(visited[index])
//                        continue;
//                    // �������
//                    int pos = index + 1;
//                    while(pos < n && height[pos] < height[index])
//                        pos++;
//                    // System.out.println("#2 Height: " + id + " list: " + list + " index: " + index + " pos: " + pos);
//                    if(pos != n)
//                    {
//                        for(int i = index + 1; i < pos; i++)
//                        {
//                            res += id - height[i];
//                            height[i] = id;
//                            visited[i] = true;
//                        }
//                    }
//                    // �������
//                    pos = index - 1;
//                    while(pos >= 0 && height[pos] < height[index])
//                        pos--;
//                    // System.out.println("#2 Height: " + id + " list: " + list + " index: " + index + " pos: " + pos);
//                    if(pos != -1)
//                    {
//                        for(int i = index - 1; i > pos; i--)
//                        {
//                            res += id - height[i];
//                            height[i] = id;
//                            visited[i] = true;
//                        }
//                    }
//                    // System.out.println("#3 res: " + res);
//                }
//            }
//        }
//        return res;
//    }
}
