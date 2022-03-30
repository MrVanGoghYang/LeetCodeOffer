package CompanyExams.NetEaseGameExams.Problem2;

import java.util.*;
public class Main {
    private static boolean isSameCateFive = true;
    private static boolean isContinueFive = true;
    private static int[][] sameNumberMap = new int[5][2];
    private static Set<Integer> sameNumberSet = new HashSet<>();
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int caseNum = in.nextInt();
        for(int caseIndex = 0; caseIndex < caseNum; caseIndex++)
        {
            int N = in.nextInt();
            int[][] pointsAndCates = new int[N][2];
            for(int i = 0; i < N; i++)
                pointsAndCates[i][0] = in.nextInt();
            in.nextLine();
            String[] parseCates = in.nextLine().split(" ");
            for(int i = 0; i < N; i++)
                pointsAndCates[i][1] = parseCates[i].charAt(0) - 'A';

            Arrays.sort(pointsAndCates, new Comparator<int[]>()
            {
                @Override
                public int compare(int[] o1, int[] o2)
                {
                    return o1[0] - o2[0];
                }
            });
            isSameCateFive = true;
            isContinueFive = true;
            for(int i = 0; i < 5; i++)
            {
                sameNumberMap[i][0] = 0;
                sameNumberMap[i][1] = 0;
            }
            sameNumberSet.clear();
            for(int i = 0; i < N; i++)
            {
                if(N == 5 && isSameCateFive && i > 0)
                    isSameCateFive = pointsAndCates[i][1] == pointsAndCates[i - 1][1];
                if(N == 5 && isContinueFive && i > 0)
                    isContinueFive = pointsAndCates[i][0] == pointsAndCates[i - 1][0] + 1;

                if(!sameNumberSet.contains(pointsAndCates[i][0]))
                {
                    sameNumberMap[sameNumberSet.size()][0] = pointsAndCates[i][0];
                    sameNumberMap[sameNumberSet.size()][1] = 1;
                    sameNumberSet.add(pointsAndCates[i][0]);
                }
                else
                {
                    for(int k = 0; k < 5; k++)
                    {
                        if(sameNumberMap[k][0] == pointsAndCates[i][0])
                            sameNumberMap[k][1]++;
                    }
                }
            }
            System.out.print(cal(N, pointsAndCates));
            if(caseIndex != caseNum - 1) System.out.println();
        }
    }

    public static int cal(int N, int[][] arr)
    {
        int res = 1;
        // 计算相同数字的倍数
        if(sameNumberSet.size() < N)
        {
            if (N == 5)
            {
                if (sameNumberSet.size() == 1) res = 15000;
                else
                    if (sameNumberSet.size() == 2 && (sameNumberMap[0][1] == 4 || sameNumberMap[1][1] == 4)) res = 150;
                    else
                        if (sameNumberSet.size() == 2 && (sameNumberMap[0][1] == 3 || sameNumberMap[1][1] == 3)) res = 40;
                        else
                            if (sameNumberSet.size() == 3 && (sameNumberMap[0][1] == 3 || sameNumberMap[1][1] == 3 || sameNumberMap[2][1] == 3))
                                res = 6;
                            else
                                if (sameNumberSet.size() == 3 && (sameNumberMap[0][1] == 2 || sameNumberMap[1][1] == 2 || sameNumberMap[2][1] == 2))
                                    res = 4;
                                else
                                    if (sameNumberSet.size() == 4 && (sameNumberMap[0][1] == 2 || sameNumberMap[1][1] == 2 || sameNumberMap[2][1] == 2 || sameNumberMap[3][1] == 2))
                                        res = 2;
            }
            else
                if (N == 4)
                {
                    if (sameNumberSet.size() == 1) res = 150;
                    else
                        if (sameNumberSet.size() == 2 && (sameNumberMap[0][1] == 3 || sameNumberMap[1][1] == 3)) res = 6;
                        else
                            if (sameNumberSet.size() == 2 && (sameNumberMap[0][1] == 2 && sameNumberMap[1][1] == 2)) res = 4;
                            else
                                if (sameNumberSet.size() == 3 && (sameNumberMap[0][1] == 2 || sameNumberMap[1][1] == 2 || sameNumberMap[2][1] == 2))
                                    res = 2;
                }
                else
                    if (N == 3)
                    {
                        if (sameNumberSet.size() == 1) res = 6;
                        else
                            if (sameNumberSet.size() == 2 && (sameNumberMap[0][1] == 2 || sameNumberMap[1][1] == 2)) res = 2;
                    }
                    else
                        if (N == 2)
                        {
                            if (sameNumberSet.size() == 1) res = 2;
                        }
        }
        // 计算连续数字的倍数 和 相同花色的倍数
        if(N == 5)
        {
            if(isSameCateFive && isContinueFive)
                res = Math.max(res, 8000);
            else if(isSameCateFive)
                res = Math.max(res, 300);
            else if(isContinueFive)
                res = Math.max(res, 20);
        }
        return res;
    }
}