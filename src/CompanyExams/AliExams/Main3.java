package CompanyExams.AliExams;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main3
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int opeCnt = sc.nextInt();
        sc.nextLine();
        Map<String, String> map = new HashMap<>();
        Map<String, Integer> datemap = new HashMap<>();

        for(int i = 0; i < opeCnt; i++)
        {
            String[] command = sc.nextLine().split(" ");
            if(command.length >= 4 && !valid(Integer.parseInt(command[1]), Integer.parseInt(command[2]), Integer.parseInt(command[3])))
            {
                System.out.println("error");
            }
            else
            {
                // insert
                if(command.length == 5)
                {
                    String key = command[4];
                    if(map.containsKey(key))
                    {
                        System.out.println("existed");
                    }
                    else
                    {
                        StringBuilder value = new StringBuilder();
                        value.append(command[1]);
                        value.append('/');
                        if(command[2].length() < 2)
                            value.append('0');
                        value.append(command[2]);
                        value.append('/');
                        if(command[3].length() < 2)
                            value.append('0');
                        value.append(command[3]);

                        map.put(key, value.toString());
                        System.out.println("done");

                        int cnt = datemap.getOrDefault(value.toString(), 0);
                        datemap.put(value.toString(), cnt + 1);
                    }
                }
                // getcount
                else if(command.length == 4)
                {
                    StringBuilder value = new StringBuilder();
                    value.append(command[1]);
                    value.append('/');
                    if(command[2].length() < 2)
                        value.append('0');
                    value.append(command[2]);
                    value.append('/');
                    if(command[3].length() < 2)
                        value.append('0');
                    value.append(command[3]);

                    System.out.println(datemap.getOrDefault(value.toString(), 0));
                }
                // getdate
                else if(command.length == 2)
                {
                    if(!map.containsKey(command[1]))
                        System.out.println("not existed");
                    else System.out.println(map.get(command[1]));
                }
            }
        }
    }

    public static boolean valid(int year, int month, int day)
    {
        if(year >= 2022 && year <= 9999)
        {
            if(month >= 1 && month <= 12)
            {
                if(month == 2)
                {
                    boolean rui = isrui(year);
                    if(rui)
                        return day >= 1 && day <= 29;
                    else
                        return day >= 1 && day <= 28;
                }
                else if((month <= 7 && month % 2 == 1) || (month >= 8 && month % 2 == 0))
                {
                    return day >= 1 && day <= 31;
                }
                else
                {
                    return day >= 1 && day <= 30;
                }
            }
        }
        return false;
    }

    public static boolean isrui(int year)
    {
        if(year % 400 == 0 || (year % 4 == 0 && year % 100 != 0))
            return true;
        return false;
    }
}
