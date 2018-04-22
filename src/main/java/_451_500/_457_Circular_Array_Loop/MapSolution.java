package _451_500._457_Circular_Array_Loop;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class MapSolution implements Solution {
  /**
   * 10 / 10 test cases passed.
   * Status: Accepted
   * Runtime: 3 ms
   * <p>
   * Time Complexity: O(N)
   * Space Complexity: O(N)
   *
   * @param nums
   * @return
   */
  public boolean circularArrayLoop(int[] nums) {
    final Map<Integer, Integer> forwardMap = new HashMap<>(), backwardMap = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] > 0) {
        forwardMap.put(i, (i + nums[i]) % nums.length);
      } else if (nums[i] < 0) {
        backwardMap.put(i, (i + nums[i]) % nums.length);
      }
    }
    return hasCycle(forwardMap) || hasCycle(backwardMap);
  }

  private boolean hasCycle(final Map<Integer, Integer> backwardMap) {
    final Set<Integer> visited = new HashSet<>();
    for (Map.Entry<Integer, Integer> entry : backwardMap.entrySet()) {
      int start = entry.getKey(), end = entry.getValue();
      final Set<Integer> curPath = new HashSet<>();
      while (!visited.contains(start)) {
        visited.add(start);
        if (curPath.contains(end)) {
          return true;
        }
        curPath.add(start);
        start = end;
        if (!backwardMap.containsKey(end)) {
          break;
        }
        end = backwardMap.get(end);
      }
    }
    return false;
  }
}
