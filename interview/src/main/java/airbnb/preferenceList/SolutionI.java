package airbnb.preferenceList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class SolutionI implements Solution {
  public List<Integer> getPreference(List<List<Integer>> preferences) {
    final Map<Integer, Integer> indegree = new HashMap<>();
    final Map<Integer, Set<Integer>> parentToChildren = new HashMap<>();

    for (final List<Integer> p : preferences) {
      if (p.isEmpty()) continue;
      indegree.putIfAbsent(p.get(0), 0);
      for (int i = 0; i < p.size() - 1; i++) {
        final int from = p.get(i), to = p.get(i + 1);
        parentToChildren.putIfAbsent(from, new HashSet<>());
        final Set<Integer> children = parentToChildren.get(from);
        if (!children.contains(to)) {
          children.add(to);
          indegree.put(to, indegree.getOrDefault(to, 0) + 1);
        }
      }
    } // end of for preference

//    final Queue<Integer> q = new ArrayDeque<>();
    final LinkedHashSet<Integer> q = new LinkedHashSet<>();
    for (final Map.Entry<Integer, Integer> e : indegree.entrySet()) {
      final int node = e.getKey(), count = e.getValue();
      if (count == 0) {
        q.add(node);
      }
    }


    final List<Integer> result = new ArrayList<>();
    while (!q.isEmpty()) {
      Iterator<Integer> itr = q.iterator();
      final int toRemove = itr.next();
      itr.remove(); // call after next
      result.add(toRemove);
      final Set<Integer> children = parentToChildren.getOrDefault(toRemove, new HashSet<>());
      for (int c : children) {
        indegree.put(c, indegree.get(c) - 1);
        if (indegree.get(c) == 0) {
          q.add(c);
        }
      }
    }
    return result;
  }

}
