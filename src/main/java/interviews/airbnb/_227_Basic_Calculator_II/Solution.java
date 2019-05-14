package interviews.airbnb._227_Basic_Calculator_II;

/**
 * @author jacka
 * @version 1.0 on 1/31/2019.
 */
public final class Solution {
  public int calculate(String s) {
    if (s == null || s.isEmpty()) {
      return 0;
    }
    int l1 = 0, o1 = 1, l2 = 1, o2 = 1;
    for (int i = 0; i < s.length(); i++) {
      final char chr = s.charAt(i);
      if (Character.isDigit(chr)) {
        int num = chr - '0';
        while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
          num = num * 10 + s.charAt(i + 1) - '0';
          i++;
        }
        l2 = o2 == 1 ? (l2 * num) : (l2 / num);
      } else if (chr == '+') {
        l1 = l1 + o1 * l2;
        l2 = 1;
        o2 = 1;
        o1 = 1;
      } else if (chr == '-') {
        l1 = l1 + o1 * l2;
        l2 = 1;
        o2 = 1;
        o1 = -1;
      } else if (chr == '*') {
        o2 = 1;
      } else if (chr == '/') {
        o2 = -1;
      }
    }
    return l1 + o1 * l2;
  }
}
