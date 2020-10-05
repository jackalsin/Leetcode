package pinterest.parent;

import java.util.*;

/**
 * http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=413627&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3046%5D%5Bvalue%5D%3D33%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311
 */
public class Solution {

  /**
   * Time Complexity: O(N)
   * Space Complexity: O(N)
   *
   * @param relationship
   * @param size
   * @return
   */
  public List<Integer> getNodeWithIParent(final int[][] relationship, int size) {
    final Map<Integer, Set<Integer>> childToParents = getGraph(relationship);

    // find the result

    final List<Integer> result = new ArrayList<>();
    for (final Map.Entry<Integer, Set<Integer>> entry : childToParents.entrySet()) {
      if (entry.getValue().size() == size) {
        result.add(entry.getKey());
      }
    }
    return result;
  }


  /**
   * Time Complexity: O(N)
   * Space Complexity: O(N)
   *
   * @param relation
   * @param i
   * @param j
   * @return
   */
  public boolean hasCommonParent(final int[][] relation, int i, int j) {
    final Map<Integer, Set<Integer>> childToParents = getGraph(relation);
    /* will visit in the next round */
    final Set<Integer> visited = new HashSet<>();
    final Queue<Integer> queue = new ArrayDeque<>();
    queue.add(i);
    queue.add(j);

    visited.add(i);
    visited.add(j);

    while (!queue.isEmpty()) {
      final int toRemove = queue.remove();
      final Set<Integer> parents = childToParents.get(toRemove);
      for (int parent : parents) {
        if (visited.contains(parent)) {
          return true;
        } else {
          visited.add(parent);
        }
      }
    }
    return false;
  }

  public int getFurthestParent(final int[][] relations, int child) {
    final Map<Integer, Set<Integer>> childToParents = getGraph(relations);
    final Queue<Integer> queue = new ArrayDeque<>();
    queue.add(child);
    final Set<Integer> toVisited = new HashSet<>();
    toVisited.add(child);
    int maxDistance = 0, curDistance = 0, res = child;
    while (!queue.isEmpty()) {
      curDistance++;
      final int size = queue.size();
      for (int i = 0; i < size; i++) {
        final int toRemove = queue.remove();
        if (maxDistance < curDistance) {
          res = toRemove;
          maxDistance = curDistance;
        }
        final Set<Integer> parents = childToParents.get(toRemove);
        for (int parent : parents) {
          if (!toVisited.contains(parent)) {
            queue.add(parent);
            toVisited.add(parent);
          }
        }
      }
    }

    return res;
  }

  /**
   * Time Complexity: O(N)
   *
   * @param relations
   * @return
   */
  private Map<Integer, Set<Integer>> getGraph(final int[][] relations) {
    final Map<Integer, Set<Integer>> childToParents = new HashMap<>();

    // add
    for (final int[] relation : relations) {
      final int child = relation[1], parent = relation[0];
      childToParents.putIfAbsent(child, new HashSet<>());
      childToParents.putIfAbsent(parent, new HashSet<>());

      childToParents.get(child).add(parent);
    }
    return childToParents;
  }


}
