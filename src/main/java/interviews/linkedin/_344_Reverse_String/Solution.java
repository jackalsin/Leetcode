package interviews.linkedin._344_Reverse_String;

public class Solution {
  public String reverseString(String s) {
    if (s == null) {
      return null;
    }
    final char[] chars = s.toCharArray();
    int left = 0, right = s.length() - 1;
    while (left < right) {
      char tmp = chars[left];
      chars[left] = chars[right];
      chars[right] = tmp;
      left++;
      right--;
    }
    return String.valueOf(chars);
  }

}
