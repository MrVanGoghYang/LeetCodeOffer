package ProblemsByType.Array;

import java.util.*;

/*
思路：将所有包含字母数量及每个字母的计数相同的字符串分为一组，使用字符串的排序结果作为HashMap的Key，注意value可以重复，即单个元素也是自己的字母异位词，还要注意有空串。
 */
public class No_49_GroupAnagrams
{
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        HashMap<String,List<String>> map = new HashMap<>();
        int cnt = 0;
        for(String s : strs)
        {
            char[] item = s.toCharArray();
            Arrays.sort(item);
            String key = String.valueOf(item);
            if(!map.containsKey(key))
            {
                ArrayList<String> addList = new ArrayList<>();
                addList.add(s);
                // 对空串特殊处理
                if(key.equals("") && !map.containsKey("1"))
                    map.put("1", addList);
                else if(key.equals("") && map.containsKey("1"))
                {
                    List<String> cur = map.get("1");
                    cur.add(s);
                }
                // 正常串
                else
                    map.put(key, addList);
            }
            else if(map.containsKey(key))
            {
                List<String> cur = map.get(key);
                cur.add(s);
            }
        }
        for(List<String> list : map.values())
        {
            res.add(new ArrayList<String>(list));
        }
        return res;
    }
}
