package oracle._227_Basic_Calculator_II;

/**
 * @author zhixi
 * @version 1.0 on 11/28/2019
 */
public final class SolutionI implements Solution {
  public int calculate(String s) {
    if (s == null || s.length() == 0) {
      return 0;
    }
    final char[] chars = s.toCharArray();
    int l1 = 0, o1 = 1, l2 = 1, o2 = 1;
    for (int i = 0; i < chars.length; i++) {
      final char chr = chars[i];
      if (chr == ' ') continue;
      if (Character.isDigit(chr)) {
        int num = chr - '0';
        while (i + 1 < chars.length && Character.isDigit(chars[i + 1])) {
          num = num * 10 + chars[i + 1] - '0';
          i++;
        }
        l2 = o2 == 1 ? l2 * num : l2 / num;
      } else if (chr == '+' || chr == '-') {
        l1 += o1 * l2;
        o1 = chr == '+' ? 1 : -1;
        l2 = 1;
        o2 = 1;
      } else if (chr == '*') {
        o2 = 1;
      } else if (chr == '/') {
        o2 = -1;
      }
    }
    return l1 + o1 * l2;
  }
}
