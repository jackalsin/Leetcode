package _0151_0200._171_Excel_Sheet_Column_Number;

public class Solution {
    public int titleToNumber(String s) {
        if (s == null) {
            return 0;
        }
        int sum = 0;
        for (char ch : s.toCharArray()) {
            sum = sum * 26 + (ch - 'A' + 1);
        }
        return sum;
    }
}
