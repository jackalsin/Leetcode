package linkedin._068_Text_Justification;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 10/2/2019
 */
public final class SolutionV implements Solution {
  @Override
  public List<String> fullJustify(String[] words, int maxWidth) {
    final List<String> result = new ArrayList<>();
    final List<String> curLine = new ArrayList<>() {{
      add(words[0]);
    }};
    int len = words[0].length();
    for (int i = 1; i < words.length; i++) {
      final String word = words[i];
      if (len + word.length() + 1 > maxWidth) {
        result.add(padding(curLine, maxWidth));

        len = word.length();
        curLine.clear();
        curLine.add(word);
      } else {
        len += word.length() + 1;
        curLine.add(word);
      }
    }
    if (!curLine.isEmpty()) {
      result.add(pendingToEnd(curLine, maxWidth));
    }
    return result;
  }

  private static String padding(final List<String> curLine, final int maxWidth) {
    int len = curLine.stream().mapToInt(String::length).sum(), spaces = maxWidth - len,
        size = curLine.size();
    if (size == 1) return pendingToEnd(curLine, maxWidth);
    final int smallSpace = spaces / (size - 1), bigSpace = smallSpace + 1,
        bigSpaceCount = spaces % (size - 1), smallSpaceCount = size - 1 - bigSpaceCount;
    final StringBuilder sb = new StringBuilder().append(curLine.get(0));
    for (int i = 0; i < bigSpaceCount; ++i) {
      sb.append(" ".repeat(bigSpace)).append(curLine.get(i + 1));
    }
    for (int j = 0; j < smallSpaceCount; ++j) {
      sb.append(" ".repeat(smallSpace)).append(curLine.get(j + 1 + bigSpaceCount));
    }
    return sb.toString();
  }

  private static String pendingToEnd(final List<String> line, final int maxWidth) {
    final StringBuilder sb = new StringBuilder().append(line.get(0));
    for (int i = 1; i < line.size(); ++i) {
      sb.append(" ").append(line.get(i));
    }
    while (sb.length() < maxWidth) sb.append(" ");
    return sb.toString();
  }
}
