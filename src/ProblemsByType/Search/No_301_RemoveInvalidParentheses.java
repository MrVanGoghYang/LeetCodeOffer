package ProblemsByType.Search;

import java.util.*;

public class No_301_RemoveInvalidParentheses
{
    // BFS�ö��б��ѳ�ʱ����Ϊ������һ�����Ԫ��ʱ������ܶ��ظ��ַ��������һ����ȫ��Ӿͻ���ɶ���Ԫ��̫�೬ʱ���˴�ʹ����һ��curSetȡ���� ���к�queue.size()����ÿ��Ԫ�ص����ã���ʹ����һ��nextSet�������ɵ���һ��Ԫ�ز���ȥ�ء�������ȥ�غ���Ҫ
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
    //     while(!queue.isEmpty() && minDel == -1){    // whileѭ��һ����BFS��һ��  �൱�ڶ�ɾ��һ���ַ�
    //         int size = queue.size();
    //         // ��¼��һ���ж��ٸ�Ԫ���ڶ����У�����һ��Ԫ��
    //         for(int j = 0; j < size; j++){
    //             // System.out.println(delCnt);
    //             // System.out.println(queue.toString());
    //             String top = queue.poll();
    //             if(isValid(top)){
    //                 res.add(top);
    //                 if(minDel == -1)
    //                     minDel = delCnt;
    //             }
    //             // �����ǰ��δ�ҵ���Сɾ����������ǰȡ���������ߵ���һ�㣨����ɾ��һ���ַ���
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
    //     // ���췵�ؽ��
    //     List<String> ret = new ArrayList<>();
    //     for(String str : res)
    //         ret.add(str);
    //     return ret;
    // }
}
