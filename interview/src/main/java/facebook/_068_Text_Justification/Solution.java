package facebook._068_Text_Justification;

import java.util.ArrayList;
import java.util.List;

public class Solution {

  public List<String> fullJustify(String[] words, int maxWidth) {
    final List<String> result = new ArrayList<>(), curLineWord = new ArrayList<>();
    if (words == null || words.length == 0) {
      result.add(repeat(" ", maxWidth));
    }
    int curLen = words[0].length();
    curLineWord.add(words[0]);
    for (int i = 1; i < words.length; i++) {
      if (curLen + 1 + words[i].length() > maxWidth) { // convert to line
        result.add(paddingToWidth(maxWidth, curLineWord));

        // end
        curLineWord.clear();
        curLineWord.add(words[i]);
        curLen = words[i].length();
      } else {
        curLineWord.add(words[i]);
        curLen += 1 + words[i].length();
      }
    }

    if (curLineWord.size() > 0) {
      result.add(paddingToWidthLast(maxWidth, curLineWord));
    }

    return result;
  }

  String paddingToWidthLast(final int maxWidth, final List<String> curLineWord) {
    final StringBuilder sb = new StringBuilder();
    sb.append(curLineWord.get(0));
    for (int i = 1; i < curLineWord.size(); i++) {
      sb.append(" ").append(curLineWord.get(i));
    }

    sb.append(repeat(" ", maxWidth - sb.length()));
    return sb.toString();
  }

  String paddingToWidth(final int maxWidth, final List<String> curLineWord) {
    int totalWordLen = 0;
    int wordCount = 0;
    for (final String word : curLineWord) {
      totalWordLen += word.length();
      wordCount++;
    }
    final StringBuilder sb = new StringBuilder();
    if (wordCount == 1) {
      sb.append(curLineWord.get(0)).append(repeat(" ", maxWidth - totalWordLen));
      return sb.toString();
    }
    final int smallIntervalSpace = (maxWidth - totalWordLen) / (wordCount - 1),
        bigIntervals = (maxWidth - totalWordLen) % (wordCount - 1),
        bigIntervalSpace = smallIntervalSpace + 1,
        smallIntervals = wordCount - 1 - bigIntervals;

    int i = 0;
    for (int spaceCount = 0; spaceCount < bigIntervals; spaceCount++) {
      sb.append(curLineWord.get(i++)).append(repeat(" ", bigIntervalSpace));
    }

    for (int spaceCount = 0; spaceCount < smallIntervals; spaceCount++) {
      sb.append(curLineWord.get(i++)).append(repeat(" ", smallIntervalSpace));
    }
    sb.append(curLineWord.get(i));
    return sb.toString();
  }

  private static String repeat(String s, int times) {
    final StringBuilder sb = new StringBuilder();
    while (sb.length() < times) {
      sb.append(s);
    }
    return sb.toString();
  }

}
