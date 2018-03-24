package interviews.uber._068_Text_Justification;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 3/20/2018.
 */
public class Solution {

  public List<String> fullJustify(String[] words, int maxWidth) {
    if (words == null || words.length == 0) {
      return new ArrayList<>();
    }
    int curLineCount = words[0].length();
    final List<String> curLineWords = new ArrayList<>(), result = new ArrayList<>();
    curLineWords.add(words[0]);
    for (int i = 1; i < words.length; i++) {
      final String word = words[i];
      if (curLineCount + word.length() + 1 > maxWidth) {
        final String curLineStr = getCurLineString(curLineWords, maxWidth);
        result.add(curLineStr);
        curLineWords.clear();
        curLineWords.add(word);
        curLineCount = word.length();
      } else {
        curLineCount += word.length() + 1;
        curLineWords.add(word);
      }
    }

    if (!curLineWords.isEmpty()) { // transform the last line
      result.add(getLastLine(curLineWords, maxWidth));
    }

    return result;
  }

  private String getLastLine(List<String> curLineWords, final int maxWidth) {
    final StringBuilder sb = new StringBuilder();
    sb.append(curLineWords.get(0));
    for (int i = 1; i < curLineWords.size(); i++) {
      sb.append(" ").append(curLineWords.get(i));
    }
    paddingToWidth(sb, maxWidth);
    return sb.toString();
  }

  private String getCurLineString(final List<String> curLineWords, final int maxWidth) {
    final StringBuilder sb = new StringBuilder();

    final int totalGaps = curLineWords.size() - 1;
    if (totalGaps == 0) {
      sb.append(curLineWords.get(0));
      paddingToWidth(sb, maxWidth);
      return sb.toString();
    }

    int wordTotalLength = 0;
    for (int i = 0; i < curLineWords.size(); i++) {
      wordTotalLength += curLineWords.get(i).length();
    }
    final int totalSpaceNum = maxWidth - wordTotalLength;
    if (totalSpaceNum % totalGaps == 0) {
      final int spaceNum = totalSpaceNum / totalGaps;
      sb.append(curLineWords.get(0));
      for (int i = 1; i < curLineWords.size(); i++) {
        appendSpace(sb, spaceNum);
        sb.append(curLineWords.get(i));
      }
    } else {
      int smallSpaceNum = totalSpaceNum / totalGaps, bigSpaceNum = smallSpaceNum + 1,
          bigSpaceCount = totalSpaceNum % totalGaps;
      sb.append(curLineWords.get(0));
      for (int i = 1; i < curLineWords.size(); i++) {
        if (bigSpaceCount != 0) {
          appendSpace(sb, bigSpaceNum);
          bigSpaceCount--;
        } else {
          appendSpace(sb, smallSpaceNum);
        }
        sb.append(curLineWords.get(i));
      }

    }
    return sb.toString();
  }

  private void paddingToWidth(StringBuilder sb, int maxWidth) {
    while (sb.length() < maxWidth) {
      sb.append(" ");
    }
  }

  private static void appendSpace(final StringBuilder sb, final int spaces) {
    for (int i = 0; i < spaces; i++) {
      sb.append(" ");
    }
  }
}
