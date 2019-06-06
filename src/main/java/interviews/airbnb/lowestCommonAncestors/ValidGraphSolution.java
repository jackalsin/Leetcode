package interviews.airbnb.lowestCommonAncestors;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class ValidGraphSolution implements Solution {
  private final Map<String, Set<String>> parentToChildren = new HashMap<>();
  private final String parent;

  /**
   * @param graph a list of words, graph[i] = {parent, child1, child2, ...}
   */
  public ValidGraphSolution(final String[][] graph) {
    final Map<String, Integer> indegrees = new HashMap<>();
    for (final String[] l : graph) {
      final String parent = l[0];
      indegrees.putIfAbsent(parent, 0);
      for (int i = 1; i < l.length; i++) {
        final String child = l[i];
        parentToChildren.computeIfAbsent(parent, p -> new HashSet<>()).add(child);
        indegrees.put(child, indegrees.getOrDefault(child, 0) + 1);
      }
    }


    {
      String parent = null;
      int count = 0;
      for (final Map.Entry<String, Integer> e : indegrees.entrySet()) {
        if (e.getValue() == 0) {
          parent = e.getKey();
          count++;
        }
      }
      assert count == 1;
      this.parent = parent;
    }
  }

  public String commonAncestors(String word1, String word2) {
    return commonAncestors(parent, word1, word2);
  }

  private String commonAncestors(final String parent, final String word1, final String word2) {
    if (word1.equals(parent) || word2.equals(parent)) {
      return parent;
    }
    final Set<String> children = parentToChildren.getOrDefault(parent, new HashSet<>());
    final List<String> result = new ArrayList<>();
    for (String c : children) {
      final String p = commonAncestors(c, word1, word2);
      if (p != null) {
        result.add(p);
      }
    }
    if (result.size() == 1) {
      return result.get(0);
    }
    if (result.size() == 2) {
      return parent;
    }
    return null;
  }

}
