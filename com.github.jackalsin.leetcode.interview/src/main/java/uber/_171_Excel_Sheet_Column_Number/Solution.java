package uber._171_Excel_Sheet_Column_Number;

public class Solution {
  private static final int[] CHARS = new int[128];

  static {
    for (int i = 'A'; i <= 'Z'; i++) {
      CHARS[i] = i - 'A' + 1;
    }
  }

  private static final int N = 26;

  public int titleToNumber(String s) {
    int result = 0;
    final char[] chars = s.toCharArray();
    for (int i = 0; i < chars.length; i++) {
      result = result * N + CHARS[chars[i]];
    }
    return result;
  }
}
