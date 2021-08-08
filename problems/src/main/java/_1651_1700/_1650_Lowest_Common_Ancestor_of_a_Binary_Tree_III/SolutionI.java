package _1651_1700._1650_Lowest_Common_Ancestor_of_a_Binary_Tree_III;

import definition._1650_Lowest_Common_Ancestor_of_a_Binary_Tree_III.Node;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public final class SolutionI implements Solution {
  public Node lowestCommonAncestor(final Node p, final Node q) {
    final Set<Integer> visited = new HashSet<>();
    final Queue<Node> queue = new ArrayDeque<>() {{
      add(q);
      add(p);
    }};
    while (!queue.isEmpty()) {
      final Node toRemove = queue.remove();
      if (!visited.add(toRemove.val)) return toRemove;
      if (toRemove.parent != null) queue.add(toRemove.parent);
    }
    throw new IllegalStateException();
  }
}
