package ProblemsByType.SlidingWindow;

/*
˼·���������ڣ���������Ҫ��ʱ�����Ҷ�һֱ�������󴰿ڣ�ֱ������Ҫ��ʱ������С�����ô�����˵����ƣ�ֱ���޷���С���ҵ�һ����С���Ǽ�������һ����ȫ����С��ȫ����С��Ҫɨ�������֪����
ʵ�֣�1. ʹ�ó���Ϊ128��int����tCntģ��HashMapͳ��t���ַ����ֵĴ�����ʹ������һ��int����sCntģ�ⴰ����ɨ�赽��t���ַ��ļ�����
2.����ȫ����С����ָ���ÿ��ɨ�����С����ָ�룬����һ���ؼ���cnt��ʾ��ǰ�����ڻ��ж��ٸ��ַ��ļ���������t�е�Ҫ�󣬵�ɨ�������ĳ���ַ�sCnt������tCnt����ͬʱ��cnt��С����ÿ�ó�һ�������е�Ԫ�ص���sCnt < tCntʱ��cnt����
�������� ������ ��+����⻨��5��Сʱ ���ǻ���������һ��
 */
public class No_76_MinimumOverlapSubstring
{
    public String minWindow(String s, String t) {
        int slen = s.length();
        int tlen = t.length();
        if(slen < tlen)
            return "";
        int[] tCnt = new int[128];
        int[] sCnt = new int[128];
        // ����Ҫ����cnt��Ԫ�صļ������ҵ�����
        int cnt = 0;
        int windowl = 0;
        int windowr = 0;
        int resl = 0;
        int resr = slen + 1;
        // ʹ��ASCII����ģ��HashMapͳ��t�и���Ԫ�صļ���
        for(int i = 0; i < tlen; i++)
        {
            Character c = t.charAt(i);
            if(tCnt[c] == 0)
                cnt++;
            tCnt[c]++;
        }
        // �������ڣ���windowr����ֱ����������Ҫ�󣨼�cnt��Ϊ0��
        while(windowr < slen)
        {
            Character c = s.charAt(windowr);
            // ֻ�޸�t���е�Ԫ�صļ�����t��û�е�Ԫ��ֱ������
            if(tCnt[c] == 0)
            {
                windowr++;
                continue;
            }
            // �޸ļ������൱�ڽ�����봰���ұߣ�����windowrһ��Ҫ++����һ�¡��޸ĺ��������t�еļ�������ô˵��������1����ĸ�ļ�����cnt--
            sCnt[c]++;
            if(sCnt[c] == tCnt[c])
                cnt--;
            // ��cnt == 0 ��������t��������ĸ�ļ�����������˵㿪ʼ��С,��ʱwindowrָ�����һ��t�����Ԫ��
            if(cnt == 0)
            {
                // ������˵���С����Ҫ��˵�С���Ҷ˵������Ҷ˵�֮���Ԫ����Ŀ���ڵ���tlen
                while(windowl <= windowr && windowr - windowl + 1 >= tlen)
                {
                    Character cc = s.charAt(windowl);
                    // ֻ�޸�t���е�Ԫ�صļ�����t��û�е�Ԫ��ֱ������
                    if(tCnt[cc] == 0)
                    {
                        windowl++;
                        continue;
                    }
                    // �޸ļ������൱�ڽ����Ƴ�������ߡ��޸ĺ��������С����t�еļ�����˵��������䶪������������һλ������ĸ����Ŀ������t��Ҫ�󣬻��������Ѿ�����������Ҫ���ˣ��´�����Ҫ��Ѱ�ҵ�cnt��Ŀ��һ��
                    sCnt[cc]--;
                    if(sCnt[cc] < tCnt[cc])
                    {
                        cnt++;
                        break;
                    }
                    // ��������޸ļ�����Ӱ�촰������Ҫ����ô�ͼ�����С
                    windowl++;  // sCnt��СwindowlҲ��Ҫ���Ʋ��ܱ���һ��
                }
                // ������˵���С��ɺ�windowlָ������Ҫ�����С���ڵ���˵㣬��λ�õ�sCnt�Ѿ��޸�
                if((windowr - windowl) < (resr - resl))
                {
                    resl = windowl;
                    resr = windowr;
                    // System.out.println("Update result: " + s.substring(resl, resr) + "  windowl: " + windowl + " windowr: " + windowr);
                }
                windowl++;  // sCnt��СwindowlҲ��Ҫ���Ʋ��ܱ���һ�£���Ϊ֮ǰbreak�����˶��Ҹ���res����Ҫʹ��ԭ��ֵ��û�����ƣ��˴��������Ʊ���sCnt��windowl��һ����
            }
            // sCnt�����ˣ������Ҷ˵�������󣬱���һ�£�ֻ����Ϊif(cnt==0)��Ҫʹ�����Էŵ����������
            windowr++;
        }
        return resr == slen + 1 ? "" : s.substring(resl, resr + 1);
    }
}
