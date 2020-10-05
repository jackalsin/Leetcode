package _0701_0750._722_Remove_Comments;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 11/4/2019
 */
public final class SolutionI implements Solution {
  @Override
  public List<String> removeComments(String[] source) {
    final List<String> result = new ArrayList<>();
    boolean isInBlock = false;
    final StringBuilder sb = new StringBuilder();
    nextLine:
    for (final String str : source) {
      final char[] chars = str.toCharArray();
      for (int i = 0; i < chars.length; ++i) {
        if (isInBlock) {
          if (chars[i] == '*' && (i + 1 < chars.length && chars[i + 1] == '/')) {
            i++;
            isInBlock = false;
            if (i == chars.length - 1 && sb.length() != 0) {
              result.add(sb.toString());
              sb.setLength(0);
            }
          }
        } else { // not in the block
          if (chars[i] == '/' && (i + 1 < chars.length && chars[i + 1] == '*')) {
            i++;
            isInBlock = true;
          } else if (chars[i] == '/' && (i + 1 < chars.length && chars[i + 1] == '/')) {
            if (sb.length() != 0) {
              result.add(sb.toString());
              sb.setLength(0);
            }
            continue nextLine;
          } else {
            final char chr = chars[i];
            sb.append(chr);
            if (i == chars.length - 1) {
              result.add(sb.toString());
              sb.setLength(0);
            }
          }
        }
      }
    }
    if (sb.length() != 0) {
      result.add(sb.toString());
    }
    return result;
  }
}
