package _0501_0550._541_Reverse_String_II;

/**
 * @author jacka
 * @version 1.0 on 9/30/2017.
 */
public class Solution {
  public String reverseStr(String s, int k) {
    if (s == null) return null;
    else {
      char[] chars = s.toCharArray();
      for (int start = 0; start < s.length(); start += 2 * k) {
        int left = start, right = Math.min(start + k - 1, s.length() - 1);
        while (left < right) {
          swap(chars, left++, right--);
        }
      }
      return new String(chars);
    }
  }

  private static void swap(char[] chars, int left, int right) {
    char tmp = chars[left];
    chars[left] = chars[right];
    chars[right] = tmp;
  }
}
