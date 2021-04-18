package uber.codeSignal.equalPairs;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 4/18/2021
 */
public final class SolutionI implements Solution {
  public int equalPairs(int[] nums1, int[] nums2) {
    final Map<Long, Integer> sumCount = new HashMap<>();
    for (int i = 0; i < nums1.length; ++i) {
      final long sum = nums1[i] + nums2[i];
      sumCount.put(sum, sumCount.getOrDefault(sum, 0) + 1);
    }
    int res = 0;
    for (final var e : sumCount.entrySet()) {
      final int val = e.getValue();
      res += val * (val - 1);
    }
    return res;
  }
}
