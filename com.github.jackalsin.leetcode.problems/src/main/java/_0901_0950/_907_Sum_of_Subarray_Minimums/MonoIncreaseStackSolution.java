package _0901_0950._907_Sum_of_Subarray_Minimums;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author jacka
 * @version 1.0 on 12/15/2019
 */
public final class MonoIncreaseStackSolution implements Solution {
  private static final int MOD = (int) (1E9 + 7);

  public int sumSubarrayMins(int[] A) {
    // previous less element: {val, i}
    final Deque<int[]> previousStack = new ArrayDeque<>(),
        nextStack = new ArrayDeque<>();
    final int n = A.length;
    final int[] previousDistance = new int[n],
        nextDistance = new int[n];
    for (int i = 0; i < n; ++i) {
      // stack contains [2, 1], 且[3, 5]
      while (!previousStack.isEmpty() && previousStack.peek()[0] >= A[i]) {
        previousStack.pop();
      }
      previousDistance[i] = previousStack.isEmpty() ? i + 1 : i - previousStack.peek()[1];
      previousStack.push(new int[]{A[i], i});
      System.out.println("i = " + i);
      previousStack.forEach(x -> System.out.println(Arrays.toString(x)));
    }
    for (int i = n - 1; i >= 0; --i) {
      while (!nextStack.isEmpty() && nextStack.peek()[0] > A[i]) {
        nextStack.pop();
      }
      nextDistance[i] = nextStack.isEmpty() ? n - i : nextStack.peek()[1] - i;
      nextStack.push(new int[]{A[i], i});
    }
//
//    PrevDistance = [1, 2, 1, 1]
//    nextDistance = [1, 3, 2, 1]
    System.out.println("PrevDistance = " + Arrays.toString(previousDistance));
    System.out.println("nextDistance = " + Arrays.toString(nextDistance));
    int sum = 0;
    for (int i = 0; i < n; ++i) {
      // sub array start from previousDistance[i]中任意一个，结束于nextDistance[i]
      sum = safeAdd(sum, A[i] * previousDistance[i] * nextDistance[i]);
    }
    return sum;
  }

  private static int safeAdd(final int a, int b) {
    return (a + b) % MOD;
  }
}
