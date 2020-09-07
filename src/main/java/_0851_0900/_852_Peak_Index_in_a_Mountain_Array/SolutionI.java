package _0851_0900._852_Peak_Index_in_a_Mountain_Array;

/**
 * @author jacka
 * @version 1.0 on 9/6/2020
 */
public final class SolutionI implements Solution {
  @Override
  public int peakIndexInMountainArray(int[] arr) {
    final int n = arr.length;
    int left = 1, right = n - 2;
    assert left <= right;
    while (left <= right) {
      final int mid = left + (right - left) / 2;
      if (arr[mid - 1] < arr[mid] && arr[mid] > arr[mid + 1]) {
        return mid;
      } else if (arr[mid - 1] < arr[mid] && arr[mid] < arr[mid + 1]) {
        left = mid + 1;
      } else if (arr[mid - 1] > arr[mid] && arr[mid] > arr[mid + 1]) {
        right = mid - 1;
      }
    }
    throw new IllegalStateException();
  }

}
