package _0201_0250._248_Strobogrammatic_Number_III;

/**
 * @author jacka
 * @version 1.0 on 8/23/2017.
 */
public class Solution {
  private static final char[][] chars = new char[][] {
      {'0', '0'}, {'1', '1'},{'8', '8'},{'6', '9'}, {'9', '6'}
  };

  private int count = 0;

  /**
   *
   * @param low   inclusive
   * @param high  inclusive
   * @return
   */
  public int strobogrammaticInRange(String low, String high) {
    for (int i = low.length(); i <= high.length(); ++i) {
      char[] c = new char[i];
      dfs(low, high, c, 0, i - 1);
    }
    return count;
  }

  private void dfs(String low, String high, char[] c, int start, int end) {
    if (start > end) {
      String s = new String(c);
      if ((low.length() == s.length() && s.compareTo(low) < 0) ||
          (high.length() == s.length() && s.compareTo(high) > 0)) return;
      count++;
    } else {
      for(char[] pair : chars) {
        if (start == end && pair[0] != pair[1]) continue;
        if (c.length != 1 && start == 0 && pair[0] == '0') continue;
        c[start] = pair[0];
        c[end] = pair[1];
        dfs(low, high, c, start + 1, end - 1);
      }
    }
  }

}
