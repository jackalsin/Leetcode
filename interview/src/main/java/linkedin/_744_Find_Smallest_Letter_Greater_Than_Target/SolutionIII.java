package linkedin._744_Find_Smallest_Letter_Greater_Than_Target;

/**
 * @author jacka
 * @version 1.0 on 7/28/2019
 */
public final class SolutionIII implements Solution {
  @Override
  public char nextGreatestLetter(char[] letters, char target) {
    if (letters == null || letters.length == 0) {
      return target;
    }
    int left = 0, right = letters.length - 1;
    while (left < right) {
      final int mid = left + (right - left) / 2;
      if (letters[mid] > target) {
        right = mid;
      } else {
        left = mid + 1;
      }
    }
    if (letters[left] > target) {
      return letters[left];
    }
    // every element is smaller than target
    return letters[0];
  }
}
