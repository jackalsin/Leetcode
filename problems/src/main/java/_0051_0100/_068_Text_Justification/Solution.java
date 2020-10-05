package _0051_0100._068_Text_Justification;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 4/27/2017.
 */
public class Solution {

  public List<String> fullJustify(String[] words, int maxWidth) {
    if (words == null || words.length == 0) {
      return new ArrayList<>();
    }
    int curLen = 0;
    List<String> result = new ArrayList<>();
    List<String> curLine = new ArrayList<>();
    for (int wordIndex = 0; wordIndex < words.length; wordIndex++) {
      String word = words[wordIndex];
      if (curLen + word.length() > maxWidth) {
        result.add(paddingToWidth(maxWidth, curLine));
        curLine.clear();
        curLen = 0;
      }
      curLine.add(word);
      curLen += 1 + word.length();
      if (wordIndex == words.length - 1 && !curLine.isEmpty()) {
        StringBuilder sb = new StringBuilder();
        for (String child : curLine) {
          sb.append(" ").append(child);
        }
        addSpace(sb, maxWidth - curLen + 1);
        result.add(sb.substring(1));
      }
    }
    return result;
  }

  String paddingToWidth(final int maxWidth, final List<String> curLine) {
    StringBuilder curSb = new StringBuilder();
    int actualLen = 0;
    for (int i = 0; i < curLine.size() - 1; i++) {
      actualLen += (curLine.get(i).length() + 1);
    }
    actualLen += curLine.get(curLine.size() - 1).length();
    if (curLine.size() == 1) {
      curSb.append(curLine.get(0));
      addSpace(curSb, maxWidth - actualLen);
    } else {
      int lessSpaces = (maxWidth - actualLen) / (curLine.size() - 1);
      int moreSpacesIndex = maxWidth - actualLen - lessSpaces * (curLine.size() - 1);
      for (int i = 0; i < curLine.size(); i++) {
        curSb.append(curLine.get(i));
        if (i != curLine.size() - 1) {
          curSb.append(" ");
          addSpace(curSb, (i < moreSpacesIndex) ? lessSpaces + 1 : lessSpaces);
        }
      }
    }
    return curSb.toString();
  }

  private void addSpace(StringBuilder sb, int spaceNum) {
    for (int i = 0; i < spaceNum; i++) {
      sb.append(" ");
    }
  }
}
