package airbnb._038_Count_and_Say;

/**
 * @author jacka
 * @version 1.0 on 1/22/2019.
 */
public class Solution {
  public String countAndSay(int n) {
    return countAndSay(n, "1");
  }

  private String countAndSay(final int remain, final String cur) {
    if (remain == 1) {
      return cur;
    }
    final StringBuilder sb = new StringBuilder();

    for (int end = 0; end < cur.length(); end++) {
      final int start = end;
      while (end + 1 < cur.length() && cur.charAt(end + 1) == cur.charAt(end)) {
        end++;
      }
      sb.append(end - start + 1).append(cur.charAt(start));
    }
    return countAndSay(remain - 1, sb.toString());
  }

}
