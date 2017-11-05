package _551_600._591_Tag_Validator;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 10/30/2017.
 */
public class Solution {
  private static final String CDATA_RIGHT_MATCH = "]]>";
  /**
   *
   * @param code
   * @return
   */
  public boolean isValid(String code) {
    /* only store tag name */
    Deque<String> stack = new ArrayDeque<>();
    if (!code.startsWith("<")) return false;
    for (int i = 0; i < code.length(); ) {
      if(i > 0 && stack.isEmpty()) return false;
      if (code.startsWith("</", i)) {
        final int rightEndIndex = code.indexOf('>', i);
        if (rightEndIndex == -1) return false;
        if (stack.isEmpty() || !stack.peekLast().equals(code.substring(i + 2, rightEndIndex))) {
          return false;
        } else {
          stack.removeLast();
        }
        i = rightEndIndex + 1;
      } else if (code.startsWith("<![CDATA[", i)) {
        final int rightEndIndex = code.indexOf(CDATA_RIGHT_MATCH, i);
        if (rightEndIndex == -1) return false;
        i = rightEndIndex + 3;
      } else if (code.startsWith("<", i)) {
        final int rightEndIndex = code.indexOf('>', i);
        if (rightEndIndex == -1) return false;
        String tagName = code.substring(i + 1, rightEndIndex);
        if (tagName.length() > 9 || tagName.length() == 0) {
          return false;
        }
        for (char chr : tagName.toCharArray()) {
          if (!Character.isUpperCase(chr)) {
            return false;
          }
        }
        stack.addLast(tagName);
        i += 1 + tagName.length() + 1;
      } else {
        i++;
      }
    }
    return stack.size() == 0;
  }

}
