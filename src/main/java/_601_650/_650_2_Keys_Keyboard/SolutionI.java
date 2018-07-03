package _601_650._650_2_Keys_Keyboard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 10/30/2017.
 */
public final class SolutionI implements Solution {

  /**
   * This solution's essen is using
   */
  public int minSteps(int n) {
    if (n <= 1) {
      return 0;
    }
    final long[] minSteps = new long[n + 1];
    Arrays.fill(minSteps, Integer.MAX_VALUE);
    minSteps[0] = 0;
    minSteps[1] = 0;
    for (int i = 2; i <= n; i++) {

//      List<Integer> factors = getFactors(i);
//      for (int factor : factors) {
//        minSteps[i] = Math.min(minSteps[i], factor + minSteps[i / factor]);
//      }
      for (long factor = 2; factor <= i; factor++) {
        if (i % factor == 0) {
          minSteps[i] = factor + minSteps[(int) (i / factor)];
          break;
        }
      }
    }
    return (int) minSteps[n];
  }

  // possible duplicated factor for perfect square
  private List<Integer> getFactors(final int num) {
    List<Integer> result = new ArrayList<>();
    for (long i = 1; i * i <= num; i++) {
      if (num % i == 0) {
        result.add((int) i);
        result.add((int) (num / i));
      }
    }
    return result;
  }

}
