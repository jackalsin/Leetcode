package uber._058_Length_of_Last_Word;

/**
 * @author jacka
 * @version 1.0 on 1/6/2020
 */
public final class SolutionI implements Solution {
  @Override
  public int lengthOfLastWord(String s) {
    int len = 0;
    if (s == null || s.isEmpty()) {
      return 0;
    }
    final int end = getEnd(s);
    if (end == -1) {
      return len;
    }
    for (int i = end; i >= 0; i--) {
      if (s.charAt(i) == ' ') {
        break;
      }
      len++;
    }
    return len;
  }

  private int getEnd(final String s) {
    int end = s.length() - 1;
    while (end >= 0 && s.charAt(end) == ' ') {
      end--;
    }
    return end;
  }
}
