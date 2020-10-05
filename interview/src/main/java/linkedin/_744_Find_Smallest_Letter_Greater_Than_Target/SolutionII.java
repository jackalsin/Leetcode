package linkedin._744_Find_Smallest_Letter_Greater_Than_Target;

public final class SolutionII implements Solution {
  public char nextGreatestLetter(char[] letters, char target) {
    assert letters.length >= 2 && letters.length <= 10000;
    int left = 0, right = letters.length - 1;
    while (left < right) {
      final int mid = (right - left) / 2 + left;
      if (letters[mid] > target) {
        right = mid;
      } else {
        left = mid + 1;
      }
    }

    if (letters[left] > target) {
      return letters[left];
    }
    return letters[0];
  }

}
