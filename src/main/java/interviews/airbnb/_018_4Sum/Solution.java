package interviews.airbnb._018_4Sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Time Complexity: Average O(N^2), worst Case O(N^3)
 *
 * @author jacka
 * @version 1.0 on 1/21/2019.
 */
public class Solution {
  public List<List<Integer>> fourSum(int[] nums, int target) {
    Arrays.sort(nums);
    final Set<List<Integer>> result = new HashSet<>();
    final Map<Integer, List<int[]>> sumToPairs = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      for (int j = i + 1; j < nums.length; j++) {
        if (sumToPairs.containsKey(target - (nums[i] + nums[j]))) {
          final List<int[]> allPairs = sumToPairs.get(target - nums[i] - nums[j]);
          for (final int[] p : allPairs) {
            final int m1 = Math.min(p[0], i),
                m2 = Math.max(p[0], i),
                m3 = Math.min(p[1], j),
                m4 = Math.max(p[1], j);
            if (m1 == m2 || m2 == m3 || m3 == m4) continue;
            result.add(Arrays.asList(nums[m1], Math.min(nums[m2], nums[m3]), Math.max(nums[m2], nums[m3]), nums[m4]));
          }
        }

        sumToPairs.putIfAbsent(nums[i] + nums[j], new ArrayList<>());
        sumToPairs.get(nums[i] + nums[j]).add(new int[]{i, j});
      }
    }
    return new ArrayList<>(result);
  }
}
