package airbnb.testJustification;

import java.util.LinkedList;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 3/7/2019.
 */
public final class LongestLengthSolution {

  public List<String> format(List<String> strs) {
    final LinkedList<String> result = new LinkedList<>();
    int maxLen = 0;
    for (String s : strs) {
      maxLen = Math.max(maxLen, s.length());
    }

    final String div = getDiv(maxLen);

    result.add(div);
    for (String s : strs) {
      result.add(format(s, maxLen));
      result.add(div);
    }

    return result;
  }

  private static String format(final String s, int maxLen) {
    final StringBuilder sb = new StringBuilder("|").append(s);
    while (sb.length() <= maxLen) {
      sb.append(" ");
    }
    return sb.append("|").toString();
  }

  /**
   * +-----------------------+
   *
   * @param maxLen
   * @return
   */
  private static String getDiv(final int maxLen) {
    final StringBuilder sb = new StringBuilder("+");
    for (int i = 0; i < maxLen; i++) {
      sb.append("-");
    }
    sb.append("+");
    return sb.toString();
  }
}
