package CompanyExams.HuaweiExams.Problem1;

import java.util.*;

public class Main {
    static class Word
    {
        String str;
        int score;
        int asTitleCnt;
        Word(String str, int score, int asTitleCnt)
        {
            this.str = str;
            this.score = score;
            this.asTitleCnt = asTitleCnt;
        }
    }
    public static void main(String[] args) {
        // please define the JAVA input here. For example: Scanner s = new Scanner(System.in);
        // please finish the function body here.
        // please define the JAVA output here. For example: System.out.println(s.nextInt());
        Scanner sc = new Scanner(System.in);
        int topN = sc.nextInt();
        int M = sc.nextInt();
        sc.nextLine();
        List<Word> list = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < M; i++)
        {
            String[] title = sc.nextLine().split(" ");
            for(int j = 0; j < title.length; j++)
            {
                if(!map.containsKey(title[j]))
                {
                    map.put(title[j], list.size());
                    list.add(new Word(title[j], 3, 1));
                }
                else
                {
                    int index = map.get(title[j]);
                    list.get(index).asTitleCnt += 1;
                    list.get(index).score += 3;
                }
            }
            String[] text = sc.nextLine().split(" ");
            for(int j = 0; j < text.length; j++)
            {
                if(!map.containsKey(text[j]))
                {
                    map.put(text[j], list.size());
                    list.add(new Word(text[j], 1, 0));
                }
                else
                {
                    int index = map.get(text[j]);
                    list.get(index).score += 1;
                }
            }
        }
        Collections.sort(list, new Comparator<Word>()
        {
            @Override
            public int compare(Word o1, Word o2)
            {
                if(o1.score != o2.score)
                    return o2.score - o1.score;
                else
                    return o2.asTitleCnt - o1.asTitleCnt;
            }
        });
        for(int i = 0; i < topN; i++)
        {
            System.out.print(list.get(i).str);
            if(i != topN - 1)
                System.out.print(" ");
        }
    }
}