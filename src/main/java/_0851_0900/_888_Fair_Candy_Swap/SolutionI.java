package _0851_0900._888_Fair_Candy_Swap;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author jacka
 * @version 1.0 on 9/16/2020
 */
public final class SolutionI implements Solution {
  @Override
  public int[] fairCandySwap(int[] A, int[] B) {
    int sumA = 0, sumB = 0;
    final Set<Integer> bSet = new HashSet<>();
    for (int a : A) {
      sumA += a;
    }
    for (int b : B) {
      sumB += b;
      bSet.add(b);
    }
    final int target = sumA - sumB;
    assert target % 2 == 0;
    for (int a : A) {
      final int expectB = a - target / 2;
      if (bSet.contains(expectB)) {
        return new int[]{a, expectB};
      }
    }
    throw new IllegalStateException("No way to do fair exchange: " +
        "A = " + Arrays.toString(A) + ", B = " + Arrays.toString(B));
  }
}
