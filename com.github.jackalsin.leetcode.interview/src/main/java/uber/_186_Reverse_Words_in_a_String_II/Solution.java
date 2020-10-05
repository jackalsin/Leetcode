package uber._186_Reverse_Words_in_a_String_II;

public class Solution {
  public void reverseWords(char[] str) {
    int left = 0, right = str.length - 1;
    // rotate the entire array
    while (left < right) {
      swap(str, left, right);
      left++;
      right--;
    }
    // rotate each word
    int start = 0;
    for (int end = 0; end <= str.length; end++) {
      if (end == str.length || str[end] == ' ') {
        reverse(str, start, end - 1);
        start = end + 1;
      }
    }
  }

  private static void reverse(final char[] str, int start, int end) {
    while (start < end) {
      swap(str, start, end);
      start++;
      end--;
    }
  }

  private static void swap(char[] str, int left, int right) {
    char tmp = str[left];
    str[left] = str[right];
    str[right] = tmp;
  }
}
