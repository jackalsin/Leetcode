package airbnb._006_ZigZag_Conversion;

/**
 * @author jacka
 * @version 1.0 on 8/15/2021
 */
public final class SolutionI implements Solution {
  @Override
  public String convert(String s, int numRows) {
    if (s == null || s.isEmpty() || numRows == 1) return s;
    final StringBuilder sb = new StringBuilder();
    final int stepSum = numRows * 2 - 2;
    for (int start = 0; start < numRows; ++start) {
      final int first = stepSum - 2 * start, second = 2 * start;
      int i = start;
      while (i < s.length()) {
        if (first != 0) {
          sb.append(s.charAt(i));
          i += first;
        }
        if (i < s.length() && second != 0) {
          sb.append(s.charAt(i));
          i += second;
        }
      }
    }
    return sb.toString();
  }
}
