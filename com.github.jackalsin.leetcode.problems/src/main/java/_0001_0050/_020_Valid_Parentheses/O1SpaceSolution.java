package _0001_0050._020_Valid_Parentheses;

/**
 * @author jacka
 * @version 1.0 on 1/23/2017.
 */
public final class O1SpaceSolution implements Solution {
  public boolean isValid(String s) {
    final char[] chars = s.toCharArray();
    int top = -1;
    for (int i = 0; i < chars.length; ++i) {
      if (top == -1 || !isMatch(chars[i], chars[top])) {
        ++top;
        chars[top] = chars[i];
      } else {
        --top;
      }
    }
    return top == -1;
  }

  private static boolean isMatch(char a, char b) {
    if (a == ')' && b == '(') return true;
    if (a == '}' && b == '{') return true;
    if (a == ']' && b == '[') return true;
    return false;
  }
}
