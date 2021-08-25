package airbnb._227_Basic_Calculator_II;

/**
 * @author zhixi
 * @version 1.0 on 8/24/2021
 */
public final class SolutionII implements Solution {
  @Override
  public int calculate(String s) {
    if (s == null || s.isEmpty()) return 0;
    final char[] chars = s.toCharArray();
    int l1 = 0, o1 = 1, l2 = 1, o2 = 1;
    for (int i = 0; i < chars.length; ++i) {
      final char c = chars[i];
      if (Character.isDigit(c)) {
        int num = c - '0';
        while (i + 1 < chars.length && Character.isDigit(chars[i + 1])) {
          num = num * 10 + (chars[i + 1] - '0');
          ++i;
        }
        l2 = o2 == 1 ? l2 * num : l2 / num;
      } else if (c == '*') {
        o2 = 1;
      } else if (c == '/') {
        o2 = -1;
      } else if (c == '+' || c == '-') {
        l1 += o1 * l2;
        l2 = 1;
        o2 = 1;
        o1 = c == '+' ? 1 : -1;
      } else {
        assert c == ' ';
      }
    }
    return l1 + o1 * l2;
  }
}
