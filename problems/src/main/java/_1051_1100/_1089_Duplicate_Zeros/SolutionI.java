package _1051_1100._1089_Duplicate_Zeros;

/**
 * @author jacka
 * @version 1.0 on 6/27/2021
 */
public final class SolutionI implements Solution {

  @Override
  public void duplicateZeros(int[] arr) {
    if (arr == null || arr.length == 0) return;
    final int size = arr.length;
    for (int i = 0, j = 0; j < arr.length; ++i) {
      arr[j] = arr[j] | ((arr[i] & 0xF) << 4);
      j++;
      if ((arr[i] & 0xF) == 0) {
        j++;
      }
    }
    for (int i = 0; i < size; ++i) {
      arr[i] >>= 4;
    }
  }
}
