package interviews.google._1231_Divide_Chocolate;

/**
 * @author jacka
 * @version 1.0 on 4/7/2020
 */
public final class SolutionII implements Solution {
  @Override
  public int maximizeSweetness(int[] sweetness, int K) {
    //  https://leetcode.com/problems/find-the-shortest-superstring/discuss/194932/Travelling-Salesman-Problem
    long sum = 0;
    for (int s : sweetness) {
      sum += s;
    }
    final int total = K + 1;
    long left = 0, right = sum;
    while (left < right) { // last can divide to k
      final long mid = (1 + left + right) / 2;
      final int count = getCount(sweetness, mid);
//      System.out.println("Left = " + left + ", right = " + right + ", mid = " + mid + ", count = " + count);
      if (count > total) {
        left = mid + 1;
      } else if (count == total) {
        left = mid;
      } else {
        right = mid - 1;
      }
    }
    return (int) left;
  }

  /**
   * Exceed mid
   */
  static int getCount(final int[] sweetness, final long minSum) {
    int count = 0;
    long sum = 0;
    for (int s : sweetness) {
      sum += s;
      if (sum >= minSum) {
        sum = 0;
        count++;
      }
    }
    return count;
  }
}
