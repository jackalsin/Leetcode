package _0401_0450._446_Arithmetic_Slices_II_Subsequence;

import java.util.HashMap;
import java.util.Map;

public class Solution {

  public int numberOfArithmeticSlices(int[] A) {
    final int n = A.length;
    long res = 0;
    final Map<Integer, Integer>[] diffCount = new HashMap[n];
    for (int i = 0; i < n; i++) {
      diffCount[i] = new HashMap<>();
      for (int j = 0; j < i; j++) {
        long diffL = (long) A[j] - (long) A[i];
        if (diffL < Integer.MIN_VALUE || diffL > Integer.MAX_VALUE) {
          continue;
        }
        final int diff = (int) diffL,
            prev = diffCount[i].getOrDefault(diff, 0),
            cur = diffCount[j].getOrDefault(diff, 0);
        diffCount[i].put(diff, prev + cur + 1);
        res += cur;
      }
    }
    return (int) res;
  }

}
