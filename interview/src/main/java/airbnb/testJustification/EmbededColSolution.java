package airbnb.testJustification;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 3/9/2019.
 */
public final class EmbededColSolution {

  /**
   * 题意不清，没法写
   *
   * @param strs
   * @return
   */
  public List<String> format(final List<List<Col>> strs) {
    if (strs == null) {
      throw new NullPointerException();
    }
    final int width = getMaxLineWidth(strs);
    final List<String> result = new ArrayList<>();
    if (strs.size() == 0) {
      return result;
    }

    List<Col> prevStr = new ArrayList<>(), curStr = strs.get(0);
    result.add(getDiv(prevStr, curStr, width));
    for (final List<Col> str : strs) {
      final List<String> curLine = formatLine(str, width);

      // add div
      prevStr = curStr;
      curStr = str;
      result.add(getDiv(prevStr, curStr, width));
    }

    return result;
  }


  private static List<String> formatLine(final List<Col> str, final int width) {
    return null;
  }

  private static String getDiv(final List<Col> prev, final List<Col> cur, final int width) {
    final char[] chars = new char[width + 2];
    Arrays.fill(chars, '-');
    chars[0] = chars[width + 2 - 1] = '+';
    for (final Col e : prev) {
      chars[e.width + 1] = '+';
    }
    for (final Col e : cur) {
      chars[e.width + 1] = '+';
    }
    return String.valueOf(chars);
  }

  // Method to get max line width
  private static int getMaxLineWidth(final List<List<Col>> strs) {
    int max = 0;
    for (final List<Col> s : strs) {
      max = Math.max(getWidth(s), max);
    }
    return max;
  }

  private static int getWidth(final List<Col> l1) {
    return l1.stream().map(e -> e.width).reduce((x, y) -> x + y).orElse(0);
  }
}
