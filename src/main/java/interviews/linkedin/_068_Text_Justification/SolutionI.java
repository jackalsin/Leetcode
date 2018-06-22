package interviews.linkedin._068_Text_Justification;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 10/18/2017.
 */
public final class SolutionI implements Solution {

  public List<String> fullJustify(String[] words, int maxWidth) {
    List<String> result = new ArrayList<>();
    if (words == null || words.length == 0) {
      return result;
    }
    List<String> curLine = new ArrayList<>();
    int curLineWordCharCount = 0;
    for (int i = 0; i < words.length; ++i) {
      final String word = words[i];
      if (curLineWordCharCount + curLine.size() + word.length() > maxWidth) {
        result.add(getLine(curLine, maxWidth, curLineWordCharCount));
        curLine.clear();
        curLineWordCharCount = 0;
      }
      curLine.add(word);
      curLineWordCharCount += word.length();
      if (i == words.length - 1 && !curLine.isEmpty()) {
        result.add(getLastLine(curLine, maxWidth));
      }
    }
    return result;
  }

  private static String getLastLine(List<String> curLine, int maxWidth) {
    assert curLine.size() != 0;
    StringBuilder sb = new StringBuilder();
    for (String word : curLine) {
      sb.append(" ").append(word);
    }
    while (sb.length() <= maxWidth) {
      sb.append(" ");
    }
    return sb.substring(1);
  }

  private static String getLine(final List<String> curLine, final int maxWidth,
                                final int totalCharCount) {
    StringBuilder sb = new StringBuilder();
    if (curLine.size() == 0) {
      while (sb.length() < maxWidth) {
        sb.append(" ");
      }
      return sb.toString();
    }
    final int totalSpace = maxWidth - totalCharCount, wordCount = curLine.size(),
        intervals = wordCount - 1;

    if (intervals == 0) {
      sb.append(curLine.get(0));
      while (sb.length() < maxWidth) {
        sb.append(" ");
      }
      return sb.toString();
    }

    final int firstSpaceNum = totalSpace / intervals + ((totalSpace % intervals == 0) ? 0 : 1);
    final int secondSpaceNum = firstSpaceNum - 1;
    final int firstCount = totalSpace % intervals == 0 ? intervals :
        (totalSpace % intervals);
    final StringBuilder firstSpace = new StringBuilder();
    final StringBuilder secondSpace = new StringBuilder();
    for (int i = 0; i < firstSpaceNum; ++i) {
      firstSpace.append(" ");
    }
    for (int i = 0; i < secondSpaceNum; ++i) {
      secondSpace.append(" ");
    }
    for (int i = 0; i < curLine.size(); ++i) {
      if (i < firstCount) {
        sb.append(curLine.get(i)).append(firstSpace);
      } else {
        sb.append(curLine.get(i)).append(secondSpace);
      }
    }
    assert sb.length() - secondSpaceNum == maxWidth;
    return sb.substring(0, sb.length() - secondSpaceNum);
  }

}
