package google._844_Backspace_String_Compare;

/**
 * @author jacka
 * @version 1.0 on 4/13/2020
 */
public final class SolutionI implements Solution {
  private static final char BACKSPACE = '#';

  public boolean backspaceCompare(String s, String t) {
    int i = s.length() - 1, j = t.length() - 1;
    while (i >= 0 || j >= 0) {
      int backspace = 0;
      while (i >= 0 && (backspace > 0 || s.charAt(i) == BACKSPACE)) {
        backspace += s.charAt(i) == BACKSPACE ? 1 : -1;
        i--;
      }
      i -= backspace;
      backspace = 0;
      while (j >= 0 && (backspace > 0 || t.charAt(j) == BACKSPACE)) {
        backspace += t.charAt(j) == BACKSPACE ? 1 : -1;
        j--;
      }
      j -= backspace;
      if (i >= 0 && j >= 0 && s.charAt(i) == t.charAt(j)) {
        --i;
        --j;
      } else {
        break;
      }
    }
    return i < 0 && j < 0;
  }
}
