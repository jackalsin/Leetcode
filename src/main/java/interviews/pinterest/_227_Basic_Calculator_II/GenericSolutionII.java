package interviews.pinterest._227_Basic_Calculator_II;

/**
 * http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=349668&extra=page%3D2%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3046%5D%5Bvalue%5D%3D33%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311
 */
public final class GenericSolutionII implements Solution {
  private static final int ADD = 1, MINUS = -1, MULTI = 1, DIVIDE = -1;

  /**
   * 109 / 109 test cases passed.
   * Status: Accepted
   * Runtime: 21 ms
   *
   * @param s
   * @return
   */
  public int calculate(String s) {
    int l1 = 0, o1 = ADD, l2 = 1, o2 = MULTI;
    for (int i = 0; i < s.length(); i++) {
      final char chr = s.charAt(i);
      if (Character.isDigit(chr)) {
        int num = chr - '0';
        while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
          num = num * 10 + s.charAt(i + 1) - '0';
          i++;
        }
        l2 = o2 == MULTI ? l2 * num : l2 / num;
      } else if (chr == '+' || chr == '-') {
        l1 += l2 * o1;
        o1 = chr == '+' ? ADD : MINUS;
        l2 = 1;
        o2 = MULTI;

      } else if (chr == '*') {
        o2 = MULTI;
      } else if (chr == '/') {
        o2 = DIVIDE;
      }
    }
    return l1 + l2 * o1;
  }
}
