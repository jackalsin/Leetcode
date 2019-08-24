package interviews.linkedin._068_Text_Justification;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 8/23/2019
 */
public final class SolutionIV implements Solution {
  @Override
  public List<String> fullJustify(String[] words, int maxWidth) {
    final List<String> result = new ArrayList<>();
    if (words == null || maxWidth <= 0 || words.length == 0) {
      return result;
    }
    final List<String> curLine = new ArrayList<String>() {{
      add(words[0]);
    }};
    int curLineLen = words[0].length();
    for (int i = 1; i < words.length; ++i) {
      final String word = words[i];
      if (curLineLen + 1 + word.length() <= maxWidth) {
        curLine.add(word);
        curLineLen += 1 + word.length();
      } else {
        final String line = getLine(curLine, maxWidth);
        result.add(line);
        curLine.clear();
        curLine.add(word);
        curLineLen = word.length();
      }
    }
    assert !curLine.isEmpty();
    result.add(getLastLine(curLine, maxWidth));
    return result;
  }

  private static String getLastLine(final List<String> curLine, final int len) {
    final StringBuilder sb = new StringBuilder().append(curLine.get(0));
    for (int i = 1; i < curLine.size(); ++i) {
      sb.append(" ").append(curLine.get(i));
    }
    while (sb.length() < len) {
      sb.append(" ");
    }
    return sb.toString();
  }

  private static String getLine(final List<String> curLine, final int maxWidth) {
    final StringBuilder sb = new StringBuilder();
    if (curLine.size() == 1) {
      sb.append(curLine.get(0));
      repeat(sb, maxWidth - curLine.get(0).length());
      return sb.toString();
    }
    final int wordLen = getWordsLength(curLine),
        smallSpace = (maxWidth - wordLen) / (curLine.size() - 1),
        bigSpace = smallSpace + 1, bigCount = (maxWidth - wordLen) % (curLine.size() - 1);
    sb.append(curLine.get(0));
    for (int i = 0; i < bigCount; ++i) {
      repeat(sb, bigSpace);
      sb.append(curLine.get(i + 1));
    }

    for (int i = bigCount + 1; i < curLine.size(); ++i) {
      repeat(sb, smallSpace);
      sb.append(curLine.get(i));
    }
    return sb.toString();
  }

  private static int getWordsLength(final List<String> curLine) {
    int sum = 0;
    for (final String w : curLine) {
      sum += w.length();
    }
    return sum;
  }

  private static void repeat(final StringBuilder sb, final int spaces) {
    for (int i = 0; i < spaces; ++i) {
      sb.append(' ');
    }
  }
}
