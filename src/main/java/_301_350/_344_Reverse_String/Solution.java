package _301_350._344_Reverse_String;

/**
 * @author jacka
 * @version 1.0 on 9/30/2017.
 */
public class Solution {
  public String reverseString(String s) {
    if(s == null) return s;
    else {
      char[] chars = s.toCharArray();
      int start = 0, end = s.length() - 1;
      while (start < end) {
        char tmp = chars[start];
        chars[start] = chars[end];
        chars[end] = tmp;
        start++; end--;
      }
      return new String(chars);
    }
  }
}
