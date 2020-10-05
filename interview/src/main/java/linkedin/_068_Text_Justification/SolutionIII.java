package linkedin._068_Text_Justification;

import java.util.ArrayList;
import java.util.List;

public final class SolutionIII implements Solution {
  @Override
  public List<String> fullJustify(String[] words, int maxWidth) {
    final List<String> result = new ArrayList<>();
    if (words == null || words.length == 0) {
      return result;
    }
    final List<String> curLineWords = new ArrayList<>();
    curLineWords.add(words[0]);
    int curLineLength = words[0].length();
    for (int i = 1; i < words.length; i++) {
      final String word = words[i];
      if (curLineLength + 1 + word.length() > maxWidth) {
        String actual = getLine(curLineWords, curLineLength, maxWidth);
        result.add(actual);
        curLineWords.clear();
        curLineWords.add(word);
        curLineLength = word.length();
      } else {
        curLineLength += 1 + word.length();
        curLineWords.add(word);
      }
    }

    if (!curLineWords.isEmpty()) {
      result.add(getLastLine(curLineWords, maxWidth));
    }
    return result;
  }

  private static String getLastLine(final List<String> curLineWords, final int maxWidth) {
    final StringBuilder sb = new StringBuilder().append(curLineWords.get(0));
    for (int i = 1; i < curLineWords.size(); i++) {
      sb.append(" ").append(curLineWords.get(i));
    }
    while (sb.length() < maxWidth) {
      sb.append(" ");
    }
    return sb.toString();
  }

  private static String getLine(final List<String> words, final int oneSpaceLen, final int maxWidth) {
    assert !words.isEmpty();
    final int len = oneSpaceLen - (words.size() - 1), totalSpace = maxWidth - len;
    final StringBuilder sb = new StringBuilder();
    if (words.size() == 1) {
      sb.append(words.get(0));
      appendPadding(sb, maxWidth - sb.length());
      return sb.toString();
    }
    final int smallSpace = totalSpace / (words.size() - 1),
        bigSpace = smallSpace + 1,
        bigSpaceNum = totalSpace % (words.size() - 1);

    sb.append(words.get(0));
    for (int i = 0; i < bigSpaceNum; i++) {
      appendPadding(sb, bigSpace);
      sb.append(words.get(i + 1));
    }

    for (int i = bigSpaceNum + 1; i < words.size(); i++) {
      appendPadding(sb, smallSpace);
      sb.append(words.get(i));
    }
    return sb.toString();
  }

  private static void appendPadding(final StringBuilder sb, final int width) {
    for (int i = 0; i < width; i++) {
      sb.append(" ");
    }
  }

}
