package interviews.airbnb.preferenceList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public final class OrderGuaranteedSolution implements Solution {
  /**
   * To break the tie, element in the first list will show up first
   *
   * @param preferences
   * @return
   */
  public List<Integer> getPreference(List<List<Integer>> preferences) {
    final Map<Integer, Set<Integer>> parentToChildren = new HashMap<>();
    final Map<Integer, Integer> indegree = new HashMap<>();
    final Map<Integer, Integer> reverseIndex = new HashMap<>();
    // end of for loop
    for (int listIndex = 0; listIndex < preferences.size(); listIndex++) {
      final List<Integer> list = preferences.get(listIndex);
      for (int i = 0; i < list.size() - 1; i++) {
        final Set<Integer> children = parentToChildren.getOrDefault(list.get(i), new HashSet<>());
        final int parent = list.get(i), child = list.get(i + 1);
        if (!children.contains(child)) {
          children.add(child);
          indegree.putIfAbsent(child, 0);
          indegree.putIfAbsent(parent, 0);
          indegree.put(child, indegree.get(child) + 1);
          reverseIndex.put(parent, Math.min(reverseIndex.getOrDefault(parent, Integer.MAX_VALUE), listIndex));
          reverseIndex.put(child, Math.min(reverseIndex.getOrDefault(child, Integer.MAX_VALUE), listIndex));
        }
        parentToChildren.put(parent, children);
      }
    }
    final Queue<int[]> q = new PriorityQueue<>((x, y) -> Integer.compare(x[1], y[1]));
    for (final Map.Entry<Integer, Integer> e : indegree.entrySet()) {
      final int node = e.getKey(), count = e.getValue();
      if (count == 0) {
        q.add(new int[]{node, reverseIndex.get(node)});
      }
    }

    final List<Integer> result = new ArrayList<>();
    while (!q.isEmpty()) {
      final int toRemove = q.remove()[0];
      result.add(toRemove);
      final Set<Integer> children = parentToChildren.getOrDefault(toRemove, new HashSet<>());
      for (int c : children) {
        indegree.put(c, indegree.get(c) - 1);
        if (indegree.get(c) == 0) {
          q.add(new int[]{c, reverseIndex.get(c)});
        }
      }
    }
    return result;
  }

}
