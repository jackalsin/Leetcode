package microsoft.noodleEssence._403_Frog_Jump;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {

  public boolean canCross(int[] stones) {
    assert stones.length >= 2 && stones.length <= 1100;
    final Map<Integer, Set<Integer>> lastJumps = new HashMap<>();
    // init
    for (int i = 0; i < stones.length; ++i) {
      lastJumps.put(stones[i], new HashSet<>());
    }
    if (!lastJumps.containsKey(1)) {
      return false;
    }
    lastJumps.get(1).add(1);
    // dp
    for (int i = 1; i < stones.length; ++i) {
      final Set<Integer> lastJump = lastJumps.get(stones[i]);
      for (int k : lastJump) {
        for (int diff = -1; diff <= 1; diff++) {
          if (diff + k + stones[i] > stones[i]) {
            if (!lastJumps.containsKey(diff + k + stones[i])) continue;
            lastJumps.get(diff + k + stones[i]).add(diff + k);
          }
        }
      }
    }
//    System.out.println(lastJumps);
    return !lastJumps.get(stones[stones.length - 1]).isEmpty();
  }
}
