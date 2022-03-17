package ProblemsByType.Array;

import java.util.*;

/*
˼·�������а�����ĸ������ÿ����ĸ�ļ�����ͬ���ַ�����Ϊһ�飬ʹ���ַ�������������ΪHashMap��Key��ע��value�����ظ���������Ԫ��Ҳ���Լ�����ĸ��λ�ʣ���Ҫע���пմ���
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
                // �Կմ����⴦��
                if(key.equals("") && !map.containsKey("1"))
                    map.put("1", addList);
                else if(key.equals("") && map.containsKey("1"))
                {
                    List<String> cur = map.get("1");
                    cur.add(s);
                }
                // ������
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
