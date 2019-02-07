package interviews.airbnb._344_Reverse_String;

/**
 * @author jacka
 * @version 1.0 on 2/6/2019.
 */
public class Solution {
  public void reverseString(char[] s) {
    if (s == null || s.length == 0) {
      return;
    }
    int left = 0, right = s.length - 1;
    while (left < right) {
      swap(s, left++, right--);
    }
  }

  private static void swap(final char[] chars, int i, int j) {
    final char tmp = chars[i];
    chars[i] = chars[j];
    chars[j] = tmp;
  }
}
