package airbnb._068_Text_Justification;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhixi
 * @version 1.0 on 8/18/2021
 */
public final class SolutionII implements Solution {
  @Override
  public List<String> fullJustify(String[] words, int maxWidth) {
    final List<String> result = new ArrayList<>();
    if (words == null || words.length == 0) return result;
    final List<String> line = new ArrayList<>() {{
      add(words[0]);
    }};
    int lineLen = words[0].length();
    for (int i = 1; i < words.length; ++i) {
      if (1 + lineLen + words[i].length() <= maxWidth) {
        lineLen += 1 + words[i].length();
        line.add(words[i]);
      } else {
        result.add(getLine(line, maxWidth));
        line.clear();
        line.add(words[i]);
        lineLen = words[i].length();
      }
    }
    if (!line.isEmpty()) {
      result.add(getLastLine(line, maxWidth));
    }
    return result;
  }

  private static String getLine(final List<String> line, final int maxWidth) {
    final StringBuilder sb = new StringBuilder().append(line.get(0));
    if (line.size() == 1) {
      padToEnd(sb, maxWidth);
      return sb.toString();
    }
    final int wordLen = line.stream().mapToInt(String::length).sum(),
        totalSpace = maxWidth - wordLen, smallSpaceNum = totalSpace / (line.size() - 1),
        bigSpaceNum = smallSpaceNum + 1, bigSpaceCount = totalSpace % (line.size() - 1),
        smallSpaceCount = line.size() - 1 - bigSpaceCount;
    for (int i = 0; i < bigSpaceCount; ++i) {
      pad(sb, bigSpaceNum);
      sb.append(line.get(i + 1));
    }

    for (int i = bigSpaceCount + 1, j = 0; j < smallSpaceCount; ++j, ++i) {
      pad(sb, smallSpaceNum);
      sb.append(line.get(i));
    }
    return sb.toString();
  }

  private static String getLastLine(final List<String> line, final int maxWidth) {
    final StringBuilder sb = new StringBuilder(line.get(0));
    for (int i = 1; i < line.size(); ++i) {
      sb.append(" ").append(line.get(i));
    }
    padToEnd(sb, maxWidth);
    return sb.toString();
  }

  private static void pad(final StringBuilder sb, final int pad) {
    for (int i = 0; i < pad; ++i) sb.append(" ");
  }

  private static void padToEnd(final StringBuilder sb, final int maxWidth) {
    while (sb.length() < maxWidth) sb.append(" ");
  }
}
