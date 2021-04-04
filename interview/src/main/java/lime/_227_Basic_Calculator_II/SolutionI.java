package lime._227_Basic_Calculator_II;

/**
 * @author jacka
 * @version 1.0 on 4/4/2021
 */
public final class SolutionI implements Solution {

  public int calculate(String s) {
    int l1 = 0, o1 = 1, l2 = 1, o2 = 1;
    final int n = s.length();
    for (int i = 0; i < n; ++i) {
      final char chr = s.charAt(i);
      if (Character.isDigit(chr)) {
        int num = chr - '0';
        while (i + 1 < n && Character.isDigit(s.charAt(i + 1))) {
          num = num * 10 + s.charAt(i + 1) - '0';
          ++i;
        }
        l2 = o2 == 1 ? l2 * num : l2 / num;
        o2 = 1;
      } else if (chr == '+' || chr == '-') {
        l1 = l1 + o1 * l2;
        o1 = chr == '+' ? 1 : -1;
        l2 = 1;
        o2 = 1;
      } else if (chr == '*') {
        o2 = 1;
      } else if (chr == '/') {
        o2 = -1;
      }
    } // end of for
    return l1 + o1 * l2;
  }
}
