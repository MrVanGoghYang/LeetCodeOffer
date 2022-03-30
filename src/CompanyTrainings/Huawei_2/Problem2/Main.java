package CompanyTrainings.Huawei_2.Problem2;
import java.util.*;
public class Main
{
    public static void main(String[] args) {
        HashMap<String, Integer> map = new LinkedHashMap<>(); // LinkedHashMap保持放入顺序很关键
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext())
        {
            String str = sc.nextLine();
            if(str.equals("#"))
                break;
            int fileNameBegin = str.length() - 1;
            for(int i = str.length() - 1; i >= 0; i--)
            {
                if(str.charAt(i) == '\\')
                {
                    fileNameBegin = i + 1;
                    break;
                }
            }
            String filename = str.substring(fileNameBegin);
            if(!map.containsKey(filename))
                map.put(filename, 1);
            else
                map.put(filename, map.get(filename) + 1);
//            System.out.println();
        }
        List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>()
        {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2)
            {
                int value1 = o1.getValue();
                int value2 = o2.getValue();
                if(value1 != value2)
                {
                    return o2.getValue() - o1.getValue();
                }
                return 0; // 出现次数相同时，判断不交换其顺序，此处返回1，不知道为啥
            }
        });
        int outputNum = Math.min(list.size(), 8);
        for(int i = 0; i < outputNum; i++)
        {
            String[] output = list.get(i).getKey().split(" ");
            String file = output[0];
            if(file.length() > 16)
                file = file.substring(file.length() - 16);
            System.out.println(file + " " + output[1] + " " + list.get(i).getValue());
        }
    }
}