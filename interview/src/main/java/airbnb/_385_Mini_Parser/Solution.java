package airbnb._385_Mini_Parser;

import definition.nestedInteger._385_Mini_Parser.NestedInteger;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author jacka
 * @version 1.0 on 2/6/2019.
 */
public final class Solution {
  public NestedInteger deserialize(String s) {
    if (s == null || s.isEmpty()) {
      return null;
    }
    if (!s.startsWith("[")) {
      return new NestedInteger(Integer.parseInt(s));
    }
    final Deque<NestedInteger> stack = new ArrayDeque<>();
    NestedInteger cur = null;
    int left = 0; // points to start of num
    for (int right = 0; right < s.length(); right++) {
      final char chr = s.charAt(right);
      if (chr == '[') {
        if (cur != null) {
          stack.push(cur);
        }
        cur = new NestedInteger();
        left = right + 1;
      } else if (chr == ']') {
        final String numStr = s.substring(left, right);
        if (!numStr.isEmpty()) {
          cur.add(new NestedInteger(Integer.parseInt(numStr)));
        }
        if (!stack.isEmpty()) {
          NestedInteger ni = stack.pop();
          ni.add(cur);
          cur = ni;
        }
        left = right + 1;
      } else if (chr == ',') {
        if (s.charAt(right - 1) != ']') {
          final String numStr = s.substring(left, right);
          cur.add(new NestedInteger(Integer.parseInt(numStr)));
        }
        left = right + 1;
      }
    }
    return cur;
  }
}
