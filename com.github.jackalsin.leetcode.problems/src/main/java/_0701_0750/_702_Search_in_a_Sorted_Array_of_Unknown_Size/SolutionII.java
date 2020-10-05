package _0701_0750._702_Search_in_a_Sorted_Array_of_Unknown_Size;

import utils._702_Search_in_a_Sorted_Array_of_Unknown_Size.ArrayReader;

/**
 * @author jacka
 * @version 1.0 on 12/8/2019
 */
public final class SolutionII implements Solution {
  private static final int OUT_OF_BOUNDARY = 2147483647;

  public int search(ArrayReader reader, int target) {
    int left = 0, right = Integer.MAX_VALUE;
    while (left <= right) {
      final int mid = left + (right - left) / 2,
          midVal = reader.get(mid);
      if (midVal == target) {
        return mid;
      } else if (midVal == OUT_OF_BOUNDARY) {
        right = mid - 1;
      } else if (midVal < target) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    return -1;
  }
}
