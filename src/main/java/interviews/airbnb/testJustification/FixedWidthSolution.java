package interviews.airbnb.testJustification;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 3/7/2019.
 */
public final class FixedWidthSolution {
  public List<String> format(List<String> strs, final int width) {
    final LinkedList<String> result = new LinkedList<>();
    final String div = getDiv(width);
    result.add(div);
    for (String s : strs) {
      result.addAll(format(s, width));
      result.add(div);
    }
    return result;
  }

  private static List<String> format(final String s, int width) {
    final StringBuilder line = new StringBuilder("|");
    final List<String> result = new ArrayList<>();
    int preStart = 0;
    for (int i = 0; i < s.length() - 1; i++) {
      if (s.charAt(i + 1) == ' ' || i == s.length()) {
        final String word = s.substring(preStart, i);
        if (line.length() + word.length() >= width) {
          padding(line, width + 1);
          result.add(line.append("|").toString());
          line.setLength(0);
          line.append("|").append(word).append(" ");
        } else {
          line.append(word).append(" ");
        }
        preStart = i + 1;
      }
    }

    if (preStart != s.length()) {
      line.append(s.substring(preStart));
      padding(line, width);
      result.add(line.append("|").toString());
    }
    return result;
  }

  private static void padding(StringBuilder sb, final int width) {
    while (sb.length() <= width) {
      sb.append(" ");
    }
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
