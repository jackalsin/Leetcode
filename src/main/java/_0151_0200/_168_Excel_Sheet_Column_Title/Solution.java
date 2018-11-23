package _0151_0200._168_Excel_Sheet_Column_Title;

public class Solution {
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while (n != 0) {
            int order = n % 26;
            int diff = order == 0 ? 25 : (order - 1);
            sb.append((char) ('A' + diff));
            n = (n - diff - 1) / 26;
        }
        return sb.reverse().toString();
    }
}
