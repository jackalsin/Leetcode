package _1251_1300._1257_Smallest_Common_Region;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * @author zhixi
 * @version 1.0 on 8/14/2021
 */
public final class SolutionI implements Solution {
  @Override
  public String findSmallestRegion(final List<List<String>> regions,
                                   final String region1, final String region2) {
    final Map<String, String> childToParent = getParent(regions);
    final Queue<String> q = new ArrayDeque<>() {{
      add(region1);
      add(region2);
    }};
    final Set<String> visited = new HashSet<>() {{
      add(region1);
      add(region2);
    }};
    while (!q.isEmpty()) {
      final String toRemove = q.remove(),
          parent = childToParent.get(toRemove);
      if (parent == null) continue;
      if (!visited.add(parent)) return parent;
      q.add(parent);
    }
    throw new IllegalStateException("No common parent was found: "
        + region1 + ", " + region2 + ", childToParent = " + childToParent);
  }

  private static Map<String, String> getParent(final List<List<String>> regions) {
    final Map<String, String> result = new HashMap<>();
    for (final List<String> region : regions) {
      final String parent = region.get(0);
      for (int i = 1; i < region.size(); ++i) {
        result.put(region.get(i), parent);
      }
    }
    return result;
  }
}