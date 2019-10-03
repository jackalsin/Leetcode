package interviews.linkedin._068_Text_Justification;

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
    if (words == null || words.length == 0 || maxWidth < 0) {
      return result;
    }

    final List<String> curLine = new ArrayList<>();
    curLine.add(words[0]);
    int curLineLen = words[0].length();
    for (int i = 1; i < words.length; ++i) {
      final String curWord = words[i];
      if (curLineLen + 1 + curWord.length() <= maxWidth) {
        curLine.add(curWord);
        curLineLen += (1 + curWord.length());
      } else {
        result.add(getLine(curLine, maxWidth));
        curLine.clear();
        curLineLen = curWord.length();
        curLine.add(curWord);
      }
    }
    if (!curLine.isEmpty()) {
      result.add(getLastLine(curLine, maxWidth));
    }
    return result;
  }

  private static String getLastLine(final List<String> curLine, final int len) {
    final StringBuilder sb = new StringBuilder();
    for (String str : curLine) {
      sb.append(' ').append(str);
    }
    fillTo(sb, len + 1);
    return sb.substring(1);
  }

  private static String getLine(final List<String> curLine, final int maxWidth) {
    final StringBuilder sb = new StringBuilder();
    if (curLine.size() == 1) {
      sb.append(curLine.get(0));
      fillTo(sb, maxWidth);
      return sb.toString();
    }
    final int totalLen = getLen(curLine), intervalCount = curLine.size() - 1,
        smallSpaceLen = (maxWidth - totalLen) / intervalCount,
        bigSpaceLen = smallSpaceLen + 1,
        bigSpaceCount = (maxWidth - totalLen) % intervalCount;
    sb.append(curLine.get(0));
    for (int i = 0; i < bigSpaceCount; ++i) {
      append(sb, bigSpaceLen);
      sb.append(curLine.get(i + 1));
    }
    for (int i = bigSpaceCount + 1; i < curLine.size(); ++i) {
      append(sb, smallSpaceLen);
      sb.append(curLine.get(i));
    }
    return sb.toString();
  }

  private static void fillTo(final StringBuilder sb, int maxWidth) {
    while (sb.length() < maxWidth) {
      sb.append(" ");
    }
  }

  private static void append(final StringBuilder sb, final int count) {
    for (int i = 0; i < count; ++i) {
      sb.append(" ");
    }
  }

  private static int getLen(final List<String> curLine) {
    int c = 0;
    for (String cur : curLine) {
      c += cur.length();
    }
    return c;
  }


}
