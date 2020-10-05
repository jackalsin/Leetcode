package oracle._554_Brick_Wall;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 10/20/2019
 */
public final class SolutionI implements Solution {
  @Override
  public int leastBricks(List<List<Integer>> walls) {
    final Map<Integer, Integer> edgeToCount = new HashMap<>();
    int max = 0, maxEdge = 0;
    for (List<Integer> wall : walls) {
      int sum = 0;
      for (int j = 0; j < wall.size() - 1; ++j) {
        sum += wall.get(j);
        final int count = edgeToCount.getOrDefault(sum, 0) + 1;
        if (max < count) {
          max = count;
          maxEdge = sum;
        }
        edgeToCount.put(sum, count);
      }
    }
    return walls.size() - max;
  }
}
