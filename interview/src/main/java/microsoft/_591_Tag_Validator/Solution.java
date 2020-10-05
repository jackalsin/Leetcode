package microsoft._591_Tag_Validator;

import java.util.ArrayDeque;
import java.util.Deque;

public final class Solution {
  private static final String CDATA_START = "<![CDATA[", CDATA_END = "]]>";

  /**
   * 256 / 256 test cases passed.
   * Status: Accepted
   * Runtime: 23 ms
   *
   * @param code
   * @return
   */
  public boolean isValid(String code) {

    if (!code.startsWith("<")) {
      return false;
    }
    final Deque<String> stack = new ArrayDeque<>();
    for (int i = 0; i < code.length(); ) {
      if (i > 0 && stack.isEmpty()) {
        return false; // TODO: add documentation
      }
      if (code.startsWith(CDATA_START, i)) {
        final int rightEndIndex = code.indexOf(CDATA_END, i);
        if (rightEndIndex == -1) {
          return false;
        }
        i = rightEndIndex + 3;
      } else if (code.startsWith("</", i)) {
        final int rightEndIndex = code.indexOf('>', i);
        if (rightEndIndex == -1) {
          return false;
        }
        final String tag = code.substring(i + 2, rightEndIndex);
        if (stack.isEmpty() || !stack.pop().equals(tag)) {
          return false;
        }
        i = rightEndIndex + 1;
      } else if (code.startsWith("<", i)) {
        final int rightEndIndex = code.indexOf('>', i);
        if (rightEndIndex == -1) {
          return false;
        }
        final String tag = code.substring(i + 1, rightEndIndex);
        if (tag.length() > 9 || tag.length() < 1) {
          return false;
        }
        for (char chr : tag.toCharArray()) {
          if (!Character.isUpperCase(chr)) {
            return false;
          }
        }
        i = rightEndIndex + 1;
        stack.push(tag);
      } else {
        i++;
      }
    }
    return stack.isEmpty();
  }
}
