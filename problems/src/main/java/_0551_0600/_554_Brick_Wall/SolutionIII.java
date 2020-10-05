package _0551_0600._554_Brick_Wall;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class SolutionIII implements Solution {
  public int leastBricks(List<List<Integer>> wall) {
    final Map<Integer, Integer> voidCount = new HashMap<>();
    int maxVoidCount = 0;
    for (final List<Integer> row : wall) {
      int curRightEdge = 0;
      for (int i = 0; i < row.size() - 1; i++) {
        curRightEdge += row.get(i);
        voidCount.put(curRightEdge, voidCount.getOrDefault(curRightEdge, 0) + 1);
        maxVoidCount = Math.max(maxVoidCount, voidCount.get(curRightEdge));
      }
    }

    return wall.size() - maxVoidCount;
  }
}

