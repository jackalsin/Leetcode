package google._1539_Kth_Missing_Positive_Number;

/**
 * @author jacka
 * @version 1.0 on 5/10/2021
 */
public final class OLogNSolution implements Solution {
  @Override
  public int findKthPositive(int[] arr, int k) {
    int left = 0, right = arr.length - 1;
    while (left < right) {
      final int mid = left + (1 + right - left) / 2;
      if (mid + 1 + k > arr[mid]) {
        left = mid;
      } else {
        right = mid - 1;
      }
    }
    if (left + 1 + k > arr[left]) {
      return left + 1 + k;
    }
    return k;
  }
}
