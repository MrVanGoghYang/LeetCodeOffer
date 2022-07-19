package ProblemsByType.Search;

import java.util.*;

public class No_301_RemoveInvalidParentheses
{
    // BFS用队列爆搜超时，因为生成下一层入队元素时会产生很多重复字符串，如果一股脑全入队就会造成队列元素太多超时。此处使用了一个curSet取代了 队列和queue.size()控制每层元素的作用；而使用另一个nextSet保存生成的下一层元素并“去重”！！！去重很重要
    public List<String> removeInvalidParentheses(String s) {
        Set<String> res = new HashSet<>();
        Set<String> curSet = new HashSet<>();
        curSet.add(s);
        while(!curSet.isEmpty()){
            for(String str : curSet){
                if(isValid(str)){
                    res.add(str);
                }
            }
            if(res.size() > 0)
                break;
            Set<String> nextSet = new HashSet<>();
            for(String top : curSet){
                StringBuilder sb = new StringBuilder(top);
                for(int i = 0; i < top.length(); i++){
                    char c = sb.charAt(i);
                    if(c == '(' || c == ')' ){
                        sb.deleteCharAt(i);
                        nextSet.add(sb.toString());
                        sb.insert(i, c);
                    }
                }
            }
            curSet = nextSet;
        }
        return new ArrayList<>(res);
    }

    public boolean isValid(String s){
        int leftCnt = 0;
        int rightCnt = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '(')
                leftCnt++;
            else if(s.charAt(i) == ')')
                rightCnt++;
            if(rightCnt > leftCnt)
                return false;
        }
        if(leftCnt != rightCnt)
            return false;
        return true;
    }


    // public List<String> removeInvalidParentheses(String s) {
    //     Set<String> res = new HashSet<>();
    //     int minDel = -1;
    //     Queue<String> queue = new ArrayDeque<>();
    //     queue.offer(s);
    //     int delCnt = 0;
    //     while(!queue.isEmpty() && minDel == -1){    // while循环一层则BFS走一步  相当于多删除一个字符
    //         int size = queue.size();
    //         // 记录上一层有多少个元素在队列中，处理一层元素
    //         for(int j = 0; j < size; j++){
    //             // System.out.println(delCnt);
    //             // System.out.println(queue.toString());
    //             String top = queue.poll();
    //             if(isValid(top)){
    //                 res.add(top);
    //                 if(minDel == -1)
    //                     minDel = delCnt;
    //             }
    //             // 如果当前还未找到最小删除数量，则当前取出结点可以走到下一层（即再删除一个字符）
    //             if(minDel == -1){
    //                 StringBuilder sb = new StringBuilder(top);
    //                 for(int i = 0; i < top.length(); i++){
    //                     char c = sb.charAt(i);
    //                     if(c == '(' || c == ')' ){
    //                         sb.deleteCharAt(i);
    //                         queue.offer(sb.toString());
    //                         sb.insert(i, c);
    //                     }
    //                 }
    //             }
    //         }
    //         delCnt++;
    //     }
    //     // 构造返回结果
    //     List<String> ret = new ArrayList<>();
    //     for(String str : res)
    //         ret.add(str);
    //     return ret;
    // }
}
