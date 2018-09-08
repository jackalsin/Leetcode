package interviews.linkedin._068_Text_Justification;

import java.util.ArrayList;
import java.util.List;

public final class SolutionIII implements Solution {
  @Override
  public List<String> fullJustify(String[] words, int maxWidth) {
    final List<String> result = new ArrayList<>(), curLine = new ArrayList<>();
    curLine.add(words[0]);
    int curLineChars = words[0].length();
    for (int i = 1; i < words.length; i++) {
      String word = words[i];
      if (i == words.length - 1 && curLineChars + 1 + word.length() == maxWidth) {
        curLine.add(word);
        result.add(paddingLastLine(curLine, maxWidth));
        curLine.clear();
        // invalid
      } else if (curLineChars + 1 + word.length() > maxWidth) {
        result.add(paddingToWidth(maxWidth, curLine));
        curLine.clear();
        curLine.add(word);
        curLineChars = word.length();
      } else {
        curLine.add(word);
        curLineChars += 1 + word.length();
      }
    }
    if (!curLine.isEmpty()) {
      result.add(paddingLastLine(curLine, maxWidth));
    }
    return result;
  }

  private static String paddingLastLine(final List<String> curLine, final int width) {
    final StringBuilder sb = new StringBuilder();
    sb.append(curLine.get(0));
    for (int i = 1; i < curLine.size(); ++i) {
      sb.append(" ").append(curLine.get(i));
    }
    appendSpace(sb, width);
    return sb.toString();
  }

  static String paddingToWidth(final int width, final List<String> curLine) {
    assert curLine.size() != 0;
    if (curLine.size() == 1) {
      final String word = curLine.get(0);
      return appendSpace(new StringBuilder().append(word), width);
    }
    int sum = 0;
    for (String word : curLine) {
      sum += word.length();
    }
    final int smallSpace = (width - sum) / (curLine.size() - 1), bigSpace = smallSpace + 1;
    int bigSpaceCount = (width - sum) % (curLine.size() - 1), smallSpaceCount = curLine.size() - 1 - bigSpaceCount;
    final StringBuilder sb = new StringBuilder().append(curLine.get(0));
    for (int i = 1; i < curLine.size(); ++i) {
      if (bigSpaceCount > 0) {
        bigSpaceCount--;
        repeatSpace(sb, bigSpace);
      } else if (smallSpaceCount > 0) {
        smallSpaceCount--;
        repeatSpace(sb, smallSpace);
      }
      sb.append(curLine.get(i));
    }
    return sb.toString();
  }

  private static void repeatSpace(final StringBuilder sb, final int num) {
    for (int i = 0; i < num; ++i) {
      sb.append(" ");
    }
  }

  private static String appendSpace(final StringBuilder sb, final int width) {
    while (sb.length() < width) {
      sb.append(" ");
    }
    return sb.toString();
  }
}
