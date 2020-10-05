package linkedin._068_Text_Justification;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 10/18/2017.
 */
public final class SolutionII implements Solution {

  public List<String> fullJustify(String[] words, int maxWidth) {
    final List<String> result = new ArrayList<>();
    if (words.length == 0) {
      return result;
    }
    final List<String> curLine = new ArrayList<>();
    curLine.add(words[0]);
    int curLineChars = words[0].length();
    for (int i = 1; i < words.length; i++) {
      final String word = words[i];
      if (curLineChars + 1 + word.length() > maxWidth) {
        final String curLineFormatted = getFormat(maxWidth, curLine);
        result.add(curLineFormatted);
        curLineChars = word.length();
        curLine.clear();
        curLine.add(words[i]);
      } else {
        curLine.add(word);
        curLineChars += 1 + word.length();
      }
    }

    if (!curLine.isEmpty()) {
      result.add(getLastFormattedLine(curLine, maxWidth));
    }
    return result;
  }

  private String getLastFormattedLine(List<String> curLine, int maxWidth) {
    final StringBuilder sb = new StringBuilder();
    sb.append(curLine.get(0));
    for (int i = 1; i < curLine.size(); i++) {
      sb.append(" ").append(curLine.get(i));
    }
    while (sb.length() < maxWidth) {
      sb.append(" ");
    }
    return sb.toString();
  }

  private String getFormat(int maxWidth, List<String> curLine) {
    int wordCharCount = 0;
    for (String word : curLine) {
      wordCharCount += word.length();
    }
    final StringBuilder sb = new StringBuilder();
    final int totalSpaces = maxWidth - wordCharCount;
    if (curLine.size() == 1) {
      sb.append(curLine.get(0));
      appendSpace(sb, totalSpaces);
      return sb.toString();
    }

    final int smallSpaceCount = totalSpaces / (curLine.size() - 1),
        bigSpaceCount = smallSpaceCount + 1, bigSpaceWords = totalSpaces % (curLine.size() - 1),
        smallSpaceWords = curLine.size() - 1 - bigSpaceWords;

    sb.append(curLine.get(0));
    int i = 1;
    for (int k = 0; k < bigSpaceWords; k++) {
      appendSpace(sb, bigSpaceCount);
      sb.append(curLine.get(i++));
    }

    for (int k = 0; k < smallSpaceWords; k++) {
      appendSpace(sb, smallSpaceCount);
      sb.append(curLine.get(i++));
    }
    return sb.toString();
  }

  private void appendSpace(StringBuilder sb, int spaces) {
    for (int i = 0; i < spaces; i++) {
      sb.append(" ");
    }
  }
}
