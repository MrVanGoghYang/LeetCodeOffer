package ProblemsByType.Stack;

import java.util.*;

// 思路一、二为按行填充的基本做法和优化做法
public class No_43_TrappingRainWater
{
    /*
    思路二：利用某个位置往右一直扫描，如果墙的高度一直递减或不增，那么这些墙之间都不能放入雨水。直到遇到非递减高度的第一堵墙，可以放入雨水。
    实现：单调栈，存储单调递减或不增的墙高度，遇到更高的一堵墙则一直出栈计算新栈顶与该堵更高的墙中间能放的水。出栈结束后再放入该元素。时间复杂度为O(n)，每个位置最多一次入栈+一次出栈。
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
    思路一： 按行填充空格，计算填充数目，比较麻烦时间复杂度为O(n^2)
     */
//    public int trap(int[] height) {
//        // 首先统计每个高度出现的下标，高度按从大到小排列，每个高度出现的下标按从小到大排列
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
//        // 然后从高度从高到低取出每个高度对应的下标List，从该高度的每个位置，尝试向右及向左填充缺失的空格块并计算填充的格子数量即res，填充过的就记录下visited为true，后续扫描到该位置就不需要继续扫描。
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
//                    // 往右填充
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
//                    // 往左填充
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
