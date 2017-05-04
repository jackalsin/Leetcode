package _051_100._068_Text_Justification;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 4/27/2017.
 */
public class Solution {
  public List<String> fullJustify(String[] words, int maxWidth) {
    if (words == null || words.length == 0 || maxWidth <= 0) {
      return new ArrayList<>();
    }
    int curLen = 0;
    List<String> result = new ArrayList<>();
    List<String> curLine = new ArrayList<>();
    for (String word : words) {
      curLen += word.length();
      if (curLen >= maxWidth) {
        int actualLen = curLen - word.length();
        StringBuilder curSb = new StringBuilder();
        int lessSpaces = (maxWidth - actualLen) / (curLine.size() - 1);
        int moreSpacesIndex = maxWidth - actualLen - lessSpaces * (curLine.size() - 1);
        for (int i = 0; i < curLen; i++) {
          curSb.append(curLine.get(i));
          if (i != curLen - 1) {
            for(int j = 0; j < ((i < moreSpacesIndex) ? lessSpaces + 1: lessSpaces); j++) {
              curSb.append(" ");
            }
          }
        }
        result.add(curSb.toString());
        //reset
        curLen = word.length() + 1;
        curLine.clear();
        curLine.add(word);
      } else {
        curLen += 1;
        curLine.add(word);
      }
    }
    return result;
  }
}
