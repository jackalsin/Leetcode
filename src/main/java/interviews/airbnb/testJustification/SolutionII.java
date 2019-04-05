package interviews.airbnb.testJustification;

import java.util.ArrayList;
import java.util.List;

public final class SolutionII implements Solution {
  @Override
  public List<String> format(final List<String> strs) {
    if (strs == null) {
      throw new NullPointerException();
    }
    final List<String> result = new ArrayList<>();
    final int maxLength = strs.stream().mapToInt(String::length).max().orElse(0);
    final String div = getDiv(maxLength);
    result.add(div);
    for (final String str : strs) {
      result.add(padding(str, maxLength));
      result.add(div);
    }
    if (result.size() == 1) {
      result.add(div);
    }
    return result;
  }

  /**
   * Get the divide line "+-----+"
   *
   * @param dashLength
   * @return
   */
  private static String getDiv(final int dashLength) {
    final StringBuilder sb = new StringBuilder("+");
    for (int i = 0; i < dashLength; i++) {
      sb.append("-");
    }
    sb.append("+");
    return sb.toString();
  }

  private static String padding(final String str, final int max) {
    final StringBuilder sb = new StringBuilder("|").append(str);
    while (sb.length() - 1 < max) {
      sb.append(" ");
    }
    return sb.append('|').toString();
  }

  private static void padding(final StringBuilder sb, final int max) {
    while (sb.length() - 1 < max) {
      sb.append(" ");
    }
  }

  // method for the fixed length
  @Override
  public List<String> format(List<String> strs, int width) {
    if (strs == null) {
      throw new NullPointerException();
    }
    final List<String> result = new ArrayList<>();
    final String div = getDiv(width);
    result.add(div);
    for (final String str : strs) {
      result.addAll(format(str, width));
      result.add(div);
    }
    if (result.size() == 1) {
      return result;
    }
    return result;
  }

  private List<String> format(final String str, final int width) {
    final List<String> result = new ArrayList<>();
    final StringBuilder sb = new StringBuilder("|");
    for (int i = 0; i < str.length(); i++) {
      final int start = i;
      if (str.charAt(i) != ' ') {
        while (i + 1 < str.length() && str.charAt(i + 1) != ' ') {
          i++;
        }
      }
      final String word = str.substring(start, i + 1);
      if (sb.length() - 1 + word.length() > width) { // finish one line
        padding(sb, width);
        result.add(sb.append("|").toString());
        sb.setLength(0);
        sb.append("|").append(word);
      } else {
        sb.append(word);
      }
    }
    if (sb.length() != 1) {
      padding(sb, width);
      result.add(sb.append("|").toString());
    }
    return result;
  }
}
