package microsoft._171_Excel_Sheet_Column_Number;

public class Solution {
  private static final char BASE = 'A';

  public int titleToNumber(String s) {
    int res = 0;
    for (char chr : s.toCharArray()) {
      res = res * 26 + (chr - BASE + 1);
    }
    return res;
  }
}
