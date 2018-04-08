package _401_450._403_Frog_Jump;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class SlowSolution implements Solution {
  /**
   * Time Complexity: O(N)
   * 39 / 39 test cases passed.
   * Status: Accepted
   * Runtime: 139 ms
   *
   * @param stones
   * @return
   */
  public boolean canCross(int[] stones) {
    if (stones == null || stones.length == 0 || stones[0] != 0) {
      return false;
    }
    final Map<Integer, Integer> valToIndex = new HashMap<>();
    final List<Set<Integer>> lastJumpHereStep = new ArrayList<>();
    for (int i = 0; i < stones.length; i++) {
      lastJumpHereStep.add(new HashSet<>());
      valToIndex.put(stones[i], i);
    }
    lastJumpHereStep.get(0).add(0);
    for (int i = 0; i < stones.length - 1; i++) {
      final Set<Integer> steps = getCandidateSteps(lastJumpHereStep.get(i));
      final int curPos = stones[i];
      for (int step : steps) {
        if (step + curPos == stones[stones.length - 1]) {
          return true;
        }
        if (valToIndex.containsKey(step + curPos)) {
          final int index = valToIndex.get(step + curPos);
          lastJumpHereStep.get(index).add(step);
        }
      }
    }
//    lastJumpHereStep.forEach(System.out::println);
    return !lastJumpHereStep.get(lastJumpHereStep.size() - 1).isEmpty();
  }

  private Set<Integer> getCandidateSteps(final Set<Integer> lastStep) {
    final Set<Integer> steps = new HashSet<>();
    for (final int step : lastStep) {
      for (int bias = -1; bias <= 1; bias++) {
        if (step + bias > 0) {
          steps.add(step + bias);
        }
      }
    } // end of for step loop
    return steps;
  }

}
