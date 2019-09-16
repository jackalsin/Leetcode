package _1151_1200._1191_K_Concatenation_Maximum_Sum;

/**
 * @author jacka
 * @version 1.0 on 9/14/2019
 */
public final class SolutionI implements Solution {
  private static final int MOD = (int) (1E9 + 7);

  public int kConcatenationMaxSum(int[] arr, int k) {
    if (arr == null || arr.length == 0) {
      return 0;
    }
    long singleRes = maxSubArraySum(arr), moreThan2Sum = 0;
    if (k > 1) {
      final long sum = getSum(arr), leftSum = getLeftSum(arr), rightSum = getRightSum(arr);
      moreThan2Sum = Math.max(0, rightSum) + Math.max(0, leftSum);
      for (int i = 0; i < k - 2; ++i) {
        moreThan2Sum += Math.max(0, sum);
      }
    }
    return (int) (Math.max(singleRes, moreThan2Sum) % MOD);
  }

  private static long maxSubArraySum(final int[] arr) {
    long maxEndHere = arr[0], maxSoFar = arr[0];
    for (int i = 1; i < arr.length; ++i) {
      maxEndHere = Math.max(maxEndHere + arr[i], arr[i]);
      maxSoFar = Math.max(maxSoFar, maxEndHere);
    }
    return maxSoFar;
  }

  private static long getLeftSum(final int[] arr) {
    long maxEndHere = arr[0], maxSoFar = arr[0];
    for (int i = 1; i < arr.length; ++i) {
      maxEndHere += arr[i];
      maxSoFar = Math.max(maxSoFar, maxEndHere);
    }
    return maxSoFar;
  }

  private static long getSum(final int[] arr) {
    long sum = 0;
    for (int a : arr) {
      sum += a;
    }
    return sum;
  }

  private static long getRightSum(final int[] arr) {
    long maxEndHere = arr[arr.length - 1], maxSoFar = arr[arr.length - 1];
    for (int i = arr.length - 2; i >= 0; --i) {
      maxEndHere += arr[i];
      maxSoFar = Math.max(maxSoFar, maxEndHere);
    }
    return maxSoFar;
  }
}
