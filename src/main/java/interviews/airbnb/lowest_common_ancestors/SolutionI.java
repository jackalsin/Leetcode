package interviews.airbnb.lowest_common_ancestors;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * @author jacka
 * @version 1.0 on 2/17/2019.
 */
public final class SolutionI implements Solution {
  private final Map<String, Set<String>> childToParents = new HashMap<>();

  public SolutionI(final String[][] words) {
    for (String[] line : words) {
      final String parent = line[0];
      for (int i = 1; i < line.length; i++) {
        childToParents.computeIfAbsent(line[i], key -> new HashSet<>()).add(parent);
      }
    } // end of line
  }

  public String commonAncestors(String word1, String word2) {
    final Set<String> w1Ancestors = childToParents.getOrDefault(word1, new HashSet<>()),
        w2Ancestors = childToParents.getOrDefault(word2, new HashSet<>());

    final Queue<String> q1 = new ArrayDeque<>(w1Ancestors), q2 = new ArrayDeque<>(w2Ancestors);
    final Set<String> visited = new HashSet<>(q1);
    for (String w : w2Ancestors) {
      if (visited.contains(w)) {
        return w;
      }
      visited.add(w);
    }

    int qi = 0;
    while (!q1.isEmpty() || !q2.isEmpty()) {
      final Queue<String> q = qi++ % 2 == 0 ? q1 : q2;
      final int size = q.size();
      for (int i = 0; i < size; i++) {
        final String toRemove = q.remove();
        final Set<String> toRemoveParents = childToParents.getOrDefault(toRemove, new HashSet<>());
        for (String p : toRemoveParents) {
          if (visited.contains(p)) {
            return p;
          }
          visited.add(p);
          q.add(p);
        }
      }
    }
    return null; // no common ancestor
  }
}
