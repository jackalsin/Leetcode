package uber.codeSignal.stringInterleaving;

/**
 * @author jacka
 * @version 1.0 on 4/17/2021
 */
public class SolutionI implements Solution {
  @Override
  public String getInterval(String a, String b) {
    if (a == null) {
      return b;
    }
    if (b == null) return a;
    final StringBuilder sb = new StringBuilder();
    for (int i = 0, j = 0; i < a.length() || j < b.length(); ++i, ++j) {
      if (i < a.length()) {
        sb.append(a.charAt(i));
      }
      if (j < b.length()) {
        sb.append(b.charAt(j));
      }
    }
    return sb.toString();
  }
}
