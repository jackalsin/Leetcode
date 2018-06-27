package _701_750._744_Find_Smallest_Letter_Greater_Than_Target;

public class Solution {
  public char nextGreatestLetter(char[] letters, char target) {
    assert letters != null;
    assert letters.length >= 2;

    int left = 0, right = letters.length - 1;
    while (left < right) {
      final int mid = (right - left) / 2 + left;
      if (letters[mid] > target) {
        right = mid;
      } else {
        left = mid + 1;
      }
    }

    // not found
    if (letters[left] <= target) {
      return letters[0];
    }
    return letters[left];
  }
}
