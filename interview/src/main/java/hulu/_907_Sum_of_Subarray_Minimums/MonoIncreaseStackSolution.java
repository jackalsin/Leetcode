package hulu._907_Sum_of_Subarray_Minimums;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author jacka
 * @version 1.0 on 2/28/2020
 */
public final class MonoIncreaseStackSolution implements Solution {
  private static final int MOD = (int) (1E9 + 7);

  public int sumSubarrayMins(int[] A) {
    if (A == null || A.length == 0) {
      return 0;
    }
    final int n = A.length;
    final int[] prevDistance = new int[n],
        nextDistance = new int[n];
    final Deque<int[]> prevStack = new ArrayDeque<>(),
        nextStack = new ArrayDeque<>();
    for (int i = 0; i < n; ++i) {
      while (!prevStack.isEmpty() && prevStack.peek()[0] >= A[i]) { // should we equal?
        prevStack.pop();
      }
      prevDistance[i] = prevStack.isEmpty() ? i + 1 : i - prevStack.peek()[1];
      System.out.println("i = " + i + " prevStack.peek()[1] = " + (prevStack.isEmpty() ? i + 1 : prevStack.peek()[1]));
      prevStack.push(new int[]{A[i], i});
      prevStack.forEach(x -> System.out.println(Arrays.toString(x)));
    }
    System.out.println("PrevDistance = " + Arrays.toString(prevDistance));

    for (int i = n - 1; i >= 0; i--) {
      while (!nextStack.isEmpty() && nextStack.peek()[0] > A[i]) {
        nextStack.pop();
      }
      nextDistance[i] = nextStack.isEmpty() ? n - i : nextStack.peek()[1] - i;
      nextStack.push(new int[]{A[i], i});
    }

    System.out.println("PrevDistance = " + Arrays.toString(prevDistance));
    System.out.println("nextDistance = " + Arrays.toString(nextDistance));
    int sum = 0;
    for (int i = 0; i < n; ++i) {
      sum = safeAdd(sum, A[i] * prevDistance[i] * nextDistance[i]);
    }
    return sum;
  }

  private static int safeAdd(final int a, final int b) {
    return (a + b) % MOD;
  }
}
