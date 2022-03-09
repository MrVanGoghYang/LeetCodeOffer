package ProblemsByType.String;

public class No_415_StringsAdd
{
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int pre = 0;
        int addRes = 0;
        num1 = new StringBuilder(num1).reverse().toString();
        num2 = new StringBuilder(num2).reverse().toString();
        int p = 0; // ¼ÇÂ¼num1É¨ÃèÎ»ÖÃ
        int q = 0; // ¼ÇÂ¼num2É¨ÃèÎ»ÖÃ
        while(p != num1.length() && q != num2.length())
        {
            int sum = (num1.charAt(p) - '0') + (num2.charAt(q) - '0') + pre;
            pre = sum / 10;
            addRes = sum % 10;
            sb.append(addRes);
            p++;
            q++;
        }
        String remain = p == num1.length() ? num2.substring(q, num2.length()) : num1.substring(p, num1.length());
        p = 0;
        while(p != remain.length())
        {
            int sum = remain.charAt(p) - '0' + pre;
            pre = sum / 10;
            addRes = sum % 10;
            sb.append(addRes);
            p++;
        }
        if(pre != 0)
        {
            sb.append(pre);
        }
        return sb.reverse().toString();
    }
}
