package interviews.airbnb._006_ZigZag_Conversion;

public class Solution {
  public String convert(String s, int numRows) {
    if (numRows == 1) return s;
    final StringBuilder sb = new StringBuilder();
    final int stepSum = 2 * (numRows - 1);
    for (int start = 0; start < numRows; start++) {
      final int first = stepSum - start * 2, second = start * 2;
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
