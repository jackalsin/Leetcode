package interviews.oracle._1231_Divide_Chocolate;

/**
 * @author jacka
 * @version 1.0 on 12/7/2019
 */
public final class BinarySearchSolution implements Solution {
  @Override
  public int maximizeSweetness(int[] sweetness, int K) {
    if (sweetness == null || sweetness.length == 0) {
      return 0;
    }
    ++K;
    int left = 1, right = (int) (1e9) / K;
    while (left < right) {
      final int mid = left + (1 + right - left) / 2;
      if (getCuts(sweetness, mid) > K) { // mid is too small
        left = mid;
      } else {
        right = mid - 1;
      }
    }
    return left;
  }

  private static int getCuts(final int[] sweetness, final int mid) {
    int count = 1, sum = 0;
    for (int n : sweetness) {
      sum += n;
      if (sum >= mid) {
        sum = 0;
        count++;
      }
    }
    return count;
  }
}
