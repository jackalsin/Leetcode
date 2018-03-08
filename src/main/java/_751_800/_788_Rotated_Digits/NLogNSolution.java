package _751_800._788_Rotated_Digits;

import java.util.HashSet;
import java.util.Set;

/**
 * @author jacka
 * @version 1.0 on 3/7/2018.
 */
public final class NLogNSolution implements Solution {
  private static final int MAX = 10_000;
  private final Set<Integer> rotateValid = new HashSet<>() {{
    add(0);
    add(1);
    add(2);
    add(5);
    add(6);
    add(8);
    add(9);
  }};

  /**
   * Time Complexity: O(N Log N)
   * 50 / 50 test cases passed.
   * Status: Accepted
   * Runtime: 16 ms
   */
  public int rotatedDigits(int N) {
    final boolean[] isRotateDiff = new boolean[MAX + 1];
    if (N < 2) {
      return 0;
    } else if (N < 5) {
      return 1;
    } else if (N < 6) {
      return 2;
    } else if (N < 9) {
      return 3;
    } else {
      isRotateDiff[2] = true;
      isRotateDiff[5] = true;
      isRotateDiff[6] = true;
      isRotateDiff[9] = true;
      int count = 4;
      for (int i = 10; i <= Math.min(N, MAX); i++) {
        if (isRotateDiff(isRotateDiff, i)) {
          count++;
        }
      }
      return count;
    }
  }

  private boolean isRotateDiff(boolean[] isRotateDiff, int i) {
    boolean res = false;
    while (i > 0) {
      final int digit = i % 10;
      if (rotateValid.contains(digit)) {
        if (isRotateDiff[digit]) {
          res = true;
        }
      } else {
        return false;
      }
      i /= 10;
    }
    return res;
  }
}
