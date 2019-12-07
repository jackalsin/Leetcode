package _1201_1250._1231_Divide_Chocolate;

/**
 * @author jacka
 * @version 1.0 on 12/6/2019
 */
public final class BinarySearchSolution implements Solution {
  @Override
  public int maximizeSweetness(int[] sweetness, int K) {
    final int sum = getSum(sweetness);
    K++;
    int left = 0, right = sum;
    while (left < right) {
      // first mid
      final int mid = left + (1 + right - left) / 2;
//      System.out.println(mid + ", left = " + left + ", right = " + right);
      if (getCount(mid, sweetness) > K) {
        left = mid;
      } else {
        right = mid - 1;
      }
    }
    return left;
  }

  private static int getCount(final int sum, final int[] sweetness) {
    int curSum = 0, count = 1;
    for (int n : sweetness) {
      curSum += n;
      if (curSum >= sum) {
        count++;
        curSum = 0;
      }
    }
    return count;
  }

  private static int getSum(final int[] sweetness) {
    int sum = 0;
    for (int num : sweetness) {
      sum += num;
    }
    return sum;
  }
}
