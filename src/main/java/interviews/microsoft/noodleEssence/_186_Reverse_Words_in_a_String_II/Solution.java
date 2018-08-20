package interviews.microsoft.noodleEssence._186_Reverse_Words_in_a_String_II;

public class Solution {
  public void reverseWords(char[] str) {
    reverse(str, 0, str.length - 1);
    for (int start = 0, end = 0; end <= str.length; end++) {
      if (end == str.length && start <= end) {
        reverse(str, start, end - 1);
        break;
      }
      final char chr = str[end];
      if (chr != ' ') {
        continue;
      }
      reverse(str, start, end - 1);
      start = end + 1;
    }
  }

  private static void reverse(final char[] str, int left, int right) {
    while (left < right) {
      char tmp = str[left];
      str[left] = str[right];
      str[right] = tmp;
      left++;
      right--;
    }
  }
}
