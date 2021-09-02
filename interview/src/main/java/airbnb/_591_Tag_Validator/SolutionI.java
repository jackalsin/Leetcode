package airbnb._591_Tag_Validator;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author jacka
 * @version 1.0 on 9/1/2021
 */
public final class SolutionI implements Solution {
  private static final String START_LEFT = "<", RIGHT = ">",
      END_LEFT = "</", CDATA_LEFT = "<![CDATA[", CDATA_RIGHT = "]]>";

  public boolean isValid(String code) {
    if (code == null || code.isEmpty()) return true;
    final Deque<String> stack = new ArrayDeque<>();
    for (int i = 0; i < code.length(); ++i) {
      if (i != 0 && stack.isEmpty()) return false;
      if (code.startsWith(CDATA_LEFT, i)) {
        i += CDATA_LEFT.length() - 1;
        while (i + 1 < code.length() && !code.startsWith(CDATA_RIGHT, i + 1)) {
          i++;
        }
        if (!code.startsWith(CDATA_RIGHT, i + 1)) return false; // not found
        i += CDATA_RIGHT.length();
      } else if (code.startsWith(END_LEFT, i)) {
        i += END_LEFT.length();
        final int start = i;
        while (i + 1 < code.length() && !code.startsWith(RIGHT, i + 1)) {
          if (!Character.isUpperCase(code.charAt(i + 1))) return false;
          ++i;
        }
        if (!code.startsWith(RIGHT, i + 1)) return false;
        if (stack.isEmpty() || !code.substring(start, i + 1).equals(stack.pop())) return false;
        i += RIGHT.length();
      } else if (code.startsWith(START_LEFT, i)) {
        final int start = i + 1;
        while (i + 1 < code.length() && !code.startsWith(RIGHT, i + 1)) {
          if (!Character.isUpperCase(code.charAt(i + 1))) return false;
          i++;
        }
        if (!code.startsWith(RIGHT, i + 1)) return false;
        final int len = i + 1 - start;
        if (len == 0 || len > 9) return false;
        stack.push(code.substring(start, i + 1));
        i += RIGHT.length();
      }
    }
    return stack.isEmpty();
  }
}
