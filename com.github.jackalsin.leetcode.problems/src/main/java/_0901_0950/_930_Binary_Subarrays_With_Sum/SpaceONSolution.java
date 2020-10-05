package _0901_0950._930_Binary_Subarrays_With_Sum;

import java.util.HashMap;
import java.util.Map;

/**
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 *
 * @author jacka
 * @version 1.0 on 9/22/2020
 */
public final class SpaceONSolution implements Solution {
  @Override
  public int numSubarraysWithSum(int[] A, int S) {
    int sum = 0, count = 0;
    final Map<Integer, Integer> preSumCount = new HashMap<>();
    preSumCount.put(sum, 1);
    for (int a : A) {
      sum += a;
      count += preSumCount.getOrDefault(sum - S, 0);
      preSumCount.put(sum, preSumCount.getOrDefault(sum, 0) + 1);
    }
    return count;
  }
}
