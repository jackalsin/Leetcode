package _1051_1100._1089_Duplicate_Zeros;

/**
 * @author jacka
 * @version 1.0 on 6/27/2021
 */
public class ReverseScanSolution implements Solution {
  @Override
  public void duplicateZeros(int[] arr) {
    int count = 0;
    for (int a : arr) {
      if (a == 0) count++;
    }
    final int len = arr.length;
    for (int left = len - 1, right = len + count - 1; left >= 0; --left) {
      if (right < len) {
        arr[right] = arr[left];
      }
      if (right - 1 < len && arr[left] == 0) {
        arr[right - 1] = arr[left];
      }
      right = arr[left] == 0 ? right - 2 : right - 1;
    }
  }
}
