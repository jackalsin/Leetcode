package interviews.airbnb._068_Text_Justification;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 1/24/2019.
 */
public class Solution {
  public List<String> fullJustify(String[] words, int maxWidth) {
    final List<String> result = new ArrayList<>();
    if (words == null || words.length == 0) {
      return result;
    }
    int curLineLen = words[0].length();
    final List<String> curLine = new ArrayList<>();
    curLine.add(words[0]);
    for (int wordIndex = 1; wordIndex < words.length; wordIndex++) {
      final String word = words[wordIndex];
      if (curLineLen + 1 + word.length() <= maxWidth) {
        curLine.add(word);
        curLineLen += 1 + word.length();
      } else {
        final String curLineStr = paddingToWidth(curLine, maxWidth);
        result.add(curLineStr);
        curLine.clear();
        curLine.add(word);
        curLineLen = word.length();
      }
    }
    assert !curLine.isEmpty();
    result.add(fitToEnd(curLine, maxWidth));

    return result;
  }

  private String fitToEnd(final List<String> curLine, final int maxWidth) {
    final StringBuilder sb = new StringBuilder().append(curLine.get(0));
    for (int i = 1; i < curLine.size(); i++) {
      sb.append(" ").append(curLine.get(i));
    }
    while (sb.length() < maxWidth) {
      sb.append(" ");
    }
    return sb.toString();
  }

  static String paddingToWidth(final List<String> curLine, final int maxWidth) {
    assert !curLine.isEmpty();
    final StringBuilder sb = new StringBuilder();
    if (curLine.size() == 1) {
      sb.append(curLine.get(0));
      repeat(sb, maxWidth - curLine.get(0).length());
      return sb.toString();
    }

    // get the all word's length
    int curLineLen = 0;
    for (String word : curLine) {
      curLineLen += word.length();
    }
    final int maxTimes = (maxWidth - curLineLen) % (curLine.size() - 1), minTimes = curLine.size() - 1 - maxTimes,
        minSpaceLen = (maxWidth - curLineLen) / (curLine.size() - 1), maxSpaceLen = 1 + minSpaceLen;
    int wordIndex = 1;
    sb.append(curLine.get(0));
    for (int i = 0; i < maxTimes; i++) {
      repeat(sb, maxSpaceLen);
      sb.append(curLine.get(wordIndex++));
    }
    for (int j = 0; j < minTimes; j++) {
      repeat(sb, minSpaceLen);
      sb.append(curLine.get(wordIndex++));
    }
    return sb.toString();
  }

  private static void repeat(final StringBuilder sb, final int times) {
    for (int i = 0; i < times; i++) {
      sb.append(" ");
    }
  }
}
