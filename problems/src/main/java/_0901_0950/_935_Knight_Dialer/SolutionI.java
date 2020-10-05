package _0901_0950._935_Knight_Dialer;

import java.util.Arrays;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 9/22/2020
 */
public final class SolutionI implements Solution {
  private static final int MOD = (int) (1E9 + 7);
  private static final List<List<Integer>> NEXT = List.of(
      List.of(4, 6),  // 0
      List.of(6, 8),  // 1
      List.of(7, 9),  // 2
      List.of(4, 8),  // 3
      List.of(0, 3, 9),  // 4
      List.of(),      // 5
      List.of(0, 1, 7),  // 6
      List.of(2, 6),  // 7
      List.of(1, 3),  // 8
      List.of(2, 4)   // 9
  );

  public int knightDialer(int N) {
    int[] prev = new int[10];
    Arrays.fill(prev, 1);
    for (int n = 2; n <= N; ++n) {
      final int[] next = new int[10];
      for (int i = 0; i < 10; ++i) {
        for (final int l : NEXT.get(i)) {
          next[l] = safeAdd(next[l], prev[i]);
        }
      }
//      System.out.println(Arrays.toString(next));
      prev = next;
    }
    return safeAdd(0, prev);
  }

  private static int safeAdd(int a, final int... b) {
    for (int c : b) {
      a = (a + c) % MOD;
    }
    return a;
  }
}
