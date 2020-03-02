package _0551_0600._582_Kill_Process;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * @author jacka
 * @version 1.0 on 3/1/2020
 */
public final class SolutionI implements Solution {
  @Override
  public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
    final Map<Integer, Set<Integer>> parentToChildren = new HashMap<>();
    for (int i = 0; i < pid.size(); ++i) {
      final int c = pid.get(i), p = ppid.get(i);
      parentToChildren.putIfAbsent(p, new HashSet<>());
      parentToChildren.putIfAbsent(c, new HashSet<>());
      parentToChildren.get(p).add(c);
    }
    final Set<Integer> result = new HashSet<>() {{
      add(kill);
    }};
    final Queue<Integer> q = new ArrayDeque<>() {{
      add(kill);
    }};
    while (!q.isEmpty()) {
      final int toRemove = q.remove();
      result.add(toRemove);
      final Set<Integer> children = parentToChildren.get(toRemove);
      for (final int c : children) {
        if (result.add(c)) {
          q.add(c);
        }
      }
    }
    return new ArrayList<>(result);
  }
}
