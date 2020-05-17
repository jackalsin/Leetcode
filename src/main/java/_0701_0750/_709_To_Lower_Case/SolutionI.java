package _0701_0750._709_To_Lower_Case;

/**
 * @author jacka
 * @version 1.0 on 5/17/2020
 */
public final class SolutionI implements Solution {
  @Override
  public String toLowerCase(String str) {
    final char[] chars = str.toCharArray();
    for (int i = 0; i < chars.length; i++) {
      final char chr = chars[i];
      if (chr >= 'A' && chr <= 'Z') {
        chars[i] -= 'A' - 'a';
      }
    }
    return String.valueOf(chars);
  }
}
