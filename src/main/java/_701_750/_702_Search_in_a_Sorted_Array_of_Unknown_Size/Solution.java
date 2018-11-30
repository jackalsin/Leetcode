package _701_750._702_Search_in_a_Sorted_Array_of_Unknown_Size;

import utils._702_Search_in_a_Sorted_Array_of_Unknown_Size.ArrayReader;

public class Solution {
  private static final int MAX_RIGHT = 20_000;

  public int search(ArrayReader reader, int target) {
    int left = 0, right = MAX_RIGHT;

    while (left <= right) {
      final int mid = (left + right) / 2, midVal = reader.get(mid);
      if (midVal == Integer.MAX_VALUE) {
        right = mid - 1;
      } else if (midVal == target) {
        return mid;
      } else if (midVal < target) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    return -1;
  }
}
