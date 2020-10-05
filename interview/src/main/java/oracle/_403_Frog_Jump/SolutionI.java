package oracle._403_Frog_Jump;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author jacka
 * @version 1.0 on 12/7/2019
 */
public final class SolutionI implements Solution {
  @Override
  public boolean canCross(int[] stones) {
    if (stones == null || stones.length == 0) {
      return true;
    }
    final Map<Integer, Set<Integer>> posToLastJumpStep = new HashMap<>();
    posToLastJumpStep.computeIfAbsent(0, k -> new HashSet<>()).add(1);

    for (int i = 0, stonesLength = stones.length; i < stonesLength; i++) {
      final int stone = stones[i];
      final Set<Integer> lastSteps = posToLastJumpStep.get(stone);
//      System.out.println("stone = " + stone + ", lastSteps = " + lastSteps);
      if (lastSteps == null) continue;
      for (int lastStep : lastSteps) {
        for (int step : i == 0 ? new int[]{lastStep} : new int[]{lastStep - 1, lastStep, lastStep + 1}) {
          if (step == 0) continue;
          posToLastJumpStep.computeIfAbsent(stone + step, k -> new HashSet<>()).add(step);
        }
      }
    }
    return posToLastJumpStep.containsKey(stones[stones.length - 1]);
  }
}
