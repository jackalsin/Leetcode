package _0551_0600._556_Next_Greater_Element_III;

public final class Solution {
  public int nextGreaterElement(int n) {
    assert n > 0;
    final char[] chars = String.valueOf(n).toCharArray();
    if (chars.length == 1) {
      return -1;
    }
    boolean swapped = false;
    for (int i = chars.length - 1; !swapped && i >= 1; --i) {
      if (chars[i - 1] >= chars[i]) continue;
      swapped = true;
      final int j = firstGreater(chars, i);
      swap(chars, i - 1, j);
      reverse(chars, i);
    }
    try {
      return swapped ? Integer.valueOf(String.valueOf(chars)) : -1;
    } catch (NumberFormatException e) {
      return -1;
    }
  }

  private static void reverse(char[] chars, int start) {
    int left = start, right = chars.length - 1;
    while (left < right) {
      swap(chars, left, right);
      left++;
      right--;
    }
  }

  private static int firstGreater(final char[] chars, int i) {
    final char target = chars[i - 1];
    int left = i, right = chars.length - 1;
    while (left < right) {
      final int mid = (1 + right - left) / 2 + left;
      if (chars[mid] > target) {
        left = mid;
      } else {
        right = mid - 1;
      }
    }
    assert chars[left] > target;
    return left;
  }

  private static void swap(final char[] chars, final int i, final int j) {
    char tmp = chars[i];
    chars[i] = chars[j];
    chars[j] = tmp;
  }

}
