package _401_450._403_Frog_Jump;

import java.util.HashSet;
import java.util.Set;

public final class DfsSolution implements Solution {
  /**
   * 39 / 39 test cases passed.
   * Status: Accepted
   * Runtime: 11 ms
   *
   * @param stones
   * @return
   */
  @Override
  public boolean canCross(int[] stones) {
    if (stones == null || stones.length == 0) {
      return false;
    }
    int n = stones.length;
    if (n == 1) {
      return true;
    }
    if (stones[1] != 1) {
      return false;
    }
    if (n == 2) {
      return true;
    }
    final int last = stones[n - 1];
    final Set<Integer> stoneSet = new HashSet<>();
    for (int i = 0; i < stones.length; i++) {
      int stone = stones[i];
      stoneSet.add(stone);
      if (i > 3 && stones[i - 1] * 2 < stones[i]) {
        return false;
      }
    }
    return canCross(stoneSet, last, 1, 1);
  }

  private boolean canCross(Set<Integer> stoneSet, final int last, int curPos, int jump) {
    final int[] nextJumps = {jump + 1, jump, jump - 1};
    for (final int nextJump : nextJumps) {
      if (nextJump <= 0) continue;
      if (last == nextJump + curPos) {
        return true;
      }
      if (stoneSet.contains(curPos + nextJump) && canCross(stoneSet, last, curPos + nextJump, nextJump)) {
        return true;
      }
    }
    return false;
  }
}
