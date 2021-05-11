package google._1539_Kth_Missing_Positive_Number;

/**
 * @author jacka
 * @version 1.0 on 5/10/2021
 */
public final class ONSolution implements Solution {
  @Override
  public int findKthPositive(int[] arr, int k) {
    if (arr == null || arr.length == 0) return 0;
    int prev = 0;
    for (int i = 0; i < arr.length; ++i) {
      final int skip = arr[i] - prev - 1;
      if (skip < k) {
        k -= skip;
      } else {
        return prev + k;
      }
      prev = arr[i];
    }
    return prev + k;
  }
}
